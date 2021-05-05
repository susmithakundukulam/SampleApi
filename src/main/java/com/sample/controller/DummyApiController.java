package com.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sample.domain.ResponseMessage;

/**
 * @author Susmitha Kundukulam
 *
 */

@RequestMapping("/Dummy")
public interface DummyApiController {

	//Here inputs are query params /x-www-form-urlencoded
	@GetMapping(value = "/getEmployee" , produces = "application/json")
	@ResponseBody ResponseMessage getEmployeeList(
			@RequestParam(value = "offset", required = true, defaultValue = "0") int offset,
			@RequestParam(value = "recordsPerPage", required = true, defaultValue = "10") int recordsPerPage
			);
	
	//Here input is JSON . so suggest to use POST
	@PostMapping(value = "/getEmployee2" , consumes = "application/json", produces = "application/json")
	@ResponseBody ResponseMessage getEmployeeList2(
			@RequestParam(value = "offset", required = true, defaultValue = "0") int offset,
			@RequestParam(value = "recordsPerPage", required = true, defaultValue = "10") int recordsPerPage
			);
	
	//Here input is x-www-form-urlencoded / form-data
	@PostMapping(value = "/addEmployee3", produces = "application/json")
	@ResponseBody ResponseMessage addEmployee3(
			@RequestParam(value = "name", required = true, defaultValue = " ") String name,
			@RequestParam(value = "age", required = true, defaultValue = "0") int age
			);
	
	//Here inputs are query params /x-www-form-urlencoded
	@GetMapping(value = "/getEmployee5/{employeeId}" , produces = "application/json")
	@ResponseBody ResponseMessage getEmployeeList5(
			@PathVariable(value = "employeeId", required = true) int empId,
			@RequestParam(value = "offset", required = true, defaultValue = "0") int offset,
			@RequestParam(value = "recordsPerPage", required = true, defaultValue = "10") int recordsPerPage
			); 
	
	//Here input is multipart/form-data... no need to mention it.. postman will take it automatically
	@PostMapping(value = "/addEmployeeFile6", produces = "application/json")
	@ResponseBody ResponseMessage addEmployeeFile6(
			@RequestPart(value = "file" , required = true) MultipartFile file,
			@RequestParam(value = "name", required = true, defaultValue = " ") String name,
			@RequestParam(value = "age", required = true, defaultValue = "0") int age
			);
}
