package com.material.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.material.utils.ID;
import com.material.utils.Time;

@Entity
public class ListOfItems {
	
	@Id
	private String id;
	
	private Integer lquantity;		//物品数量
	
	private String itemstatus;		//物品状态
	
	private String type;			//操作类型
	
	private Timestamp ctime;
	
	@OneToOne
	@JoinColumn(name="materialId")
	private Material material;
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;

	
	public void init(){
		this.id = ID.uuid();
		this.ctime = Time.timestamp();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getLquantity() {
		return lquantity;
	}

	public void setLquantity(Integer lquantity) {
		this.lquantity = lquantity;
	}

	public String getItemstatus() {
		return itemstatus;
	}

	public void setItemstatus(String itemstatus) {
		this.itemstatus = itemstatus;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

}
