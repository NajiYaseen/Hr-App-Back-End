package com.hr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.entity.Employee;
import com.hr.entity.ExpenseClaim;
import com.hr.entity.ExpenseClaimDetail;
import com.hr.entity.Leave;
import com.hr.model.ResponseModel;
import com.hr.model.SuccessFail;
import com.hr.repository.ExpenseDetailRepository;
import com.hr.repository.ExpenseRepository;

@RestController
@CrossOrigin
@RequestMapping("/claimDetails")
public class ExpenseClaimDetailsController {
	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private ExpenseDetailRepository expenseDetailRepository;

	@PostMapping("/{id}")
	public ResponseEntity<ResponseModel> addExpense(@PathVariable Long id,
			@RequestBody ExpenseClaimDetail expenseClaimDetail) throws Exception {
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		ExpenseClaimDetail claim = null;
		HttpStatus httpStatus;
		try {

			ExpenseClaim expenseClaim = this.expenseRepository.findById(id).get();

			if ((expenseClaimDetail != null)) {
				expenseClaimDetail = new ExpenseClaimDetail(expenseClaimDetail.getExpenseDate(),
						expenseClaimDetail.getDescription(), expenseClaimDetail.getTotal(), expenseClaim);
				expenseClaimDetail = this.expenseDetailRepository.save(expenseClaimDetail);
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = expenseClaimDetail;
			} else {
				httpStatus = HttpStatus.EXPECTATION_FAILED;
				statusCode = SuccessFail.FAIL;
				errorMSG = "check all field,  make sure that you entered all the parameters";
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			statusCode = SuccessFail.FAIL;
			errorMSG = e.getMessage();
		}
		ResponseModel responseModel = new ResponseModel(data, statusCode, errorMSG);
		return new ResponseEntity<ResponseModel>(responseModel, httpStatus);

	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseModel> updatExpenseDetail(@PathVariable long id,
			@RequestBody ExpenseClaimDetail expenseClaimDetails) throws Exception {
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;
		ExpenseClaimDetail expenseClaimDetail1;
		try {
			ExpenseClaimDetail expenseClaimDetails1 = this.expenseDetailRepository.findById(id).get();
			if ((expenseClaimDetails != null)) {
				expenseClaimDetail1 = new ExpenseClaimDetail(id, expenseClaimDetails.getExpenseDate(),
						expenseClaimDetails.getDescription(), expenseClaimDetails.getTotal(),
						expenseClaimDetails1.getExpenseClaim());
				expenseClaimDetail1 = this.expenseDetailRepository.save(expenseClaimDetail1);
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = expenseClaimDetail1;
			} else {
				httpStatus = HttpStatus.EXPECTATION_FAILED;
				statusCode = SuccessFail.FAIL;
				errorMSG = "check all field,  make sure that you entered all the parameters";
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			statusCode = SuccessFail.FAIL;
			errorMSG = e.getMessage();
		}

		ResponseModel responseModel = new ResponseModel(data, statusCode, errorMSG);
		return new ResponseEntity<ResponseModel>(responseModel, httpStatus);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseModel> getExpenseClaimDetails(@PathVariable Long id) throws Exception {
		ExpenseClaim expenseClaim = null;
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;
		List<ExpenseClaimDetail> expenseClaimDetail1;

		try {

			expenseClaim = this.expenseRepository.findById(id).get();
			expenseClaimDetail1 = expenseDetailRepository.findByexpenseClaim(expenseClaim);
			System.out.println(expenseClaim);
			if (expenseClaimDetail1.size() > 0) {
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = expenseClaim;
			} else {
				httpStatus = HttpStatus.EXPECTATION_FAILED;
				statusCode = SuccessFail.FAIL;
				errorMSG = ("List is Empty");
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			statusCode = SuccessFail.FAIL;
			errorMSG = e.getMessage();
		}
		ResponseModel responseModel = new ResponseModel(data, statusCode, errorMSG);
		return new ResponseEntity<ResponseModel>(responseModel, httpStatus);
	}

	@GetMapping("/")
	public ResponseEntity<ResponseModel> getAllExpenseClaimDetails() throws Exception {
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;
		List<ExpenseClaimDetail> expenseClaimDetail1;
		try {
			expenseClaimDetail1 = expenseDetailRepository.findAll();
			statusCode = SuccessFail.SUCCESS;
			httpStatus = HttpStatus.OK;
			errorMSG = "";
			data = expenseClaimDetail1;
		} catch (Exception e) {
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			statusCode = SuccessFail.FAIL;
			errorMSG = e.getMessage();
		}
		ResponseModel responseModel = new ResponseModel(data, statusCode, errorMSG);
		return new ResponseEntity<ResponseModel>(responseModel, httpStatus);
	}

	@DeleteMapping("/{id}")
	public void deleteLeaves(@PathVariable Long id) throws Exception {
		Optional<ExpenseClaimDetail> expenseClaimDetail1 = expenseDetailRepository.findById(id);
		if (expenseClaimDetail1.isPresent()) {
			this.expenseDetailRepository.deleteById(id);
		} else {
			throw new Exception("Expense Claim Detail not found");
		}
	}

}
