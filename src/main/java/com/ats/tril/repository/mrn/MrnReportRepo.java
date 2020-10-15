package com.ats.tril.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.tril.model.mrn.MrnReport;

public interface MrnReportRepo  extends JpaRepository<MrnReport, Integer>{
	
	@Query(value = " SELECT h.mrn_no,h.mrn_type,h.mrn_date,v.vendor_name,h.user_id,h.mrn_status, " + 
			" detail.*, item.item_code,item.item_desc, (pod.landing_cost / pod.item_qty) as landing_rate, pod.item_rate AS item_rate "
			+ ", (detail.remaining_qty*(pod.landing_cost / pod.item_qty) ) as landing_valueation, (detail.remaining_qty*pod.item_rate ) as basic_valueation " + 
			" FROM t_mrn_header h,m_vendor v, t_mrn_detail detail,m_item item,po_detail pod " + 
			" WHERE h.vendor_id IN(:vendorIdList) AND v.vendor_id=h.vendor_id AND h.mrn_type IN(:grnTypeList) AND h.mrn_status IN(:statusList) "+
			 " AND h.del_status=1 AND h.mrn_date BETWEEN :fromDate AND :toDate " +
			" AND h.mrn_id=detail.mrn_id AND detail.po_detail_id=pod.po_detail_id AND detail.item_id=item.item_id and item.cat_id in (:catId) ", nativeQuery = true)
	List<MrnReport> getMrnReport( @Param("vendorIdList") List<String> vendorIdList,@Param("grnTypeList") List<String> grnTypeList,
			@Param("statusList") List<String> statusList,@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("catId") List<String> catId);

