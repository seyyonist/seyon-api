package io.seyon;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.seyon.company.entity.Company;
import io.seyon.company.entity.User;
import io.seyon.company.model.CompanyModel;
import io.seyon.company.service.CompanyService;
import io.seyon.invoice.entity.SACCode;
import io.seyon.invoice.repository.SACCodeRepository;

@Component
public class SeyonTestDataLoader implements CommandLineRunner {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	SACCodeRepository sACCodeRepository;
	
	 @Override
	 public void run(String... strings) throws Exception {
		 log.info("SeyonTestDataLoader loading test data...");
		 
		 createCompanyAndUser();
		 createSACCodes();
	     
	    }
	 
	 public void createSACCodes(){
		 
		 try {
			List sacCodes = new ArrayList<SACCode>();
			 SACCode sacCode = new SACCode();
			 
			 sacCode.setSacCode("SAC001");
			 sacCode.setCgstPercent(new Double("2.5"));
			 sacCode.setEndDate(null);
			 sacCode.setIgstPercent(new Double("2.5"));
			 sacCode.setSgstPercent(new Double("2.5"));
			 sacCode.setStartDate(null);
			 
			 SACCode sacCode1 = new SACCode();
			 sacCode1.setSacCode("SAC002");
			 sacCode1.setCgstPercent(new Double("5"));
			 sacCode1.setEndDate(null);
			 sacCode1.setIgstPercent(new Double("5"));
			 sacCode1.setSgstPercent(new Double("5"));
			 sacCode1.setStartDate(null);
			 
			 sacCodes.add(sacCode);
			 sacCodes.add(sacCode1);
			 
			 sACCodeRepository.saveAll(sacCodes);
		} catch (NumberFormatException e) {
			log.error("Error in createSACCode test data loader:",e);
		}
	 }
	 
	 public void createCompanyAndUser(){
		 
		 try {
			 CompanyModel companyModel = new CompanyModel();
			 Company company = new Company();
			 
			 company.setAccountingType("");
			 company.setAccountName("TESTBANKACCT");
			 company.setAccountNo("TEST1234");
			 company.setAccountType("TESTSAVINGS");
			 company.setAddressLine1("123 Test st");
			 company.setAddressLine2("Test area");
			 company.setBankName("TEST BANK");
			 company.setBranch("TEST BRANCH");
		     company.setBranchIFSCCode("TEST001245");
		     company.setCity("CHENNAI");
		     company.setCompanyName("TESTCOMPANY");
		     company.setFaxNo("13131313133");
		     company.setGstNo("G1234567894564133");
		     company.setLogoImg("");
		     company.setOwnerName("TEST OWNER");
		     company.setPanNo("AFJPTEST1234");
		     company.setPhonePrimary("9874567890");
		     company.setPhoneSecondary("9874567891");
		     company.setPinCode("600500");
		     company.setPrimaryEmail("t1@t.com");
		     company.setSecondaryEmail("test2@test.com");
		     company.setServiceTaxRegNo("S1131616161");
		     company.setSignatureImg("");
		     company.setState("TN");
		     company.setTitle("TEST C");
		     company.setTanNo("T6161616161616");
		     
		     User userInfo = new User();
		     userInfo.setActive(true);
		     userInfo.setEmail("t1@t.com");
		     userInfo.setName("TESTUSR1");
		     userInfo.setPassword("pass");
		 
		     companyModel.setCompany(company);
		     companyModel.setUserInfo(userInfo);
		     
		     companyService.createCompanyAndUser(companyModel);
			
		} catch (Exception e) {
			log.error("Error in  createCompanyAndUser test data loader:",e);
		}
		 
	 }

}
