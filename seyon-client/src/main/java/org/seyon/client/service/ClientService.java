package org.seyon.client.service;

import org.seyon.client.entity.ClientEntity;
import org.seyon.client.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	private final Logger log= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ClientRepository clientRepository;
	
	public ClientEntity saveClient(ClientEntity client) {
		log.info("Saving the client {}",client);
		return clientRepository.save(client);
	}
}
