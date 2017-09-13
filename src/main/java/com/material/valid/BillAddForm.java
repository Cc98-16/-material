package com.material.valid;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class BillAddForm {
	
	private MultipartFile billfile;		//票据照片
	
	private String billunit;		//开票单位
	
	private String shoppername;		//抬头
	
	private String money;			//金额
	
	private String btime;			//开票时间
	
	private String billtype;		//类型

	public MultipartFile getBillfile() {
		return billfile;
	}

	public void setBillfile(MultipartFile billfile) {
		if(StringUtils.isBlank(billfile.toString())) {
			this.billfile = null;
		}
		this.billfile = billfile;
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
	
	
}
