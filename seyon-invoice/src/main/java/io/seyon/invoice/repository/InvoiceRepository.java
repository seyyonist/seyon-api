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

	@Query("select max(inv.performadate) from invoice inv where inv.companyid=:companyid")
	Timestamp getLastProformaDate(@Param(value = "companyId") Long companyId);

	@Query("select max(inv.invoicedate) from invoice inv where inv.companyid=:companyid")
	Timestamp getLastInvoiceDate(@Param(value = "companyId") Long companyId);

	@Query(value = "select month(invoice_date) monthname, count(*) count from invoice where company_id=:companyid and year(invoice_date)=:year group by month(invoice_date)",
			nativeQuery = true)
	List<Object[]> getInvoiceCountMonthWise(@Param(value = "companyId") Long companyId,
			@Param(value = "year") Integer year);
	
	
	@Query(value = "select month(performa_date) monthname, count(*) count from invoice where company_id=:companyid and year(performa_date)=:year group by month(performa_date)",
			nativeQuery = true)
	List<Object[]> getProfomaCountMonthWise(@Param(value = "companyId") Long companyId,
			@Param(value = "year") Integer year);

}
