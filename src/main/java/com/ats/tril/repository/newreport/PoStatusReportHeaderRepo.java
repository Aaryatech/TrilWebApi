package com.ats.tril.repository.newreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.PoStatusReportHeader;

public interface PoStatusReportHeaderRepo extends JpaRepository<PoStatusReportHeader, Integer>  {
	
	@Query(value = " SELECT m_item.item_code,m_item.item_desc,m_item.item_id," + 
			" po_detail.item_qty as po_qty," + 
			" po_detail.po_detail_id,  "+
			" po_detail.pending_qty as bal_qty," + 
			" t_mrn_detail.approve_qty as recv_qty," + 
			" po_detail.item_rate," + 
			" po_header.po_no,po_header.po_date," + 
			" indent.ind_m_no as indent_no," + 
			" m_vendor.vendor_code,m_vendor.vendor_name " + 
			" FROM m_item,po_detail,t_mrn_detail,indent,m_vendor,po_header " + 
			" WHERE m_item.item_id=po_detail.item_id " + 
			" AND t_mrn_detail.po_detail_id=po_detail.po_detail_id " + 
			" AND po_header.po_id=po_detail.po_id " + 
			" AND po_header.vend_id=m_vendor.vendor_id " + 
			" and indent.ind_m_id=po_header.ind_id " + 
			" AND po_header.po_date BETWEEN :fromDate AND :toDate " + 
			" AND po_header.po_type=:typeId AND m_item.cat_id=:catId "
			+ " AND po_detail.status IN (0,1) " + 
			"" + 
			"  ORDER BY m_item.item_code ", 
			nativeQuery = true)
	
	List<PoStatusReportHeader> getPoStatusReportHeader(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("typeId") int typeId,@Param("catId") int catId);

	@Query(value = " SELECT m_item.item_code,m_item.item_desc,m_item.item_id," + 
			" po_detail.po_detail_id, "+
			" po_detail.item_qty as po_qty," + 
			" po_detail.pending_qty as bal_qty," + 
			" t_mrn_detail.approve_qty as recv_qty," + 
			" po_detail.item_rate," + 
			" po_header.po_no,po_header.po_date," + 
			" indent.ind_m_no as indent_no," + 
			" m_vendor.vendor_code,m_vendor.vendor_name " + 
			" FROM m_item,po_detail,t_mrn_detail,indent,m_vendor,po_header " + 
			" WHERE m_item.item_id=po_detail.item_id " + 
			" AND t_mrn_detail.po_detail_id=po_detail.po_detail_id " + 
			" AND po_header.po_id=po_detail.po_id " + 
			" AND po_header.vend_id=m_vendor.vendor_id " + 
			" and indent.ind_m_id=po_header.ind_id " + 
			" AND po_header.po_date BETWEEN :fromDate AND :toDate " + 
			" and m_item.cat_id=:catId " + 
			" AND po_detail.status IN ( 0,1) " + 
			" ORDER BY m_item.item_code", 
			nativeQuery = true)
	List<PoStatusReportHeader> stockValueationReportAllType(String fromDate, String toDate, int catId);

}
