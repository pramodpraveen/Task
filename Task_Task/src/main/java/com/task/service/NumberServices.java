package com.task.service;

import java.util.List;
import java.util.Map;

import com.task.model.Number;

public interface NumberServices {
	
	//Services class which consits of abstract methods.
	
	public String saveDetails(Number num);
	
	public List<Number> getAllData();

	public Double getAverage();
	
	public Integer getMiddleNumber();
	
	public String countDuplicates();
	
	public Map<String, Double> calculateEvenOddAverages();
}
