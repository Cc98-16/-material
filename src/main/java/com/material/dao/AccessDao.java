package com.material.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.material.domain.Access;
import com.material.domain.User;
import com.material.utils.MyPage;

@Repository
@Transactional
public class AccessDao extends BaseDao<Access>{
	
	public void save(Access access){
		try {
			getSession().save(access);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Access access){
		try {
			getSession().delete(access);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Access findById(String id){
		try {
			Access instance = getSession().get(Access.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void merge(Access access){
		try {
			getSession().merge(access);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public MyPage<Access> findAll(int page,int pagesize){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Access.class);
			return this.findPageByCriteria(dc,pagesize,page);
		} catch (RuntimeException re) {
			throw re;
		}	
	}
	
	public MyPage<Access> findAllUser(User user,String keyword,int page,int pagesize){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Access.class);
			dc.add(Property.forName("user").eq(user));
			dc.addOrder(Order.asc("operationstatus"));
			if(StringUtils.isNotBlank(keyword)){
				Disjunction diskey = Restrictions.disjunction();
				diskey.add(Property.forName("material_id").like(keyword,MatchMode.ANYWHERE));
				dc.add(diskey);
			}
			return this.findPageByCriteria(dc,pagesize,page);
		} catch (RuntimeException re) {
			throw re;
		}	
	}
}
