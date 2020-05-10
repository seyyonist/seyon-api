package io.seyon.client.resource;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.client.config.GstnAlreadyExistException;
import io.seyon.client.entity.ClientEntity;
import io.seyon.client.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

	private final Logger log= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ClientService clientService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ClientEntity saveClientInfo(@Valid @RequestBody ClientEntity client,
    			@RequestAttribute(name="x-company-id",required=true) Long companyId, @RequestAttribute(name="x-user-name",required=true) String userId ) throws Exception {
		
		log.info("Incoming request {}",client);
		client.setCompanyId(companyId);
		client.setCreatedBy(userId);
		
		ClientEntity cli =null;
		try {
			cli = clientService.saveClient(client);
		} catch (DataIntegrityViolationException e) {
			if(e.getMessage().contains("GST")){
				throw new GstnAlreadyExistException("GSTN Number already in use");
			}
		}
		log.info("Response {}",cli);
        
		return cli;
    }
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ClientEntity> getClientsForCompany(@RequestAttribute(name="x-company-id",required=true) Long companyId) {

		log.info("Incoming request {}",companyId);
		List<ClientEntity> clis = clientService.getClientsForCompany(companyId);
		log.info("Response {}",clis);
        
		return clis;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE,path="/totalNumberOfClients")
	public Long getTotalNumberOfClients(@RequestAttribute(name="x-company-id",required=true) Long companyId) {
		log.info("Incoming request {}",companyId);
		Long count = clientService.getCountOfClients(companyId);
		log.info("TotalNumberOfClients  {}",count);
		return count;
	}
}
