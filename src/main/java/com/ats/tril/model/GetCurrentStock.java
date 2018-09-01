package com.ats.tril.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetCurrentStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_code")
	private String itemCode;

	@Column(name = "opening_stock")
	private float openingStock;

	@Column(name = "approve_qty")
	private float approveQty;

	@Column(name = "issue_qty")
	private float issueQty;
	
	@Column(name = "return_issue_qty")
	private float returnIssueQty;
	
	@Column(name = "damage_qty")
	private float damageQty;
	
	@Column(name = "gatepass_qty")
	private float gatepassQty;
	
	@Column(name = "gatepass_return_qty")
	private float gatepassReturnQty;
	
	@Transient
	private float rolLevel;
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public float getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(float openingStock) {
		this.openingStock = openingStock;
	}

	public float getApproveQty() {
		return approveQty;
	}

	public void setApproveQty(float approveQty) {
		this.approveQty = approveQty;
	}

	public float getIssueQty() {
		return issueQty;
	}

	public void setIssueQty(float issueQty) {
		this.issueQty = issueQty;
	}

	public float getReturnIssueQty() {
		return returnIssueQty;
	}

	public void setReturnIssueQty(float returnIssueQty) {
		this.returnIssueQty = returnIssueQty;
	}

	public float getDamageQty() {
		return damageQty;
	}

	public void setDamageQty(float damageQty) {
		this.damageQty = damageQty;
	}

	public float getGatepassQty() {
		return gatepassQty;
	}

	public void setGatepassQty(float gatepassQty) {
		this.gatepassQty = gatepassQty;
	}

	public float getGatepassReturnQty() {
		return gatepassReturnQty;
	}

	public void setGatepassReturnQty(float gatepassReturnQty) {
		this.gatepassReturnQty = gatepassReturnQty;
	}

	public float getRolLevel() {
		return rolLevel;
	}

	public void setRolLevel(float rolLevel) {
		this.rolLevel = rolLevel;
	}

	@Override
	public String toString() {
		return "GetCurrentStock [itemId=" + itemId + ", itemCode=" + itemCode + ", openingStock=" + openingStock
				+ ", approveQty=" + approveQty + ", issueQty=" + issueQty + ", returnIssueQty=" + returnIssueQty
				+ ", damageQty=" + damageQty + ", gatepassQty=" + gatepassQty + ", gatepassReturnQty="
				+ gatepassReturnQty + ", rolLevel=" + rolLevel + "]";
	}
	
	
	
	 

}
