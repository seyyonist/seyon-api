package io.seyon.company.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.company.entity.User;
import io.seyon.company.model.CompanyModel;
import io.seyon.company.model.Success;

@RestController
@RequestMapping(path = "/api")
public class CompanyController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE , path="/createCompany")
	public Success createCompanyAndUser(@RequestBody CompanyModel newCompany,
			@RequestAttribute(required = false) String username) {

		// TODO: Implement the service
		return new Success(0, "Company Created Successfully");
	}

}
