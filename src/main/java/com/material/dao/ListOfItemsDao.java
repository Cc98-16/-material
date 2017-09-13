package com.material.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.material.domain.ListOfItems;
import com.material.utils.MyPage;

@Repository
@Transactional
public class ListOfItemsDao extends BaseDao<ListOfItems>{
	
	public void save(ListOfItems listOfItems){
		try {
			getSession().save(listOfItems);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void merge(ListOfItems listOfItems){
		try {
			getSession().merge(listOfItems);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public ListOfItems findById(String id) {
		try {
			ListOfItems instance = getSession().get(ListOfItems.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
		
	}
	
	public MyPage<ListOfItems> findAllUser(String userid,String keyword,int page,int pagesize){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(ListOfItems.class);
			dc.add(Property.forName("user.id").eq(userid));
			if(StringUtils.isNotBlank(keyword)){
				Disjunction diskey = Restrictions.disjunction();
				diskey.add(Property.forName("material_id.name").like(keyword,MatchMode.ANYWHERE));
				dc.add(diskey);
			}
			return this.findPageByCriteria(dc,pagesize,page);
		} catch (RuntimeException re) {
			throw re;
		}	
	}
	public List<ListOfItems> findByMaterial(String material){
		try {
			
			DetachedCriteria dc = DetachedCriteria.forClass(ListOfItems.class);
			dc.add(Property.forName("material.id").eq(material));
			Criteria criteria = dc.getExecutableCriteria(getSession());
			List<ListOfItems> list = criteria.list();
			return list;
			
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
