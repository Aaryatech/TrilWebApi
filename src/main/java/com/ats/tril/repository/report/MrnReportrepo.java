package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.MrnReport;

public interface MrnReportrepo extends JpaRepository<MrnReport, Integer> {

	@Query(value = "SELECT d.mrn_detail_id ,h.*,v.vendor_name,v.vendor_code,v.vendor_add1 ,i.item_desc,i.item_code,"
			+ " d.item_id ,d.approve_qty FROM t_mrn_header h,m_vendor v ,t_mrn_detail d ,m_item i WHERE h.del_status=1 "
			+ "AND h.mrn_id IN(:mrnIdList) AND h.vendor_id=v.vendor_id  AND h.mrn_id=d.mrn_id AND i.item_id=d.item_id ", nativeQuery = true)
	List<MrnReport> getMrnReportList(@Param("mrnIdList") List<Integer> mrnIdList);

}
