package io.seyon;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class JwtService {

	@GetMapping
	public ResponseEntity<?> generateJwt(HttpServletResponse response) {
		// create a cookie
	    Cookie cookie = new Cookie("JWT","mobile");

	    // expires in 7 days
	    cookie.setMaxAge(7 * 24 * 60 * 60);

	    // optional properties
	    cookie.setSecure(true);
	    cookie.setHttpOnly(true);
	    cookie.setPath("/");

	    // add cookie to response
	    response.addCookie(cookie);

	    // TODO: add your login logic here
	    String jwtToken = "NOT_AVAILABLE";

	    // return response entity
	    return new ResponseEntity<>(jwtToken, HttpStatus.OK);
	}
}
