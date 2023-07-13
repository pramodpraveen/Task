package com.task.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Number {
	
	@Id
	private Integer id;
	private Integer number;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Number(Integer id, Integer number) {
		super();
		this.id = id;
		this.number = number;
	}
	public Number() {
		super();
	}

}
