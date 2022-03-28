package com.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.entity.ExpenseClaimDetail;

public interface ExpenseDetailRepository extends JpaRepository<ExpenseClaimDetail, Long> {

}
