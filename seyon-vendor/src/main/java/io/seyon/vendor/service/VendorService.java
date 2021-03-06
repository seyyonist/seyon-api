package io.seyon.vendor.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.seyon.vendor.entity.VendorEntity;
import io.seyon.vendor.repository.VendorRepository;

@Service
public class VendorService {

	private final Logger log= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	VendorRepository vendorRepository;
	
	public VendorEntity saveVendor(VendorEntity vendor) {
		log.info("Saving the Vendors {}",vendor);
		return vendorRepository.save(vendor);
	}
	
	public List<VendorEntity> getVendorsForCompany(Long companyId) {
		log.info("Retrieving Vendors for the company {}",companyId);
		return vendorRepository.findByCompanyId(companyId);
	}

	public Long getCountOfVendors(Long companyId) {
		log.info("Retrieving total Vendors for the company {}",companyId);
		return vendorRepository.countByCompanyId(companyId);
	}
	
}
