package com.material.valid;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class MaterialMergeForm {
	private String id;
	
	@NotBlank(message="material.name.empty")
	private String name;			//名称
	
	@NotBlank(message="material.numbering.empty")
	private String numbering;    		//编号
	
	@NotBlank(message="material.factory.empty")
	private String factory;    		//厂家
	
	@NotBlank(message="material.brand.empty")
	private String brand;			//品牌
	
	@NotBlank(message="material.model.empty")
	private String model;			//型号
	
	@NotBlank(message="material.tparameters.empty")
	private String tparameters;		//技术参数，JSON
	
	@NotNull(message="material.price.empty")
	private Integer price;			//单价
	
	@NotNull(message="material.quantity.empty")
	private Integer quantity;		//数量
	
	@NotBlank(message="material.slocation.empty")
	private String slocation;		//存放地点
	
	@NotNull(message="material.materialfile.empty")	
	private MultipartFile materialfile;	//照片
	
	@NotBlank(message="material.prtime.empty")
	private String prtime;			//生产日期
	
	@NotBlank(message="material.sctime.empty")
	private String sctime;			//报废日期
	
	@NotBlank(message="material.wactime.empty")
	private String wactime;			//质保日期
	
	@NotBlank(message="material.prchannels.empty")
	private String prchannels;		//采购渠道
	
	private String intro;			//介绍
	
	private String chremark;		//采购备注
	
	private String afterservice;	//售后服务
	
	private String remark;			//备注
	
	private String type;			//类型
	
	

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

	public String getNumbering() {
		return numbering;
	}

	public void setNumbering(String numbering) {
		this.numbering = numbering;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSlocation() {
		return slocation;
	}

	public void setSlocation(String slocation) {
		this.slocation = slocation;
	}

	public MultipartFile getMaterialfile() {
		return materialfile;
	}

	public void setMaterialfile(MultipartFile materialfile) {
		this.materialfile = materialfile;
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

	public String getPrchannels() {
		return prchannels;
	}

	public void setPrchannels(String prchannels) {
		this.prchannels = prchannels;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getChremark() {
		return chremark;
	}

	public void setChremark(String chremark) {
		this.chremark = chremark;
	}

	public String getAfterservice() {
		return afterservice;
	}

	public void setAfterservice(String afterservice) {
		this.afterservice = afterservice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
