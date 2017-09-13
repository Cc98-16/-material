package com.material.valid;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;


public class BookAddForm {
	private String id;
	
	@NotBlank(message="material.name.empty")
	private String name;			//名称
	
	@NotBlank(message="material.author.empty")
	private String author;			//作者
	
	@NotBlank(message="material.numbering.empty")
	private String numbering;		//编号
	
	@NotBlank(message="material.isbn.empty")
	private String isbn;			//书号
	
	@NotBlank(message="material.price.empty")
	private Integer price;			//单价
	
	@NotBlank(message="material.press.empty")
	private String press;			//出版社
	
	@NotBlank(message="material.pubtime.empty")
	private String pubtime;	        //出版时间

	@NotNull(message="material.quantity.empty")
	private Integer quantity;		//数量
	
	@NotBlank(message="material.slocation.empty")
	private String slocation;		//存放地点
	
	@NotNull(message="material.bookfile.empty")	
	private MultipartFile bookfile;	//照片
	
	@NotBlank(message="material.prchannels.empty")
	private String prchannels;		//采购渠道
	
	private String category;		//类别
	
	private String type;			//类型
	
	private String status;			//状态
	
	private String intro;			//介绍
	
	private String chremark;		//采购备注
	
	private String remark;			//备注
	
	private String afterservice;	//售后服务
	
	private List<BillAddForm> bills = new ArrayList<BillAddForm>();
	
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
	
	public MultipartFile getBookfile() {
		return bookfile;
	}
	public void setBookfile(MultipartFile bookfile) {
		this.bookfile = bookfile;
	}

	public String getPrchannels() {
		return prchannels;
	}

	public void setPrchannels(String prchannels) {
		this.prchannels = prchannels;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BillAddForm> getBills() {
		return bills;
	}

	public void setBills(List<BillAddForm> bills) {
		this.bills = bills;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAfterservice() {
		return afterservice;
	}

	public void setAfterservice(String afterservice) {
		this.afterservice = afterservice;
	}
	
	
}
