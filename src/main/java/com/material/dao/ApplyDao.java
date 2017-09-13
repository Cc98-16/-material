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

import com.material.domain.Apply;
import com.material.utils.MyPage;
@Repository
@Transactional
public class ApplyDao extends BaseDao<Apply>{
	
	public void save(Apply apply){
		try {
			getSession().save(apply);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Apply apply){
		try {
			getSession().delete(apply);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Apply findById(String id){
		try {
			Apply instance = getSession().get(Apply.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void merge(Apply apply){
		try {
			getSession().merge(apply);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public MyPage<Apply> findAll(String keyword,int page,int pagesize){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Apply.class);
			dc.addOrder(Order.desc("status"));
			dc.addOrder(Order.asc("aphoto"));
			dc.addOrder(Order.desc("ctime"));
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
	
	public MyPage<Apply> findadopt(String status,String keyword,int page,int pagesize){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Apply.class);
			dc.add(Property.forName("status").eq(status));
			dc.addOrder(Order.desc("status"));
			dc.addOrder(Order.asc("aphoto"));
			dc.addOrder(Order.desc("ctime"));
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
	
	public MyPage<Apply> findUser(String userid,String keyword,int page,int pagesize){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Apply.class);
			dc.add(Property.forName("user.id").eq(userid));
			dc.addOrder(Order.desc("status"));
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
