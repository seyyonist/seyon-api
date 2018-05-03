package io.seyon.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.seyon.user.entity.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long>{

	public List<UserRole> findByEmail(String email);
	
}
