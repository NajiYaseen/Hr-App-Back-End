package com.hr.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import org.hibernate.annotations.OnDelete;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "leave")
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "leave_id")
	private Long leaveID;
	@Column(name = "leave_from")
	private Date leaveFrom;
	@Column(name = "leave_to")
	private String leaveTo;
	@Column(name = "number_of_days")
	private int numberOfDays;
	@Column(name = "note")
	private String note;
	@Column(name = "typeid")
	private Long typeId;

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

	public Leave(Long leaveID, Date leaveFrom, String leaveTo, int numberOfDays, String note, Employee employee,
			LeaveType type) {
		super();
		this.leaveID = leaveID;
		this.leaveFrom = leaveFrom;
		this.leaveTo = leaveTo;
		this.numberOfDays = numberOfDays;
		this.note = note;
		this.employee = employee;
		this.type = type;
	}

	public Leave(Date leaveFrom, String leaveTo, int numberOfDays, String note, Employee employee, LeaveType type) {
		super();
		this.leaveFrom = leaveFrom;
		this.leaveTo = leaveTo;
		this.numberOfDays = numberOfDays;
		this.note = note;
		this.employee = employee;
		this.type = type;
	}

	public Leave(Date leaveFrom, String leaveTo, int numberOfDays, String note, Employee employee) {
		super();
		this.leaveFrom = leaveFrom;
		this.leaveTo = leaveTo;
		this.numberOfDays = numberOfDays;
		this.note = note;
		this.employee = employee;
	}

	public Leave(Date leaveFrom, String leaveTo, int numberOfDays, String note) {
		super();
		this.leaveFrom = leaveFrom;
		this.leaveTo = leaveTo;
		this.numberOfDays = numberOfDays;
		this.note = note;
	}

	public Leave(Date leaveFrom, String leaveTo, int numberOfDays, String note, Long typeId) {
		super();
		this.leaveFrom = leaveFrom;
		this.leaveTo = leaveTo;
		this.numberOfDays = numberOfDays;
		this.note = note;
		this.typeId = typeId;
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

	public String getLeaveTo() {
		return leaveTo;
	}

	public void setLeaveTo(String leaveTo) {
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

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

}
