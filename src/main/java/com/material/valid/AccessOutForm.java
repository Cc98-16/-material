package com.material.valid;

import org.hibernate.validator.constraints.NotBlank;

public class AccessOutForm {
	
	private String status;
	
	@NotBlank(message="access.rrtime.empty")
	private String rrtime;						//要求时间
	
	@NotBlank(message="access.acode.empty")
	private String acode;						//编码
	
	@NotBlank(message="access.pplace.empty")
	private String pplace;						//领取地点
	
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

	public String getAcode() {
		return acode;
	}

	public void setAcode(String acode) {
		this.acode = acode;
	}

	public String getPplace() {
		return pplace;
	}

	public void setPplace(String pplace) {
		this.pplace = pplace;
	}

	
}
