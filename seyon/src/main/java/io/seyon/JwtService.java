package io.seyon;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import io.seyon.oauth2.OAuthDomain;
import io.seyon.oauth2.OauthTokenResponse;

@RestController
@RequestMapping("/jwt")
public class JwtService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SeyonApiProperties properties;
	
	@PostMapping
	public ResponseEntity<?> generateJwt(@RequestBody String code,HttpServletResponse response) {
	    String jwtToken = "";
	    OAuthDomain oauthDetails= new OAuthDomain();
	    oauthDetails.setClient_id(properties.getClientId());
	    oauthDetails.setClient_secret(properties.getClientSecret());
	    oauthDetails.setCode(code);
	    RestTemplate restTemplate = new RestTemplate();
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED));
	    HttpEntity<OAuthDomain> entity = new HttpEntity<OAuthDomain>(oauthDetails, headers);
	     
	    ResponseEntity<OauthTokenResponse> result = restTemplate.exchange(properties.getTokenUrl(), HttpMethod.POST, entity, OauthTokenResponse.class);
	    log.debug(result.getBody().toString());
	    
	    //get user infor using access token
	    //generate JWT using that user info
	    
	    return new ResponseEntity<>(result.getBody().getAccess_token(), HttpStatus.OK);
	}
}
