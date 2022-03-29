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
import com.hr.model.ResponseModel;
import com.hr.model.SuccessFail;
import com.hr.repository.EmployeeRepository;
import com.hr.repository.ExpenseDetailRepository;
import com.hr.repository.ExpenseRepository;

@CrossOrigin
@RestController
@RequestMapping("expense")
public class ExpenseClaimController {
	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private ExpenseDetailRepository expenseDetailRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/{id}")
	public ResponseEntity<ResponseModel> addExpense(@PathVariable Long id, @RequestBody ExpenseClaim expenseClaim)
			throws Exception {
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;
		List<ExpenseClaimDetail> claimDetail = null;
		try {

			Employee employee = this.employeeRepository.findById(id).get();

			if ((expenseClaim != null)) {
				expenseClaim = new ExpenseClaim(expenseClaim.getExpenseId(), expenseClaim.getDate(),
						expenseClaim.getDescription(), expenseClaim.getTotal(), expenseClaim.getStatus(), employee,
						null);
				expenseClaim = this.expenseRepository.save(expenseClaim);
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = expenseClaim;
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
	public ResponseEntity<ResponseModel> updatexpense(@PathVariable long id, @RequestBody ExpenseClaim expenseClaim)
			throws Exception {
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;
		Optional<Employee> employee1;
		ExpenseClaim expenseClaim1;
		try {
			Employee employee = this.employeeRepository.findById(id).get();
			if ((expenseClaim != null)) {
				expenseClaim1 = new ExpenseClaim(id, expenseClaim.getDate(), expenseClaim.getDescription(),
						expenseClaim.getTotal(), expenseClaim.getStatus(), employee,
						expenseClaim.getExpenseClaimDetail());
				expenseClaim1 = this.expenseRepository.save(expenseClaim1);
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = expenseClaim1;
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
	public ResponseEntity<ResponseModel> getExpense(@PathVariable Long id) throws Exception {
		List<ExpenseClaim> expenseClaim = null;
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;

		try {

			Employee employee = this.employeeRepository.findById(id).get();
			expenseClaim = expenseRepository.findByEmployee(employee);
			System.out.println(expenseClaim);
			if (expenseClaim.size() > 0) {
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
	public ResponseEntity<ResponseModel> getExpenseForAllEmployes() throws Exception {
		List<ExpenseClaim> expenseClaims;
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;
		Long total = 0L;

		try {
			expenseClaims = expenseRepository.findAll();

			if (expenseClaims.size() > 0) {
				for (ExpenseClaim expenseClaim : expenseClaims) {

					List<ExpenseClaimDetail> expenseClaimsDetails = this.expenseDetailRepository
							.findByexpenseClaim(expenseClaim);
					for (int i = 0; i < expenseClaimsDetails.size(); i++) {
						total = total + expenseClaimsDetails.get(i).getTotal();
						expenseClaim.setTotal(total);
						expenseClaim = this.expenseRepository.save(expenseClaim);
					}

				}
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = expenseClaims;
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

	@DeleteMapping("/{id}")
	public void deleteExpense(@PathVariable Long id) throws Exception {
		Optional<ExpenseClaim> expenseClaim = expenseRepository.findById(id);
		if (expenseClaim.isPresent()) {
			this.expenseRepository.deleteById(id);
		} else {
			throw new Exception("expenseClaim not found");
		}
	}

}
