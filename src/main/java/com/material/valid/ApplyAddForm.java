package com.material.valid;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.material.utils.Applys;

public class ApplyAddForm {
	
	private String status;
	
	private String type;
	
	@NotBlank(message="apply.reason.empty")
	private String reason;				//申请理由
	
	@NotBlank(message="apply.srtime.empty")
	private String srtime;				//计划归还时间
	
	private List<Applys> applys;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSrtime() {
		return srtime;
	}

	public void setSrtime(String srtime) {
		this.srtime = srtime;
	}

	public List<Applys> getApplys() {
		return applys;
	}

	public void setApplys(List<Applys> applys) {
		this.applys = applys;
	}
	
	
}
