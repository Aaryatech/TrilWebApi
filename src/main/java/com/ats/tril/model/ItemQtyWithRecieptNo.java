package com.ats.tril.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemQtyWithRecieptNo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private String date;
	
	@Column(name = "recept_no")
	private String receptNo;
	
	@Column(name = "qty")
	private int qty;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReceptNo() {
		return receptNo;
	}

	public void setReceptNo(String receptNo) {
		this.receptNo = receptNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "ItemQtyWithRecieptNo [id=" + id + ", date=" + date + ", receptNo=" + receptNo + ", qty=" + qty + "]";
	}
	
	

	

}
