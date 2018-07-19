package com.ats.tril.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item_issue_detail")
public class IssueDetail {

	
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

	@Override
	public String toString() {
		return "IssueDetail [issueDetailId=" + issueDetailId + ", issueId=" + issueId + ", itemGroupId=" + itemGroupId
				+ ", deptId=" + deptId + ", subDeptId=" + subDeptId + ", accHead=" + accHead + ", itemId=" + itemId
				+ ", itemIssueQty=" + itemIssueQty + ", itemRequestQty=" + itemRequestQty + ", itemPendingQty="
				+ itemPendingQty + ", delStatus=" + delStatus + ", status=" + status + "]";
	}
	
	
	
}