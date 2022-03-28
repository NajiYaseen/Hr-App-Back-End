//package com.hr.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.hr.entity.ExpenseClaim;
//import com.hr.entity.ExpenseClaimDetail;
//import com.hr.model.ResponseModel;
//import com.hr.model.SuccessFail;
//import com.hr.repository.ExpenseDetailRepository;
//import com.hr.repository.ExpenseRepository;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/claimDetails")
//public class ExpenseClaimDetailsController {
//	@Autowired
//	private ExpenseRepository expenseRepository;
//	@Autowired
//	private ExpenseDetailRepository expenseDetailRepository;
//
//	@PostMapping("/{id}")
//	public ResponseEntity<ResponseModel> addExpense(@PathVariable Long id,
//			@RequestBody ExpenseClaimDetail expenseClaimDetail) throws Exception {
//		String errorMSG = "";
//		String statusCode = SuccessFail.FAIL;
//		Object data = null;
//		ExpenseClaimDetail claim = null;
//		HttpStatus httpStatus;
//		try {
//
//			ExpenseClaim expenseClaim = this.expenseRepository.findById(id).get();
//
//			if ((expenseClaimDetail != null)) {
//				expenseClaimDetail = new ExpenseClaimDetail(expenseClaimDetail.getDescription(),
//						expenseClaimDetail.getTotal(), expenseClaim);
//				expenseClaimDetail = this.expenseDetailRepository.save(expenseClaimDetail);
//				statusCode = SuccessFail.SUCCESS;
//				httpStatus = HttpStatus.OK;
//				errorMSG = "";
//				data = expenseClaim;
//			} else {
//				httpStatus = HttpStatus.EXPECTATION_FAILED;
//				statusCode = SuccessFail.FAIL;
//				errorMSG = "check all field,  make sure that you entered all the parameters";
//			}
//		} catch (Exception e) {
//			httpStatus = HttpStatus.EXPECTATION_FAILED;
//			statusCode = SuccessFail.FAIL;
//			errorMSG = e.getMessage();
//		}
//		ResponseModel responseModel = new ResponseModel(data, statusCode, errorMSG);
//		return new ResponseEntity<ResponseModel>(responseModel, httpStatus);
//
//	}
//}
