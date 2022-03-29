package com.hr.entity;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table(name = "expenseClaim")
@Entity
public class ExpenseClaim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_id")
	private Long expenseId;
	@Column(name = "date")
	private Date date;
	@Column(name = "description")
	private String description;
	@Column(name = "total")
	private Long total;
	@Column(name = "status")
	private String status;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@OneToMany(mappedBy = "expenseClaim", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ExpenseClaimDetail> expenseClaimDetail;

	public ExpenseClaim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpenseClaim(Long expenseId, Date date, String description, Long total, String status, Employee employee,
			List<ExpenseClaimDetail> expenseClaimDetail) {
		super();
		this.expenseId = expenseId;
		this.date = date;
		this.description = description;
		this.total = total;
		this.status = status;
		this.employee = employee;
		this.expenseClaimDetail = expenseClaimDetail;
	}

	public ExpenseClaim(Date date, String description, Long total, String status, Employee employee,
			List<ExpenseClaimDetail> expenseClaimDetail) {
		super();
		this.date = date;
		this.description = description;
		this.total = total;
		this.status = status;
		this.employee = employee;
		this.expenseClaimDetail = expenseClaimDetail;

	}

	public Long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public List<ExpenseClaimDetail> getExpenseClaimDetail() {
		return expenseClaimDetail;
	}

	public void setExpenseClaimDetail(List<ExpenseClaimDetail> expenseClaimDetail) {
		this.expenseClaimDetail = expenseClaimDetail;
	}

}
