package com.material.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.material.utils.ID;

@Entity
public class Applicationcode {
	@Id
	private String id;
	
	private String code;		//编码
	
	private String place;		//操作地点
	
	private String status;		//状态
	
	private String rrtime;		//要求归还时间
	
	@OneToOne
	@JoinColumn(name="materialId")
	private Material material;
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	@OneToOne
	@JoinColumn(name="accessId")
	private Access access;
	
	public void init(){
		this.id = ID.uuid();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRrtime() {
		return rrtime;
	}

	public void setRrtime(String rrtime) {
		this.rrtime = rrtime;
	}
	
}
