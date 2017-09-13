package com.material.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.material.domain.Applicationcode;

@Repository
@Transactional
public class ApplicationCodeDao extends BaseDao<Applicationcode>{
	
	public void save(Applicationcode applicationCode){
		try {
			getSession().save(applicationCode);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
}
