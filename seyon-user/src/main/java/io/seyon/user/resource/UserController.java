package io.seyon.user.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.user.entity.UserInfo;
import io.seyon.user.model.SeyonResponse;
import io.seyon.user.model.UserDetails;
import io.seyon.user.service.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
	
	final String COMPANY_ID="x-company-id";

	@Autowired
	UserService userService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SeyonResponse createUser(@RequestBody UserDetails userDetails,
			@RequestAttribute(required = false) String username) {
		return userService.createUser(userDetails);
	}

	@RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public SeyonResponse updateUser(@RequestAttribute(required = true) String email,
			@RequestAttribute(required = true) String name, @RequestAttribute(required = true) String password,
			@RequestAttribute(required = true) Boolean active) {
		return userService.updateUser(email, name, password, active);
	}
	

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/resetpassword")
	public SeyonResponse resetPassword(@RequestAttribute(required = true) String email) {
		log.info("Resetting password for email {}", email);
		return userService.resetPassword(email);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserInfo> getUsers(@RequestHeader(name=COMPANY_ID,required=true) Long companyId) {
		return userService.getUsers(companyId);
	}
}
