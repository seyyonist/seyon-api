package io.seyon.vendor.resource;

 

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.vendor.entity.HeadOfAccount;
import io.seyon.vendor.service.HeadOfAccountService;



@RestController
@RequestMapping("/api/headofaccount")
public class HeadOfAccountController {

	private final Logger log= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	HeadOfAccountService headOfAccountService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public HeadOfAccount saveHeadofAccount(@Valid @RequestBody HeadOfAccount headOfAccount,
    			@RequestAttribute(name="x-company-id",required=true) Long companyId, @RequestAttribute(name="x-user-name",required=true) String userId ) {
		log.info("Incoming request {}",headOfAccount);
		HeadOfAccount result = headOfAccountService.saveHeadOfAccount(headOfAccount,companyId, userId);
		log.info("Response {}",result);     
		return result;
    }
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<HeadOfAccount> getHeadofAccountForCompany(@RequestAttribute(name="x-company-id",required=true) Long companyId) {
		log.info("Incoming request {}",companyId);
		List<HeadOfAccount> headOfAccounts = headOfAccountService.getHeadOfAccountsForCompany(companyId);
		log.info("Response {}",headOfAccounts);
		return headOfAccounts;
	}
	
}
