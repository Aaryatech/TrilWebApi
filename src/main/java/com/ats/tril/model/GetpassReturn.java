package com.ats.tril.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_getpass_return")
public class GetpassReturn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int returnId;
	private int returnNo;

	private int gpId;
	private int gpNo;
	private int vendorId;

	private Date gpReturnDate;
	private String remark;
	private String remark1;
	private int status;
	private int isUsed;

	@Transient
	List<GetpassReturnDetail> getpassReturnDetailList;

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public int getReturnNo() {
		return returnNo;
	}

	public void setReturnNo(int returnNo) {
		this.returnNo = returnNo;
	}

	public int getGpId() {
		return gpId;
	}

	public void setGpId(int gpId) {
		this.gpId = gpId;
	}

	public int getGpNo() {
		return gpNo;
	}

	public void setGpNo(int gpNo) {
		this.gpNo = gpNo;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGpReturnDate() {
		return gpReturnDate;
	}

	public void setGpReturnDate(Date gpReturnDate) {
		this.gpReturnDate = gpReturnDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public List<GetpassReturnDetail> getGetpassReturnDetailList() {
		return getpassReturnDetailList;
	}

	public void setGetpassReturnDetailList(List<GetpassReturnDetail> getpassReturnDetailList) {
		this.getpassReturnDetailList = getpassReturnDetailList;
	}

	@Override
	public String toString() {
		return "GetpassReturn [returnId=" + returnId + ", returnNo=" + returnNo + ", gpId=" + gpId + ", gpNo=" + gpNo
				+ ", vendorId=" + vendorId + ", gpReturnDate=" + gpReturnDate + ", remark=" + remark + ", remark1="
				+ remark1 + ", status=" + status + ", isUsed=" + isUsed + ", getpassReturnDetailList="
				+ getpassReturnDetailList + "]";
	}

}
