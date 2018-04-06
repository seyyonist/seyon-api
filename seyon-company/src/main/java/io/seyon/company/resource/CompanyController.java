package io.seyon.company.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.company.model.CompanyModel;
import io.seyon.company.model.SeyonResponse;
import io.seyon.company.service.CompanyService;

@RestController
@RequestMapping(path = "/api/company")
public class CompanyController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CompanyService companyService;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, path = "/createCompany")
	public SeyonResponse createCompanyAndUser(@RequestBody CompanyModel newCompany,
			@RequestAttribute(required = false) String username) {
		SeyonResponse seyonResponse = companyService.createCompanyAndUser(newCompany);
		return seyonResponse;
	}

}
