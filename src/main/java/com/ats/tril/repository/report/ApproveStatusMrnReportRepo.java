package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.ApproveStatusMrnReport;

public interface ApproveStatusMrnReportRepo extends JpaRepository<ApproveStatusMrnReport, Integer> {

	@Query(value = "SELECT d.mrn_detail_id ,h.*,v.vendor_name,v.vendor_code,v.vendor_add1 ,i.item_desc,i.item_code,d.item_id , "
			+ "d.approve_qty ,d.po_id,d.po_no,d. po_detail_id ,d.indent_qty,d. po_qty,d.mrn_qty,d.reject_qty,d.batch_no,"
			+ "d.reject_remark,d.issue_qty,d.remaining_qty ,po.sch_remark,po.sch_days\r\n"
			+ "FROM t_mrn_header h,m_vendor v ,t_mrn_detail d ,m_item i,po_detail po WHERE h.del_status=1 AND h.mrn_id IN(:mrnIdList) AND h.vendor_id=v.vendor_id  AND h.mrn_id=d.mrn_id AND i.item_id=d.item_id AND d.po_detail_id=po.po_detail_id", nativeQuery = true)
	List<ApproveStatusMrnReport> getApproveStatusMrnReport(@Param("mrnIdList") List<Integer> mrnIdList);

}
