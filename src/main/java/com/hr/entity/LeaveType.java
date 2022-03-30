package com.hr.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "type")
public class LeaveType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "typeId")
	private Long Id;
	@Column(name = "select_leave_type")
	private String selectLeaveType;
	
	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Leave.class)
	private List<Leave> leave;

	public LeaveType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveType(Long id, String selectLeaveType, List<Leave> leave) {
		super();
		Id = id;
		this.selectLeaveType = selectLeaveType;
		this.leave = leave;
	}

	public LeaveType(String selectLeaveType, List<Leave> leave) {
		super();
		this.selectLeaveType = selectLeaveType;
		this.leave = leave;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getSelectLeaveType() {
		return selectLeaveType;
	}

	public void setSelectLeaveType(String selectLeaveType) {
		this.selectLeaveType = selectLeaveType;
	}

	public List<Leave> getLeave() {
		return leave;
	}

	public void setLeave(List<Leave> leave) {
		this.leave = leave;
	}

}
