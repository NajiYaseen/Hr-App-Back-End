package com.hr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.entity.Employee;
import com.hr.entity.ExpenseClaim;
import com.hr.entity.Leave;

public interface ExpenseRepository extends JpaRepository<ExpenseClaim, Long> {

	List<ExpenseClaim> findByEmployee(Employee employee);

}
