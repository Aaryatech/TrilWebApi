package com.ats.tril.model.yearlyreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MrnAndIssueData {

	@Id
	private String id;

	private int month;
	private String year;

	private int catId;

	private int typeId;

	private float amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "MrnAndIssueData [id=" + id + ", month=" + month + ", year=" + year + ", catId=" + catId + ", typeId="
				+ typeId + ", amount=" + amount + "]";
	}

}
