package io.seyon.vendor.resource;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.vendor.entity.VendorEntity;
import io.seyon.vendor.service.VendorService;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

	private final Logger log= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	VendorService vendorService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public VendorEntity saveClientInfo(@Valid @RequestBody VendorEntity client,
    			@RequestHeader(name="x-company-id",required=true) Long companyId, @RequestHeader(name="x-user-name",required=true) String userId ) {
		log.info("Incoming request {}",client);
		client.setCompanyId(companyId);
		client.setCreatedBy(userId);
		VendorEntity cli = vendorService.saveVendor(client);
		log.info("Response {}",cli);     
		return cli;
    }
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<VendorEntity> getClientsForCompany(@RequestHeader(name="x-company-id",required=true) Long companyId) {
		log.info("Incoming request {}",companyId);
		List<VendorEntity> clis = vendorService.getVendorsForCompany(companyId);
		log.info("Response {}",clis);
		return clis;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE,path="/totalNumberOfVendors")
	public Long getTotalNumberOfVendors(@RequestHeader(name="x-company-id",required=true) Long companyId) {
		log.info("Incoming request {}",companyId);
		Long count = vendorService.getCountOfVendors(companyId);
		log.info("TotalNumberOfVendors  {}",count);
		return count;
	}
}
