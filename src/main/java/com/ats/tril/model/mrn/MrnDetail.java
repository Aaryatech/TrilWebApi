package com.ats.tril.model.mrn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_mrn_detail")
public class MrnDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mrnDetailId;
	
	private int mrnId;
	
	private int itemId;
	
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
	
	private int poDetailId;
	
	private int mrnDetailStatus;
	
	private int delStatus;
	
	
	@Transient
	private int mrnQtyBeforeEdit;
	
	


	public int getMrnQtyBeforeEdit() {
		return mrnQtyBeforeEdit;
	}

	public void setMrnQtyBeforeEdit(int mrnQtyBeforeEdit) {
		this.mrnQtyBeforeEdit = mrnQtyBeforeEdit;
	}

	public int getMrnId() {
		return mrnId;
	}

	public int getItemId() {
		return itemId;
	}

	public int getIndentQty() {
		return indentQty;
	}

	public int getPoQty() {
		return poQty;
	}

	public int getMrnQty() {
		return mrnQty;
	}

	public int getApproveQty() {
		return approveQty;
	}

	public int getRejectQty() {
		return rejectQty;
	}

	public int getRejectRemark() {
		return rejectRemark;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public int getIssueQty() {
		return issueQty;
	}

	public int getRemainingQty() {
		return remainingQty;
	}

	public int getPoId() {
		return poId;
	}

	public String getPoNo() {
		return poNo;
	}

	public int getMrnDetailStatus() {
		return mrnDetailStatus;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setIndentQty(int indentQty) {
		this.indentQty = indentQty;
	}

	public void setPoQty(int poQty) {
		this.poQty = poQty;
	}

	public void setMrnQty(int mrnQty) {
		this.mrnQty = mrnQty;
	}

	public void setApproveQty(int approveQty) {
		this.approveQty = approveQty;
	}

	public void setRejectQty(int rejectQty) {
		this.rejectQty = rejectQty;
	}

	public void setRejectRemark(int rejectRemark) {
		this.rejectRemark = rejectRemark;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public void setIssueQty(int issueQty) {
		this.issueQty = issueQty;
	}

	public void setRemainingQty(int remainingQty) {
		this.remainingQty = remainingQty;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public void setMrnDetailStatus(int mrnDetailStatus) {
		this.mrnDetailStatus = mrnDetailStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getPoDetailId() {
		return poDetailId;
	}

	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
	}


	public int getMrnDetailId() {
		return mrnDetailId;
	}

	public void setMrnDetailId(int mrnDetailId) {
		this.mrnDetailId = mrnDetailId;
	}

	@Override
	public String toString() {
		return "MrnDetail [mrnDetailId=" + mrnDetailId + ", mrnId=" + mrnId + ", itemId=" + itemId + ", indentQty="
				+ indentQty + ", poQty=" + poQty + ", mrnQty=" + mrnQty + ", approveQty=" + approveQty + ", rejectQty="
				+ rejectQty + ", rejectRemark=" + rejectRemark + ", batchNo=" + batchNo + ", issueQty=" + issueQty
				+ ", remainingQty=" + remainingQty + ", poId=" + poId + ", poNo=" + poNo + ", poDetailId=" + poDetailId
				+ ", mrnDetailStatus=" + mrnDetailStatus + ", delStatus=" + delStatus + ", mrnQtyBeforeEdit="
				+ mrnQtyBeforeEdit + "]";
	}


}
