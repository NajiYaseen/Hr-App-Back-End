package com.hr.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "type")
public class LeaveType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "leave_type_id")
	private Long leaveTypeId;

	@Column(name = "select_leave_type")
	private String selectLeaveType;

	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Leave.class)
	private List<Leave> leave;

	public LeaveType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveType(Long leaveTypeId, String selectLeaveType, List<Leave> leave) {
		super();
		this.leaveTypeId = leaveTypeId;
		this.selectLeaveType = selectLeaveType;
		this.leave = leave;
	}

	public LeaveType(Long leaveTypeId, String selectLeaveType) {
		super();
		this.leaveTypeId = leaveTypeId;
		this.selectLeaveType = selectLeaveType;
	}

	public Long getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getSelectLeaveType() {
		return selectLeaveType;
	}

	public void setSelectLeaveType(String selectLeaveType) {
		this.selectLeaveType = selectLeaveType;
	}

	public List<Leave> getLeaves() {
		return leave;
	}

	public void setLeaves(List<Leave> leave) {
		this.leave = leave;
	}

}
