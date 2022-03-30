package com.hr.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "leave")
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leave_id")
	private Long leaveID;
	@Column(name = "leave_from")
	private Date leaveFrom;
	@Column(name = "leave_to")
	private Date leaveTo;
	@Column(name = "number_of_days")
	private int numberOfDays;
	@Column(name = "note")
	private String note;
	@Column(name = "leaveType")
	private String leaveType;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private LeaveType type;

	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Leave(Long leaveID, Date leaveFrom, Date leaveTo, int numberOfDays, String note, String leaveType,
			Employee employee, LeaveType type) {
		super();
		this.leaveID = leaveID;
		this.leaveFrom = leaveFrom;
		this.leaveTo = leaveTo;
		this.numberOfDays = numberOfDays;
		this.note = note;
		this.leaveType = leaveType;
		this.employee = employee;
		this.type = type;
	}

	public Leave(Long leaveID, Date leaveFrom, Date leaveTo, int numberOfDays, String note, String leaveType,
			Employee employee) {
		super();
		this.leaveID = leaveID;
		this.leaveFrom = leaveFrom;
		this.leaveTo = leaveTo;
		this.numberOfDays = numberOfDays;
		this.note = note;
		this.leaveType = leaveType;
		this.employee = employee;
	}

	public Leave(Date leaveFrom, Date leaveTo, int numberOfDays, String note, String leaveType, Employee employee) {
		super();
		this.leaveFrom = leaveFrom;
		this.leaveTo = leaveTo;
		this.numberOfDays = numberOfDays;
		this.note = note;
		this.leaveType = leaveType;
		this.employee = employee;
	}

	public Long getLeaveID() {
		return leaveID;
	}

	public void setLeaveID(Long leaveID) {
		this.leaveID = leaveID;
	}

	public Date getLeaveFrom() {
		return leaveFrom;
	}

	public void setLeaveFrom(Date leaveFrom) {
		this.leaveFrom = leaveFrom;
	}

	public Date getLeaveTo() {
		return leaveTo;
	}

	public void setLeaveTo(Date leaveTo) {
		this.leaveTo = leaveTo;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LeaveType getType() {
		return type;
	}

	public void setType(LeaveType type) {
		this.type = type;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

}
