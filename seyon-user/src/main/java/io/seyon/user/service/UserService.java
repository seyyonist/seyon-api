package io.seyon.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.seyon.user.entity.UserInfo;
import io.seyon.user.entity.UserInfoNoPwd;
import io.seyon.user.entity.UserRole;
import io.seyon.user.model.SeyonResponse;
import io.seyon.user.model.UserDetails;
import io.seyon.user.repository.UserRepository;
import io.seyon.user.repository.UserRepositoryNoPwd;
import io.seyon.user.repository.UserRoleRepository;

@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("bcryptEncoder")
	PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRepositoryNoPwd userRepositoryNoPwd;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Transactional
	public SeyonResponse createUser(UserDetails userdetails) {
		
		
		UserInfo userInfo= userdetails.getUserInfo();
		String password = userInfo.getPassword();
		log.debug("Entry createUser");
		SeyonResponse seyonResponse = null;
		try {
			
			if (!StringUtils.isEmpty(password)) {
				String encodedPassword = encoder.encode(password);
				userInfo.setPassword(encodedPassword);
				userRepository.save(userInfo);
			}
			else
			{
				UserInfoNoPwd userInfoNoPwd = new UserInfoNoPwd();
				userInfoNoPwd.setEmail(userInfo.getEmail());
				userInfoNoPwd.setName(userInfo.getName());
				userInfoNoPwd.setActive(userInfo.getActive());
				userInfoNoPwd.setCompanyId(userInfo.getCompanyId());
				userRepositoryNoPwd.save(userInfoNoPwd);
				
			}
			
			UserRole userRole=userdetails.getUserRole();
			if(null!=userRole) {
				userRoleRepository.save(userRole);
			}
			seyonResponse = new SeyonResponse(0, "success");
		} catch (Exception e) {
			log.error("Error in createUser", e);
			seyonResponse = new SeyonResponse(-1, e.getMessage());
		}

		return seyonResponse;
	}

	@Transactional
	public SeyonResponse updateUser(String email, String name, String password, Boolean active) {

		log.debug("Entry updateUser");
		SeyonResponse seyonResponse = null;
		try {
			if (!StringUtils.isEmpty(email)) {

				UserInfo userInfo = userRepository.findByEmail(email);
				if (!StringUtils.isEmpty(name)) {
					userInfo.setName(name);

				}
				if (!StringUtils.isEmpty(password)) {

					String encodedPassword = encoder.encode(password);
					userInfo.setPassword(encodedPassword);
				}
				if (!StringUtils.isEmpty(active)) {
					userInfo.setActive(active);
				}

				seyonResponse = new SeyonResponse(0, "success");
			}

		} catch (Exception e) {
			log.error("Error in createUser", e);
			seyonResponse = new SeyonResponse(-1, e.getMessage());
		}

		return seyonResponse;
	}

	@Transactional
	public SeyonResponse addUserRole(String email, String roleCode) {

		log.debug("Entry addUserRole");
		SeyonResponse seyonResponse = null;
		try {
			if (!StringUtils.isEmpty(email)) {
				List<UserRole> userRoles = userRoleRepository.findByEmail(email);
				if (userRoles != null) {
					UserRole userRole = new UserRole();
					userRole.setEmail(email);
					userRole.setRoleCode(roleCode);
					userRoles.add(userRole);
					userRoleRepository.saveAll(userRoles);
					seyonResponse = new SeyonResponse(0, "success");
				} else {
					seyonResponse = new SeyonResponse(-2, "No email id found in user role table- " + email);
				}

			}

		} catch (Exception e) {
			log.error("Error in addUserRole", e);
			seyonResponse = new SeyonResponse(-1, e.getMessage());
		}

		return seyonResponse;
	}

	@Transactional
	public SeyonResponse deleteUserRole(Long roleId) {

		log.debug("Entry deleteUserRole");
		SeyonResponse seyonResponse = null;
		try {

			userRoleRepository.deleteById(roleId);
			seyonResponse = new SeyonResponse(0, "success");

		} catch (

		Exception e) {
			log.error("Error in deleteUserRole", e);
			seyonResponse = new SeyonResponse(-1, e.getMessage());
		}

		return seyonResponse;
	}

	@Transactional
	public SeyonResponse resetPassword(String emailName) {

		log.debug("Entry resetPassword");
		SeyonResponse seyonResponse = null;
		try {
			UserInfo userInfo = userRepository.findByEmail(emailName);
			if (userInfo != null) { // User update with default password
				String encodedPassword = encoder.encode("welcome1");
				userInfo.setPassword(encodedPassword);
				userRepository.save(userInfo);
				// TODO: Mail the default password to email id
				seyonResponse = new SeyonResponse(0, "success");
			} else {
				seyonResponse = new SeyonResponse(-2, "No email id found in user table- " + emailName);
			}

		} catch (Exception e) {
			log.error("Error in resetPassword", e);
			seyonResponse = new SeyonResponse(-1, e.getMessage());
		}

		return seyonResponse;
	}
	
	private boolean isUserAlreadyRegistered(UserInfo userInfo) {
		return false;
	}
	
	public List<UserInfo> getUsers(Long companyId){
		return userRepository.findByCompanyId(companyId);
	}
	
	public List<UserRole> getUserRoles(String email){
		return userRoleRepository.findByEmail(email);
	}

	public UserInfo getUser(String userId) {
		return userRepository.findByEmail(userId);
	}

	public UserInfo getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
