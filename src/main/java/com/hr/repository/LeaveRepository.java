package com.hr.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.entity.Employee;
import com.hr.entity.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
	
//	@Query(value = "select * from leave  where (TO_DATE(TO_CHAR(leave.leave_from,'YYYY-MM-DD') BETWEEN TO_DATE(:startD,'YYYY-MM-DD') AND TO_DATE(:endD,'YYYY-MM-DD')))", nativeQuery = true)
//	List<Leave> findAllLeaves(@Param("startD") String from, @Param("endD") String to);

	List<Leave> findByEmployee(Employee employee);

	List<Leave> findByLeaveFromBetween(Date start, Date end);

	List<Leave> findByEmployeeAndLeaveFromBetween(Employee employee, Date from, Date to);

}
