package com.ats.tril.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_stock_detail")
public class StockDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stock_detail_id")
	private int stockDetailId;
	
	@Column(name = "stock_header_id")
	private int stockHeaderId;
 
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "op_stock_qty")
	private int opStockQty;

	@Column(name = "approved_qty")
	private int approvedQty;
	
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
	
	@Column(name = "closing_qty")
	private int closingQty;
	
	@Column(name = "del_status")
	private int delStatus;

	public int getStockDetailId() {
		return stockDetailId;
	}

	public void setStockDetailId(int stockDetailId) {
		this.stockDetailId = stockDetailId;
	}

	public int getStockHeaderId() {
		return stockHeaderId;
	}

	public void setStockHeaderId(int stockHeaderId) {
		this.stockHeaderId = stockHeaderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOpStockQty() {
		return opStockQty;
	}

	public void setOpStockQty(int opStockQty) {
		this.opStockQty = opStockQty;
	}

	public int getApprovedQty() {
		return approvedQty;
	}

	public void setApprovedQty(int approvedQty) {
		this.approvedQty = approvedQty;
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

	public int getClosingQty() {
		return closingQty;
	}

	public void setClosingQty(int closingQty) {
		this.closingQty = closingQty;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "StockDetail [stockDetailId=" + stockDetailId + ", stockHeaderId=" + stockHeaderId + ", itemId=" + itemId
				+ ", opStockQty=" + opStockQty + ", approvedQty=" + approvedQty + ", issueQty=" + issueQty
				+ ", returnIssueQty=" + returnIssueQty + ", damageQty=" + damageQty + ", gatepassQty=" + gatepassQty
				+ ", gatepassReturnQty=" + gatepassReturnQty + ", closingQty=" + closingQty + ", delStatus=" + delStatus
				+ "]";
	}
	
	

}
