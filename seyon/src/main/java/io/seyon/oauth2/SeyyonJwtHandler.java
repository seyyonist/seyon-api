package io.seyon.oauth2;

import java.security.Key;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class SeyyonJwtHandler {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("jwtKey")
	Key jwtKey;

	/**
	 * Tries to parse specified String as a JWT token. If successful, returns User
	 * object with username, id and role prefilled (extracted from token). If
	 * unsuccessful (token is invalid or not containing all required user
	 * properties), simply returns null.
	 *
	 * @param token the JWT token to parse
	 * @return the User object extracted from specified token or null if a token is
	 *         invalid.
	 */
	public OauthUserInfo parseToken(String token) {
		OauthUserInfo currentUser = new OauthUserInfo();
		Claims body = Jwts.parserBuilder().setSigningKey(jwtKey).build().parseClaimsJws(token).getBody();
		currentUser.setName((String) body.get("name"));
		currentUser.setEmail((String) body.get("email"));
		return currentUser;
	}

	/**
	 * Generates a JWT token containing username as subject, and userId and role as
	 * additional claims. These properties are taken from the specified User object.
	 * Tokens validity is infinite.
	 * 
	 * @param u the user for which the token will be generated
	 * @return the JWT token
	 */
	public String generateToken(OauthUserInfo u) {
		Claims claims = Jwts.claims().setSubject(u.getEmail());
		claims.put("name", u.getName());
		claims.put("email", u.getEmail());
		return Jwts.builder().setIssuer("Seyyon Finacial Corp").setClaims(claims).signWith(jwtKey).compact();
	}

}
