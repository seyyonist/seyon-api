package io.seyon.voucher.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.seyon.voucher.entity.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Long>,JpaSpecificationExecutor<Voucher> {

	Long countByCompanyId(Long companyId);
	
	Long countByCompanyIdAndVoucherDate(Long companyId,Date voucherDate);
	
	@Query("select count(1) from Voucher v where year(v.voucherDate) = year(current_date) and  month(v.voucherDate) = month(current_date) and companyId=:companyId")
	Long getAllOfCurrentMonth(@Param("companyId") Long companyId);
}
