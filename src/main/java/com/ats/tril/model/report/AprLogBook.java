package com.ats.tril.model.report;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AprLogBook {
	@Id
	private int logId;
	
	private int docType;
	private Date reqDate;
	private Date app1Date;
	private Date app2Date;
	
	private String apr1User;
	private String apr2User;
	
	private String docNo;
	private Date docDate;
	
	
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public int getDocType() {
		return docType;
	}
	public void setDocType(int docType) {
		this.docType = docType;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getApp1Date() {
		return app1Date;
	}
	public void setApp1Date(Date app1Date) {
		this.app1Date = app1Date;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getApp2Date() {
		return app2Date;
	}
	public void setApp2Date(Date app2Date) {
		this.app2Date = app2Date;
	}
	public String getApr1User() {
		return apr1User;
	}
	public void setApr1User(String apr1User) {
		this.apr1User = apr1User;
	}
	public String getApr2User() {
		return apr2User;
	}
	public void setApr2User(String apr2User) {
		this.apr2User = apr2User;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDocDate() {
		return docDate;
	}
	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}
	@Override
	public String toString() {
		return "AprLogBook [logId=" + logId + ", docType=" + docType + ", reqDate=" + reqDate + ", app1Date=" + app1Date
				+ ", app2Date=" + app2Date + ", apr1User=" + apr1User + ", apr2User=" + apr2User + ", docNo=" + docNo
				+ ", docDate=" + docDate + "]";
	}
	
}
