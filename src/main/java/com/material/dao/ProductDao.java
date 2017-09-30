package com.material.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.material.domain.Product;
import com.material.utils.MyPage;
@Repository
@Transactional
public class ProductDao extends BaseDao<Product>{
	
	public void sava(Product product){
		try{
			getSession().save(product);
		}catch(RuntimeException re){
			throw re;
		}
	}
	
	public MyPage<Product> findAll(String keyword,int page,int pagesize){
		try{
			DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
			if(StringUtils.isNotBlank(keyword)){
				Disjunction diskey = Restrictions.disjunction();
				diskey.add(Property.forName("name").like(keyword,MatchMode.ANYWHERE));
				dc.add(diskey);
			}
			return this.findPageByCriteria(dc,pagesize,page);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}

