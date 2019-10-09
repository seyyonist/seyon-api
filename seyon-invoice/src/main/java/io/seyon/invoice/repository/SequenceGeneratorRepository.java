package io.seyon.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.seyon.invoice.entity.SequenceGenerator;

public interface SequenceGeneratorRepository extends JpaRepository<SequenceGenerator, Long> {

	
}
