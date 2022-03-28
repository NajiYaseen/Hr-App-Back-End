package com.hr.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hr.entity.Employee;
import com.hr.entity.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
	List<Leave> findByEmployeeIdAndLeaveFromAndLeaveTo(Long employeeid, Date leaveFrom, Date leaveTo);

//	List<Leave> findByLeaveFromAndLeaveTo(Date leaveFrom, Date leaveTo);
//
//	@Query(value = "select * from leave  where (TO_DATE(TO_CHAR(leave.leave_from,'YYYY-MM-DD') BETWEEN TO_DATE(:startD,'YYYY-MM-DD') AND TO_DATE(:endD,'YYYY-MM-DD')))", nativeQuery = true)
//	List<Leave> findAllLeaves(@Param("startD") String from, @Param("endD") String to);

	List<Leave> findByLeaveFromBetween(Long from, Long to);

	List<Leave> findByEmployeeIdAndLeaveFromBetween(Long id, Long from, Long to);

	List<Leave> findByEmployee(Employee employee);

	List<Leave> findByLeaveFromBetween(Date start, Date end);

	List<Leave> findByEmployeeAndLeaveFromBetween(Employee employee, Date from, Date to);

}
