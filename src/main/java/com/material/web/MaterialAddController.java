package com.material.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.material.service.MaterialService;
import com.material.utils.ID;
import com.material.utils.Result;
import com.material.valid.BookAddForm;
import com.material.valid.MaterialAddForm;

@Controller
public class MaterialAddController extends BaseController{
	
	@Resource
	private MaterialService materialService;
	
	@GetMapping(value = "/materialadd")
	public String MaterialAdd(Model model){
		model.addAttribute("materialid", ID.uuid());
		return "materialadd";		
	}
	
	@GetMapping(value = "/bookadd")
	public String BookAdd(Model model){
		model.addAttribute("materialid", ID.uuid());
		return "bookadd";
	}
	@ResponseBody
	@PostMapping(value = "/bookadd")
	public Map<String,Object> BookSava(@Valid BookAddForm bookAddForm){
		materialService.BookSava(bookAddForm);
		return Result.toUrl("/materialindex");
	}
	
	@ResponseBody
	@PostMapping(value = "/materialadd")
	public Map<String,Object> MaterialSava(@Valid MaterialAddForm materialAddForm){
		materialService.MateriaSava(materialAddForm);
		return Result.toUrl("/materialindex");
	}
}
