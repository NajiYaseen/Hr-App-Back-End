package com.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.entity.Employee;
import com.hr.entity.ExpenseClaim;

public interface ExpenseRepository extends JpaRepository<ExpenseClaim, Long> {

	List<ExpenseClaim> findByEmployee(Employee employee);

}
