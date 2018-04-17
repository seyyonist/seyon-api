package io.seyon.user.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.user.model.SeyonResponse;
import io.seyon.user.model.UserDetails;
import io.seyon.user.service.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

	@Autowired
	UserService userService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, path = "/createuser")
	public SeyonResponse createUser(@RequestBody UserDetails userDetails,
			@RequestAttribute(required = false) String username) {
		return userService.createUser(userDetails);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, path = "/updateuser")
	public SeyonResponse updateUser(@RequestAttribute(required = true) String email,
			@RequestAttribute(required = true) String name, @RequestAttribute(required = true) String password,
			@RequestAttribute(required = true) Boolean active) {
		return userService.updateUser(email, name, password, active);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, path = "/adduserrole")
	public SeyonResponse addUserRole(@RequestAttribute(required = true) String email,
			@RequestAttribute(required = true) String roleCode) {
		return userService.addUserRole(email, roleCode);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, path = "/deleteuserrole")
	public SeyonResponse deleteUserRole(@RequestAttribute(required = false) Long roleId) {
		return userService.deleteUserRole(roleId);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/resetpassword")
	public SeyonResponse resetPassword(@RequestAttribute(required = true) String email) {
		log.info("Resetting password for email {}", email);
		return userService.resetPassword(email);
	}
}
