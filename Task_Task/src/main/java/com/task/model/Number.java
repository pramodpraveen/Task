package com.task.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Number {
	
	@Id
	private Integer id;
	private Integer value;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	
	public Number(Integer id, Integer value) {
		super();
		this.id = id;
		this.value = value;
	}
	public Number() {
		super();
	}

}
