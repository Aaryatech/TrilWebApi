package com.ats.tril.model.report;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApproveStatusMrnReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mrnDetailId;

	private int mrnId;

	private String mrnNo;

	private Date mrnDate;

	private int mrnType;

	private String vendorId;

	private String gateEntryNo;
	private Date gateEntryDate;

	private String docNo;// chalan no
	private Date docDate;// chalan Date

	private String billNo;
	private Date billDate;

	private int userId;

	private String transport;

	private String lrNo;

	private Date lrDate;
	private String remark1;
	private String remark2;

	private int mrnStatus;

	private int delStatus;

	private String vendorCode;
	private String vendorName;
	private String vendorAdd1;

	private String itemCode;
	private String itemDesc;

	private int itemId;
	private int approveQty;

	private int poQty;

	private int mrnQty;

	private int rejectQty;

	private int rejectRemark;

	private String batchNo;

	private int issueQty;

	private int remainingQty;

	private int poId;

	private String poNo;

	private int poDetailId;

	private int schDays;

	private String schRemark;

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

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	public Date getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}

	public int getMrnType() {
		return mrnType;
	}

	public void setMrnType(int mrnType) {
		this.mrnType = mrnType;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getGateEntryNo() {
		return gateEntryNo;
	}

	public void setGateEntryNo(String gateEntryNo) {
		this.gateEntryNo = gateEntryNo;
	}

	public Date getGateEntryDate() {
		return gateEntryDate;
	}

	public void setGateEntryDate(Date gateEntryDate) {
		this.gateEntryDate = gateEntryDate;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}

	public Date getLrDate() {
		return lrDate;
	}

	public void setLrDate(Date lrDate) {
		this.lrDate = lrDate;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public int getMrnStatus() {
		return mrnStatus;
	}

	public void setMrnStatus(int mrnStatus) {
		this.mrnStatus = mrnStatus;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAdd1() {
		return vendorAdd1;
	}

	public void setVendorAdd1(String vendorAdd1) {
		this.vendorAdd1 = vendorAdd1;
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

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getApproveQty() {
		return approveQty;
	}

	public void setApproveQty(int approveQty) {
		this.approveQty = approveQty;
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

	public int getPoDetailId() {
		return poDetailId;
	}

	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
	}

	public int getSchDays() {
		return schDays;
	}

	public void setSchDays(int schDays) {
		this.schDays = schDays;
	}

	public String getSchRemark() {
		return schRemark;
	}

	public void setSchRemark(String schRemark) {
		this.schRemark = schRemark;
	}

	@Override
	public String toString() {
		return "ApproveStatusMrnReport [mrnDetailId=" + mrnDetailId + ", mrnId=" + mrnId + ", mrnNo=" + mrnNo
				+ ", mrnDate=" + mrnDate + ", mrnType=" + mrnType + ", vendorId=" + vendorId + ", gateEntryNo="
				+ gateEntryNo + ", gateEntryDate=" + gateEntryDate + ", docNo=" + docNo + ", docDate=" + docDate
				+ ", billNo=" + billNo + ", billDate=" + billDate + ", userId=" + userId + ", transport=" + transport
				+ ", lrNo=" + lrNo + ", lrDate=" + lrDate + ", remark1=" + remark1 + ", remark2=" + remark2
				+ ", mrnStatus=" + mrnStatus + ", delStatus=" + delStatus + ", vendorCode=" + vendorCode
				+ ", vendorName=" + vendorName + ", vendorAdd1=" + vendorAdd1 + ", itemCode=" + itemCode + ", itemDesc="
				+ itemDesc + ", itemId=" + itemId + ", approveQty=" + approveQty + ", poQty=" + poQty + ", mrnQty="
				+ mrnQty + ", rejectQty=" + rejectQty + ", rejectRemark=" + rejectRemark + ", batchNo=" + batchNo
				+ ", issueQty=" + issueQty + ", remainingQty=" + remainingQty + ", poId=" + poId + ", poNo=" + poNo
				+ ", poDetailId=" + poDetailId + ", schDays=" + schDays + ", schRemark=" + schRemark + "]";
	}

}
