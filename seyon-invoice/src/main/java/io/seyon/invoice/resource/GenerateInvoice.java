package io.seyon.invoice.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import io.seyon.invoice.service.GenerateInvoiceService;
import io.seyon.invoice.service.InvoiceService;

@Controller
@RequestMapping("/api/invoice")
public class GenerateInvoice {

	
	private static final Logger log = LoggerFactory.getLogger(GenerateInvoice.class);

	@Autowired
	private GenerateInvoiceService invoiceService;
	
	@RequestMapping(path="/IhtmlReport",method=RequestMethod.GET,produces= "text/html")
	public @ResponseBody String generateIHtmlInvoice(@RequestParam(required = true) String performaId) throws IOException {
		log.info("Genetrating the html Invoice {}",performaId);
		return invoiceService.processInvoiceReport(performaId);
	}
	
	@RequestMapping(path="/PhtmlReport",method=RequestMethod.GET,produces= "text/html")
	public @ResponseBody String generatePHtmlInvoice(@RequestParam(required = true) String performaId) throws IOException {
		log.info("Genetrating the html Invoice {}",performaId);
		return invoiceService.processPInvoiceReport(performaId);
	}
}
