package com.material.service;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.material.dao.ApplyDao;
import com.material.domain.Apply;
import com.material.utils.MyPage;
import com.material.utils.ServiceException;
@Service
@Transactional
public class ApplyService {
	
	@Resource
	private ApplyDao applyDao;
	
	
	public Apply findById(String seuserid, String id) {
		try {
			if(!StringUtils.isNotBlank(seuserid))
				throw new ServiceException("login","你没有登录");
			Apply apply = applyDao.findById(id); 
			return apply;
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public MyPage<Apply> findAll(String seuserid,String keyword,int page,int pagesize){
		try {
			return applyDao.findAll(keyword,page,pagesize);
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public MyPage<Apply> findadopt(String status,String seuserid,String keyword,int page,int pagesize){
		try {
			return applyDao.findadopt(status,keyword,page,pagesize);
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public MyPage<Apply> findUser(String seuserid,String keyword,int page,int pagesize){
		try {
			return applyDao.findUser(seuserid,keyword,page,pagesize);
		} catch (ServiceException e) {
			throw e;
		}
	}
}
