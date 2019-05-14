package io.seyon.vendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.seyon.vendor.entity.HeadOfAccount;

public interface HeadOfAccountRepository extends JpaRepository<HeadOfAccount, Long>{

	List<HeadOfAccount> findByCompanyId(Long companyId);
	
	
}
