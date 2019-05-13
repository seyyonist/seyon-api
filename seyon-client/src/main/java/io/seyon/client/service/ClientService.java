package io.seyon.client.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.seyon.client.entity.ClientEntity;
import io.seyon.client.repository.ClientRepository;

@Service
public class ClientService {

	private final Logger log= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ClientRepository clientRepository;
	
	public ClientEntity saveClient(ClientEntity client) {
		log.info("Saving the client {}",client);
		return clientRepository.save(client);
	}
	
	public List<ClientEntity> getClientsForCompany(Long companyId) {
		log.info("Retrieving clients for the company {}",companyId);
		return clientRepository.findByCompanyId(companyId);
	}
	
	public Long getCountOfClients(Long companyId) {
		log.info("Retrieving Total number of clients for the company {}",companyId);
		return clientRepository.countByCompanyId(companyId);
	}
}
