package io.seyon.invoice.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.seyon.invoice.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>, JpaSpecificationExecutor<Invoice> {

	Optional<Invoice> findByPerformaId(String performaId);

	@Query("SELECT MAX(inv.performaDate) from Invoice inv where inv.companyId=:companyId")
	Timestamp getLastProformaDate(@Param(value = "companyId") Long companyId);

	@Query("SELECT MAX(inv.invoiceDate) from Invoice inv where inv.companyId=:companyId")
	Timestamp getLastInvoiceDate(@Param(value = "companyId") Long companyId);

	@Query(value = "select MONTH(INVOICE_DATE) monthName, COUNT(*) count FROM INVOICE where COMPANY_ID=:companyId and YEAR(INVOICE_DATE)=:year GROUP BY MONTH(INVOICE_DATE)",
			nativeQuery = true)
	List<Object[]> getInvoiceCountMonthWise(@Param(value = "companyId") Long companyId,
			@Param(value = "year") Integer year);
	
	
	@Query(value = "select MONTH(PERFORMA_DATE) monthName, COUNT(*) count FROM INVOICE where COMPANY_ID=:companyId and YEAR(PERFORMA_DATE)=:year GROUP BY MONTH(PERFORMA_DATE)",
			nativeQuery = true)
	List<Object[]> getProfomaCountMonthWise(@Param(value = "companyId") Long companyId,
			@Param(value = "year") Integer year);

}
