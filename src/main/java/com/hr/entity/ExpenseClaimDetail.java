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
@Table(name = "expenseClaimDetail")
public class ExpenseClaimDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_detail_id")
	private Long expenseDetailId;
	@Column(name = "expense_date")
	private Date expenseDate;
	@Column(name = "description")
	private String description;
	@Column(name = "total")
	private Long total;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "expense_id")
	private ExpenseClaim expenseClaim;

	public ExpenseClaimDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpenseClaimDetail(Long expenseDetailId, Date expenseDate, String description, Long total,
			ExpenseClaim expenseClaim) {
		super();
		this.expenseDetailId = expenseDetailId;
		this.expenseDate = expenseDate;
		this.description = description;
		this.total = total;
		this.expenseClaim = expenseClaim;
	}

	public ExpenseClaimDetail(Date expenseDate, String description, Long total, ExpenseClaim expenseClaim) {
		super();
		this.expenseDate = expenseDate;
		this.description = description;
		this.total = total;
		this.expenseClaim = expenseClaim;

	}

	public Long getExpenseDetailId() {
		return expenseDetailId;
	}

	public void setExpenseDetailId(Long expenseDetailId) {
		this.expenseDetailId = expenseDetailId;
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

	public ExpenseClaim getExpenseClaim() {
		return expenseClaim;
	}

	public void setExpenseClaim(ExpenseClaim expenseClaim) {
		this.expenseClaim = expenseClaim;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}

}
