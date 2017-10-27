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

import com.material.domain.Access;
import com.material.domain.Apply;
import com.material.service.AccessService;
import com.material.service.ApplyService;
import com.material.utils.Result;
import com.material.valid.AccessFileForm;
import com.material.valid.AccessInForm;
import com.material.valid.AccessReturnForm;
import com.material.valid.AccessOutForm;
@Controller
public class AccessInfoController extends BaseController{
	
	@Resource
	private AccessService accessService;
	
	@Resource
	private ApplyService applyService;
	
	/**
	 * 查看上传的材料图片
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/access/{id}/vphoto")
	public String Vphoto(Model model,@PathVariable String id){
		Access access = accessService.findById(seuserid, id);
		model.addAttribute("accessinfo",access);
		return "vphoto";
	}
	
	/**
	 * 填写归还材料申请表界面
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/access/{id}/editreturn")
	public String Edit(Model model, @PathVariable String id) {
		Access access = accessService.findById(seuserid, id);
		model.addAttribute("accessinfo",access);
		return "editreturn";
	}
	
	/**
	 * 提交归还材料申请表
	 * 
	 * @param accessReturnForm
	 * @param id
	 * @param aid
	 * @return
	 */
	@ResponseBody
	@PostMapping(value ="/access/{id}/{aid}/return")
	public Map<String,Object> Accessreturn(@Valid AccessReturnForm accessReturnForm,@PathVariable String id,@PathVariable String aid){
		accessService.AccessReturn(accessReturnForm,id,aid,seuserid);
		return Result.toUrl("/user/{id}/userinfo");	
	}
	
	/**
	 * 管理员确认后新增一条编码记录
	 * 
	 * @param accessoutForm
	 * @param id
	 * @param aid
	 * @param uid
	 * @return
	 */
	@ResponseBody
	@PostMapping(value ="/apply/{id}/{aid}/{uid}/out")
	public Map<String,Object> Accessout(@Valid AccessOutForm accessoutForm,@PathVariable String id,@PathVariable String aid,@PathVariable String uid){
		String status = "Conduct";
		accessService.AccessOut(accessoutForm,id,aid,uid,seuserid,status);
		return Result.toUrl("/applyadmin");	
	}
	/**
	 * 通过申请后新增一条记录
	 * @param id
	 */
	@PostMapping(value = "/accesssava")
	@ResponseBody
	public Map<String,Object> Accesssave(String id){
		String operationstatus = "confirm";
		Apply apply = applyService.findById(seuserid,id);
		accessService.AccessSave(seuserid,apply,operationstatus);
		return Result.success();
	}
	/**
	 * 管理员同意申请者归还
	 * @param accessinForm
	 * @param id
	 * @param aid
	 * @return
	 */
	@ResponseBody
	@PostMapping(value ="/apply/{id}/{aid}/in")
	public Map<String,Object> Accessin(@Valid AccessInForm accessinForm,@PathVariable String id,@PathVariable String aid){
		accessService.AccessIn(accessinForm,id,aid,seuserid);
		return Result.toUrl("/applyadmin");	
	}
	/**
	 * 提交材料照片
	 * @param accessFireForm
	 * @param id
	 * @return
	 */
	@ResponseBody
	@PostMapping(value ="/accessfile")
	public Map<String,Object> AccessFire(@Valid AccessFileForm accessFireForm,String id){
		accessService.AccessFile(accessFireForm,id);
		return Result.toUrl("/user/{id}/userinfo");	
	}
}
