package io.seyon.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.seyon.user.entity.UserCompanyXref;

public interface UserCompanyXrefRepository extends CrudRepository<UserCompanyXref, Long> {
	
	List<UserCompanyXref> findByEmail(String email);
	List<UserCompanyXref> findByCompanyId(Long companyId);
}
