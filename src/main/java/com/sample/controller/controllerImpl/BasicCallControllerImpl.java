package com.sample.controller.controllerImpl;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RestController;

import com.sample.controller.BasicCallController;

@RestController
public class BasicCallControllerImpl implements BasicCallController{

	@Override
	public String sayHello() {
		
		return "Hello World : Server Time is " + LocalDateTime.now();
	}
}
