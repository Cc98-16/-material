package com.material.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.material.domain.Material;
import com.material.service.MaterialService;
import com.material.utils.MyPage;

@Controller
public class PmaterialController extends BaseController{
	
	@Resource
	private MaterialService materialService;
	
	@GetMapping(value = "/product/{productid}/materialinfo")
	public String ProductMaterial(@PathVariable String productid,Model model){
		MyPage<Material> material = materialService.findAllProductid(productid, keyword, page, pagesize);
		model.addAttribute("ps",material);
		return "pmaterial";
	}
}
