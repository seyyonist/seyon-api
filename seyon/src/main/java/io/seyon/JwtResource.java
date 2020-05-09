package io.seyon;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.seyon.oauth2.SeyyonJwtHandler;
import io.seyon.user.entity.UserInfo;
import io.seyon.user.service.UserService;
import io.seyon.oauth2.OAuthDomain;
import io.seyon.oauth2.Oauth2JwtRequest;
import io.seyon.oauth2.Oauth2JwtResponse;
import io.seyon.oauth2.OauthTokenResponse;
import io.seyon.oauth2.OauthUserInfo;

@RestController
@RequestMapping("/jwt")
public class JwtResource {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SeyonApiProperties properties;
	
	@Autowired
	SeyyonJwtHandler jwtHandler;
	
	@Autowired
	UserService userService;//.getUserByEmail(email);
	
	@Autowired
	@Qualifier("oauthRestTemplate")
	RestTemplate restTemplate;
	
	@PostMapping
	public ResponseEntity<Oauth2JwtResponse> generateJwt(@RequestBody Oauth2JwtRequest req,HttpServletResponse response) {
		log.info("Generating JWT");
	    OauthTokenResponse accessTokenResponse=getAccessToken(req.getCode(),req.getRedirectUrl());
	    log.debug(accessTokenResponse.getAccess_token());
	    OauthUserInfo userInfo=getUserFromOauth(accessTokenResponse.getAccess_token());
	    //generate JWT using that user info
	    Oauth2JwtResponse resp=new Oauth2JwtResponse();
	    resp.setJwt(jwtHandler.generateToken(userInfo));
	    resp.setName(userInfo.getName());
	    resp.setPicture(userInfo.getPicture());
	    resp.setEmail(userInfo.getEmail());
	    //get current user info
	    UserInfo user=userService.getUserByEmail(userInfo.getEmail());
	    if(null!=user) {
	    	if(null!=user.getSuperUser())
	    		resp.setAdmin(user.getSuperUser());
	    }
	    return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	private OauthTokenResponse getAccessToken(String code,String reUrl) {
		OAuthDomain oauthDetails= new OAuthDomain();
	    oauthDetails.setClient_id(properties.getClientId());
	    oauthDetails.setClient_secret(properties.getClientSecret());
	    oauthDetails.setCode(code);
	    oauthDetails.setRedirect_uri(reUrl);
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED));
	    HttpEntity<OAuthDomain> entity = new HttpEntity<OAuthDomain>(oauthDetails, headers);
	    ResponseEntity<OauthTokenResponse> result = restTemplate.exchange(properties.getTokenUrl(), HttpMethod.POST, entity, OauthTokenResponse.class);
	    return result.getBody();
	}
	
	private OauthUserInfo getUserFromOauth(String accessToken) {
		String url=properties.getUserProfileUrl().concat("?oauth_token=").concat(accessToken);
	    ResponseEntity<OauthUserInfo> userDetails = restTemplate.getForEntity(url, OauthUserInfo.class);
	    OauthUserInfo userInfo=userDetails.getBody();
	    log.debug(userInfo.toString());
	    return userInfo;
	}
}
