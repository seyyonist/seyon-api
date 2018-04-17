package io.seyon.company.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.seyon.company.entity.Company;
import io.seyon.company.entity.User;
import io.seyon.company.model.CompanyModel;
import io.seyon.company.model.SeyonResponse;
import io.seyon.company.repository.CompanyRepository;
import io.seyon.user.entity.UserInfo;
import io.seyon.user.entity.UserRole;
import io.seyon.user.model.UserDetails;
import io.seyon.user.service.UserService;

@Service
public class CompanyService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public SeyonResponse createCompanyAndUser(CompanyModel companyModel) {

		SeyonResponse seyonResponse = null;
		UserDetails userDetails = new UserDetails();
		try {
			/*
			 * Step 1- Save company and get companyId
			 * Step 2 - Save user details to user service
			 */
			Company company=companyRepository.save(companyModel.getCompany());
			User user=companyModel.getUserInfo();
			user.setActive(true);
			user.setName(company.getOwnerName());
			user.setCompanyId(company.getCompanyId());
			UserRole userRole= new UserRole();
			userRole.setEmail(user.getEmail());
			userRole.setRoleCode("ADMIN");
			UserInfo userInfo = new UserInfo();
			BeanUtils.copyProperties(user,userInfo);
			userDetails.setUserInfo(userInfo);
			userDetails.setUserRole(userRole);
			userService.createUser(userDetails);
			seyonResponse = new SeyonResponse(0, company.getCompanyId().toString());
		} catch (Exception e) {
			log.error("Error in createCompanyAndUser", e);
			seyonResponse = new SeyonResponse(-1, e.getMessage());
		}
		
		return seyonResponse;
	}
}
