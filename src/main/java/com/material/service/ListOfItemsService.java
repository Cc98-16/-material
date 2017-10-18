package com.material.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.material.dao.ListOfItemsDao;
import com.material.dao.MaterialDao;
import com.material.dao.UserDao;
import com.material.domain.ListOfItems;
import com.material.domain.Material;
import com.material.domain.User;
import com.material.utils.MyPage;
import com.material.utils.ServiceException;


@Service
@Transactional
public class ListOfItemsService {
	
	@Resource
	private UserDao userdao;
	
	@Resource
	private MaterialDao materialDao;
	
	@Resource
	private ListOfItemsDao listOfItemsDao;
	
	public void listsava(String listid,String type,Integer lquantity,String seuserid){
		try {
			List<ListOfItems> listOfItems = listOfItemsDao.findByMaterial(listid);
			
			if (listOfItems.size() >= 1) {
				
				ListOfItems listOf = listOfItemsDao.findById(listOfItems.get(0).getId());

				listOf.setLquantity(listOf.getLquantity() + lquantity);
				
				listOfItemsDao.merge(listOf); 
			}else{
				Material material = materialDao.findById(listid);
				User user = userdao.findById(seuserid);
				
				ListOfItems list = new ListOfItems();
				list.init();
				list.setType(type);
				list.setLquantity(lquantity);
				list.setMaterial(material);
				list.setUser(user);
				
				listOfItemsDao.save(list);
			}

		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public MyPage<ListOfItems> findByBooksUser(String seuserid,String keyword,int page,int pagesize){
		try {
			if(!StringUtils.isNotBlank(seuserid))
				throw new ServiceException("login","你没有登录");
			
			return listOfItemsDao.findAllUser(seuserid,keyword,page,pagesize);
			
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public List<ListOfItems> findByMaterial(String seuserid,String listid){
		try {
			if(!StringUtils.isNotBlank(seuserid))
				throw new ServiceException("login","你没有登录");
			
			return listOfItemsDao.findByMaterial(listid);
			
		} catch (ServiceException e) {
			throw e;
		}
	}
	

}
