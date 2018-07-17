package com.ats.tril.model.rejection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_rejection_memo_detail")
public class RejectionMemoDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rejectionDetailId;

	private int rejectionId;

	private int itemId;

	private float rejectionQty;

	private float memoQty;

	private int mrnNo;

	private String mrnDate;

	private int status;
	private int isUsed;

	public int getRejectionDetailId() {
		return rejectionDetailId;
	}

	public void setRejectionDetailId(int rejectionDetailId) {
		this.rejectionDetailId = rejectionDetailId;
	}

	public int getRejectionId() {
		return rejectionId;
	}

	public void setRejectionId(int rejectionId) {
		this.rejectionId = rejectionId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getRejectionQty() {
		return rejectionQty;
	}

	public void setRejectionQty(float rejectionQty) {
		this.rejectionQty = rejectionQty;
	}

	public float getMemoQty() {
		return memoQty;
	}

	public void setMemoQty(float memoQty) {
		this.memoQty = memoQty;
	}

	public int getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(int mrnNo) {
		this.mrnNo = mrnNo;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public String getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(String mrnDate) {
		this.mrnDate = mrnDate;
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

	@Override
	public String toString() {
		return "RejectionMemoDetail [rejectionDetailId=" + rejectionDetailId + ", rejectionId=" + rejectionId
				+ ", itemId=" + itemId + ", rejectionQty=" + rejectionQty + ", memoQty=" + memoQty + ", mrnNo=" + mrnNo
				+ ", mrnDate=" + mrnDate + ", status=" + status + ", isUsed=" + isUsed + "]";
	}

}
