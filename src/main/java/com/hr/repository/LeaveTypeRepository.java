package com.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.entity.Leave;
import com.hr.entity.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {

	List<Leave> findByLeaveType(LeaveType leaveType);

}
