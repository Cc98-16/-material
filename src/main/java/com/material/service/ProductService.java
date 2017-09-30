package com.material.service;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.material.dao.ProductDao;
import com.material.domain.Product;
import com.material.utils.MyPage;
import com.material.utils.ServiceException;
import com.material.valid.ProductAddForm;

@Service
@Transactional
public class ProductService {
	
	@Resource
	private ProductDao productDao;
	
	public void ProductSave(ProductAddForm productAddForm){
		try{
			Product product = new Product();
			product.init();
			
			BeanUtils.copyProperties(productAddForm, product, Product.class);
			
			productDao.sava(product);
		}catch(ServiceException e){
			throw e;
		}
	}
	
	public MyPage<Product> findAll(String keyword,int page,int pagesize){
		try{
			return productDao.findAll(keyword,page,pagesize);		
		}catch(ServiceException e){
			throw e;
		}
	}
}
