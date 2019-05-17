package io.seyon.company.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.company.entity.Company;
import io.seyon.company.model.CompanyModel;
import io.seyon.company.model.CompanyRole;
import io.seyon.company.model.SeyonResponse;
import io.seyon.company.service.CompanyService;

@RestController
@RequestMapping(path = "/api/company")
public class CompanyController {
	
	final String COMPANY_ID = "x-company-id";

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CompanyService companyService;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, path = "/createCompany")
	public SeyonResponse createCompanyAndUser(@RequestBody CompanyModel newCompany,
			@RequestAttribute(required = false) String username) {
		SeyonResponse seyonResponse = companyService.createCompanyAndUser(newCompany);
		return seyonResponse;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, path = "/updateCompany")
	public SeyonResponse updateCompany(@RequestBody Company company,
			@RequestAttribute(required = false) String username) {
		SeyonResponse seyonResponse = companyService.updateCompany(company);
		return seyonResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/getCompany")
	public Company getCompany(@RequestHeader(name = COMPANY_ID, required = true) Long companyId) {
		return companyService.getCompany(companyId);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/getCompanyForUser")
	public List<CompanyRole> getCompanies(@RequestParam(name = "email", required = true) String email) {
		return companyService.getCompanies(email);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/getUserCompany")
	public List<CompanyRole> getUserCompanies(@RequestHeader(name = "x-user-email", required = true) String email) {
		return companyService.getCompanies(email);
	}
	
	
	
}
