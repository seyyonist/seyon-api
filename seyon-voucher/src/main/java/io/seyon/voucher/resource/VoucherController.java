package io.seyon.voucher.resource;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.voucher.entity.Voucher;
import io.seyon.voucher.model.VoucherSearch;
import io.seyon.voucher.service.VoucherService;

@RestController
@RequestMapping("/api/voucher")
public class VoucherController {

	@Autowired
	private VoucherService voucherService;

	private static final Logger log = LoggerFactory.getLogger(VoucherController.class);


	@PostMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE , path = "/saveVoucher")
	public Long saveVoucher(@RequestBody Voucher voucher,
			@RequestHeader(name = "x-company-id", required = true) Long companyId,
			@RequestHeader(name = "x-user-name", required = true) String userId) {
		log.info("Voucher save request {}", voucher);
		voucher.setCreatedBy(userId);
		voucher.setCreatedDate(new Date());
		voucher.setCompanyId(companyId);
		Long id = voucherService.saveVoucher(voucher);
		log.info("Voucher save response{}", id);
		return id;
	}
	
	@PostMapping(path = "/search", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Iterable<Voucher> searchInvoice(@RequestParam(required = false) Integer pageNumber,
			@RequestHeader(name = "x-company-id", required = true) Long companyId,
			@RequestBody VoucherSearch voucherSearch) {
		log.info(
				"Invoice Search Data pageNumber {},companyId {},"
						+ "voucherId {},vendorName {}, voucher Start Date {},voucher end date {}",
				pageNumber, companyId, voucherSearch.getVoucherId(), voucherSearch.getVendorId(),
				voucherSearch.getStartDate(), voucherSearch.getEndDate());

		if (null == pageNumber)
			throw new IllegalArgumentException("Page Number is null");
		if (companyId == null)
			throw new IllegalArgumentException("Company Id is null");
		if (null != voucherSearch.getStartDate() && null == voucherSearch.getEndDate())
			throw new IllegalArgumentException("End date is null");
		if (null != voucherSearch.getEndDate() && null == voucherSearch.getStartDate())
			throw new IllegalArgumentException("Start date is null");
		

		if(null!=voucherSearch.getEndDate() && null!=voucherSearch.getStartDate() && !voucherSearch.getStartDate().equals(voucherSearch.getEndDate()) 
				&& voucherSearch.getEndDate().before(voucherSearch.getStartDate())) {
			throw new IllegalArgumentException("End date is greater than start date");
		}

		return voucherService.getVoucherist(pageNumber, companyId, voucherSearch.getVoucherId(),  voucherSearch.getVendorId(),
				voucherSearch.getStartDate(), voucherSearch.getEndDate());

	}
	
	@DeleteMapping( produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public String deleteVoucher(@RequestParam Long id) {
		voucherService.deleteVoucher(id);
		return "Successfully Deleted";
	}
	
	@GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Voucher getVoucher(@RequestParam Long id) {
		return voucherService.getVoucherist(id);
	}

}
