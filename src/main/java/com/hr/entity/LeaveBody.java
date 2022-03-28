package com.hr.entity;

public class LeaveBody {

	private String from;
	private String to;
	private String note;
	private Long leaveTypeId;
	private Long employeeId;
	private Long empId;

	public LeaveBody(String from, String to, String note, Long leaveTypeId, Long employeeId, Long empId) {
		super();
		this.from = from;
		this.to = to;
		this.note = note;
		this.leaveTypeId = leaveTypeId;
		this.employeeId = employeeId;
		this.empId = empId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getLeaveType() {
		return leaveTypeId;
	}

	public void setLeaveType(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

}
