package com.ats.tril.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetCurrentStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_code")
	private String itemCode;

	@Column(name = "opening_stock")
	private int openingStock;

	@Column(name = "approve_qty")
	private int approveQty;

	@Column(name = "issue_qty")
	private int issueQty;
	
	@Column(name = "return_issue_qty")
	private int returnIssueQty;
	
	@Column(name = "damage_qty")
	private int damageQty;
	
	@Column(name = "gatepass_qty")
	private int gatepassQty;
	
	@Column(name = "gatepass_return_qty")
	private int gatepassReturnQty;

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

	public int getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(int openingStock) {
		this.openingStock = openingStock;
	}

	public int getApproveQty() {
		return approveQty;
	}

	public void setApproveQty(int approveQty) {
		this.approveQty = approveQty;
	}

	public int getIssueQty() {
		return issueQty;
	}

	public void setIssueQty(int issueQty) {
		this.issueQty = issueQty;
	}

	public int getReturnIssueQty() {
		return returnIssueQty;
	}

	public void setReturnIssueQty(int returnIssueQty) {
		this.returnIssueQty = returnIssueQty;
	}

	public int getDamageQty() {
		return damageQty;
	}

	public void setDamageQty(int damageQty) {
		this.damageQty = damageQty;
	}

	public int getGatepassQty() {
		return gatepassQty;
	}

	public void setGatepassQty(int gatepassQty) {
		this.gatepassQty = gatepassQty;
	}

	public int getGatepassReturnQty() {
		return gatepassReturnQty;
	}

	public void setGatepassReturnQty(int gatepassReturnQty) {
		this.gatepassReturnQty = gatepassReturnQty;
	}

	@Override
	public String toString() {
		return "GetCurrentStock [itemId=" + itemId + ", itemCode=" + itemCode + ", openingStock=" + openingStock
				+ ", approveQty=" + approveQty + ", issueQty=" + issueQty + ", returnIssueQty=" + returnIssueQty
				+ ", damageQty=" + damageQty + ", gatepassQty=" + gatepassQty + ", gatepassReturnQty="
				+ gatepassReturnQty + "]";
	}
	
	
	
	 

}
