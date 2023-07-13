package com.task.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Number;
import com.task.service.NumberServices;

@RestController
public class NumberController {
	
	@Autowired
	private NumberServices services;
	
	@PostMapping
	public ResponseEntity<String> saveRecord(@RequestBody Number num) {
		
		return ResponseEntity.ok(services.saveDetails(num));	
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Number>> getAll() {
		
		return ResponseEntity.ok(services.getAllData());
	}
	
	@GetMapping("/average")
	public ResponseEntity<String> getAverage() {

        return ResponseEntity.ok("Average of numbers is :"+services.getAverage());
	}
	
	 @GetMapping("/middle")
	    public ResponseEntity<String> getMiddleNumber() {
		 	
	        return ResponseEntity.ok("Middle number is : "+services.getMiddleNumber());
	    }
	 
	 @GetMapping("/duplicates")
	    public ResponseEntity<String> countDuplicates() {
		 
	        return ResponseEntity.ok(services.countDuplicates());
	    }
	 
	 @GetMapping("/even-odd-averages")
	    public ResponseEntity<Map<String,Double>> calculateEvenOddAverages() {
		 
	        return ResponseEntity.ok(services.calculateEvenOddAverages());
	    }
	    
	
	@ExceptionHandler(InputMismatchException.class)
    public ResponseEntity<String> handleInvalidInputException(InputMismatchException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
