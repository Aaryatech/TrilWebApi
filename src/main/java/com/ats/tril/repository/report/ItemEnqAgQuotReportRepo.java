package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.ItemEnqAgQuotReport;

public interface ItemEnqAgQuotReportRepo extends JpaRepository<ItemEnqAgQuotReport, Integer> {

	@Query(value = "SELECT m_item.item_id,enq_header.enq_status, enq_header.enq_no,enq_header.enq_date,enq_detail.ind_no,"
			+ "m_item.item_desc,enq_detail.enq_qty,enq_detail.enq_remark FROM enq_header,enq_detail,m_item"
			+ " WHERE enq_header.enq_id=enq_detail.enq_id AND enq_detail.item_id=m_item.item_id AND enq_header.enq_date "
			+ "BETWEEN :fromDate AND :toDate AND enq_header.enq_status=:status  ", nativeQuery = true)
	List<ItemEnqAgQuotReport> getQuotReportBetDAte(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("status") int status);

	@Query(value = "SELECT m_item.item_id,enq_header.enq_status, enq_header.enq_no,enq_header.enq_date,enq_detail.ind_no,"
			+ "m_item.item_desc,enq_detail.enq_qty,enq_detail.enq_remark FROM enq_header,enq_detail,m_item"
			+ " WHERE enq_header.enq_id=enq_detail.enq_id AND enq_detail.item_id=m_item.item_id AND enq_header.enq_date "
			+ "BETWEEN :fromDate AND :toDate AND enq_header.enq_status=:status AND enq_header.vend_id in(:vendorIdList)  ", nativeQuery = true)
	List<ItemEnqAgQuotReport> getQuotReportBetDAteAndStatus(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("status") int status,
			@Param("vendorIdList") List<String> vendorIdList);

}
