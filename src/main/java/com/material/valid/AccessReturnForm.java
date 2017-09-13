package com.material.valid;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class AccessReturnForm {
	
	@NotNull(message="access.accessfile.empty")
	private MultipartFile accessfile;	//物品照片
	
	@NotNull(message="access.aquantity.empty")
	private Integer aquantity;			//数量
	
	@NotBlank(message="access.reason.empty")
	private String reason;				//耗材说明
	
	private String type;				//申请类型
	
	private String status;				//申请状态
	
	private String operationstatus;		//操作状态
	
	public MultipartFile getAccessfile() {
		return accessfile;
	}

	public void setAccessfile(MultipartFile accessfile) {
		this.accessfile = accessfile;
	}

	public Integer getAquantity() {
		return aquantity;
	}

	public void setAquantity(Integer aquantity) {
		this.aquantity = aquantity;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperationstatus() {
		return operationstatus;
	}

	public void setOperationstatus(String operationstatus) {
		this.operationstatus = operationstatus;
	}

}