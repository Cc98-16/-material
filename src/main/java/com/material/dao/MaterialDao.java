package com.material.dao;


import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.material.domain.Material;
import com.material.utils.MyPage;

@Repository
@Transactional
public class MaterialDao extends BaseDao<Material>{
	
	public void save(Material material){
		try {
			getSession().save(material);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Material material){
		try {
			getSession().delete(material);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Material findById(String id){
		try {
			Material instance = getSession().get(Material.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void merge(Material material){
		try {
			getSession().merge(material);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public MyPage<Material> findAllCategory(String category,String keyword,int page,int pagesize){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Material.class);
			dc.add(Property.forName("category").eq(category));
			if(StringUtils.isNotBlank(keyword)){
				Disjunction diskey = Restrictions.disjunction();
				diskey.add(Property.forName("bookname").like(keyword,MatchMode.ANYWHERE));
				dc.add(diskey);
			}
			return this.findPageByCriteria(dc,pagesize,page);
		} catch (RuntimeException re) {
			throw re;
		}	
	}
	
	public MyPage<Material> findAllProductid(String productid,String keyword,int page,int pagesize){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Material.class);
			dc.add(Property.forName("productid").eq(productid));
			if(StringUtils.isNotBlank(keyword)){
				Disjunction diskey = Restrictions.disjunction();
				diskey.add(Property.forName("bookname").like(keyword,MatchMode.ANYWHERE));
				dc.add(diskey);
			}
			return this.findPageByCriteria(dc,pagesize,page);
		} catch (RuntimeException re) {
			throw re;
		}	
	}

	
	public MyPage<Material> findAll(String keyword,int page,int pagesize){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Material.class);
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
