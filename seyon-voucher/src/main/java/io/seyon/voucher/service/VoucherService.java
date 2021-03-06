package io.seyon.voucher.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.seyon.voucher.config.VoucherProperties;
import io.seyon.voucher.entity.Voucher;
import io.seyon.voucher.repository.VoucherRepository;

@Service
public class VoucherService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private VoucherRepository voucherRepository;
	
	@Autowired
	private VoucherProperties voucherProperties;


	@Transactional
	public Voucher saveVoucher(Voucher voucher,Long companyId, String userId) {
		log.info("Saving the voucher");
		if (null == voucher) {
			return null;
		}
		
		if(voucher.getId()!=null)//update
		{
			voucher.setUpdatedBy(userId);
			voucher.setUpdatedDate(new Date());
			
		}
		else{ //new one
			voucher.setVoucherId(generateUniqueVoucherID());
			voucher.setVoucherDate(new Date());
			voucher.setCreatedBy(userId);
			voucher.setCreatedDate(new Date());
			voucher.setCompanyId(companyId);
		}
		
		voucher.setStatus("NEW");
		voucher = voucherRepository.save(voucher);
		//Long id = voucher.getId();
		return voucher;
	}
	
	
	public void deleteVoucher(Long id) {
		log.info("Deleting the voucher");
		voucherRepository.deleteById(id);
		return;
	}
	
	public Iterable<Voucher> getVoucherist(Integer pageNumber, Long companyId, String voucherId,  Long vendorId,
			Date voucherStDate, Date voucherEndDate,String status) {

		log.debug("Getting page {}", pageNumber);

		Pageable page = PageRequest.of(pageNumber, voucherProperties.getPageSize(),
				Sort.by(Direction.DESC, "voucherDate"));

		Specification<Voucher> spec = (Root<Voucher> root, CriteriaQuery<?> cq, CriteriaBuilder cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(cb.equal(root.get("companyId"), companyId));

			if (null != voucherId) {
				predicates.add(cb.equal(root.get("voucherId"), voucherId));
			}
			if (null != vendorId) {
				predicates.add(cb.equal(root.get("vendorId"), vendorId));
			}

			
			if (null != voucherStDate && null != voucherEndDate) {
				predicates.add(cb.between(root.get("voucherDate"), voucherStDate, voucherEndDate));
			}
			if(null!=status) {
				predicates.add(cb.equal(root.get("status"), status));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};

		return voucherRepository.findAll(spec, page);
	}


	public Voucher getVoucherist(Long id) {
		Optional<Voucher> opVoucher=voucherRepository.findById(id);
		log.info("Voucher {}",opVoucher.get());
		return opVoucher.orElse(null);
	}
	
	public String  generateUniqueVoucherID(){
	    DateFormat dateFormat = new SimpleDateFormat("yyddmm");
	    Date date = new Date();
	    String dt=String.valueOf(dateFormat.format(date));
	    SimpleDateFormat time = new SimpleDateFormat("HHmm");
	    String tm= String.valueOf(time.format(new Date()));//time in 24 hour format
	    String id= "V"+dt+tm;
	    return id;   
	}
	
	
	public Map<String,Long> getVoucherCounts(Long companyId){
		Map<String, Long> result=new HashMap<>();
		Long totalVoucher=voucherRepository.countByCompanyId(companyId);
		Long countByMonth=voucherRepository.getAllOfCurrentMonth(companyId);
		result.put("Total", totalVoucher);
		result.put("Month", countByMonth);
		log.info("returning voucher count {}",result);
		return result;
	}
	
	public Voucher approve(Voucher v) {
		v.setStatus("APPROVED");
		Voucher uv=voucherRepository.save(v);
		return uv;
	}

}
