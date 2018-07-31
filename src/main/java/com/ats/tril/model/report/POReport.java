package com.ats.tril.model.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class POReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "po_detail_id")
	private int poDetailId;

	@Column(name = "po_id")
	private int poId;

	@Column(name = "po_type")
	private int poType;

	@Column(name = "po_no")
	private String poNo;

	@Column(name = "po_date")
	private String poDate;

	@Column(name = "vend_id")
	private int vendId;

	@Column(name = "vend_quation")
	private String vendQuation;

	@Column(name = "vend_quation_date")
	private String vendQuationDate;

	@Column(name = "po_basic_value")
	private float poBasicValue;

	@Column(name = "disc_value")
	private float discValue;

	@Column(name = "po_tax_id")
	private int poTaxId;

	@Column(name = "po_tax_per")
	private float poTaxPer;

	@Column(name = "po_tax_value")
	private float poTaxValue;

	@Column(name = "po_pack_per")
	private float poPackPer;

	@Column(name = "po_pack_val")
	private float poPackVal;

	@Column(name = "po_pack_remark")
	private String poPackRemark;

	@Column(name = "po_insu_per")
	private float poInsuPer;

	@Column(name = "po_insu_val")
	private float poInsuVal;

	@Column(name = "po_insu_remark")
	private String poInsuRemark;

	@Column(name = "po_frt_per")
	private float poFrtPer;

	@Column(name = "po_frt_val")
	private float poFrtVal;

	@Column(name = "po_frt_remark")
	private String poFrtRemark;

	@Column(name = "other_charge_before")
	private float otherChargeBefore;

	@Column(name = "other_charge_before_remark")
	private String otherChargeBeforeRemark;

	@Column(name = "other_charge_after")
	private float otherChargeAfter;

	@Column(name = "other_charge_after_remark")
	private String otherChargeAfterRemark;

	@Column(name = "total_value")
	private float totalValue;

	@Column(name = "delivery_id")
	private int deliveryId;

	@Column(name = "dispatch_id")
	private int dispatchId;

	@Column(name = "payment_term_id")
	private int paymentTermId;

	@Column(name = "po_remark")
	private String poRemark;

	@Column(name = "po_status")
	private int poStatus;

	@Column(name = "prn_status")
	private int prnStatus;

	@Column(name = "prn_copies")
	private int prnCopies;

	@Column(name = "ind_id")
	private int indId;

	@Column(name = "ind_no")
	private String indNo;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "approv_status")
	private int approvStatus;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_desc")
	private String itemDesc;

	@Column(name = "item_uom")
	private String itemUom;

	@Column(name = "item_qty")
	private int itemQty;

	@Column(name = "item_rate")
	private float itemRate;

	@Column(name = "mrn_qty")
	private int mrnQty;

	@Column(name = "pending_qty")
	private int pendingQty;

	@Column(name = "inded_qty")
	private int indedQty;

	@Column(name = "disc_per")
	private float discPer;

	@Column(name = "sch_days")
	private int schDays;

	@Column(name = "sch_date")
	private String schDate;

	@Column(name = "insu")
	private float insu;

	@Column(name = "other_charges_befor")
	private float otherChargesBefor;

	@Column(name = "tax_value")
	private float taxValue;

	@Column(name = "freight_value")
	private String freightValue;

	@Column(name = "other_charges_after")
	private float otherChargesAfter;

	@Column(name = "landing_cost")
	private float landingCost;

	private String vendorCode;
	private String vendorName;
	private String vendorAdd1;

	private String taxDesc;
	private String deliveryDesc;
	private String dispModeDesc;
	private String pymtDesc;

	public int getPoDetailId() {
		return poDetailId;
	}

	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public int getPoType() {
		return poType;
	}

	public void setPoType(int poType) {
		this.poType = poType;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getPoDate() {
		return poDate;
	}

	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	public int getVendId() {
		return vendId;
	}

	public void setVendId(int vendId) {
		this.vendId = vendId;
	}

	public String getVendQuation() {
		return vendQuation;
	}

	public void setVendQuation(String vendQuation) {
		this.vendQuation = vendQuation;
	}

	public String getVendQuationDate() {
		return vendQuationDate;
	}

	public void setVendQuationDate(String vendQuationDate) {
		this.vendQuationDate = vendQuationDate;
	}

	public float getPoBasicValue() {
		return poBasicValue;
	}

	public void setPoBasicValue(float poBasicValue) {
		this.poBasicValue = poBasicValue;
	}

	public float getDiscValue() {
		return discValue;
	}

	public void setDiscValue(float discValue) {
		this.discValue = discValue;
	}

	public int getPoTaxId() {
		return poTaxId;
	}

	public void setPoTaxId(int poTaxId) {
		this.poTaxId = poTaxId;
	}

	public float getPoTaxPer() {
		return poTaxPer;
	}

	public void setPoTaxPer(float poTaxPer) {
		this.poTaxPer = poTaxPer;
	}

	public float getPoTaxValue() {
		return poTaxValue;
	}

	public void setPoTaxValue(float poTaxValue) {
		this.poTaxValue = poTaxValue;
	}

	public float getPoPackPer() {
		return poPackPer;
	}

	public void setPoPackPer(float poPackPer) {
		this.poPackPer = poPackPer;
	}

	public float getPoPackVal() {
		return poPackVal;
	}

	public void setPoPackVal(float poPackVal) {
		this.poPackVal = poPackVal;
	}

	public String getPoPackRemark() {
		return poPackRemark;
	}

	public void setPoPackRemark(String poPackRemark) {
		this.poPackRemark = poPackRemark;
	}

	public float getPoInsuPer() {
		return poInsuPer;
	}

	public void setPoInsuPer(float poInsuPer) {
		this.poInsuPer = poInsuPer;
	}

	public float getPoInsuVal() {
		return poInsuVal;
	}

	public void setPoInsuVal(float poInsuVal) {
		this.poInsuVal = poInsuVal;
	}

	public String getPoInsuRemark() {
		return poInsuRemark;
	}

	public void setPoInsuRemark(String poInsuRemark) {
		this.poInsuRemark = poInsuRemark;
	}

	public float getPoFrtPer() {
		return poFrtPer;
	}

	public void setPoFrtPer(float poFrtPer) {
		this.poFrtPer = poFrtPer;
	}

	public float getPoFrtVal() {
		return poFrtVal;
	}

	public void setPoFrtVal(float poFrtVal) {
		this.poFrtVal = poFrtVal;
	}

	public String getPoFrtRemark() {
		return poFrtRemark;
	}

	public void setPoFrtRemark(String poFrtRemark) {
		this.poFrtRemark = poFrtRemark;
	}

	public float getOtherChargeBefore() {
		return otherChargeBefore;
	}

	public void setOtherChargeBefore(float otherChargeBefore) {
		this.otherChargeBefore = otherChargeBefore;
	}

	public String getOtherChargeBeforeRemark() {
		return otherChargeBeforeRemark;
	}

	public void setOtherChargeBeforeRemark(String otherChargeBeforeRemark) {
		this.otherChargeBeforeRemark = otherChargeBeforeRemark;
	}

	public float getOtherChargeAfter() {
		return otherChargeAfter;
	}

	public void setOtherChargeAfter(float otherChargeAfter) {
		this.otherChargeAfter = otherChargeAfter;
	}

	public String getOtherChargeAfterRemark() {
		return otherChargeAfterRemark;
	}

	public void setOtherChargeAfterRemark(String otherChargeAfterRemark) {
		this.otherChargeAfterRemark = otherChargeAfterRemark;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public int getDispatchId() {
		return dispatchId;
	}

	public void setDispatchId(int dispatchId) {
		this.dispatchId = dispatchId;
	}

	public int getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(int paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getPoRemark() {
		return poRemark;
	}

	public void setPoRemark(String poRemark) {
		this.poRemark = poRemark;
	}

	public int getPoStatus() {
		return poStatus;
	}

	public void setPoStatus(int poStatus) {
		this.poStatus = poStatus;
	}

	public int getPrnStatus() {
		return prnStatus;
	}

	public void setPrnStatus(int prnStatus) {
		this.prnStatus = prnStatus;
	}

	public int getPrnCopies() {
		return prnCopies;
	}

	public void setPrnCopies(int prnCopies) {
		this.prnCopies = prnCopies;
	}

	public int getIndId() {
		return indId;
	}

	public void setIndId(int indId) {
		this.indId = indId;
	}

	public String getIndNo() {
		return indNo;
	}

	public void setIndNo(String indNo) {
		this.indNo = indNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getApprovStatus() {
		return approvStatus;
	}

	public void setApprovStatus(int approvStatus) {
		this.approvStatus = approvStatus;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public float getItemRate() {
		return itemRate;
	}

	public void setItemRate(float itemRate) {
		this.itemRate = itemRate;
	}

	public int getMrnQty() {
		return mrnQty;
	}

	public void setMrnQty(int mrnQty) {
		this.mrnQty = mrnQty;
	}

	public int getPendingQty() {
		return pendingQty;
	}

	public void setPendingQty(int pendingQty) {
		this.pendingQty = pendingQty;
	}

	public int getIndedQty() {
		return indedQty;
	}

	public void setIndedQty(int indedQty) {
		this.indedQty = indedQty;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	public int getSchDays() {
		return schDays;
	}

	public void setSchDays(int schDays) {
		this.schDays = schDays;
	}

	public String getSchDate() {
		return schDate;
	}

	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}

	public float getInsu() {
		return insu;
	}

	public void setInsu(float insu) {
		this.insu = insu;
	}

	public float getOtherChargesBefor() {
		return otherChargesBefor;
	}

	public void setOtherChargesBefor(float otherChargesBefor) {
		this.otherChargesBefor = otherChargesBefor;
	}

	public float getTaxValue() {
		return taxValue;
	}

	public void setTaxValue(float taxValue) {
		this.taxValue = taxValue;
	}

	public String getFreightValue() {
		return freightValue;
	}

	public void setFreightValue(String freightValue) {
		this.freightValue = freightValue;
	}

	public float getOtherChargesAfter() {
		return otherChargesAfter;
	}

	public void setOtherChargesAfter(float otherChargesAfter) {
		this.otherChargesAfter = otherChargesAfter;
	}

	public float getLandingCost() {
		return landingCost;
	}

	public void setLandingCost(float landingCost) {
		this.landingCost = landingCost;
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

	public String getTaxDesc() {
		return taxDesc;
	}

	public void setTaxDesc(String taxDesc) {
		this.taxDesc = taxDesc;
	}

	public String getDeliveryDesc() {
		return deliveryDesc;
	}

	public void setDeliveryDesc(String deliveryDesc) {
		this.deliveryDesc = deliveryDesc;
	}

	public String getDispModeDesc() {
		return dispModeDesc;
	}

	public void setDispModeDesc(String dispModeDesc) {
		this.dispModeDesc = dispModeDesc;
	}

	public String getPymtDesc() {
		return pymtDesc;
	}

	public void setPymtDesc(String pymtDesc) {
		this.pymtDesc = pymtDesc;
	}

}
