package com.material.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.material.utils.ID;

@Entity
public class Bill {
	
	@Id
	private String id;
	private String billunit;		//开票单位
	private String shoppername;		//抬头
	private String billfiles;		//票据文件
	private String money;			//金额
	private String btime;			//开票时间
	private String billtype;		//类型
	
	
	@ManyToOne
	private Material material;
	
	public void init(){
		this.id = ID.uuid();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBillunit() {
		return billunit;
	}
	public void setBillunit(String billunit) {
		this.billunit = billunit;
	}
	public String getShoppername() {
		return shoppername;
	}
	public void setShoppername(String shoppername) {
		this.shoppername = shoppername;
	}

	public String getBillfiles() {
		return billfiles;
	}

	public void setBillfiles(String billfiles) {
		this.billfiles = billfiles;
	}

	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}


	public String getBilltype() {
		return billtype;
	}

	public void setBilltype(String billtype) {
		this.billtype = billtype;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	
	
}
