package io.seyon.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyon.SeyonApiApplicationTests;

import io.seyon.user.model.SeyonResponse;
import io.seyon.user.model.UserDetails;
import io.seyon.user.repository.UserRepository;
import io.seyon.user.repository.UserRoleRepository;

@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	public SeyonResponse createUser(UserDetails userDetails) {

		SeyonResponse seyonResponse = null;
		try {
			userRepository.save(userDetails.getUserInfo());
			userRoleRepository.save(userDetails.getUserRole());
			seyonResponse = new SeyonResponse(0, "success");
		} catch (Exception e) {
			log.error("Error in createUser", e);
			seyonResponse = new SeyonResponse(-1, e.getMessage());
		}
		
		return seyonResponse;
	}

}
