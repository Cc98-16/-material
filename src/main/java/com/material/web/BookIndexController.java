package com.material.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.material.domain.Material;
import com.material.service.AccessService;
import com.material.service.MaterialService;
import com.material.utils.MyPage;
@Controller
public class BookIndexController extends BaseController{
	@Resource
	private MaterialService materialService;
	
	@Resource
	private AccessService accessService;
	
	@GetMapping("/bookindex")
	public String Index(Model model){
		String category = "book";
		MyPage<Material> material = materialService.findAllCategory(category,keyword,page,pagesize);
		model.addAttribute("ps",material);
		return "/book";
	}
/*	@PostMapping(value ="/bookindex")
	@ResponseBody
	public String IndexConfirm(@Valid Confirm borrowForm,AccessAddForm accessAddForm){
		accessService.MaterialBorrow(borrowForm, accessAddForm,seuserid);
		return "/";
	}*/
}
