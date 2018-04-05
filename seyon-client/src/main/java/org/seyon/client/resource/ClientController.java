package org.seyon.client.resource;

import javax.validation.Valid;

import org.seyon.client.entity.ClientEntity;
import org.seyon.client.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {

	private final Logger log= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ClientService clientService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ClientEntity acceptInput(@Valid @RequestBody ClientEntity client ) {
		log.info("Incoming request {}",client);
		ClientEntity cli = clientService.saveClient(client);
		log.info("Response {}",cli);
        return cli;
    }
}
