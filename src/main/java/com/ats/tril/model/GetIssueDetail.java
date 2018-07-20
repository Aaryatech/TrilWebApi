package com.ats.tril.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetIssueDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "issue_detail_id")
	private int issueDetailId;

	@Column(name = "issue_id")
	private int issueId;

	@Column(name = "item_group_id")
	private int itemGroupId;

	@Column(name = "dept_id")
	private int deptId;
	
	@Column(name = "sub_dept_id")
	private int subDeptId;
	
	@Column(name = "acc_head")
	private int accHead;
	
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_issue_qty")
	private int itemIssueQty;
	
	@Column(name = "item_request_qty")
	private int itemRequestQty;
	
	@Column(name = "item_pending_qty")
	private int itemPendingQty;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "status")
	private int status;
	
	@Column(name = "item_code")
	private String itemCode;

	@Column(name = "grp_code")
	private String grpCode;
	
	@Column(name = "dept_code")
	private String deptCode;
	
	@Column(name = "sub_dept_code")
	private String subDeptCode;
	
	@Column(name = "acc_head_desc")
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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getGrpCode() {
		return grpCode;
	}

	public void setGrpCode(String grpCode) {
		this.grpCode = grpCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getSubDeptCode() {
		return subDeptCode;
	}

	public void setSubDeptCode(String subDeptCode) {
		this.subDeptCode = subDeptCode;
	}

	public String getAccHeadDesc() {
		return accHeadDesc;
	}

	public void setAccHeadDesc(String accHeadDesc) {
		this.accHeadDesc = accHeadDesc;
	}

	@Override
	public String toString() {
		return "GetIssueDetail [issueDetailId=" + issueDetailId + ", issueId=" + issueId + ", itemGroupId="
				+ itemGroupId + ", deptId=" + deptId + ", subDeptId=" + subDeptId + ", accHead=" + accHead + ", itemId="
				+ itemId + ", itemIssueQty=" + itemIssueQty + ", itemRequestQty=" + itemRequestQty + ", itemPendingQty="
				+ itemPendingQty + ", delStatus=" + delStatus + ", status=" + status + ", itemCode=" + itemCode
				+ ", grpCode=" + grpCode + ", deptCode=" + deptCode + ", subDeptCode=" + subDeptCode + ", accHeadDesc="
				+ accHeadDesc + "]";
	}
	
	

}
