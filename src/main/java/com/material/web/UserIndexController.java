package com.material.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.material.domain.Access;
import com.material.domain.User;
import com.material.service.AccessService;
import com.material.service.UserService;
import com.material.utils.MyPage;

@Controller
public class UserIndexController extends BaseController{
	
	@Resource
	private UserService userService;
	
	@Resource
	private AccessService accessService;
	
	@GetMapping(value="/user/{id}/userinfo")
	public String UserInfo(@PathVariable String id,Model model){
		User user = userService.findById(seuserid, id);
		MyPage<Access> access = accessService.findByUserMaterial(seuserid, user,keyword,page,pagesize);
		model.addAttribute("usermerge",user);
		model.addAttribute("ps",access);
		return "userinfo";
	}
}
