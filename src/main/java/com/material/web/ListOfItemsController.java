package com.material.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.material.domain.ListOfItems;
import com.material.service.ListOfItemsService;
import com.material.utils.MyPage;
import com.material.utils.Result;
@Controller
public class ListOfItemsController extends BaseController{
	
	@Resource
	private ListOfItemsService listOfItemsService;
	
	@GetMapping(value = "list")
	public String ListIndex(Model model){
		MyPage<ListOfItems> listOfItems = listOfItemsService.findByBooksUser(seuserid, keyword, page, pagesize);
		model.addAttribute("ps",listOfItems);
		return "listofitems";
	}
	
	@PostMapping(value = "/list")
	@ResponseBody
	public Map<String,Object> BooksShelves(String listid,String type,Integer lquantity){
		listOfItemsService.listsava(listid,type,lquantity,seuserid);
		return Result.success();
	}
}
