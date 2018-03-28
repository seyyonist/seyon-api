package io.seyon.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.entity.UserInfo;
import io.seyon.model.UserDetails;

@RestController
@RequestMapping(path = "/api")
public class UserServicesController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE , path="/createCompanyAndUser")
	public String createCompanyAndUser(@RequestBody UserDetails userDetails,
			@RequestAttribute(required = false) String username) {
		String status = "success";
		// TODO: Implement the service
		
		return status;
	}

}
