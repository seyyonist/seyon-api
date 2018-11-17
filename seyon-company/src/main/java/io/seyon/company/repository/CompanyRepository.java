package io.seyon.company.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.seyon.company.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	public Company findByCompanyName(String companyName);
	public Integer countByCompanyNameAndPrimaryEmail(String companyName,String primaryEmail);
	
}
