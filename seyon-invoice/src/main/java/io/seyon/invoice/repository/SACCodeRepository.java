package io.seyon.invoice.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.seyon.invoice.entity.SACCode;

public interface SACCodeRepository extends CrudRepository<SACCode, Long> {

	@Query("select s from SACCode where sacCode=:sacCode and startDate<=:invoiceDate")
	List<SACCode> findByDate(@Param(value = "invoiceDate") LocalDate invoiceDate,@Param(value = "sacCode") String sacCode);
}
