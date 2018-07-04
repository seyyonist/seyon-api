package io.seyon.invoice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import io.seyon.invoice.entity.ClientEntityView;

public interface ClientViewRepository extends JpaRepository<ClientEntityView, Long>{
	
}
