package com.ats.tril.model.report;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemEnqAgQuotReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int itemId;
	private int enqStatus;

	private String enqRemark;

	private String indNo;
	private String enqNo;
	private String itemDesc;
	private float enqQty;

	private String enqDate;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getEnqRemark() {
		return enqRemark;
	}

	public void setEnqRemark(String enqRemark) {
		this.enqRemark = enqRemark;
	}

	public String getIndNo() {
		return indNo;
	}

	public void setIndNo(String indNo) {
		this.indNo = indNo;
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

	public float getEnqQty() {
		return enqQty;
	}

	public void setEnqQty(float enqQty) {
		this.enqQty = enqQty;
	}

	public String getEnqDate() {
		return enqDate;
	}

	public void setEnqDate(String enqDate) {
		this.enqDate = enqDate;
	}
	

	public int getEnqStatus() {
		return enqStatus;
	}

	public void setEnqStatus(int enqStatus) {
		this.enqStatus = enqStatus;
	}

	@Override
	public String toString() {
		return "ItemEnqAgQuotReport [itemId=" + itemId + ", enqStatus=" + enqStatus + ", enqRemark=" + enqRemark
				+ ", indNo=" + indNo + ", enqNo=" + enqNo + ", itemDesc=" + itemDesc + ", enqQty=" + enqQty
				+ ", enqDate=" + enqDate + "]";
	}

}
