package io.seyon.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import io.seyon.company.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>,JpaSpecificationExecutor<Company> {
	
	public Company findByCompanyName(String companyName);
	public Integer countByCompanyNameAndPrimaryEmail(String companyName,String primaryEmail);
	public List<Company> findByCompanyIdIn(List<Long> companyIds);
	
}
