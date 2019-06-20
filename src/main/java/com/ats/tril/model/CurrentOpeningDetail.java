package com.ats.tril.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrentOpeningDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "opening_stock")
	private float openingStock;

	@Column(name = "op_stock_value")
	private float opStockValue;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(float openingStock) {
		this.openingStock = openingStock;
	}

	public float getOpStockValue() {
		return opStockValue;
	}

	public void setOpStockValue(float opStockValue) {
		this.opStockValue = opStockValue;
	}

	@Override
	public String toString() {
		return "CurrentOpeningDetail [itemId=" + itemId + ", openingStock=" + openingStock + ", opStockValue="
				+ opStockValue + "]";
	}
	
	

}
