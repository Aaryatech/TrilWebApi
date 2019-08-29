package com.ats.tril.repository.yearlyreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.yearlyreport.MrnAndIssueData;

public interface MrnAndIssueDataRepo extends JpaRepository<MrnAndIssueData, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    UUID() AS id, MONTH(t_mrn_header.mrn_date) AS MONTH,\r\n" + 
			"    YEAR(t_mrn_header.mrn_date) AS YEAR,\r\n" + 
			"    m_item.cat_id AS cat_id,\r\n" + 
			"    t_mrn_header.mrn_type AS type_id,\r\n" + 
			"    ROUND(\r\n" + 
			"        SUM(\r\n" + 
			"            (\r\n" + 
			"                po_detail.landing_cost / po_detail.item_qty\r\n" + 
			"            ) * t_mrn_detail.approve_qty\r\n" + 
			"        ),\r\n" + 
			"        2\r\n" + 
			"    ) AS amount\r\n" + 
			"FROM\r\n" + 
			"    t_mrn_detail,\r\n" + 
			"    t_mrn_header,\r\n" + 
			"    po_detail,\r\n" + 
			"    m_item\r\n" + 
			"WHERE\r\n" + 
			"    t_mrn_header.mrn_date BETWEEN :fromDate AND :toDate AND t_mrn_header.mrn_id = t_mrn_detail.mrn_id AND m_item.item_id = t_mrn_detail.item_id AND t_mrn_header.del_status = 1 AND t_mrn_detail.del_status = 1 AND po_detail.po_detail_id = t_mrn_detail.po_detail_id AND m_item.cat_id IN(:catId) AND t_mrn_header.mrn_type IN(\r\n" + 
			"    SELECT\r\n" + 
			"        type_id\r\n" + 
			"    FROM type\r\n" + 
			"WHERE\r\n" + 
			"    del_status = 1\r\n" + 
			") AND t_mrn_detail.mrn_detail_status = 4\r\n" + 
			"GROUP BY\r\n" + 
			"    MONTH(t_mrn_header.mrn_date),\r\n" + 
			"    YEAR(t_mrn_header.mrn_date),\r\n" + 
			"    m_item.cat_id,\r\n" + 
			"    t_mrn_header.mrn_type", nativeQuery = true)
	List<MrnAndIssueData> getMRNData(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("catId") int catId);
	
	
	@Query(value = "SELECT\r\n" + 
			"    UUID() AS id, MONTH(item_issue_header.issue_date) AS MONTH,\r\n" + 
			"    YEAR(item_issue_header.issue_date) AS YEAR,\r\n" + 
			"    m_item.cat_id AS cat_id,\r\n" + 
			"    item_issue_header.item_category AS type_id,\r\n" + 
			"    ROUND(\r\n" + 
			"        SUM(\r\n" + 
			"            (\r\n" + 
			"                po_detail.landing_cost / po_detail.item_qty\r\n" + 
			"            ) * item_issue_detail.item_issue_qty\r\n" + 
			"        ),\r\n" + 
			"        2\r\n" + 
			"    ) AS amount\r\n" + 
			"FROM\r\n" + 
			"    item_issue_header,\r\n" + 
			"    item_issue_detail,\r\n" + 
			"    t_mrn_detail,\r\n" + 
			"    po_detail,\r\n" + 
			"    m_item\r\n" + 
			"WHERE\r\n" + 
			"    item_issue_header.issue_date BETWEEN :fromDate AND :toDate AND item_issue_header.issue_id = item_issue_detail.issue_id AND m_item.item_id = item_issue_detail.item_id AND item_issue_header.delete_status = 1 AND item_issue_detail.del_status = 1 AND item_issue_detail.mrn_detail_id = t_mrn_detail.mrn_detail_id AND po_detail.po_detail_id = t_mrn_detail.po_detail_id AND m_item.cat_id IN(:catId) AND item_issue_header.item_category IN(\r\n" + 
			"    SELECT\r\n" + 
			"        type_id\r\n" + 
			"    FROM type\r\n" + 
			"WHERE\r\n" + 
			"    del_status = 1\r\n" + 
			") AND item_issue_detail.status = 2\r\n" + 
			"GROUP BY\r\n" + 
			"    MONTH(item_issue_header.issue_date),\r\n" + 
			"    YEAR(item_issue_header.issue_date),\r\n" + 
			"    m_item.cat_id,\r\n" + 
			"    item_issue_header.item_category", nativeQuery = true)
	List<MrnAndIssueData> getIssueData(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("catId") int catId);
	
	
	@Query(value = "SELECT\r\n" + 
			"    UUID() AS id, MONTH(t_mrn_header.mrn_date) AS MONTH,\r\n" + 
			"    YEAR(t_mrn_header.mrn_date) AS YEAR,\r\n" + 
			"    m_item.cat_id AS cat_id,\r\n" + 
			"    t_mrn_header.mrn_type AS type_id,\r\n" + 
			"    ROUND(\r\n" + 
			"        SUM(\r\n" + 
			"            (\r\n" + 
			"                po_detail.landing_cost / po_detail.item_qty\r\n" + 
			"            ) * t_mrn_detail.approve_qty\r\n" + 
			"        ),\r\n" + 
			"        2\r\n" + 
			"    ) AS amount\r\n" + 
			"FROM\r\n" + 
			"    t_mrn_detail,\r\n" + 
			"    t_mrn_header,\r\n" + 
			"    po_detail,\r\n" + 
			"    m_item\r\n" + 
			"WHERE\r\n" + 
			"    t_mrn_header.mrn_date BETWEEN :fromDate AND :toDate AND t_mrn_header.mrn_id = t_mrn_detail.mrn_id AND m_item.item_id = t_mrn_detail.item_id AND t_mrn_header.del_status = 1 AND t_mrn_detail.del_status = 1 AND po_detail.po_detail_id = t_mrn_detail.po_detail_id AND m_item.cat_id IN(SELECT cat_id FROM m_category WHERE deleted_in=0) AND t_mrn_header.mrn_type IN(\r\n" + 
			"    SELECT\r\n" + 
			"        type_id\r\n" + 
			"    FROM type\r\n" + 
			"WHERE\r\n" + 
			"    del_status = 1\r\n" + 
			") AND t_mrn_detail.mrn_detail_status = 4\r\n" + 
			"GROUP BY\r\n" + 
			"    MONTH(t_mrn_header.mrn_date),\r\n" + 
			"    YEAR(t_mrn_header.mrn_date),\r\n" + 
			"    t_mrn_header.mrn_type", nativeQuery = true)
	List<MrnAndIssueData> getTotalMRNData(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	@Query(value = "SELECT\r\n" + 
			"    UUID() AS id, MONTH(item_issue_header.issue_date) AS MONTH,\r\n" + 
			"    YEAR(item_issue_header.issue_date) AS YEAR,\r\n" + 
			"    m_item.cat_id AS cat_id,\r\n" + 
			"    item_issue_header.item_category AS type_id,\r\n" + 
			"    ROUND(\r\n" + 
			"        SUM(\r\n" + 
			"            (\r\n" + 
			"                po_detail.landing_cost / po_detail.item_qty\r\n" + 
			"            ) * item_issue_detail.item_issue_qty\r\n" + 
			"        ),\r\n" + 
			"        2\r\n" + 
			"    ) AS amount\r\n" + 
			"FROM\r\n" + 
			"    item_issue_header,\r\n" + 
			"    item_issue_detail,\r\n" + 
			"    t_mrn_detail,\r\n" + 
			"    po_detail,\r\n" + 
			"    m_item\r\n" + 
			"WHERE\r\n" + 
			"    item_issue_header.issue_date BETWEEN :fromDate AND :toDate AND item_issue_header.issue_id = item_issue_detail.issue_id AND m_item.item_id = item_issue_detail.item_id AND item_issue_header.delete_status = 1 AND item_issue_detail.del_status = 1 AND item_issue_detail.mrn_detail_id = t_mrn_detail.mrn_detail_id AND po_detail.po_detail_id = t_mrn_detail.po_detail_id AND m_item.cat_id IN(SELECT cat_id FROM m_category WHERE deleted_in=0) AND item_issue_header.item_category IN(\r\n" + 
			"    SELECT\r\n" + 
			"        type_id\r\n" + 
			"    FROM type\r\n" + 
			"WHERE\r\n" + 
			"    del_status = 1\r\n" + 
			") AND item_issue_detail.status = 2\r\n" + 
			"GROUP BY\r\n" + 
			"    MONTH(item_issue_header.issue_date),\r\n" + 
			"    YEAR(item_issue_header.issue_date),\r\n" + 
			"    item_issue_header.item_category", nativeQuery = true)
	List<MrnAndIssueData> getTotalIssueData(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	

}
