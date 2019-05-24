package io.seyon.company.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.seyon.company.entity.Company;
import io.seyon.company.model.CompanyModel;
import io.seyon.company.model.CompanyRole;
import io.seyon.company.model.SeyonResponse;
import io.seyon.company.repository.CompanyRepository;
import io.seyon.user.entity.UserCompanyXref;
import io.seyon.user.entity.UserInfo;
import io.seyon.user.entity.UserRole;
import io.seyon.user.model.UserDetails;
import io.seyon.user.repository.UserCompanyXrefRepository;
import io.seyon.user.repository.UserRoleRepository;
import io.seyon.user.service.UserService;

@Service
public class CompanyService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserCompanyXrefRepository userCompanyXrefRepo;

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Transactional
	public SeyonResponse createCompanyAndUser(CompanyModel companyModel) {
		
		SeyonResponse seyonResponse = null;
		UserDetails userDetails = new UserDetails();
		try {
			/*
			 * Step 1- Save company and get companyId Step 2 - Save user details
			 * to user service
			 */
			Company newCompany=companyModel.getCompany();
			if(getCompany(newCompany.getCompanyName(),newCompany.getPrimaryEmail())>0) {
				throw new Exception("Company Already registered");
			}
				
			Company company = companyRepository.save(newCompany);
			UserInfo userInfo = companyModel.getUserInfo();
			UserCompanyXref xref= new UserCompanyXref();
			UserRole userRole = new UserRole();
			userInfo.setActive(true);
			userInfo.setName(company.getOwnerName());
			
			userRole.setEmail(userInfo.getEmail());
			userRole.setRoleCode("COMPANY_ADMIN");
			userRole.setCompanyId(company.getCompanyId());
			xref.setCompanyId(company.getCompanyId());
			xref.setEmail(userInfo.getEmail());
			userDetails.setUserInfo(userInfo);
			userDetails.setUserRole(userRole);
			userDetails.setUserCompanyXref(xref);
			userService.createUser(userDetails);
			seyonResponse = new SeyonResponse(0, company.getCompanyId().toString());
		} catch (Exception e) {
			log.error("Error in createCompanyAndUser", e);
			seyonResponse = new SeyonResponse(-1, e.getMessage());
		}

		return seyonResponse;
	}

	@Transactional
	public SeyonResponse updateCompany(Company company) {

		SeyonResponse seyonResponse = null;

		try {
			companyRepository.save(company);
			seyonResponse = new SeyonResponse(0, "success");
		} catch (Exception e) {
			log.error("Error in updateCompany", e);
			seyonResponse = new SeyonResponse(-1, e.getMessage());
		}

		return seyonResponse;
	}

	public Company getCompany(Long companyId) {

		Company company = null;

		try {
			company = companyRepository.findById(companyId).get();

		} catch (Exception e) {
			log.error("Error in getCompany", e);

		}

		return company;
	}
	
	
	public List<CompanyRole> getCompanies(String email){
		List<UserRole> userRole=userRoleRepository.findByEmail(email);
		List<Long> companyIds=userRole.stream().map(x->x.getCompanyId()).collect(Collectors.toList());
		Map<Long,List<UserRole>> companyRoleMap=userRole.stream().collect(Collectors.groupingBy(role->role.getCompanyId()));
		List<Company> companies=companyRepository.findByCompanyIdIn(companyIds);
		List<CompanyRole> companyRoles=companies.stream().map(comp->{
			CompanyRole cr= new CompanyRole();
			cr.setCompanyId(comp.getCompanyId());
			cr.setCompanyName(comp.getCompanyName());
			return cr;
		}).collect(Collectors.toList());
		
		for(CompanyRole cr:companyRoles) {
			List<UserRole> userRoleForCompany=companyRoleMap.get(cr.getCompanyId());
			List<String> roleCodes=userRoleForCompany.stream().map(ur->ur.getRoleCode()).collect(Collectors.toList());
			cr.setRoleCode(roleCodes);
		}
		return companyRoles;
		
	}
	
	private Integer getCompany(String companyName,String email) {
		
		Integer company = 0;
		try {
			company = companyRepository.countByCompanyNameAndPrimaryEmail(companyName,email);
		} catch (Exception e) {
			log.error("Error in getCompany", e);
		}

		return company;
	}
}
