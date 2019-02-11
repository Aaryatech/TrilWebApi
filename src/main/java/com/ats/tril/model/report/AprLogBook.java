package com.ats.tril.model.report;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AprLogBook {
	@Id
	private int logId;
	private int docTranId;
	
	private int docType;
	private Date reqDate;
	private Date aprDate1;
	private Date aprDate2;
	
	private String aprUser1;
	private String aprUser2;
	
	private String docNo;
	private Date docDate;
	
	
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public int getDocTranId() {
		return docTranId;
	}
	public void setDocTranId(int docTranId) {
		this.docTranId = docTranId;
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
	public Date getAprDate1() {
		return aprDate1;
	}
	public void setAprDate1(Date aprDate1) {
		this.aprDate1 = aprDate1;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAprDate2() {
		return aprDate2;
	}
	public void setAprDate2(Date aprDate2) {
		this.aprDate2 = aprDate2;
	}
	@Override
	public String toString() {
		return "AprLogBook [logId=" + logId + ", docTranId=" + docTranId + ", docType=" + docType + ", reqDate="
				+ reqDate + ", aprDate1=" + aprDate1 + ", aprDate2=" + aprDate2 + ", aprUser1=" + aprUser1
				+ ", aprUser2=" + aprUser2 + ", docNo=" + docNo + ", docDate=" + docDate + "]";
	}
	public String getAprUser1() {
		return aprUser1;
	}
	public void setAprUser1(String aprUser1) {
		this.aprUser1 = aprUser1;
	}
	public String getAprUser2() {
		return aprUser2;
	}
	public void setAprUser2(String aprUser2) {
		this.aprUser2 = aprUser2;
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
	
	
	
	
}
