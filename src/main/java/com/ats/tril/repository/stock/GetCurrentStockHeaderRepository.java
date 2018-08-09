package com.ats.tril.repository.stock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.GetCurrStockRol;
import com.ats.tril.model.GetCurrentStock;

public interface GetCurrentStockHeaderRepository extends JpaRepository<GetCurrentStock, Integer>{

	@Query(value=("SELECT\r\n" + 
			"        m_item.item_id,\r\n" + 
			"        m_item.item_code,\r\n" + 
			"        coalesce((Select SUM(t_stock_detail.op_stock_qty)\r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header\r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:fromDate\r\n" + 
			"            AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id\r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) AS opening_stock,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_mrn_detail.approve_qty)\r\n" + 
			"        FROM\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            t_mrn_header\r\n" + 
			"        where\r\n" + 
			"            t_mrn_header.bill_date between :fromDate and :toDate\r\n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id\r\n" + 
			"            AND m_item.item_id=t_mrn_detail.item_id \r\n" + 
			"            and t_mrn_header.del_status=1\r\n" + 
			"            and t_mrn_detail.del_status=1),\r\n" + 
			"        0) AS approve_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)\r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail\r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate\r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id\r\n" + 
			"            AND m_item.item_id=item_issue_detail.item_id\r\n" + 
			"            and item_issue_header.delete_status=1\r\n" + 
			"            and item_issue_detail.del_status=1),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce(0)  AS return_issue_qty,\r\n" + 
			"        coalesce(0) AS damage_qty, \r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_gatepass_detail.gp_qty)\r\n" + 
			"        FROM\r\n" + 
			"            t_gatepass_header,\r\n" + 
			"            t_gatepass_detail\r\n" + 
			"        WHERE\r\n" + 
			"            t_gatepass_header.gp_date between :fromDate and :toDate\r\n" + 
			"            AND t_gatepass_header.gp_id=t_gatepass_detail.gp_id\r\n" + 
			"            AND m_item.item_id=t_gatepass_detail.gp_item_id\r\n" + 
			"            and t_gatepass_header.is_used=1\r\n" + 
			"            and t_gatepass_detail.is_used=1),\r\n" + 
			"        0) AS gatepass_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_getpass_return_detail.return_qty)\r\n" + 
			"        FROM\r\n" + 
			"            t_getpass_return,\r\n" + 
			"            t_getpass_return_detail\r\n" + 
			"        WHERE\r\n" + 
			"            t_getpass_return.gp_return_date between :fromDate and :toDate\r\n" + 
			"            AND t_getpass_return.return_id=t_getpass_return_detail.return_id\r\n" + 
			"            AND m_item.item_id=t_getpass_return_detail.gp_item_id\r\n" + 
			"            and t_getpass_return.is_used=1\r\n" + 
			"            and t_getpass_return_detail.is_used=1),\r\n" + 
			"        0) AS gatepass_return_qty \r\n" + 
			"    FROM\r\n" + 
			"        m_item\r\n" + 
			"    where\r\n" + 
			"        m_item.is_used=1 "),nativeQuery=true)
	List<GetCurrentStock> getCurrentStock(@Param("fromDate")String fromDate,@Param("toDate") String toDate);


}
