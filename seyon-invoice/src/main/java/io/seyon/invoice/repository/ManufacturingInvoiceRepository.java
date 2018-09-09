package io.seyon.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import io.seyon.invoice.entity.ManufacturingInvoice;

public interface ManufacturingInvoiceRepository extends JpaRepository<ManufacturingInvoice, Long>,JpaSpecificationExecutor<ManufacturingInvoice> {

	ManufacturingInvoice findByProFormaId(String proformaInvoiceId);

}
