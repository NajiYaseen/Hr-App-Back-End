package com.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.entity.ExpenseClaim;
import com.hr.entity.ExpenseClaimDetail;

public interface ExpenseDetailRepository extends JpaRepository<ExpenseClaimDetail, Long> {

	List<ExpenseClaimDetail> findByexpenseClaim(ExpenseClaim expenseClaim);

}
