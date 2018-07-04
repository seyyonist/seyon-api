package io.seyon.invoice.repository;

import org.springframework.data.repository.CrudRepository;

import io.seyon.invoice.entity.CompanyView;

public interface CompanyViewRepository extends CrudRepository<CompanyView, Long> {
	
}
