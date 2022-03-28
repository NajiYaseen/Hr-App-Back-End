package com.hr.entity;

public class LeaveTypeDetails {
	private String detail;
	private Long leaveId;

	public LeaveTypeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveTypeDetails(String detail, Long leaveId) {
		super();
		this.detail = detail;
		this.leaveId = leaveId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

}
