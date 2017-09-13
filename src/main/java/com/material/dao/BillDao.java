package com.material.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.material.domain.Bill;
import com.material.utils.MyPage;

@Repository
@Transactional
public class BillDao extends BaseDao<Bill> {
	
	public void save(Bill bill){
		try {
			getSession().save(bill);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Bill bill){
		try {
			getSession().delete(bill);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Bill findById(String id){
		try {
			Bill instance = getSession().get(Bill.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void merge(Bill bill){
		try {
			getSession().merge(bill);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public MyPage<Bill> findAll(int page,int pagesize){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Bill.class);
			return this.findPageByCriteria(dc,pagesize,page);
		} catch (RuntimeException re) {
			throw re;
		}	
	}
}
