package com.material.domain;

import com.material.utils.ID;

public class Tparameters {
	private String id;
	private String name;
	
	
	
	public Tparameters() {
		super();
	}
	public Tparameters(String name) {
		this.id = ID.uuid();
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
