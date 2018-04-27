package io.seyon.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.seyon.invoice.entity.Particulars;

public interface ParticularsRepository extends JpaRepository<Particulars, Long> {

}
