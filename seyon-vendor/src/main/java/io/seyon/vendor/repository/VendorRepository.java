package io.seyon.vendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.seyon.vendor.entity.VendorEntity;

public interface VendorRepository extends JpaRepository<VendorEntity, Long>{

	List<VendorEntity> findByCompanyId(Long companyId);
	
	List<VendorEntity> findByName(String name);
	
}
