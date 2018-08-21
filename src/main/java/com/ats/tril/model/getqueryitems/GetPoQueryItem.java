package com.ats.tril.model.getqueryitems;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetPoQueryItem {
	
	@Id
	@Column(name = "po_detail_id")
	private int poDetailId;
	
	private String poNo;
	
	private String poDate;
	
	private int poType;
	
	private String vendorCode;
	
	private String vendorName;
	
	private int itemQty;//ie poQty
	
	private  int itemRate;//i.e poRate
	
	private int indedQty;//ie indentQty
	
	private String indNo;//from indent
		
	private String indDate;//from indent
	
	
	

}
