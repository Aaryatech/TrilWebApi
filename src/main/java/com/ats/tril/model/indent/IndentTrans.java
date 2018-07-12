package com.ats.tril.model.indent;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "indtrans")
public class IndentTrans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ind_d_id")
	private int indDId;
	
	@Column(name = "ind_m_id")
	private int indMId;
	
	@Column(name = "ind_m_no")
	private String indMNo;
	
	@Column(name = "ind_m_date")
	private Date indMDate;
	
	private int itemId;
	
	private int indQty;
	
	private String indItemUom;
	
	private String indItemDesc;
	
	private int indItemCurstk;
	
	private int indItemSchd;
	
	private Date indItemSchddt;
	
	private String indRemark;
	@Column(name = "ind_d_status")
	private int indDStatus;
	
	private int	indFyr;

	public int getIndDId() {
		return indDId;
	}

	public int getIndMId() {
		return indMId;
	}

	public String getIndMNo() {
		return indMNo;
	}

	public Date getIndMDate() {
		return indMDate;
	}

	public int getItemId() {
		return itemId;
	}

	public int getIndQty() {
		return indQty;
	}

	public String getIndItemUom() {
		return indItemUom;
	}

	public String getIndItemDesc() {
		return indItemDesc;
	}

	public int getIndItemCurstk() {
		return indItemCurstk;
	}

	public int getIndItemSchd() {
		return indItemSchd;
	}

	public Date getIndItemSchddt() {
		return indItemSchddt;
	}

	public String getIndRemark() {
		return indRemark;
	}

	public int getIndDStatus() {
		return indDStatus;
	}

	public int getIndFyr() {
		return indFyr;
	}

	public void setIndDId(int indDId) {
		this.indDId = indDId;
	}

	public void setIndMId(int indMId) {
		this.indMId = indMId;
	}

	public void setIndMNo(String indMNo) {
		this.indMNo = indMNo;
	}

	public void setIndMDate(Date indMDate) {
		this.indMDate = indMDate;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setIndQty(int indQty) {
		this.indQty = indQty;
	}

	public void setIndItemUom(String indItemUom) {
		this.indItemUom = indItemUom;
	}

	public void setIndItemDesc(String indItemDesc) {
		this.indItemDesc = indItemDesc;
	}

	public void setIndItemCurstk(int indItemCurstk) {
		this.indItemCurstk = indItemCurstk;
	}

	public void setIndItemSchd(int indItemSchd) {
		this.indItemSchd = indItemSchd;
	}

	public void setIndItemSchddt(Date indItemSchddt) {
		this.indItemSchddt = indItemSchddt;
	}

	public void setIndRemark(String indRemark) {
		this.indRemark = indRemark;
	}

	public void setIndDStatus(int indDStatus) {
		this.indDStatus = indDStatus;
	}

	public void setIndFyr(int indFyr) {
		this.indFyr = indFyr;
	}
	
	@Override
	public String toString() {
		return "IndentTrans [indDId=" + indDId + ", indMId=" + indMId + ", indMNo=" + indMNo + ", indMDate=" + indMDate
				+ ", itemId=" + itemId + ", indQty=" + indQty + ", indItemUom=" + indItemUom + ", indItemDesc="
				+ indItemDesc + ", indItemCurstk=" + indItemCurstk + ", indItemSchd=" + indItemSchd + ", indItemSchddt="
				+ indItemSchddt + ", indRemark=" + indRemark + ", indDStatus=" + indDStatus + ", indFyr=" + indFyr
				+ "]";
	}

}