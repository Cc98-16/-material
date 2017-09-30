package com.material.service;


import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.material.dao.BillDao;
import com.material.dao.MaterialDao;
import com.material.domain.Bill;
import com.material.domain.Material;
import com.material.utils.FileUtils;
import com.material.utils.ID;
import com.material.utils.MyPage;
import com.material.utils.ServiceException;
import com.material.valid.BillAddForm;
import com.material.valid.BookAddForm;
import com.material.valid.MaterialAddForm;
import com.material.valid.MaterialMergeForm;

@Service
@Transactional
public class MaterialService {
	
	@Resource
	private MaterialDao materialDao;
	
	@Resource
	private BillDao billDao;
	
	public void IdSava(){
		try {
			Material material = new Material();
			material.setId(ID.uuid());
			materialDao.save(material);
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public void delete(String id,String status) {
		try {
			Material material = materialDao.findById(id);
			
			material.setStatus(status);
			
			materialDao.merge(material);
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public void shelves(String shelvesid,String status) {
		try {
			Material material = materialDao.findById(shelvesid);
			
			material.setStatus(status);
			
			materialDao.merge(material);
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public Material findById(String seuserid, String id) {
		try {
			if(!StringUtils.isNotBlank(seuserid))
				throw new ServiceException("login","你没有登录");
			Material material = materialDao.findById(id); 
			return material;
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public MyPage<Material> findAllCategory(String category,String keyword,int page,int pagesize){
		try {
			return materialDao.findAllCategory(category,keyword,page,pagesize);			
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public MyPage<Material> findAll(String keyword,int page,int pagesize){
		try {
			return materialDao.findAll(keyword,page,pagesize);			
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public void MaterialMerge(MaterialMergeForm materialMergeForm,String id){
		try {
			Material material = materialDao.findById(id);
			
			BeanUtils.copyProperties(materialMergeForm, material, Material.class);
			
			materialDao.merge(material);
		} catch (ServiceException e) {
			throw e;
		}
	}

	public void BookSava(BookAddForm bookAddForm){
		try {
			Material material = new Material();
			material.init();
			
			BeanUtils.copyProperties(bookAddForm, material, Material.class);

			material.setPhoto(FileUtils.getFileNameAndSaveFile(bookAddForm.getBookfile()));
			
			materialDao.save(material);
			
			if(bookAddForm.getBills().size() >= 1) {
				for (BillAddForm billAddForm : bookAddForm.getBills()) {
					if(null != billAddForm.getBillfile()){
						Bill bill = new Bill();
						BeanUtils.copyProperties(billAddForm, bill, Bill.class);
						bill.setId(ID.uuid());
						bill.setMaterial(material);
						bill.setBillfiles(FileUtils.getFileNameAndSaveFile(billAddForm.getBillfile()));
						billDao.save(bill);
					}
				}
			}

		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public void MaterialSava(MaterialAddForm materialAddForm){
		try {
			Material material = new Material();
			material.init();
			
			BeanUtils.copyProperties(materialAddForm, material, Material.class);

//			material.setPhoto(FileUtils.getFileNameAndSaveFile(materialAddForm.getMaterialfile()));
			
			materialDao.save(material);
			
			if(materialAddForm.getBills().size() >= 1) {
				for (BillAddForm billAddForm : materialAddForm.getBills()) {
					if(null != billAddForm.getBillfile()){
						Bill bill = new Bill();
						BeanUtils.copyProperties(billAddForm, bill, Bill.class);
						bill.setId(ID.uuid());
						bill.setMaterial(material);
						bill.setBillfiles(FileUtils.getFileNameAndSaveFile(billAddForm.getBillfile()));
						billDao.save(bill);
					}
				}
			}

		} catch (ServiceException e) {
			throw e;
		}
	}
}
