package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.IndentReport;
import com.ats.tril.model.report.POReport;

public interface POReportRepository extends JpaRepository<POReport, Integer> {

	@Query(value = "SELECT d.po_detail_id,h.*,v.vendor_name,v.vendor_code,v.vendor_add1,x.tax_desc ,t.delivery_desc ,"
			+ "dp.disp_mode_desc ,pt.pymt_desc ,d.item_id,d.item_desc,d.item_uom,d.item_qty,d.item_rate,d.mrn_qty,d.pending_qty,"
			+ "d.inded_qty,d.disc_per,d.sch_days,d.sch_date,d.landing_cost,d.other_charges_after,d.freight_value,d.tax_value,"
			+ "d.other_charges_befor,d.insu FROM po_header h ,po_detail d,m_vendor v,m_tax_form x,m_delivery_terms t,"
			+ "m_dispatch_mode dp ,m_payment_terms pt WHERE h.po_id IN(:poIdList) AND h.del_status=1 AND v.vendor_id=h.vend_id"
			+ " AND x.tax_id=h.po_tax_id AND t.delivery_term_id=h.delivery_id AND h.dispatch_id=dp.disp_mode_id AND "
			+ "h.payment_term_id=pt.pymt_term_id AND h.po_id=d.po_id ", nativeQuery = true)
	List<POReport> getPOReportList(@Param("poIdList") List<Integer> poIdList);

}
