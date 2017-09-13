package com.material.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.alibaba.fastjson.JSON;
import com.material.utils.Time;
@Entity
@Table(name="material")
public class Material implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;			//名称
	private String author;			//作者
	private String numbering;		//编号
	private String isbn;			//书号
	private Integer price;			//单价
	private String press;			//出版社
	private String pubtime;	        //出版时间
	private String category;		//类别
	private Timestamp ctime;		//创建时间
	private String intro;			//介绍
	private String status;			//状态
	private String factory;    		//厂家
	private String brand;			//品牌
	private String model;			//型号
	private String tparameters;		//技术参数，JSON
	private Integer quantity;		//数量
	private String type;			//类型
	private String slocation;		//存放地点
	private String photo;	//照片
	private String prtime;			//生产日期
	private String sctime;			//报废日期
	private String wactime;			//质保日期
	private String afterservice;	//售后服务
	private String prchannels;		//采购渠道
	private String chremark;		//采购备注
	private String remark;			//备注
	
	@OneToMany
	private Set<Bill> bill = new HashSet<Bill>();
	
	@Transient
	private List<Tparameters> tparameterss = new ArrayList<Tparameters>();

	public List<Tparameters> getTparameterss() {
		tparameterss = JSON.parseArray(this.getTparameters(),Tparameters.class);
		return tparameterss;
	}

	public void setTparameterss(List<Tparameters> tparameterss) {
		this.tparameterss = tparameterss;
		this.tparameters = JSON.toJSONString(tparameterss);
	}
	
	public void init(){
		this.ctime = Time.timestamp();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getNumbering() {
		return numbering;
	}

	public void setNumbering(String numbering) {
		this.numbering = numbering;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getPubtime() {
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTparameters() {
		return tparameters;
	}

	public void setTparameters(String tparameters) {
		this.tparameters = tparameters;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSlocation() {
		return slocation;
	}

	public void setSlocation(String slocation) {
		this.slocation = slocation;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPrtime() {
		return prtime;
	}

	public void setPrtime(String prtime) {
		this.prtime = prtime;
	}

	public String getSctime() {
		return sctime;
	}

	public void setSctime(String sctime) {
		this.sctime = sctime;
	}

	public String getWactime() {
		return wactime;
	}

	public void setWactime(String wactime) {
		this.wactime = wactime;
	}

	public String getAfterservice() {
		return afterservice;
	}

	public void setAfterservice(String afterservice) {
		this.afterservice = afterservice;
	}

	public String getPrchannels() {
		return prchannels;
	}

	public void setPrchannels(String prchannels) {
		this.prchannels = prchannels;
	}

	public String getChremark() {
		return chremark;
	}

	public void setChremark(String chremark) {
		this.chremark = chremark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<Bill> getBill() {
		return bill;
	}

	public void setBill(Set<Bill> bill) {
		this.bill = bill;
	}
	
}
