package com.ats.tril.repository.newreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.PoStatusReportDetail;

public interface PoStatusReportDetailRepo extends JpaRepository<PoStatusReportDetail, Integer> {
	
	@Query(value = " SELECT t_mrn_header.mrn_no,t_mrn_header.mrn_date, " + 
			" t_mrn_detail.mrn_detail_id, " + 
			" t_mrn_detail.chalan_qty,t_mrn_detail.mrn_qty as recv_qty,t_mrn_detail.approve_qty as accep_qty," + 
			" po_detail.item_rate,po_detail.basic_value " + 
			" FROM t_mrn_header,t_mrn_detail,po_detail " + 
			" WHERE t_mrn_header.mrn_id=t_mrn_detail.mrn_id AND t_mrn_detail.po_detail_id=po_detail.po_detail_id " + 
			" AND po_detail.po_detail_id=:poDetailId  ", 
			nativeQuery = true)
	
	List<PoStatusReportDetail> getPoStatusReportDetail(@Param("poDetailId") int poDetailId);
	

}
