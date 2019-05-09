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

public interface InvoiceRepository extends JpaRepository<Invoice, Long>,JpaSpecificationExecutor<Invoice> {

   Optional<Invoice> findByPerformaId(String performaId);
   
   @Query("SELECT MAX(inv.performaDate) from Invoice inv where inv.companyId=:companyId")
   Timestamp getLastProformaDate( @Param(value = "companyId") Long companyId);
   
   @Query("SELECT MAX(inv.invoiceDate) from Invoice inv where inv.companyId=:companyId")
   Timestamp getLastInvoiceDate( @Param(value = "companyId") Long companyId);
   
   @Query(value="select new io.seyon.invoice.repository.InvoiceMonthWiseResultMap(MONTH_NAME(inv.invoiceDate) month, COUNT(*) count) FROM Invoice inv where COMPANY_ID=:companyId and YEAR(inv.invoiceDate)=:year GROUP BY MONTH_NAME(inv.invoiceDate)"
		   ,nativeQuery=true)
   List<InvoiceMonthWiseResultMap> getInvoiceCountMonthWise( @Param(value = "companyId") Long companyId,@Param(value = "year") Integer year);
   
   /*@SqlResultSetMapping(
		    name="invoiceMonthWiseCount",
		    classes={
		        @ConstructorResult(
		            targetClass=InvoiceMonthWiseResultMap.class,
		            columns={
		                @ColumnResult(name="monthName"),
		                @ColumnResult(name="count")
		            }
		        )
		    }
		)
   
   @NamedNativeQuery(name="getInvoiceCountMonthWise", query="select MONTH_NAME(INVOICE_DATE) monthName, COUNT(*) count FROM INVOICE where COMPANY_ID=:companyId and YEAR(INVOICE_DATE)=:year GROUP BY MONTH_NAME(INVOICE_DATE)", 
		   resultSetMapping="invoiceMonthWiseCount")
   List<InvoiceMonthWiseResultMap> getInvoiceCountMonthWise( @Param(value = "companyId") Long companyId,@Param(value = "year") Integer year);*/
   
}
