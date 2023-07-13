package com.task.service;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.task.Repository.NumberRepo;
import com.task.model.Number;

//Implemented NumberServices interface in this class to use abstract methods.

@Service
public class NumberServiceImplimentation implements NumberServices{

	@Autowired
	private NumberRepo repo;
	
	//Saving data in table
	@Override
	public String saveDetails(Number num) {
		Number result=repo.save(num);
		return "Data Inserted Succesfully \n"+"ID: "+result.getId()+"\nNumber: "+result.getNumber();
	}
	
	
	//Retrieving all columns from table Number
	@Override
	public List<Number> getAllData() {
		
		List<Number> result=repo.findAll();
		return result;
	}

	//Finding average of all numbers except 1st and last numbers.
	@Override
	public Double getAverage() {
		
		List<Number> data=repo.findAll();
		if (data.size() <= 2) {
            throw new InputMismatchException("List must contain at least three numbers.");
        }
        List<Number> trimmedNumbers = data.subList(1, data.size() - 1);
        double sum = trimmedNumbers.stream().map(num1->num1.getNumber()).reduce((num1, num2)->num1+num2).get();
        double average = sum / trimmedNumbers.size();
		return average;
	}

	//Finding middle number from table.
	@Override
	public Integer getMiddleNumber() {
		
		List<Number> data=repo.findAll();
        if (data.isEmpty()) {
            throw new InputMismatchException("List must not be empty.");
        }
        List<Integer> res1=data.stream().map(num1->num1.getNumber()).collect(Collectors.toList());
        int middleIndex = res1.size() / 2;
		return res1.get(middleIndex);
	}

	//Finding duplicate numbers count from table.
	@Override
	public String countDuplicates() {
		List<Number> data=repo.findAll();
        Set<Integer> uniqueNumbers = data.stream().map(num1->num1.getNumber()).collect(Collectors.toSet());
        int duplicates = data.size() - uniqueNumbers.size();
		return "Total no of duplicates from the table is = "+duplicates;
	}

	//Calculating even and odd numbers average and count of them .
	@Override
	public Map<String, Double> calculateEvenOddAverages() {
		List<Number> data=repo.findAll();
        if (data.isEmpty()) {
            throw new InputMismatchException("List must not be empty.");
        }	
        
        Map<String, Double> averages = new HashMap<>();

        // Calculate even average
        Double evenAverage = data.stream()
                .filter(num -> num.getNumber() % 2 == 0).map(num1->num1.getNumber())// Filter even numbers
                .collect(Collectors.averagingInt(Integer::intValue)); // Calculate average

        averages.put("evenAverage", evenAverage);

        // Calculate odd average
        Double oddAverage = data.stream()
                .filter(num -> num.getNumber() % 2 != 0).map(num1->num1.getNumber())// Filter odd numbers
                .collect(Collectors.averagingInt(Integer::intValue)); // Calculate average
        
        averages.put("oddAverage", oddAverage);

        // Count even and odd numbers
        long evenCount = data.stream()
                .filter(num -> num.getNumber() % 2 == 0) // Filter even numbers
                .count();

        long oddCount = data.size() - evenCount;

        averages.put("evenCount", (double) evenCount);
        averages.put("oddCount", (double) oddCount);

		return averages;
	}

}
