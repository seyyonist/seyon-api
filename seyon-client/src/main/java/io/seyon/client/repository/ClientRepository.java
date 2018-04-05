package io.seyon.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.seyon.client.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long>{

	ClientEntity findByName(String name);
	
}
