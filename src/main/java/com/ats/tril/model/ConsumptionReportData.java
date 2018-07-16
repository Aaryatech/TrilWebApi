package com.ats.tril.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConsumptionReportData implements Serializable{
	
	@Id
	private int catId;
	
	private String catDesc;
	
	private float target;
	
	private float totalValue;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public float getTarget() {
		return target;
	}

	public void setTarget(float target) {
		this.target = target;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return "ConsumptionReport [catId=" + catId + ", catDesc=" + catDesc + ", target=" + target + ", totalValue="
				+ totalValue + "]";
	}
	
	

}
