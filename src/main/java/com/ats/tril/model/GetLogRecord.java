package com.ats.tril.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetLogRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "log_id")
	private int logId;

	@Column(name = "doc_type")
	private int docType;

	@Column(name = "doc_tran_id")
	private int docTranId;

	@Column(name = "usr_name")
	private String usrName;
	
	@Column(name = "req_user_id")
	private int reqUserId;

	@Column(name = "req_date")
	private Date reqDate;
	
	@Column(name = "req_date_time")
	private Date reqDateTime; 
	  
	@Column(name = "edit_user_name")
	private String editUserName;
	
	@Column(name = "edit_user_id")
	private int editUserId;

	@Column(name = "edit_date")
	private Date editDate;
	
	@Column(name = "edit_date_time")
	private Date editDateTime;
	
	@Column(name = "delete_user_name")
	private String deleteUserName;
	
	@Column(name = "del_user_id")
	private int delUserId;

	@Column(name = "del_date")
	private Date delDate;
	
	@Column(name = "del_date_time")
	private Date delDateTime;
	
	@Column(name = "app1_user_name")
	private String app1UserName;
	
	@Column(name = "app1_user_id")
	private int app1UserId;

	@Column(name = "app1_date")
	private Date app1Date;
	
	@Column(name = "app1_date_time")
	private Date app1DateTime;
	
	@Column(name = "app2_user_name")
	private String app2UserName;
	
	@Column(name = "app2_user_id")
	private int app2UserId;

	@Column(name = "app2_date")
	private Date app2Date;
	
	@Column(name = "app2_date_time")
	private Date app2DateTime;
	
	@Column(name = "insp_user_name")
	private String inspUserName;
	
	@Column(name = "insp_user_id")
	private int inspUserId;

	@Column(name = "insp_date")
	private Date inspDate;
	
	@Column(name = "insp_date_time")
	private Date inspDateTime;
	
	@Column(name = "rej1_user_name")
	private String rej1UserName;
	
	@Column(name = "rej1_user_id")
	private int rej1UserId;

	@Column(name = "rej1_date")
	private Date rej1Date;
	
	@Column(name = "rej1_date_time")
	private Date rej1DateTime;
	
	@Column(name = "rej2_user_name")
	private String rej2UserName;
	
	@Column(name = "rej2_user_id")
	private int rej2UserId;

	@Column(name = "rej2_date")
	private Date rej2Date;
	 
	@Column(name = "rej2_date_time")
	private Date rej2DateTime;
	 
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

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public int getReqUserId() {
		return reqUserId;
	}

	public void setReqUserId(int reqUserId) {
		this.reqUserId = reqUserId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	@JsonFormat( timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy hh:mm:ss aa")
	public Date getReqDateTime() {
		return reqDateTime;
	}

	public void setReqDateTime(Date reqDateTime) {
		this.reqDateTime = reqDateTime;
	}

	public String getEditUserName() {
		return editUserName;
	}

	public void setEditUserName(String editUserName) {
		this.editUserName = editUserName;
	}

	public int getEditUserId() {
		return editUserId;
	}

	public void setEditUserId(int editUserId) {
		this.editUserId = editUserId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy ")
	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	@JsonFormat( timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy hh:mm:ss aa")
	public Date getEditDateTime() {
		return editDateTime;
	}

	public void setEditDateTime(Date editDateTime) {
		this.editDateTime = editDateTime;
	}

	public String getDeleteUserName() {
		return deleteUserName;
	}

	public void setDeleteUserName(String deleteUserName) {
		this.deleteUserName = deleteUserName;
	}

	public int getDelUserId() {
		return delUserId;
	}

	public void setDelUserId(int delUserId) {
		this.delUserId = delUserId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy ")
	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	@JsonFormat( timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy hh:mm:ss aa")
	public Date getDelDateTime() {
		return delDateTime;
	}

	public void setDelDateTime(Date delDateTime) {
		this.delDateTime = delDateTime;
	}

	public String getApp1UserName() {
		return app1UserName;
	}

	public void setApp1UserName(String app1UserName) {
		this.app1UserName = app1UserName;
	}

	public int getApp1UserId() {
		return app1UserId;
	}

	public void setApp1UserId(int app1UserId) {
		this.app1UserId = app1UserId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy ")
	public Date getApp1Date() {
		return app1Date;
	}

	public void setApp1Date(Date app1Date) {
		this.app1Date = app1Date;
	}
	@JsonFormat( timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy hh:mm:ss aa")
	public Date getApp1DateTime() {
		return app1DateTime;
	}

	public void setApp1DateTime(Date app1DateTime) {
		this.app1DateTime = app1DateTime;
	}

	public String getApp2UserName() {
		return app2UserName;
	}

	public void setApp2UserName(String app2UserName) {
		this.app2UserName = app2UserName;
	}

	public int getApp2UserId() {
		return app2UserId;
	}

	public void setApp2UserId(int app2UserId) {
		this.app2UserId = app2UserId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy ")
	public Date getApp2Date() {
		return app2Date;
	}

	public void setApp2Date(Date app2Date) {
		this.app2Date = app2Date;
	}
	@JsonFormat( timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy hh:mm:ss aa")
	public Date getApp2DateTime() {
		return app2DateTime;
	}
	
	public void setApp2DateTime(Date app2DateTime) {
		this.app2DateTime = app2DateTime;
	}

	public String getInspUserName() {
		return inspUserName;
	}

	public void setInspUserName(String inspUserName) {
		this.inspUserName = inspUserName;
	}

	public int getInspUserId() {
		return inspUserId;
	}

	public void setInspUserId(int inspUserId) {
		this.inspUserId = inspUserId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy ")
	public Date getInspDate() {
		return inspDate;
	}

	public void setInspDate(Date inspDate) {
		this.inspDate = inspDate;
	}
	@JsonFormat(  timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy hh:mm:ss aa")
	public Date getInspDateTime() {
		return inspDateTime;
	}

	public void setInspDateTime(Date inspDateTime) {
		this.inspDateTime = inspDateTime;
	}

	public String getRej1UserName() {
		return rej1UserName;
	}

	public void setRej1UserName(String rej1UserName) {
		this.rej1UserName = rej1UserName;
	}

	public int getRej1UserId() {
		return rej1UserId;
	}

	public void setRej1UserId(int rej1UserId) {
		this.rej1UserId = rej1UserId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy ")
	public Date getRej1Date() {
		return rej1Date;
	}

	public void setRej1Date(Date rej1Date) {
		this.rej1Date = rej1Date;
	}
	@JsonFormat( timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy hh:mm:ss aa")
	public Date getRej1DateTime() {
		return rej1DateTime;
	}

	public void setRej1DateTime(Date rej1DateTime) {
		this.rej1DateTime = rej1DateTime;
	}

	public String getRej2UserName() {
		return rej2UserName;
	}

	public void setRej2UserName(String rej2UserName) {
		this.rej2UserName = rej2UserName;
	}

	public int getRej2UserId() {
		return rej2UserId;
	}

	public void setRej2UserId(int rej2UserId) {
		this.rej2UserId = rej2UserId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy ")
	public Date getRej2Date() {
		return rej2Date;
	}

	public void setRej2Date(Date rej2Date) {
		this.rej2Date = rej2Date;
	}
	@JsonFormat( timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy hh:mm:ss aa ")
	public Date getRej2DateTime() {
		return rej2DateTime;
	}

	public void setRej2DateTime(Date rej2DateTime) {
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
		return "GetLogRecord [logId=" + logId + ", docType=" + docType + ", docTranId=" + docTranId + ", usrName="
				+ usrName + ", reqUserId=" + reqUserId + ", reqDate=" + reqDate + ", reqDateTime=" + reqDateTime
				+ ", editUserName=" + editUserName + ", editUserId=" + editUserId + ", editDate=" + editDate
				+ ", editDateTime=" + editDateTime + ", deleteUserName=" + deleteUserName + ", delUserId=" + delUserId
				+ ", delDate=" + delDate + ", delDateTime=" + delDateTime + ", app1UserName=" + app1UserName
				+ ", app1UserId=" + app1UserId + ", app1Date=" + app1Date + ", app1DateTime=" + app1DateTime
				+ ", app2UserName=" + app2UserName + ", app2UserId=" + app2UserId + ", app2Date=" + app2Date
				+ ", app2DateTime=" + app2DateTime + ", inspUserName=" + inspUserName + ", inspUserId=" + inspUserId
				+ ", inspDate=" + inspDate + ", inspDateTime=" + inspDateTime + ", rej1UserName=" + rej1UserName
				+ ", rej1UserId=" + rej1UserId + ", rej1Date=" + rej1Date + ", rej1DateTime=" + rej1DateTime
				+ ", rej2UserName=" + rej2UserName + ", rej2UserId=" + rej2UserId + ", rej2Date=" + rej2Date
				+ ", rej2DateTime=" + rej2DateTime + ", extra1=" + extra1 + ", extra2=" + extra2 + ", extraVar1="
				+ extraVar1 + ", extraVar2=" + extraVar2 + "]";
	}
	
	

}
