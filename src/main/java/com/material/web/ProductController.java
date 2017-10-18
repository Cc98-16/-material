package com.material.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.material.domain.Material;
import com.material.domain.Product;
import com.material.service.MaterialService;
import com.material.service.ProductService;
import com.material.utils.MyPage;
import com.material.utils.Result;
import com.material.valid.ProductAddForm;

@Controller
public class ProductController extends BaseController{
	
	@Resource
	private ProductService productService;
	
	@Resource
	private MaterialService materialService;

	@GetMapping(value = "/productadd")
	public String ProductAdd(){
		return "productadd";
	}
	
	/**
	 * 创建新的材料分类
	 * 
	 * @param productAddForm
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "/productadd")
	public Map<String, Object> ProductSava(@Valid ProductAddForm productAddForm){
		productService.ProductSave(productAddForm);
		return Result.toUrl("/productindex");
	}
	
	/**
	 * 全部材料分类显示
	 * 
	 * @param model
	 * @param pagesize
	 * @return
	 */
	@GetMapping(value = "/productindex")
	public String ProductIndex(Model model){
		MyPage<Product> product = productService.findAll(keyword, page, pagesize);
		model.addAttribute("ps",product);
		return "productindex";
	}
	
	/**
	 * 显示分类下的详细材料
	 * 
	 * @param model
	 * @param pagesize
	 * @return
	 */
	@GetMapping(value = "/product/{productid}/materialinfo")
	public String ProductMaterial(@PathVariable String productid,Model model){
		MyPage<Material> material = materialService.findAllProductid(productid, keyword, page, pagesize);
		model.addAttribute("ps",material);
		return "pmaterial";
	}
}
