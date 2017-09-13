package com.material.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.material.dao.UserDao;
import com.material.domain.User;
import com.material.utils.ServiceException;
import com.material.valid.LoginForm;
import com.material.valid.UserForm;
import com.material.valid.UserInfoForm;

@Service
@Transactional
public class UserService {
	@Resource
	private UserDao userRepository;
	
	public void Register(UserForm userForm){
		try {
			User user = new User();
			user.init();
			
			BeanUtils.copyProperties(userForm, user, User.class);
			
			userRepository.save(user);
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public User findById(String id,String seuserid){
		try {
			if(!StringUtils.isNotBlank(seuserid))
				throw new ServiceException("login","你没有登录");
			User user = userRepository.findById(id); 
			return user;
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public void UserMerge(UserInfoForm userInfoForm,String id){
		try {
			User user = userRepository.findById(id);
			
			BeanUtils.copyProperties(userInfoForm, user, User.class);
			
			userRepository.merge(user);
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public String login(HttpSession session,LoginForm loginForm){
		try {
			List<User> list = userRepository.findByUser(loginForm);	
			User user = list.get(0);
			session.setAttribute("seuser",user);
			return "success";
		} catch (ServiceException e) {
			throw e;
		}
	}
	
/*	public String login(HttpSession session, String account, String password) {
		try {
			if(StringUtils.isNotBlank(account) && StringUtils.isNotBlank(password)){
				List<User> list = userRepository.findByUser(account, password);
				if(list.size() > 1) {
					throw new ServiceException("账号或密码错误,请点击下方的'找回密码'");
				} else if (list.size() == 1) {
					User user = list.get(0);
					session.setAttribute("seuser",user);
					return "success";
				} else {
					throw new ServiceException("账号或密码错误");
				}
			} else {
				throw new ServiceException("账号或密码不能为空");
			}
		} catch (ServiceException e) {
			throw e;
		}
	}*/
}
