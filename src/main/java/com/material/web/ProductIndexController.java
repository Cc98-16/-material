package com.material.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.material.domain.Product;
import com.material.service.ProductService;
import com.material.utils.MyPage;


@Controller
public class ProductIndexController extends BaseController{
	@Resource
	private ProductService productService;
	
	@GetMapping(value = "/productindex")
	public String ProductIndex(Model model){
		MyPage<Product> product = productService.findAll(keyword, page, pagesize);
		model.addAttribute("ps",product);
		return "productindex";
	}

}
