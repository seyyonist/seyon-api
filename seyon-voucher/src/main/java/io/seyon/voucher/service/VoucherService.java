package io.seyon.voucher.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public Long saveVoucher(Voucher voucher) {
		log.info("Saving the voucher");
		if (null == voucher) {
			return null;
		}
		voucher = voucherRepository.save(voucher);
		Long id = voucher.getId();
		return id;
	}
	
	
	public void deleteVoucher(Long id) {
		log.info("Deleting the voucher");
		voucherRepository.deleteById(id);
		return;
	}
	
	public Iterable<Voucher> getVoucherist(Integer pageNumber, Long companyId, String voucherId,  String vendorName,
			Date voucherStDate, Date voucherEndDate) {

		log.debug("Getting page {}", pageNumber);

		Pageable page = PageRequest.of(pageNumber, voucherProperties.getPageSize(),
				Sort.by(Direction.DESC, "voucherDate"));

		Specification<Voucher> spec = (Root<Voucher> root, CriteriaQuery<?> cq, CriteriaBuilder cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(cb.equal(root.get("companyId"), companyId));

			if (null != voucherId) {
				predicates.add(cb.equal(root.get("voucherId"), voucherId));
			}
			if (null != vendorName) {
				predicates.add(cb.equal(root.get("vendorName"), vendorName));
			}

			
			if (null != voucherStDate && null != voucherEndDate) {
				predicates.add(cb.between(root.get("voucherDate"), voucherStDate, voucherEndDate));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};

		return voucherRepository.findAll(spec, page);
	}
	

}
