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

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "department_id")
	private String departmentId;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Leave.class)
	private List<Leave> leave;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ExpenseClaim> claims;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id, String name, String email, String address, String departmentId, List<Leave> leave,
			List<ExpenseClaim> claims) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.departmentId = departmentId;
		this.leave = leave;
		this.claims = claims;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public List<Leave> getLeave() {
		return leave;
	}

	public void setLeave(List<Leave> leave) {
		this.leave = leave;
	}

	public List<ExpenseClaim> getClaims() {
		return claims;
	}

	public void setClaims(List<ExpenseClaim> claims) {
		this.claims = claims;
	}

}
