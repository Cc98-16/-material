package com.material.valid;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class AccessFileForm {
	@NotNull(message="access.accessfile.empty")
	private MultipartFile accessfile;	//物品照片

	public MultipartFile getAccessfile() {
		return accessfile;
	}

	public void setAccessfile(MultipartFile accessfile) {
		this.accessfile = accessfile;
	}
	
}