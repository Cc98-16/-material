package com.material.web;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.material.domain.User;
import com.material.utils.ServiceException;


public class BaseController {
	
	protected String seuserid;
	protected User seuser;
	protected String keyword;
	protected int pagesize;
	protected int page;
	
	@ModelAttribute
	public void getSeuserid(HttpSession httpSession) {
		seuser = (User) httpSession.getAttribute("seuser");
		if(seuser != null) {
			seuserid = seuser.getId();
		}
	}
	
	public boolean checkAuth(){  //权限检测
		try {
			if(seuser != null){ //如果userid为空或者不存在的话就可能是　用户退出　或者　session失效。
				if(seuser.getAuthority() == 1){
					return true;
				}else{
					throw new ServiceException("权限不足,你不能进行这一步操作。");
				}
			}else{
				throw new ServiceException("你没有登录");
			}	
		} catch (ServiceException e) {
			throw e;
		}
		
	}
	@ModelAttribute
	public void input_inti(Model model, 
			@RequestParam(value = "keyword", defaultValue = "", required = false) String keyword,
			@RequestParam(value = "pagesize", defaultValue = "10", required = false) Integer pagesize,
			@RequestParam(value = "page", defaultValue = "1", required = false) Integer page){
		this.keyword = keyword;
		this.pagesize = pagesize;
		this.page = page;
	}
	
}
