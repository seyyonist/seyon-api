package io.seyon.invoice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import io.seyon.invoice.entity.ClientEntityView;
import io.seyon.invoice.entity.CompanyView;
import io.seyon.invoice.entity.Invoice;
import io.seyon.invoice.entity.Particulars;
import io.seyon.invoice.repository.ClientViewRepository;
import io.seyon.invoice.repository.CompanyViewRepository;
import io.seyon.invoice.repository.InvoiceRepository;
import io.seyon.invoice.repository.ParticularsRepository;

@Service
public class GenerateInvoiceService {

	
	private static final Logger log = LoggerFactory.getLogger(GenerateInvoiceService.class);
	
	@Autowired
	TemplateEngine templateEngine;
	
	@Autowired
	CompanyViewRepository cr;
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Resource
	private ClientViewRepository clientViewRepository;
	
	@Autowired
	private ParticularsRepository particularsRepository;
	
	public String processInvoiceReport(String performaId) {	
		final Context ctx=getContext(performaId);
		return templateEngine.process("invoice.html",ctx);
	}
	
	
	
	public String processPInvoiceReport(String performaId) {

		final Context ctx=getContext(performaId);
		return templateEngine.process("P-invoice.html",ctx);
	}
	
	private Context getContext(String performaId) {
		Optional<Invoice> opInv = invoiceRepository.findByPerformaId(performaId);
		if (!opInv.isPresent()) {
			new NoResultException("No Invoice Found");
		}
		Invoice inv=opInv.get();
		List<Particulars> parti=particularsRepository.findByInvoiceTableId(inv.getId());
		log.info("Retrieved Invoice {}, Particulars {}", inv,parti);
		
		Optional<CompanyView> opsCmy=cr.findById(inv.getCompanyId());
		if(!opsCmy.isPresent()) {
			new NoResultException("No Invoice Found");
		}
		CompanyView cmp=opsCmy.get();
		log.info("Retrieved Company {}", cmp);
		Optional<ClientEntityView> opcev=clientViewRepository.findById(inv.getClientId());
		if(!opcev.isPresent()) {
			new NoResultException("No Invoice Found");
		}
		ClientEntityView cev=opcev.get();
		log.info("Retrieved Client {}", cev);
		final Context ctx=new Context();
		Map<String, Object> variables= new HashMap<>();
		variables.put("invoice", inv);
		variables.put("particulars", parti);
		variables.put("company", cmp);
		variables.put("client", cev);
		ctx.setVariables(variables);
		
		return ctx;
	}
}
