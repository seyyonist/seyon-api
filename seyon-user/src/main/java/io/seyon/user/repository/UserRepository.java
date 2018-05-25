package io.seyon.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.seyon.user.entity.UserInfo;

public interface UserRepository extends CrudRepository<UserInfo, String> {
	
	UserInfo findByEmail(String email);
	
	List<UserInfo> findByCompanyId(Long companyId);

}
