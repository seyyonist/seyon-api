package io.seyon.invoice.resource;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import io.seyon.invoice.entity.SequenceGenerator;
import io.seyon.invoice.repository.SequenceGeneratorRepository;

@Component
public class SequenceGeneratorService {

	@Autowired
	SequenceGeneratorRepository  sequenceGeneratorRepository;
	
	@Transactional
	public synchronized Long nextManuInvId() {
		SequenceGenerator sqG= sequenceGeneratorRepository.getOne(1L);
		Long id=sqG.getManuInvoiceid();
		Long newId=++id;
		sqG.setManuInvoiceid(newId);
		sequenceGeneratorRepository.save(sqG);
		return newId;
	}
	
	@Transactional
	public synchronized Long nextServiceInvId() {
		SequenceGenerator sqG= sequenceGeneratorRepository.getOne(1L);
		Long id=sqG.getServiceInvoiceId();
		Long newId=++id;
		sqG.setServiceInvoiceId(newId);
		sequenceGeneratorRepository.save(sqG);
		return newId;
	}
	
	@PostConstruct
	@Transactional
	public void insertIfEmpty() {
		List<SequenceGenerator> sqGs= sequenceGeneratorRepository.findAll();
		if(CollectionUtils.isEmpty(sqGs)) {
			SequenceGenerator sqG= new SequenceGenerator();
			sqG.setManuInvoiceid(1000L);
			sqG.setServiceInvoiceId(1000L);
			sequenceGeneratorRepository.save(sqG);
		}
	}
}
