package com.material.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.material.dao.AccessDao;
import com.material.dao.ApplicationCodeDao;
import com.material.dao.ApplyDao;
import com.material.dao.MaterialDao;
import com.material.dao.UserDao;
import com.material.domain.Access;
import com.material.domain.Applicationcode;
import com.material.domain.Apply;
import com.material.domain.Material;
import com.material.domain.User;
import com.material.utils.Applys;
import com.material.utils.Confirm;
import com.material.utils.Confirms;
import com.material.utils.FileUtils;
import com.material.utils.MyPage;
import com.material.utils.ServiceException;
import com.material.valid.AccessFileForm;
import com.material.valid.AccessInForm;
import com.material.valid.AccessOutForm;
import com.material.valid.AccessReturnForm;
import com.material.valid.ApplyAddForm;

@Service
@Transactional
public class AccessService {
	
	@Resource
	private AccessDao accessDao;
	
	@Resource
	private ApplyDao applyDao;
	
	@Resource
	private UserDao userdao;
	
	@Resource
	private MaterialDao materialDao;
	
	@Resource
	private ApplicationCodeDao applicationCodeDao;
	
	public String Confirm(HttpSession session,Confirm confirm){
		try {
			List<Confirms> confirms = confirm.getConfirms();
			session.setAttribute("seconfirm", confirms);
			return "success";
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public void AccessFile(AccessFileForm accessFireForm,String id){
		try {
			Access access = accessDao.findById(id);
			access.setPhoto(FileUtils.getFileNameAndSaveFile(accessFireForm.getAccessfile()));
			accessDao.merge(access);
			
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public void AccessSave(String seuserid,Apply apply,String operationstatus){
		try {
			User useroperator = userdao.findById(seuserid);
			
			Access access = new Access();
			access.init();
			access.setMaterial(apply.getMaterial());
			access.setApply(apply);
			access.setUser(apply.getUser());
			access.setOperator(useroperator.getUsername());
			accessDao.save(access);
			
			apply.setOperationstatus(operationstatus);
			apply.setAccess(access);
			applyDao.merge(apply);
			
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	//同意申请后，申请人完成申请事项后，管理员确认已完成新增一条订单。
	public void AccessOut(AccessOutForm accessoutForm,String id,String aid,String uid,String seuserid,String status){
		try {
			Material material = materialDao.findById(id);
			Apply apply = applyDao.findById(aid);
			User user = userdao.findById(uid);
			
			/*User useroperator = userdao.findById(seuserid);*/
			
/*			Access access = new Access();
			access.init();
			BeanUtils.copyProperties(accessoutForm, access, Access.class);
			access.setMaterial(material);
			access.setApply(apply);
			access.setUser(user);
			access.setOperator(useroperator.getUsername());
			accessDao.save(access);*/
			
			Applicationcode applicationCode = new Applicationcode();
			applicationCode.init();
			applicationCode.setStatus(status);
			applicationCode.setCode(accessoutForm.getAcode());
			applicationCode.setPlace(accessoutForm.getPplace());
			applicationCode.setRrtime(accessoutForm.getRrtime());
/*			applicationCode.setAccess(access);*/
			applicationCode.setUser(user);
			applicationCode.setMaterial(material);
			
			applicationCodeDao.save(applicationCode);
			
/*			apply.setAccess(access);*/
			apply.setApplicationcode(applicationCode);
			apply.setStatus(accessoutForm.getStatus());
			applyDao.merge(apply);
			
			
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public void AccessReturn(AccessReturnForm accessReturnForm,String id,String aid,String seuserid){
		try {
			Material material = materialDao.findById(id);
			User user = userdao.findById(seuserid);
			
			Access access = accessDao.findById(aid);
			access.setOperationstatus(accessReturnForm.getOperationstatus());
			accessDao.merge(access);
			
			Apply apply = new Apply();
			apply.init();
			BeanUtils.copyProperties(accessReturnForm, apply, Apply.class);
			apply.setAphoto(FileUtils.getFileNameAndSaveFile(accessReturnForm.getAccessfile()));
			apply.setMaterial(material);
			apply.setUser(user);
			
			applyDao.save(apply);
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public void AccessIn(AccessInForm accessinForm,String id,String aid,String seuserid){
		try {
			Material material = materialDao.findById(id);
			Apply apply = applyDao.findById(aid);
			User user = userdao.findById(seuserid);
			
			Access access = new Access();
			access.init();
			BeanUtils.copyProperties(accessinForm, access, Access.class);
			access.setMaterial(material);
			access.setApply(apply);
			access.setUser(user);
			accessDao.save(access);
			
			apply.setAccess(access);
			apply.setStatus(accessinForm.getStatus());
			applyDao.merge(apply);
			
			//归还，申请材料与材料相加数量
			
			material.setQuantity(apply.getAquantity() + material.getQuantity());
			materialDao.merge(material);
		} catch (ServiceException e) {
			throw e;
		}
	}
	
/*	public void AccessIn(AccessMergeInForm accessMergeInForm,Confirm borrowForm,String id,String seuserid,String aid){
		try {
			
			Access accessid = accessDao.findById(aid);
			
			accessid.setOperationstatus(accessMergeInForm.getOperationstatus());
			accessDao.merge(accessid);
			
			User user = userdao.findById(seuserid);
			Material material = materialDao.findById(id);
			
			material.setStatus(borrowForm.getStatus());
			
			if(accessMergeInForm.getCquantity() <= accessid.getCquantity()){
			material.setQuantity(material.getQuantity() + accessMergeInForm.getCquantity());
			materialDao.merge(material);
			
			Access access = new Access();
			access.init();
			BeanUtils.copyProperties(accessMergeInForm, access, Access.class);
			access.setPhoto(FileUtils.getFileNameAndSaveFile(accessMergeInForm.getAccessfile()));
			access.setCquantity(accessMergeInForm.getCquantity());
			access.setOperationstatus(accessMergeInForm.getOperationstatus());
			access.setMaterial(material);
			access.setUser(user);
			accessDao.save(access);
			
			}
		} catch (ServiceException e) {
			throw e;
		}
	}*/
	
	public void MaterialBorrow(ApplyAddForm applyAddForm,String seuserid){
	try {			
		User user = userdao.findById(seuserid);
		
		for (Applys applys : applyAddForm.getApplys()) {
			if (StringUtils.isNotBlank(applys.getId())) {
				Material material = materialDao.findById(applys.getId());
				material.setStatus(applyAddForm.getStatus());
				if(material.getQuantity() >= 1){
				material.setQuantity(material.getQuantity() - applys.getCquantity());
				materialDao.merge(material);
				
				Apply apply = new Apply();
				apply.init();
				BeanUtils.copyProperties(applyAddForm, apply, Apply.class);
				apply.setAquantity(applys.getCquantity());
				apply.setMaterial(material);
				apply.setUser(user);
				applyDao.save(apply);
			}
			}
		}
	} catch (ServiceException e) {
		throw e;
	}
}
	
/*	public void MaterialBorrow(Confirm borrowForm,AccessAddForm accessAddForm,String seuserid){
		try {			
			User user = userdao.findById(seuserid);
			
			for (Confirms materials : borrowForm.getMaterials()) {
				if (StringUtils.isNotBlank(materials.getId())) {
					Material material = materialDao.findById(materials.getId());
					material.setStatus(borrowForm.getStatus());
					if(material.getQuantity() >= 1){
					material.setQuantity(material.getQuantity() - materials.getCquantity());
					materialDao.merge(material);
					
					Access access = new Access();
					access.init();
					BeanUtils.copyProperties(accessAddForm, access, Access.class);
					access.setPhoto(FileUtils.getFileNameAndSaveFile(accessAddForm.getAccessfile()));
					access.setCquantity(materials.getCquantity());
					access.setMaterial(material);
					access.setUser(user);
					accessDao.save(access);
				}
				}
			}
		} catch (ServiceException e) {
			throw e;
		}
	}*/
	
	public MyPage<Access> findByUserMaterial(String seuserid,User user,String keyword,int page,int pagesize){
		try {
			if(!StringUtils.isNotBlank(seuserid))
				throw new ServiceException("login","你没有登录");
			return accessDao.findAllUser(user,keyword,page,pagesize);
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public Access findById(String seuserid, String id) {
		try {
			if(!StringUtils.isNotBlank(seuserid))
				throw new ServiceException("login","你没有登录");
			Access access = accessDao.findById(id); 
			return access;
		} catch (ServiceException e) {
			throw e;
		}
	}
	
}
