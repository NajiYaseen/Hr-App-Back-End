package com.hr.entity;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "expense_claim")
@Entity
public class ExpenseClaim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "expense_id")
	private Long expenseID;
	@Column(name = "date")
	private Long date;
	@Column(name = "description")
	private String description;
	@Column(name = "total")
	private Long total;
	@Column(name = "status")
	private String status;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "emplyee_id")
	private Employee employee;
//
//	@OneToMany(mappedBy = "ExpenseClaim", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ExpenseClaimDetail.class)
//	private List<ExpenseClaimDetail> expenseClaimDetail;

	public ExpenseClaim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpenseClaim(Long expenseID, Long date, String description, Long total, String status, Employee employee,
			List<ExpenseClaimDetail> expenseClaimDetail) {
		super();
		this.expenseID = expenseID;
		this.date = date;
		this.description = description;
		this.total = total;
		this.status = status;
		this.employee = employee;
	}

	public ExpenseClaim(Long date, String description, Long total, String status, Employee employee) {
		super();
		this.date = date;
		this.description = description;
		this.total = total;
		this.status = status;
		this.employee = employee;
	}

	public Long getExpenseID() {
		return expenseID;
	}

	public void setExpenseID(Long expenseID) {
		this.expenseID = expenseID;
	}

	public Long getDate() {
		return date;
	}

	public void setLong(Long date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setDate(Long date) {
		this.date = date;
	}

}
