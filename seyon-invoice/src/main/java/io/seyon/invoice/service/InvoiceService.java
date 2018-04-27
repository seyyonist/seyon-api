package io.seyon.invoice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.seyon.invoice.config.InvoiceProperties;
import io.seyon.invoice.entity.Invoice;
import io.seyon.invoice.entity.InvoiceStatus;
import io.seyon.invoice.entity.Particulars;
import io.seyon.invoice.repository.InvoiceRepository;
import io.seyon.invoice.repository.ParticularsRepository;

@Service
public class InvoiceService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private ParticularsRepository particularsRepository;

	@Autowired
	InvoiceProperties invoiceProperties;

	public Iterable<Invoice> getInvoiceList(Integer pageNumber, Long companyId, Long id, Long clientId,
			Date invoiceStDate, Date invoiceEdDate, InvoiceStatus status) {

		log.debug("Getting page {}", pageNumber);

		Pageable page = PageRequest.of(pageNumber, invoiceProperties.getPageSize(),
				Sort.by(Direction.DESC, "invoiceDate"));

		Specification<Invoice> spec = (Root<Invoice> root, CriteriaQuery<?> cq, CriteriaBuilder cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(cb.equal(root.get("companyId"), companyId));

			if (null != id) {
				predicates.add(cb.equal(root.get("id"), id));
			}
			if (null != clientId) {
				predicates.add(cb.equal(root.get("clientId"), clientId));
			}

			if (null != invoiceStDate && null != invoiceEdDate) {
				predicates.add(cb.between(root.get("invoiceDate"), invoiceStDate, invoiceEdDate));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};

		return invoiceRepository.findAll(spec, page);
	}
	
	@Transactional
	public Long saveInvoice(Invoice invoice, List<Particulars> particulars) {
		
		log.info("Saving the invoice");
		invoice=invoiceRepository.save(invoice);
		Long invoiceId=invoice.getId();
		
		log.info("Updating the particulars with invoice id {}",invoiceId);
		particulars.forEach(part->{
			part.setInvoiceId(invoiceId);
		});
		
		log.info("Saving particulars");
		particularsRepository.saveAll(particulars);
		
		return invoice.getId();
	}
	
	public Long createInvoice(Invoice invoice) {
		log.info("Moving the invoice to created status, {}", invoice);
		invoice.setStatus(InvoiceStatus.CREATED);
		
		return invoiceRepository.save(invoice);
	}

}
