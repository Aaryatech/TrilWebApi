package com.ats.tril.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="item_issue_header")
public class IssueHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "issue_id")
	private int issueId;

	@Column(name = "issue_no")
	private String issueNo;

	@Column(name = "item_category")
	private int itemCategory;

	@Column(name = "issue_date")
	private String issueDate;

	@Column(name = "delete_status")
	private int deleteStatus;

	@Column(name = "status")
	private int status;
	
	@Transient
	List<IssueDetail> issueDetailList;

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

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
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

	public List<IssueDetail> getIssueDetailList() {
		return issueDetailList;
	}

	public void setIssueDetailList(List<IssueDetail> issueDetailList) {
		this.issueDetailList = issueDetailList;
	}

	@Override
	public String toString() {
		return "IssueHeader [issueId=" + issueId + ", issueNo=" + issueNo + ", itemCategory=" + itemCategory
				+ ", issueDate=" + issueDate + ", deleteStatus=" + deleteStatus + ", status=" + status
				+ ", issueDetailList=" + issueDetailList + "]";
	}
	
	
  
}
