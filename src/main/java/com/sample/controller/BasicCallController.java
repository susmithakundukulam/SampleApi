package com.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Susmitha Kundukulam
 *
 */
public interface BasicCallController {
    
	//GET request
	// http://localhost:8080/sampleApi/
	
	@GetMapping("/")
	public String sayHello();
}
