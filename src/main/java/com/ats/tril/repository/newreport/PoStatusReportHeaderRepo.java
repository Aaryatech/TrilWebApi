package com.ats.tril.repository.newreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.tril.model.report.PoStatusReportHeader;

public interface PoStatusReportHeaderRepo extends JpaRepository<PoStatusReportHeader, Integer>  {
	
	@Query(value = " SELECT m_item.item_code,m_item.item_desc,m_item.item_id," + 
			" po_detail.item_qty as po_qty," + 
			" po_detail.po_detail_id,  "+
			" po_detail.pending_qty as bal_qty," + 
			//" COALESCE((SELECT SUM(t_mrn_detail.approve_qty)),0) as recv_qty," + 
	        " COALESCE((SELECT SUM(t_mrn_detail.approve_qty) from t_mrn_detail WHERE t_mrn_detail.po_detail_id=po_detail.po_detail_id GROUP by t_mrn_detail.po_detail_id),0) as recv_qty,"+
			" po_detail.item_rate," + 
			" po_header.po_no,po_header.po_date," + 
			" indent.ind_m_no as indent_no," + 
			" m_vendor.vendor_code,m_vendor.vendor_name " + 
			" FROM m_item,po_detail,indent,m_vendor,po_header " + 
			" WHERE m_item.item_id=po_detail.item_id " + 
			//" AND t_mrn_detail.po_detail_id=po_detail.po_detail_id " + 
			" AND po_header.po_id=po_detail.po_id " + 
			" AND po_header.vend_id=m_vendor.vendor_id " + 
			" and indent.ind_m_id=po_header.ind_id " + 
			" AND po_header.po_date BETWEEN :fromDate AND :toDate " + 
			" AND po_header.po_type=:typeId AND m_item.cat_id=:catId AND po_detail.status IN (:statusList)  "
			+ " AND po_header.vend_id IN (:vendorList) "+
			//+ " GROUP BY t_mrn_detail.po_detail_id " + 
			
			" ORDER BY po_header.vend_id,po_header.po_no DESC ", 
			nativeQuery = true)
	
	List<PoStatusReportHeader> getPoStatusReportHeaderByTypeAndCatId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("typeId") int typeId,@Param("catId") int catId,@Param("statusList") List<String> statusList,@Param("vendorList") List<String> vendorList);

	@Query(value = " SELECT m_item.item_code,m_item.item_desc,m_item.item_id," + 
			" po_detail.po_detail_id, "+
			" po_detail.item_qty as po_qty," + 
			" po_detail.pending_qty as bal_qty," + 
			//" SUM(t_mrn_detail.approve_qty) as recv_qty," +
	        " COALESCE((SELECT SUM(t_mrn_detail.approve_qty) from t_mrn_detail WHERE t_mrn_detail.po_detail_id=po_detail.po_detail_id GROUP by t_mrn_detail.po_detail_id),0) as recv_qty,"+
			" po_detail.item_rate," + 
			" po_header.po_no,po_header.po_date," + 
			" indent.ind_m_no as indent_no," + 
			" m_vendor.vendor_code,m_vendor.vendor_name " + 
			" FROM m_item,po_detail,indent,m_vendor,po_header " + 
			" WHERE m_item.item_id=po_detail.item_id " + 
			//" AND t_mrn_detail.po_detail_id=po_detail.po_detail_id " + 
			" AND po_header.po_id=po_detail.po_id " + 
			" AND po_header.vend_id=m_vendor.vendor_id " + 
			" and indent.ind_m_id=po_header.ind_id " + 
			" AND po_header.po_date BETWEEN :fromDate AND :toDate " + 
			" and m_item.cat_id=:catId  AND po_detail.status IN (:statusList) " + 
			 " AND po_header.vend_id IN (:vendorList) "+
			//" GROUP BY t_mrn_detail.po_detail_id  " + 
			" ORDER BY po_header.vend_id,po_header.po_no DESC ", 
			nativeQuery = true)
	List<PoStatusReportHeader> getPoStatusReportHeaderAllTypeOnecatId(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("catId") int catId,@Param("statusList") List<String> statusList,@Param("vendorList") List<String> vendorList);
	
	//all type all category -3
	
	@Query(value = " SELECT m_item.item_code,m_item.item_desc,m_item.item_id," + 
			" po_detail.po_detail_id, "+
			" po_detail.item_qty as po_qty," + 
			" po_detail.pending_qty as bal_qty," + 
			//" SUM(t_mrn_detail.approve_qty) as recv_qty," +
	        " COALESCE((SELECT SUM(t_mrn_detail.approve_qty) from t_mrn_detail WHERE t_mrn_detail.po_detail_id=po_detail.po_detail_id GROUP by t_mrn_detail.po_detail_id),0) as recv_qty,"+
			" po_detail.item_rate," + 
			" po_header.po_no,po_header.po_date," + 
			" indent.ind_m_no as indent_no," + 
			" m_vendor.vendor_code,m_vendor.vendor_name " + 
			" FROM m_item,po_detail,indent,m_vendor,po_header " + 
			" WHERE m_item.item_id=po_detail.item_id " + 
			" AND po_header.po_id=po_detail.po_id " + 
			" AND po_header.vend_id=m_vendor.vendor_id " + 
			" and indent.ind_m_id=po_header.ind_id " + 
			" AND po_header.po_date BETWEEN :fromDate AND :toDate AND po_detail.status IN (:statusList)  " +
			 " AND po_header.vend_id IN (:vendorList) " +
			" ORDER BY po_header.vend_id,po_header.po_no DESC ", 
			nativeQuery = true)
	List<PoStatusReportHeader> getPoStatusReportHeaderAllTypeAllcatId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("statusList") List<String> statusList,@Param("vendorList") List<String> vendorList);
// all cate one type -4
	
	@Query(value = " SELECT m_item.item_code,m_item.item_desc,m_item.item_id," + 
			" po_detail.item_qty as po_qty," + 
			" po_detail.po_detail_id,  "+
			" po_detail.pending_qty as bal_qty," + 
			//" SUM(t_mrn_detail.approve_qty) as recv_qty," + 
	        " COALESCE((SELECT SUM(t_mrn_detail.approve_qty) from t_mrn_detail WHERE t_mrn_detail.po_detail_id=po_detail.po_detail_id GROUP by t_mrn_detail.po_detail_id),0) as recv_qty,"+
			" po_detail.item_rate," + 
			" po_header.po_no,po_header.po_date," + 
			" indent.ind_m_no as indent_no," + 
			" m_vendor.vendor_code,m_vendor.vendor_name " + 
			" FROM m_item,po_detail,indent,m_vendor,po_header " + 
			" WHERE m_item.item_id=po_detail.item_id " + 
			//" AND t_mrn_detail.po_detail_id=po_detail.po_detail_id " + 
			" AND po_header.po_id=po_detail.po_id " + 
			" AND po_header.vend_id=m_vendor.vendor_id " + 
			" and indent.ind_m_id=po_header.ind_id " + 
			" AND po_header.po_date BETWEEN :fromDate AND :toDate " + 
			" AND po_header.po_type=:typeId AND po_detail.status IN (:statusList)  " +
			 " AND po_header.vend_id IN (:vendorList) " +
			"" + 
			" ORDER BY po_header.vend_id,po_header.po_no DESC ", 
			nativeQuery = true)
	
	List<PoStatusReportHeader> getPoStatusReportHeaderByTypeAndAllCatId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("typeId") int typeId,@Param("statusList") List<String> statusList,@Param("vendorList") List<String> vendorList);


}
