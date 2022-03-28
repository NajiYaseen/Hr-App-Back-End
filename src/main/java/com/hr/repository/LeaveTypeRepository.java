package com.hr.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.entity.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {

}
