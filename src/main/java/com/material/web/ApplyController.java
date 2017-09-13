package com.material.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.material.domain.Apply;
import com.material.service.ApplyService;
import com.material.utils.MyPage;

@Controller
public class ApplyController extends BaseController{
	
	@Resource
	private ApplyService applyService;
	
	@GetMapping(value = "/apply")
	public String ApplyIndex(Model model){
		MyPage<Apply> apply = applyService.findUser(seuserid, keyword, page, pagesize);
		model.addAttribute("ps",apply);
		return "apply";
	}
	
	@GetMapping(value = "/applyadmin")
	public String ApplyAdminIndex(Model model){
		checkAuth();
		MyPage<Apply> apply = applyService.findAll(seuserid, keyword, page, pagesize);
		model.addAttribute("ps",apply);
		return "applyadmin";
	}
	
	@GetMapping(value = "/adoptapply")
	public String AdoptApplyIndex(Model model){
		checkAuth();
		String status = "adopt";
		MyPage<Apply> apply = applyService.findadopt(status,seuserid, keyword, page, pagesize);
		model.addAttribute("ps",apply);
		return "adoptapply";
	}
	
	@GetMapping("/apply/{id}/editagree")
	public String EditAgree(Model model, @PathVariable String id) {
		Apply apply = applyService.findById(seuserid, id);
		model.addAttribute("apply",apply);
		return "editagree";
	}
	
	@GetMapping("/apply/{id}/editrefuse")
	public String EditRefuse(Model model, @PathVariable String id) {
		Apply apply = applyService.findById(seuserid, id);
		model.addAttribute("apply",apply);
		return "editrefuse";
	}
}
