package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.MrnCatwiseReport;

public interface MrnCatwiseReportRepo extends JpaRepository<MrnCatwiseReport, Integer> {

	@Query(value = "SELECT t_mrn_detail.mrn_detail_id, m_category.cat_desc,m_item.item_desc,m_item.item_code, DATEDIFF(CURDATE(),t_mrn_header.mrn_date) as days,"
			+ "t_mrn_header.mrn_no,t_mrn_header.mrn_date,t_mrn_detail.mrn_qty,t_mrn_detail.remaining_qty,po_detail.item_rate "
			+ "FROM m_category,m_item,t_mrn_detail,t_mrn_header,po_detail WHERE t_mrn_header.mrn_id=t_mrn_detail.mrn_id AND "
			+ "t_mrn_detail.po_detail_id=po_detail.po_detail_id AND t_mrn_detail.item_id=m_item.item_id "
			+ "AND m_item.cat_id=m_category.cat_id AND m_category.cat_id IN(:catIdList) AND t_mrn_detail.remaining_qty > 0 "
			+ "ORDER BY t_mrn_header.mrn_id", nativeQuery = true)
	List<MrnCatwiseReport> getMrnReportCatwiseList(@Param("catIdList") List<String> catIdList);

	@Query(value = "SELECT t_mrn_detail.mrn_detail_id, m_category.cat_desc,m_item.item_desc,m_item.item_code,DATEDIFF(CURDATE(),t_mrn_header.mrn_date) as days,"
			+ "t_mrn_header.mrn_no,t_mrn_header.mrn_date,t_mrn_detail.mrn_qty,t_mrn_detail.remaining_qty,po_detail.item_rate "
			+ "FROM m_category,m_item,t_mrn_detail,t_mrn_header,po_detail WHERE t_mrn_header.mrn_id=t_mrn_detail.mrn_id AND "
			+ "t_mrn_detail.po_detail_id=po_detail.po_detail_id AND t_mrn_detail.item_id=m_item.item_id "
			+ "AND m_item.cat_id=m_category.cat_id  AND t_mrn_detail.remaining_qty > 0 "
			+ "ORDER BY t_mrn_header.mrn_id", nativeQuery = true)
	List<MrnCatwiseReport> getMrnReport();

}
