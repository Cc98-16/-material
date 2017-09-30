package com.material.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.material.service.ProductService;
import com.material.utils.Result;
import com.material.valid.ProductAddForm;

@Controller
public class ProductAddController extends BaseController{
	@Resource
	private ProductService productService;
	
	@GetMapping(value = "/productadd")
	public String ProductAdd(){
		return "productadd";
	}
	
	@ResponseBody
	@PostMapping(value = "/productadd")
	public Map<String, Object> ProductSava(@Valid ProductAddForm productAddForm){
		productService.ProductSave(productAddForm);
		return Result.toUrl("/productindex");
	}

}
