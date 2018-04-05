package io.seyon.company.repository;

import org.springframework.data.repository.CrudRepository;

import io.seyon.company.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, String> {
	
	Company findByEmail(String email);

}
