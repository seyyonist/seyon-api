package io.seyon.user.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.user.entity.UserInfo;
import io.seyon.user.model.SeyonResponse;
import io.seyon.user.model.UserDetails;

@RestController
@RequestMapping(path = "/api")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE , path="/createUser")
	public String createUser(@RequestBody UserDetails userDetails,
			@RequestAttribute(required = false) String username) {
		String status = "success";
		// TODO: Implement the service
		
		return status;
	}

	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE , path="/resetpassword")
	public SeyonResponse resetPassword(@RequestBody String email, @RequestAttribute(required = false) String username) {
		// TODO: Implement the service
		log.info("Resetting password for email {}",email);
		
		return new SeyonResponse(0, "New password is sent to your email");
	}
}
