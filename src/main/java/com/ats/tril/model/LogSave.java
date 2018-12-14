package com.ats.tril.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_log")
public class LogSave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "log_id")
	private int logId;

	@Column(name = "doc_type")
	private int docType;

	@Column(name = "doc_tran_id")
	private int docTranId;

	@Column(name = "req_user_id")
	private int reqUserId;

	@Column(name = "req_date")
	private String reqDate;
	
	@Column(name = "req_date_time")
	private String reqDateTime; 
	 
	@Column(name = "edit_user_id")
	private int editUserId;

	@Column(name = "edit_date")
	private String editDate;
	
	@Column(name = "edit_date_time")
	private String editDateTime;
	
	@Column(name = "del_user_id")
	private int delUserId;

	@Column(name = "del_date")
	private String delDate;
	
	@Column(name = "del_date_time")
	private String delDateTime;
	
	@Column(name = "app1_user_id")
	private int app1UserId;

	@Column(name = "app1_date")
	private String app1Date;
	
	@Column(name = "app1_date_time")
	private String app1DateTime;
	
	@Column(name = "app2_user_id")
	private int app2UserId;

	@Column(name = "app2_date")
	private String app2Date;
	
	@Column(name = "app2_date_time")
	private String app2DateTime;
	
	@Column(name = "insp_user_id")
	private int inspUserId;

	@Column(name = "insp_date")
	private String inspDate;
	
	@Column(name = "insp_date_time")
	private String inspDateTime;
	
	@Column(name = "rej1_user_id")
	private int rej1UserId;

	@Column(name = "rej1_date")
	private String rej1Date;
	
	@Column(name = "rej1_date_time")
	private String rej1DateTime;
	
	@Column(name = "rej2_user_id")
	private int rej2UserId;

	@Column(name = "rej2_date")
	private String rej2Date;
	
	@Column(name = "rej2_date_time")
	private String rej2DateTime;
	 
	@Column(name = "extra1")
	private int extra1;
	
	@Column(name = "extra2")
	private int extra2;
	 
	@Column(name = "extra_var1")
	private String extraVar1;
	
	@Column(name = "extra_var2")
	private String extraVar2;

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

	public int getDocTranId() {
		return docTranId;
	}

	public void setDocTranId(int docTranId) {
		this.docTranId = docTranId;
	}

	public int getReqUserId() {
		return reqUserId;
	}

	public void setReqUserId(int reqUserId) {
		this.reqUserId = reqUserId;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getReqDateTime() {
		return reqDateTime;
	}

	public void setReqDateTime(String reqDateTime) {
		this.reqDateTime = reqDateTime;
	}

	public int getEditUserId() {
		return editUserId;
	}

	public void setEditUserId(int editUserId) {
		this.editUserId = editUserId;
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	public String getEditDateTime() {
		return editDateTime;
	}

	public void setEditDateTime(String editDateTime) {
		this.editDateTime = editDateTime;
	}

	public int getDelUserId() {
		return delUserId;
	}

	public void setDelUserId(int delUserId) {
		this.delUserId = delUserId;
	}

	public String getDelDate() {
		return delDate;
	}

	public void setDelDate(String delDate) {
		this.delDate = delDate;
	}

	public String getDelDateTime() {
		return delDateTime;
	}

	public void setDelDateTime(String delDateTime) {
		this.delDateTime = delDateTime;
	}

	public int getApp1UserId() {
		return app1UserId;
	}

	public void setApp1UserId(int app1UserId) {
		this.app1UserId = app1UserId;
	}

	public String getApp1Date() {
		return app1Date;
	}

	public void setApp1Date(String app1Date) {
		this.app1Date = app1Date;
	}

	public String getApp1DateTime() {
		return app1DateTime;
	}

	public void setApp1DateTime(String app1DateTime) {
		this.app1DateTime = app1DateTime;
	}

	public int getApp2UserId() {
		return app2UserId;
	}

	public void setApp2UserId(int app2UserId) {
		this.app2UserId = app2UserId;
	}

	public String getApp2Date() {
		return app2Date;
	}

	public void setApp2Date(String app2Date) {
		this.app2Date = app2Date;
	}

	public String getApp2DateTime() {
		return app2DateTime;
	}

	public void setApp2DateTime(String app2DateTime) {
		this.app2DateTime = app2DateTime;
	}

	public int getInspUserId() {
		return inspUserId;
	}

	public void setInspUserId(int inspUserId) {
		this.inspUserId = inspUserId;
	}

	public String getInspDate() {
		return inspDate;
	}

	public void setInspDate(String inspDate) {
		this.inspDate = inspDate;
	}

	public String getInspDateTime() {
		return inspDateTime;
	}

	public void setInspDateTime(String inspDateTime) {
		this.inspDateTime = inspDateTime;
	}

	public int getRej1UserId() {
		return rej1UserId;
	}

	public void setRej1UserId(int rej1UserId) {
		this.rej1UserId = rej1UserId;
	}

	public String getRej1Date() {
		return rej1Date;
	}

	public void setRej1Date(String rej1Date) {
		this.rej1Date = rej1Date;
	}

	public String getRej1DateTime() {
		return rej1DateTime;
	}

	public void setRej1DateTime(String rej1DateTime) {
		this.rej1DateTime = rej1DateTime;
	}

	public int getRej2UserId() {
		return rej2UserId;
	}

	public void setRej2UserId(int rej2UserId) {
		this.rej2UserId = rej2UserId;
	}

	public String getRej2Date() {
		return rej2Date;
	}

	public void setRej2Date(String rej2Date) {
		this.rej2Date = rej2Date;
	}

	public String getRej2DateTime() {
		return rej2DateTime;
	}

	public void setRej2DateTime(String rej2DateTime) {
		this.rej2DateTime = rej2DateTime;
	}

	public int getExtra1() {
		return extra1;
	}

	public void setExtra1(int extra1) {
		this.extra1 = extra1;
	}

	public int getExtra2() {
		return extra2;
	}

	public void setExtra2(int extra2) {
		this.extra2 = extra2;
	}

	public String getExtraVar1() {
		return extraVar1;
	}

	public void setExtraVar1(String extraVar1) {
		this.extraVar1 = extraVar1;
	}

	public String getExtraVar2() {
		return extraVar2;
	}

	public void setExtraVar2(String extraVar2) {
		this.extraVar2 = extraVar2;
	}

	@Override
	public String toString() {
		return "LogSave [logId=" + logId + ", docType=" + docType + ", docTranId=" + docTranId + ", reqUserId="
				+ reqUserId + ", reqDate=" + reqDate + ", reqDateTime=" + reqDateTime + ", editUserId=" + editUserId
				+ ", editDate=" + editDate + ", editDateTime=" + editDateTime + ", delUserId=" + delUserId
				+ ", delDate=" + delDate + ", delDateTime=" + delDateTime + ", app1UserId=" + app1UserId + ", app1Date="
				+ app1Date + ", app1DateTime=" + app1DateTime + ", app2UserId=" + app2UserId + ", app2Date=" + app2Date
				+ ", app2DateTime=" + app2DateTime + ", inspUserId=" + inspUserId + ", inspDate=" + inspDate
				+ ", inspDateTime=" + inspDateTime + ", rej1UserId=" + rej1UserId + ", rej1Date=" + rej1Date
				+ ", rej1DateTime=" + rej1DateTime + ", rej2UserId=" + rej2UserId + ", rej2Date=" + rej2Date
				+ ", rej2DateTime=" + rej2DateTime + ", extra1=" + extra1 + ", extra2=" + extra2 + ", extraVar1="
				+ extraVar1 + ", extraVar2=" + extraVar2 + "]";
	}
	
	

}
