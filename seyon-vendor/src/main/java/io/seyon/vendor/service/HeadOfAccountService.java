package io.seyon.vendor.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.seyon.vendor.entity.HeadOfAccount;
import io.seyon.vendor.repository.HeadOfAccountRepository;

@Service
public class HeadOfAccountService {

	private final Logger log= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	HeadOfAccountRepository headOfAccountRepository;
	
	public HeadOfAccount saveHeadOfAccount(HeadOfAccount headOfAccount,Long companyId, String userId) {
		log.info("Saving the headOfAccount");
		if (null == headOfAccount) {
			return null;
		}
		
		if(headOfAccount.getId()!=null)//update
		{
			headOfAccount.setUpdatedBy(userId);
			headOfAccount.setUpdatedDate(new Date());
			
		}
		else{ //new one
			headOfAccount.setCompanyId(companyId);
			headOfAccount.setCreatedBy(userId);
			headOfAccount.setCreatedDate(new Date());
			
		}
		
		headOfAccount = headOfAccountRepository.save(headOfAccount);
		//Long id = voucher.getId();
		return headOfAccount;
		
	}
	
	public List<HeadOfAccount> getHeadOfAccountsForCompany(Long companyId) {
		log.info("Retrieving headOfAccounts for the company {}",companyId);
		return headOfAccountRepository.findByCompanyId(companyId);
	}

	
	
}
