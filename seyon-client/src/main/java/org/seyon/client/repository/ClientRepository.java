package org.seyon.client.repository;

import org.seyon.client.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long>{

	ClientEntity findByName(String name);
	
}
