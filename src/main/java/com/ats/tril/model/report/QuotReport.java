package com.ats.tril.model.report;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class QuotReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="enq_detail_id")
	private int enqDetId;

	private int enqId;

	private Date enqDate;

	private String enqRemark;

	private String headerRemark;

	private float enqQty;
	private String enqNo;

	private String itemDesc;

	private String itemCode;

	public int getEnqDetId() {
		return enqDetId;
	}

	public void setEnqDetId(int enqDetId) {
		this.enqDetId = enqDetId;
	}

	public int getEnqId() {
		return enqId;
	}

	public void setEnqId(int enqId) {
		this.enqId = enqId;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

	public Date getEnqDate() {
		return enqDate;
	}

	public void setEnqDate(Date enqDate) {
		this.enqDate = enqDate;
	}

	public String getEnqRemark() {
		return enqRemark;
	}

	public void setEnqRemark(String enqRemark) {
		this.enqRemark = enqRemark;
	}

	public String getHeaderRemark() {
		return headerRemark;
	}

	public void setHeaderRemark(String headerRemark) {
		this.headerRemark = headerRemark;
	}

	public float getEnqQty() {
		return enqQty;
	}

	public void setEnqQty(float enqQty) {
		this.enqQty = enqQty;
	}

	public String getEnqNo() {
		return enqNo;
	}

	public void setEnqNo(String enqNo) {
		this.enqNo = enqNo;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Override
	public String toString() {
		return "QuotReport [enqDetId=" + enqDetId + ", enqId=" + enqId + ", enqDate=" + enqDate + ", enqRemark="
				+ enqRemark + ", headerRemark=" + headerRemark + ", enqQty=" + enqQty + ", enqNo=" + enqNo
				+ ", itemDesc=" + itemDesc + ", itemCode=" + itemCode + "]";
	}

}
