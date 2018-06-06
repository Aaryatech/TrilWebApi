package com.ats.tril.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_category")

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private int catId;

	private String catDesc;

	private int catSeq;

	private int isUsed;

	private int createdIn;

	private int deletedIn;

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

	public int getCatSeq() {
		return catSeq;
	}

	public void setCatSeq(int catSeq) {
		this.catSeq = catSeq;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public int getCreatedIn() {
		return createdIn;
	}

	public void setCreatedIn(int createdIn) {
		this.createdIn = createdIn;
	}

	public int getDeletedIn() {
		return deletedIn;
	}

	public void setDeletedIn(int deletedIn) {
		this.deletedIn = deletedIn;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catDesc=" + catDesc + ", catSeq=" + catSeq + ", isUsed=" + isUsed
				+ ", createdIn=" + createdIn + ", deletedIn=" + deletedIn + "]";
	}

}
