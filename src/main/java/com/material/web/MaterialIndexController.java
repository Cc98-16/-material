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
import com.material.service.MaterialService;
import com.material.utils.MyPage;
import com.material.utils.Result;
import com.material.valid.MaterialMergeForm;

@Controller
public class MaterialIndexController extends BaseController{
	@Resource
	private MaterialService materialService;
	
	@GetMapping(value = "/materialindex")
	public String MaterialIndex(Model model){
		MyPage<Material> material = materialService.findAll(keyword,page,pagesize);
		model.addAttribute("ps",material);
		return "materialindex";
	}
	
	@PostMapping(value = "/delete")
	@ResponseBody
	public Map<String,Object> BooksDelete(String id,String status){
		materialService.delete(id,status);
		return Result.success();
	}
	
	@PostMapping(value = "/shelves")
	@ResponseBody
	public Map<String,Object> BooksShelves(String shelvesid,String status){
		materialService.shelves(shelvesid,status);
		return Result.success();
	}
	
	@GetMapping("/material/{id}/editmerge")
	public String EditMerge(Model model, @PathVariable String id) {
		Material material = materialService.findById(seuserid, id);
		model.addAttribute("material",material);
		return "editmerge";
	}
	
	@ResponseBody
	@PostMapping(value ="/material/{id}/editmerge")
	public Map<String,Object> MaterialMerge(@Valid MaterialMergeForm materialMergeForm,@PathVariable String id){
		materialService.MaterialMerge(materialMergeForm,id);
		return Result.toUrl("/materialindex");	
	}
	
}
