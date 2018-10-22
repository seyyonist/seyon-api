package io.seyon.invoice.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.seyon.invoice.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>,JpaSpecificationExecutor<Invoice> {

   Optional<Invoice> findByPerformaId(String performaId);
   
   @Query("SELECT MAX(inv.performaDate) from Invoice inv where inv.companyId=:companyId")
   LocalDate getMinProformaDate( @Param(value = "companyId") Long companyId);
}
