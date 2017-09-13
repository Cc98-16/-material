package com.material.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.material.utils.ID;
import com.material.utils.Time;

@Entity
public class Apply {
	@Id
	private String id;
	private Integer aquantity;	//申请数量
	private String status;		//申请状态
	private String reason;		//申请理由
	private String aphoto;		//申请物品照片
	private String remarks;		//耗材说明
	private String srtime;		//计划归还时间
	private String type;		//操作类型(出库，入库)
	private String operationstatus;	//操作状态
	private Timestamp ctime;	//创建时间
	
	@OneToOne
	@JoinColumn(name="materialId")
	private Material material;
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	@OneToOne
	@JoinColumn(name="accessId")
	private Access access;
	
	@OneToOne
	@JoinColumn(name="applicationcodeId")
	private Applicationcode applicationcode;
	
	public void init(){
		this.id = ID.uuid();
		this.ctime = Time.timestamp();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAquantity() {
		return aquantity;
	}

	public void setAquantity(Integer aquantity) {
		this.aquantity = aquantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getAphoto() {
		return aphoto;
	}

	public void setAphoto(String aphoto) {
		this.aphoto = aphoto;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSrtime() {
		return srtime;
	}

	public void setSrtime(String srtime) {
		this.srtime = srtime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	public String getOperationstatus() {
		return operationstatus;
	}

	public void setOperationstatus(String operationstatus) {
		this.operationstatus = operationstatus;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
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

	public Applicationcode getApplicationcode() {
		return applicationcode;
	}

	public void setApplicationcode(Applicationcode applicationcode) {
		this.applicationcode = applicationcode;
	}
	
}
