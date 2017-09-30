package com.material.valid;

import org.hibernate.validator.constraints.NotBlank;

public class ProductAddForm {
	
	@NotBlank(message="product.name.empty")
	private String name;
	
	@NotBlank(message="product.intro.empty")
	private String intro;

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
