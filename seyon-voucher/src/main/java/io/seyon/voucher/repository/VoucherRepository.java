package io.seyon.voucher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import io.seyon.voucher.entity.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Long>,JpaSpecificationExecutor<Voucher> {

}
