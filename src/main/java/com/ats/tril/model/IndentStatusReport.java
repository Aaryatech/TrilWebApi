package com.ats.tril.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class IndentStatusReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sr")
	private int sr;
	
	@Column(name = "ind_d_id")
	private int indDId;
	
	@Column(name = "ind_m_no")
	private String indMNo;
	
	@Column(name = "indMDate")
	private Date ind_m_date;
  
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_code")
	private String itemCode; 
	
	@Column(name = "ind_item_schddt")
	private Date indItemSchddt;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "excess_days")
	private int excessDays;

	public int getSr() {
		return sr;
	}

	public void setSr(int sr) {
		this.sr = sr;
	}

	public int getIndDId() {
		return indDId;
	}

	public void setIndDId(int indDId) {
		this.indDId = indDId;
	}

	public String getIndMNo() {
		return indMNo;
	}

	public void setIndMNo(String indMNo) {
		this.indMNo = indMNo;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getInd_m_date() {
		return ind_m_date;
	}

	public void setInd_m_date(Date ind_m_date) {
		this.ind_m_date = ind_m_date;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIndItemSchddt() {
		return indItemSchddt;
	}

	public void setIndItemSchddt(Date indItemSchddt) {
		this.indItemSchddt = indItemSchddt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getExcessDays() {
		return excessDays;
	}

	public void setExcessDays(int excessDays) {
		this.excessDays = excessDays;
	}

	@Override
	public String toString() {
		return "IndentStatusReport [sr=" + sr + ", indDId=" + indDId + ", indMNo=" + indMNo + ", ind_m_date="
				+ ind_m_date + ", itemId=" + itemId + ", itemCode=" + itemCode + ", indItemSchddt=" + indItemSchddt
				+ ", remark=" + remark + ", excessDays=" + excessDays + "]";
	}
	
	

}
