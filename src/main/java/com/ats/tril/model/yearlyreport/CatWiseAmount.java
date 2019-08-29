package com.ats.tril.model.yearlyreport;

public class CatWiseAmount {
	
	private int catId;
	private float mrnAmount;
	private float issueAmount;
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public float getMrnAmount() {
		return mrnAmount;
	}
	public void setMrnAmount(float mrnAmount) {
		this.mrnAmount = mrnAmount;
	}
	public float getIssueAmount() {
		return issueAmount;
	}
	public void setIssueAmount(float issueAmount) {
		this.issueAmount = issueAmount;
	}
	@Override
	public String toString() {
		return "CatWiseAmount [catId=" + catId + ", mrnAmount=" + mrnAmount + ", issueAmount=" + issueAmount + "]";
	}
	
	
	

}
