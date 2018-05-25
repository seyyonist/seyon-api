package io.seyon.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.seyon.user.entity.UserInfoNoPwd;

public interface UserRepositoryNoPwd extends CrudRepository<UserInfoNoPwd, String> {
	
	UserInfoNoPwd findByEmail(String email);
	
	List<UserInfoNoPwd> findByCompanyId(Long companyId);

}
