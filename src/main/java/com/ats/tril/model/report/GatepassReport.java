package com.ats.tril.model.report;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GatepassReport {

	@Id
	private int gpDetailId;
	private int gpId;
	private int gpNo;
	private int gpVendor;

	private int gpType;
	private Date gpReturnDate;
	private int gpStatus;
	private int isUsed;

	private String remark1;
	private String remark2;
	private String sendingWith;
	private int isStockable;
	private int forRepair;
	private Date gpDate;

	private int gpItemId;
	private float gpQty;
	private int gpNoDays;
	private Date gpReturnableDate;
	private float gpRemQty;
	private float gpRetQty;

	private String vendorName;
	private String vendorCode;
	private String vendorAdd1;

	private String itemCode;
	private String itemDesc;

}