	@Query(value = " SELECT h.mrn_no,h.mrn_type,h.mrn_date,v.vendor_name,h.user_id,h.mrn_status, " + 
			"			detail.*, item.item_code,item.item_desc, (pod.landing_cost / pod.item_qty) as landing_rate, pod.item_rate AS item_rate "
			+ ", (detail.remaining_qty*(pod.landing_cost / pod.item_qty) ) as landing_valueation, (detail.remaining_qty*pod.item_rate ) as basic_valueation " + 
			"			FROM t_mrn_header h,m_vendor v, t_mrn_detail detail,m_item item,po_detail pod " + 
			"			WHERE  v.vendor_id=h.vendor_id AND h.mrn_type IN(:grnTypeList) AND h.mrn_status IN(:statusList) " + 
			"			 AND h.del_status=1 AND h.mrn_date BETWEEN :fromDate AND :toDate " + 
			"			 AND h.mrn_id=detail.mrn_id AND detail.po_detail_id=pod.po_detail_id AND detail.item_id=item.item_id and item.cat_id in (:catId)"
			+ " ", nativeQuery = true)
	List<MrnReport> getMrnReportAllVendor(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("grnTypeList") List<String> grnTypeList, @Param("statusList") List<String> statusList, @Param("catId") List<String> catId);
 
	 
	@Query(value = "SELECT\n" + 
			"        h.mrn_no,\n" + 
			"        h.mrn_type,\n" + 
			"        h.mrn_date,\n" + 
			"        v.vendor_name,\n" + 
			"        h.user_id,\n" + 
			"        h.mrn_status,\n" + 
			"        detail.*,\n" + 
			"        item.item_code,\n" + 
			"        item.item_desc,\n" + 
			"        (pod.landing_cost / pod.item_qty) as landing_rate,\n" + 
			"        pod.item_rate AS item_rate, (detail.remaining_qty*(pod.landing_cost / pod.item_qty) ) as landing_valueation, (detail.remaining_qty*pod.item_rate ) as basic_valueation     \n" + 
			"    FROM\n" + 
			"        t_mrn_header h,\n" + 
			"        m_vendor v,\n" + 
			"        t_mrn_detail detail,\n" + 
			"        m_item item,\n" + 
			"        po_detail pod    \n" + 
			"    WHERE\n" + 
			"        v.vendor_id=h.vendor_id \n" + 
			"        AND h.mrn_type IN(:grnTypeList) \n" + 
			"        AND h.mrn_status IN (4)     \n" + 
			"        AND h.del_status=1 \n" + 
			"        AND h.mrn_date BETWEEN :fromDate AND :toDate     \n" + 
			"        AND h.mrn_id=detail.mrn_id \n" + 
			"        AND detail.po_detail_id=pod.po_detail_id \n" + 
			"        AND detail.item_id=item.item_id\n" + 
			"        and detail.remaining_qty=0", nativeQuery = true)
	List<MrnReport> getMrnDetailCompletedReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("grnTypeList") List<String> grnTypeList);

	@Query(value = "SELECT\n" + 
			"        h.mrn_no,\n" + 
			"        h.mrn_type,\n" + 
			"        h.mrn_date,\n" + 
			"        v.vendor_name,\n" + 
			"        h.user_id,\n" + 
			"        h.mrn_status,\n" + 
			"        detail.*,\n" + 
			"        item.item_code,\n" + 
			"        item.item_desc,\n" + 
			"        (pod.landing_cost / pod.item_qty) as landing_rate,\n" + 
			"        pod.item_rate AS item_rate, (detail.remaining_qty*(pod.landing_cost / pod.item_qty) ) as landing_valueation, (detail.remaining_qty*pod.item_rate ) as basic_valueation     \n" + 
			"    FROM\n" + 
			"        t_mrn_header h,\n" + 
			"        m_vendor v,\n" + 
			"        t_mrn_detail detail,\n" + 
			"        m_item item,\n" + 
			"        po_detail pod    \n" + 
			"    WHERE\n" + 
			"        v.vendor_id=h.vendor_id \n" + 
			"        AND h.mrn_type IN(:grnTypeList) \n" + 
			"        AND h.mrn_status IN (4)     \n" + 
			"        AND h.del_status=1 \n" + 
			"        AND h.mrn_date BETWEEN :fromDate AND :toDate     \n" + 
			"        AND h.mrn_id=detail.mrn_id \n" + 
			"        AND detail.po_detail_id=pod.po_detail_id \n" + 
			"        AND detail.item_id=item.item_id\n" + 
			"        and detail.issue_qty=0", nativeQuery = true)
	List<MrnReport> getMrnDetailPendingReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("grnTypeList") List<String> grnTypeList);

	@Query(value = "SELECT\n" + 
			"        h.mrn_no,\n" + 
			"        h.mrn_type,\n" + 
			"        h.mrn_date,\n" + 
			"        v.vendor_name,\n" + 
			"        h.user_id,\n" + 
			"        h.mrn_status,\n" + 
			"        detail.*,\n" + 
			"        item.item_code,\n" + 
			"        item.item_desc,\n" + 
			"        (pod.landing_cost / pod.item_qty) as landing_rate,\n" + 
			"        pod.item_rate AS item_rate, (detail.remaining_qty*(pod.landing_cost / pod.item_qty) ) as landing_valueation, (detail.remaining_qty*pod.item_rate ) as basic_valueation     \n" + 
			"    FROM\n" + 
			"        t_mrn_header h,\n" + 
			"        m_vendor v,\n" + 
			"        t_mrn_detail detail,\n" + 
			"        m_item item,\n" + 
			"        po_detail pod    \n" + 
			"    WHERE\n" + 
			"        v.vendor_id=h.vendor_id \n" + 
			"        AND h.mrn_type IN(:grnTypeList) \n" + 
			"        AND h.mrn_status IN (4)     \n" + 
			"        AND h.del_status=1 \n" + 
			"        AND h.mrn_date BETWEEN :fromDate AND :toDate     \n" + 
			"        AND h.mrn_id=detail.mrn_id \n" + 
			"        AND detail.po_detail_id=pod.po_detail_id \n" + 
			"        AND detail.item_id=item.item_id\n" + 
			"        and detail.issue_qty=0 and h.vendor_id IN(:vendorIdList)", nativeQuery = true)
	List<MrnReport> getMrnDetailPendingReportByVendorId(@Param("vendorIdList") List<String> vendorIdList,@Param("fromDate")String fromDate,
			@Param("toDate")String toDate,@Param("grnTypeList") List<String> grnTypeList);
	
	@Query(value = "SELECT\n" + 
			"        h.mrn_no,\n" + 
			"        h.mrn_type,\n" + 
			"        h.mrn_date,\n" + 
			"        v.vendor_name,\n" + 
			"        h.user_id,\n" + 
			"        h.mrn_status,\n" + 
			"        detail.*,\n" + 
			"        item.item_code,\n" + 
			"        item.item_desc,\n" + 
			"        (pod.landing_cost / pod.item_qty) as landing_rate,\n" + 
			"        pod.item_rate AS item_rate, (detail.remaining_qty*(pod.landing_cost / pod.item_qty) ) as landing_valueation, (detail.remaining_qty*pod.item_rate ) as basic_valueation     \n" + 
			"    FROM\n" + 
			"        t_mrn_header h,\n" + 
			"        m_vendor v,\n" + 
			"        t_mrn_detail detail,\n" + 
			"        m_item item,\n" + 
			"        po_detail pod    \n" + 
			"    WHERE\n" + 
			"        v.vendor_id=h.vendor_id \n" + 
			"        AND h.mrn_type IN(:grnTypeList) \n" + 
			"        AND h.mrn_status IN (4)     \n" + 
			"        AND h.del_status=1 \n" + 
			"        AND h.mrn_date BETWEEN :fromDate AND :toDate     \n" + 
			"        AND h.mrn_id=detail.mrn_id \n" + 
			"        AND detail.po_detail_id=pod.po_detail_id \n" + 
			"        AND detail.item_id=item.item_id\n" + 
			"        and detail.issue_qty>0 and detail.issue_qty!=detail.approve_qty", nativeQuery = true)
	List<MrnReport> getMrnDetailPartialPendingReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("grnTypeList") List<String> grnTypeList);

	@Query(value = "SELECT\n" + 
			"        h.mrn_no,\n" + 
			"        h.mrn_type,\n" + 
			"        h.mrn_date,\n" + 
			"        v.vendor_name,\n" + 
			"        h.user_id,\n" + 
			"        h.mrn_status,\n" + 
			"        detail.*,\n" + 
			"        item.item_code,\n" + 
			"        item.item_desc,\n" + 
			"        (pod.landing_cost / pod.item_qty) as landing_rate,\n" + 
			"        pod.item_rate AS item_rate, (detail.remaining_qty*(pod.landing_cost / pod.item_qty) ) as landing_valueation, (detail.remaining_qty*pod.item_rate ) as basic_valueation     \n" + 
			"    FROM\n" + 
			"        t_mrn_header h,\n" + 
			"        m_vendor v,\n" + 
			"        t_mrn_detail detail,\n" + 
			"        m_item item,\n" + 
			"        po_detail pod    \n" + 
			"    WHERE\n" + 
			"        v.vendor_id=h.vendor_id \n" + 
			"        AND h.mrn_type IN(:grnTypeList) \n" + 
			"        AND h.mrn_status IN (4)     \n" + 
			"        AND h.del_status=1 \n" + 
			"        AND h.mrn_date BETWEEN :fromDate AND :toDate     \n" + 
			"        AND h.mrn_id=detail.mrn_id \n" + 
			"        AND detail.po_detail_id=pod.po_detail_id \n" + 
			"        AND detail.item_id=item.item_id\n" + 
			"        and detail.issue_qty>0 and detail.issue_qty!=detail.approve_qty and h.vendor_id IN(:vendorIdList)", nativeQuery = true)
	List<MrnReport> getMrnDetailPartialPendingReportByVendorId(@Param("vendorIdList") List<String> vendorIdList,@Param("fromDate")String fromDate,
			@Param("toDate")String toDate,@Param("grnTypeList") List<String> grnTypeList);

	@Query(value = "SELECT\n" + 
			"        h.mrn_no,\n" + 
			"        h.mrn_type,\n" + 
			"        h.mrn_date,\n" + 
			"        v.vendor_name,\n" + 
			"        h.user_id,\n" + 
			"        h.mrn_status,\n" + 
			"        detail.*,\n" + 
			"        item.item_code,\n" + 
			"        item.item_desc,\n" + 
			"        (pod.landing_cost / pod.item_qty) as landing_rate,\n" + 
			"        pod.item_rate AS item_rate, (detail.remaining_qty*(pod.landing_cost / pod.item_qty) ) as landing_valueation, (detail.remaining_qty*pod.item_rate ) as basic_valueation     \n" + 
			"    FROM\n" + 
			"        t_mrn_header h,\n" + 
			"        m_vendor v,\n" + 
			"        t_mrn_detail detail,\n" + 
			"        m_item item,\n" + 
			"        po_detail pod    \n" + 
			"    WHERE\n" + 
			"        v.vendor_id=h.vendor_id \n" + 
			"        AND h.mrn_type IN(:grnTypeList) \n" + 
			"        AND h.mrn_status IN (4)     \n" + 
			"        AND h.del_status=1 \n" + 
			"        AND h.mrn_date BETWEEN :fromDate AND :toDate     \n" + 
			"        AND h.mrn_id=detail.mrn_id \n" + 
			"        AND detail.po_detail_id=pod.po_detail_id \n" + 
			"        AND detail.item_id=item.item_id\n" + 
			"        and detail.remaining_qty=0 and h.vendor_id IN(:vendorIdList)", nativeQuery = true)
	List<MrnReport> getMrnDetailCompletedReportByVendorId(@Param("vendorIdList") List<String> vendorIdList,@Param("fromDate")String fromDate,
			@Param("toDate")String toDate,@Param("grnTypeList") List<String> grnTypeList);

	

}
