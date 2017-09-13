package com.material.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.material.service.UserService;
import com.material.utils.Result;
import com.material.valid.UserForm;


@Controller
public class RegisterController {
	
	@Resource
	private UserService userService;
	
	@GetMapping("/register")
	public String Registers(){
		return "register";
	}
	
	@ResponseBody
	@PostMapping("/register")
	public Map<String, Object> Register(@Valid UserForm userform){
		userService.Register(userform);
		return Result.toUrl("/login");
	}
}
