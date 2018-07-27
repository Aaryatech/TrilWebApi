package com.ats.tril.model.mrn;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetMrnDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mrn_detail_id")
	private int mrnDetailId;
	
	private int mrnId;
	
	private int itemId;
	
	private String itemName;
	
	private String itemCode;
	
	private int indentQty;
	
	private int poQty;
	
	private int mrnQty;
	
	private int approveQty;
	
	private int rejectQty;
	
	private int rejectRemark;
	
	private String batchNo;
	
	private int issueQty;
	
	private int remainingQty;
	
	private int poId;
	
	private String poNo;
	
	private int mrnDetailStatus;
	
	private int delStatus;
	
	private int poPendingQty;//new added on 25-07 2018 Sachin
	
	private int poDetailId;//new added on 25-07 2018 Sachin
	
	private int mrnQtyBeforeEdit;//new added on 25-07 2018 Sachin
	
	
	
	
	public int getMrnQtyBeforeEdit() {
		return mrnQtyBeforeEdit;
	}

	public void setMrnQtyBeforeEdit(int mrnQtyBeforeEdit) {
		this.mrnQtyBeforeEdit = mrnQtyBeforeEdit;
	}

	public int getPoDetailId() {
		return poDetailId;
	}

	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
	}

	public int getPoPendingQty() {
		return poPendingQty;
	}

	public void setPoPendingQty(int poPendingQty) {
		this.poPendingQty = poPendingQty;
	}

	public int getMrnDetailId() {
		return mrnDetailId;
	}

	public void setMrnDetailId(int mrnDetailId) {
		this.mrnDetailId = mrnDetailId;
	}

	public int getMrnId() {
		return mrnId;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getIndentQty() {
		return indentQty;
	}

	public void setIndentQty(int indentQty) {
		this.indentQty = indentQty;
	}

	public int getPoQty() {
		return poQty;
	}

	public void setPoQty(int poQty) {
		this.poQty = poQty;
	}

	public int getMrnQty() {
		return mrnQty;
	}

	public void setMrnQty(int mrnQty) {
		this.mrnQty = mrnQty;
	}

	public int getApproveQty() {
		return approveQty;
	}

	public void setApproveQty(int approveQty) {
		this.approveQty = approveQty;
	}

	public int getRejectQty() {
		return rejectQty;
	}

	public void setRejectQty(int rejectQty) {
		this.rejectQty = rejectQty;
	}

	public int getRejectRemark() {
		return rejectRemark;
	}

	public void setRejectRemark(int rejectRemark) {
		this.rejectRemark = rejectRemark;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public int getIssueQty() {
		return issueQty;
	}

	public void setIssueQty(int issueQty) {
		this.issueQty = issueQty;
	}

	public int getRemainingQty() {
		return remainingQty;
	}

	public void setRemainingQty(int remainingQty) {
		this.remainingQty = remainingQty;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public int getMrnDetailStatus() {
		return mrnDetailStatus;
	}

	public void setMrnDetailStatus(int mrnDetailStatus) {
		this.mrnDetailStatus = mrnDetailStatus;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "GetMrnDetail [mrnDetailId=" + mrnDetailId + ", mrnId=" + mrnId + ", itemId=" + itemId + ", itemName="
				+ itemName + ", itemCode=" + itemCode + ", indentQty=" + indentQty + ", poQty=" + poQty + ", mrnQty="
				+ mrnQty + ", approveQty=" + approveQty + ", rejectQty=" + rejectQty + ", rejectRemark=" + rejectRemark
				+ ", batchNo=" + batchNo + ", issueQty=" + issueQty + ", remainingQty=" + remainingQty + ", poId="
				+ poId + ", poNo=" + poNo + ", mrnDetailStatus=" + mrnDetailStatus + ", delStatus=" + delStatus
				+ ", poPendingQty=" + poPendingQty + ", poDetailId=" + poDetailId + ", mrnQtyBeforeEdit="
				+ mrnQtyBeforeEdit + "]";
	}

	
	
}
