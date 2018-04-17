package io.seyon.client.resource;

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
    			@RequestHeader(name="companyId",required=true) Long companyId ) {
		
		log.info("Incoming request {}",client);
		client.setCompanyId(companyId);
		ClientEntity cli = clientService.saveClient(client);
		log.info("Response {}",cli);
        
		return cli;
    }
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ClientEntity> getClientsForCompany(@RequestHeader(name="companyId",required=true) Long companyId) {

		log.info("Incoming request {}",companyId);
		List<ClientEntity> clis = clientService.getClientsForCompany(companyId);
		log.info("Response {}",clis);
        
		return clis;
	}
}
