package com.material.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.material.utils.ID;

@Entity
public class Product {
	@Id
	private String id;
	private String pid;
	private String name;
	private String intro;
	
	public void init(){
		this.id = ID.uuid();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
}
