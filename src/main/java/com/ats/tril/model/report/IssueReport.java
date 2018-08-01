package com.ats.tril.model.report;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class IssueReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "issue_detail_id")
	private int issueDetailId;

	private int issueId;

	private String issueNo;

	private int itemCategory;

	private Date issueDate;

	private int deleteStatus;

	private int status;

	private int itemGroupId;

	private int deptId;

	private int subDeptId;

	private int accHead;

	private int itemId;

	private int itemIssueQty;

	private int itemRequestQty;

	private int itemPendingQty;

	private String itemCode;
	private String itemDesc;

	private String deptDesc;
	private String subDeptDesc;
	private String accHeadDesc;

	public int getIssueDetailId() {
		return issueDetailId;
	}

	public void setIssueDetailId(int issueDetailId) {
		this.issueDetailId = issueDetailId;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public int getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(int itemCategory) {
		this.itemCategory = itemCategory;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public int getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getItemGroupId() {
		return itemGroupId;
	}

	public void setItemGroupId(int itemGroupId) {
		this.itemGroupId = itemGroupId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getSubDeptId() {
		return subDeptId;
	}

	public void setSubDeptId(int subDeptId) {
		this.subDeptId = subDeptId;
	}

	public int getAccHead() {
		return accHead;
	}

	public void setAccHead(int accHead) {
		this.accHead = accHead;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemIssueQty() {
		return itemIssueQty;
	}

	public void setItemIssueQty(int itemIssueQty) {
		this.itemIssueQty = itemIssueQty;
	}

	public int getItemRequestQty() {
		return itemRequestQty;
	}

	public void setItemRequestQty(int itemRequestQty) {
		this.itemRequestQty = itemRequestQty;
	}

	public int getItemPendingQty() {
		return itemPendingQty;
	}

	public void setItemPendingQty(int itemPendingQty) {
		this.itemPendingQty = itemPendingQty;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public String getSubDeptDesc() {
		return subDeptDesc;
	}

	public void setSubDeptDesc(String subDeptDesc) {
		this.subDeptDesc = subDeptDesc;
	}

	public String getAccHeadDesc() {
		return accHeadDesc;
	}

	public void setAccHeadDesc(String accHeadDesc) {
		this.accHeadDesc = accHeadDesc;
	}

	@Override
	public String toString() {
		return "IssueReport [issueDetailId=" + issueDetailId + ", issueId=" + issueId + ", issueNo=" + issueNo
				+ ", itemCategory=" + itemCategory + ", issueDate=" + issueDate + ", deleteStatus=" + deleteStatus
				+ ", status=" + status + ", itemGroupId=" + itemGroupId + ", deptId=" + deptId + ", subDeptId="
				+ subDeptId + ", accHead=" + accHead + ", itemId=" + itemId + ", itemIssueQty=" + itemIssueQty
				+ ", itemRequestQty=" + itemRequestQty + ", itemPendingQty=" + itemPendingQty + ", itemCode=" + itemCode
				+ ", itemDesc=" + itemDesc + ", deptDesc=" + deptDesc + ", subDeptDesc=" + subDeptDesc
				+ ", accHeadDesc=" + accHeadDesc + "]";
	}

}
