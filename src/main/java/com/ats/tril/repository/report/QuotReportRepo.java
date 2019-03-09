package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.QuotReport;

public interface QuotReportRepo extends JpaRepository<QuotReport, Integer> {

	@Query(value = "SELECT t_quotation_header.enq_id,t_quotation_header.enq_no,t_quotation_header.enq_date,m_item.item_desc,"
			+ "t_quotation_detail.enq_qty,t_quotation_detail.enq_remark,t_quotation_header.enq_remark as header_remark FROM"
			+ " t_quotation_header,t_quotation_detail,m_item WHERE t_quotation_header.enq_id=t_quotation_detail.enq_id AND "
			+ "t_quotation_detail.item_id=m_item.item_id AND t_quotation_header.enq_date BETWEEN :fromDate AND :toDate"
			+ " AND t_quotation_header.enq_status IN(:status)", nativeQuery = true)
	List<QuotReport> getQuotReportBetDAteAndStatus(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("status") List<String> status);
	
	@Query(value = "SELECT t_quotation_header.enq_id,t_quotation_header.enq_no,t_quotation_header.enq_date,m_item.item_desc,"
			+ "t_quotation_detail.enq_qty,t_quotation_detail.enq_remark,t_quotation_header.enq_remark as header_remark FROM"
			+ " t_quotation_header,t_quotation_detail,m_item WHERE t_quotation_header.enq_id=t_quotation_detail.enq_id AND "
			+ "t_quotation_detail.item_id=m_item.item_id AND t_quotation_header.enq_date BETWEEN :fromDate AND :toDate"
			+ " ", nativeQuery = true)
	List<QuotReport> getQuotReportBetDAte(@Param("fromDate") String fromDate, @Param("toDate") String toDate
			 );


}
