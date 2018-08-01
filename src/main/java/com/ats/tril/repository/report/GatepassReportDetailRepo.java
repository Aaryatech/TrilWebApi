package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.GatepassReportDetail;

public interface GatepassReportDetailRepo extends JpaRepository<GatepassReportDetail, Integer> {

	@Query(value = "SELECT d.*,i.item_desc,i.item_code,i.item_uom FROM t_gatepass_detail d,m_item i WHERE d.gp_id IN(:gpIdList) AND d.is_used=1 AND d.gp_item_id=i.item_id"
			+ "", nativeQuery = true)
	List<GatepassReportDetail> gatepassReportDetail(@Param("gpIdList") List<Integer> gpIdList);

	@Query(value = "SELECT d.*,i.item_desc,i.item_code ,i.item_uom FROM t_gatepass_detail d,m_item i WHERE d.gp_id IN(:gpIdList) AND d.gp_status!=3 AND d.is_used=1 AND d.gp_item_id=i.item_id"
			+ "", nativeQuery = true)
	List<GatepassReportDetail> gatepassReportDetailReturnable(@Param("gpIdList") List<Integer> gpIdList);

}
