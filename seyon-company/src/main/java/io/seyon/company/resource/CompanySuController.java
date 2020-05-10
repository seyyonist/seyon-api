package io.seyon.company.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.company.entity.Company;
import io.seyon.company.service.CompanyService;

@RestController
@RequestMapping(path = "/su/api/company")
public class CompanySuController {
	
	final String COMPANY_ID = "x-company-id";

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CompanyService companyService;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, path = "/filterCompany")
	public Iterable<Company> getCompanies(@RequestBody Company company,@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		return companyService.getCompanies(company,pageNumber,pageSize);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/getCompanyById")
	public Company getCompanyById(@RequestParam Long companyId) {
		return companyService.getCompany(companyId);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, path = "/activate")
	public Company activateCompany(@RequestAttribute(name = "x-user-email", required = true) String email,@RequestParam Long companyId) {
		return companyService.activeCompany(email,companyId);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, path = "/deActivate")
	public Company deActivateCompany(@RequestAttribute(name = "x-user-email", required = true) String email,@RequestParam Long companyId) {
		return companyService.deActiveCompany(email,companyId);
	}
}
