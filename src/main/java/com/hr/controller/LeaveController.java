package com.hr.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.entity.Employee;
import com.hr.entity.Leave;
import com.hr.entity.LeaveType;
import com.hr.model.ResponseModel;
import com.hr.model.SuccessFail;
import com.hr.repository.EmployeeRepository;
import com.hr.repository.LeaveRepository;
import com.hr.repository.LeaveTypeRepository;

@CrossOrigin
@RestController
@RequestMapping("leaves")
public class LeaveController {
	@Autowired
	private LeaveRepository leaveRepository;
	@Autowired
	private LeaveTypeRepository leaveTypeRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/{id}")
	public ResponseEntity<ResponseModel> addLeave(@PathVariable Long id, @RequestBody Leave leaveBody)
			throws Exception {
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;
		Leave leave = null;
//		String from = leaveBody.getFrom();
//		String to = leaveBody.getTo();
//		Long fromDate = new Date(from).getTime();
//		Long toDate = new Date(to).getTime();
//
//		Long timeDiff = toDate - fromDate;
//		int daysDiff = (int) (timeDiff / (1000 * 60 * 60 * 24));

		try {
			if (leaveBody != null) {
				Employee defaultEmployee = this.employeeRepository.findById(id).get();
				leave = new Leave(leaveBody.getLeaveFrom(), leaveBody.getLeaveTo(), 20, leaveBody.getNote(),
						defaultEmployee);
				leave = this.leaveRepository.save(leave);
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = leave;

			} else {
				httpStatus = HttpStatus.EXPECTATION_FAILED;
				statusCode = SuccessFail.FAIL;
				errorMSG = "check all field,  make sure that you entered number of days & leave type";
			}
		} catch (Exception e) {
			e.printStackTrace();
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			statusCode = SuccessFail.FAIL;
			errorMSG = e.getMessage();
		}

		ResponseModel responseModel = new ResponseModel(data, statusCode, errorMSG);
		return new ResponseEntity<ResponseModel>(responseModel, httpStatus);

	}

	@PostMapping("/leaveType")
	public ResponseEntity<ResponseModel> addLeaveType(@RequestParam String leaveType) throws Exception {
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data[] = new Object[2];
		HttpStatus httpStatus;

		try {

			LeaveType leaveDetails = new LeaveType();
			leaveDetails.setSelectLeaveType(leaveType);
			leaveDetails = this.leaveTypeRepository.save(leaveDetails);
			statusCode = SuccessFail.SUCCESS;
			httpStatus = HttpStatus.OK;
			errorMSG = "";

		} catch (

		Exception e) {
			e.printStackTrace();
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			statusCode = SuccessFail.FAIL;
			errorMSG = e.getMessage();
		}

		ResponseModel responseModel = new ResponseModel(data, statusCode, errorMSG);
		return new ResponseEntity<ResponseModel>(responseModel, httpStatus);

	}

	@GetMapping("/")
	public ResponseEntity<ResponseModel> getLeavesForEmployee(@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "from", required = false) Date from,
			@RequestParam(name = "to", required = false) Date to) throws Exception {
		List<Leave> leaves = null;
		String errorMSG = "";
		String statusCode = SuccessFail.FAIL;
		Object data = null;
		HttpStatus httpStatus;
//		Long fromDate = new Date(from).getTime();
//		Long toDate = new Date(to).getTime();

		try {

			if (id == null && (from != null && to != null)) {
				leaves = this.leaveRepository.findByLeaveFromBetween(from, to);
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = leaves;
			} else if (id != null && from != null) {
				Employee employee = this.employeeRepository.findById(id).get();

				leaves = this.leaveRepository.findByEmployeeAndLeaveFromBetween(employee, from, to);
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = leaves;
			} else if (id != null && ((from == null || from.equals("")) && (to == null || from.equals("")))) {
				Employee employee = this.employeeRepository.findById(id).get();
				leaves = this.leaveRepository.findByEmployee(employee);
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = leaves;
			} else {
				leaves = this.leaveRepository.findAll();
				statusCode = SuccessFail.SUCCESS;
				httpStatus = HttpStatus.OK;
				errorMSG = "";
				data = leaves;
			}

			// Employee employee = this.employeeRepository.findById(id).get();

//			leaves = leaveRepository.findByEmployee(employee);
//			for (Leave leave : leaves) {
//				LeaveType leaveType = this.leaveTypeRepository.findById(leave.getLeaveID()).get();
////				leave.setLeaveType(leaveType);
//

			// }

//			statusCode = SuccessFail.SUCCESS;
//			httpStatus = HttpStatus.OK;
//			errorMSG = "";
//			data = leaves;

		} catch (Exception e) {
			e.printStackTrace();
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			statusCode = SuccessFail.FAIL;
			errorMSG = e.getMessage();
		}

		ResponseModel responseModel = new ResponseModel(data, statusCode, errorMSG);
		return new ResponseEntity<ResponseModel>(responseModel, httpStatus);

	}

//	@GetMapping("/")
//	public ResponseEntity<ResponseModel> getLeaves(@RequestParam String from, @RequestParam String to)
//			throws Exception {
//		List<Leave> leave;
//		Long fromDate = new Date(from).getTime();
//		Long toDate = new Date(to).getTime();
//		String errorMSG = "";
//		String statusCode = SuccessFail.FAIL;
//		Object data = null;
//		HttpStatus httpStatus;
//		try {
//			leave = leaveRepository.findByLeaveFromBetween(fromDate, toDate);
//
//			statusCode = SuccessFail.SUCCESS;
//			httpStatus = HttpStatus.OK;
//			errorMSG = "";
//			data = leave;
////		else {
////			httpStatus = HttpStatus.EXPECTATION_FAILED;
////			statusCode = SuccessFail.FAIL;
////				errorMSG = ("List is Empty");
////			}
//		} catch (Exception e) {
//			httpStatus = HttpStatus.EXPECTATION_FAILED;
//			statusCode = SuccessFail.FAIL;
//			errorMSG = e.getMessage();
//		}
//
//		ResponseModel responseModel = new ResponseModel(data, statusCode, errorMSG);
//		return new ResponseEntity<ResponseModel>(responseModel, httpStatus);
//
//	}

	@DeleteMapping("/{id}")
	public void deleteLeaves(@PathVariable Long id) throws Exception {
		Optional<Leave> leave = leaveRepository.findById(id);
		if (leave.isPresent()) {
			this.leaveRepository.deleteById(id);
		} else {
			throw new Exception("employee not found");
		}
	}
}
