package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.repository.LeaveTypeRepository;
import com.hr.entity.Employee;
import com.hr.entity.ExpenseClaim;
import com.hr.entity.Leave;
import com.hr.entity.LeaveType;
import com.hr.model.ResponseModel;
import com.hr.model.SuccessFail;
import com.hr.repository.LeaveRepository;

@CrossOrigin
@RestController
public class LeaveTypeController {
	@Autowired
	private LeaveTypeRepository leaveTypeRepository;
	@Autowired
	private LeaveRepository LeaveRepository;

	@GetMapping("/")
	public ResponseEntity<ResponseModel> getEmployees() throws Exception {
		List<LeaveType> leaveTypes;
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;

		try {
			leaveTypes = leaveTypeRepository.findAll();
			if (leaveTypes.size() > 0) {

				for (LeaveType leaveType : leaveTypes) {
					List<Leave> leave = this.leaveTypeRepository.findByLeaveType(leaveType);

				}
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = leaveTypes;

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
}
