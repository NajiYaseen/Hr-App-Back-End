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
import com.hr.entity.Leave;
import com.hr.model.ResponseModel;
import com.hr.model.SuccessFail;
import com.hr.repository.EmployeeRepository;
import com.hr.repository.ExpenseRepository;
import com.hr.repository.LeaveRepository;

@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private LeaveRepository leaveRepository;
	@Autowired
	private ExpenseRepository expenseRepository;

	@PostMapping("/")
	public ResponseEntity<ResponseModel> addEmployee(@RequestBody Employee employee) throws Exception {
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;
		try {
			if ((employee != null)) {
				employee = this.employeeRepository.save(employee);
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = employee;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
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
	public ResponseEntity<ResponseModel> updateEmployee(@PathVariable long id, @RequestBody Employee employee)
			throws Exception {
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;
		Employee employee1;
		try {
			if ((employee != null)) {
				employee1 = this.employeeRepository.findById(id).get();
				employee1 = new Employee(id, employee.getName(), employee.getEmail(), employee.getAddress(),
						employee.getDepartmentId(), employee.getLeave(), employee.getClaims());
				employee1 = this.employeeRepository.save(employee1);
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = employee1;
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

	@GetMapping("/")
	public ResponseEntity<ResponseModel> getEmployees() throws Exception {
		List<Employee> employees;
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;

		try {
			employees = employeeRepository.findAll();
			if (employees.size() > 0) {

				for (Employee employee : employees) {
					List<Leave> leave = this.leaveRepository.findByEmployee(employee);
					
					List<ExpenseClaim> expenseClaims = this.expenseRepository.findByEmployee(employee);

				}
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = employees;

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
	public void deleteEmployee(@PathVariable Long id) throws Exception {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			this.employeeRepository.deleteById(id);
		} else {
			throw new Exception("employee not found");
		}
	}

}
