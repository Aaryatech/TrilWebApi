package com.ats.tril.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrentMrnDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "approve_qty")
	private float approveQty;
	
	@Column(name = "approved_qty_value")
	private float approvedQtyValue;
	
	@Column(name = "approved_landing_value")
	private float approvedLandingValue;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getApproveQty() {
		return approveQty;
	}

	public void setApproveQty(float approveQty) {
		this.approveQty = approveQty;
	}

	public float getApprovedQtyValue() {
		return approvedQtyValue;
	}

	public void setApprovedQtyValue(float approvedQtyValue) {
		this.approvedQtyValue = approvedQtyValue;
	}

	public float getApprovedLandingValue() {
		return approvedLandingValue;
	}

	public void setApprovedLandingValue(float approvedLandingValue) {
		this.approvedLandingValue = approvedLandingValue;
	}

	@Override
	public String toString() {
		return "CurrentMrnDetail [itemId=" + itemId + ", approveQty=" + approveQty + ", approvedQtyValue="
				+ approvedQtyValue + ", approvedLandingValue=" + approvedLandingValue + "]";
	}
	
	

}
