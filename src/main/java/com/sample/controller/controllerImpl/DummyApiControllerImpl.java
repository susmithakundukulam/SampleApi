package com.sample.controller.controllerImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sample.controller.DummyApiController;
import com.sample.domain.ResponseMessage;

@RestController
public class DummyApiControllerImpl implements DummyApiController{

	@Override
	public ResponseMessage getEmployeeList(int offset, int recordsPerPage) {
		ResponseMessage response = new ResponseMessage();
		System.out.println("****************************");
		System.out.println(offset+" " + recordsPerPage);
		response.setStatus(1);
		response.setMessage(response.SUCCESS);
		return response;
	}

	@Override
	public ResponseMessage getEmployeeList2(int offset, int recordsPerPage) {
		ResponseMessage response = new ResponseMessage();
		System.out.println("****************************");
		System.out.println(offset+" " + recordsPerPage);
		response.setStatus(2);
		response.setMessage(response.SUCCESS);
		return response;
	}

	@Override
	public ResponseMessage addEmployee3(String name, int age) {
		ResponseMessage response = new ResponseMessage();
		System.out.println("****************************");
		System.out.println(name+" " + age);
		response.setStatus(3);
		response.setMessage(response.SUCCESS);
		return response;
	}

	@Override
	public ResponseMessage getEmployeeList5(int empId, int offset, int recordsPerPage) {
		ResponseMessage response = new ResponseMessage();
		System.out.println("****************************");
		System.out.println(empId + " " +offset+" " + recordsPerPage);
		response.setStatus(5);
		response.setMessage(response.SUCCESS);
		return response;
	}

	@Override
	public ResponseMessage addEmployeeFile6(MultipartFile file, String name, int age) {
		ResponseMessage response = new ResponseMessage();
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(file.getOriginalFilename());
			Files.write(path, bytes);
			System.out.println("****************************");
			System.out.println(path.getFileName()+" "+name + " "+age);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		response.setStatus(6);
		response.setMessage(response.SUCCESS);
		return response;
	}
}
