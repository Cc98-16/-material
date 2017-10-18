package com.material.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.material.domain.Material;
import com.material.domain.Product;
import com.material.service.AccessService;
import com.material.service.MaterialService;
import com.material.service.ProductService;
import com.material.utils.MyPage;
import com.material.utils.Result;
import com.material.valid.ApplyAddForm;

@Controller
public class IndexController extends BaseController{
	@Resource
	private MaterialService materialService;
	
	@Resource
	private AccessService accessService;
	
	@Resource
	private ProductService productService;
	
	@GetMapping(value="/index")
	public String Index(Model model){
		MyPage<Product> product = productService.findAll(keyword, page, pagesize);
		model.addAttribute("ps",product);
		return "index";
	}
	
	@ResponseBody
	@PostMapping(value ="/index")
	public Map<String,Object> MaterialBorrow(@Valid ApplyAddForm applyAddForm){
		accessService.MaterialBorrow(applyAddForm,seuserid);
		return Result.toUrl("/apply");
	}
	
	@GetMapping("/product/{productid}/editpmaterial")
	public String EditPmaterial(Model model, @PathVariable String productid, @RequestParam(name="row") int index) {
		MyPage<Material> material = materialService.findAllProductid(productid, keyword, page, pagesize);
		model.addAttribute("ps",material);
		model.addAttribute("index", index);
		return "editpmaterial";
	}
}
