package com.material.valid;

import org.hibernate.validator.constraints.NotBlank;

public class AccessInForm {
	
	private String status;
	
	@NotBlank(message="access.rreason.empty")
	private String rreason;		//拒绝理由

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRreason() {
		return rreason;
	}

	public void setRreason(String rreason) {
		this.rreason = rreason;
	}

	
}
