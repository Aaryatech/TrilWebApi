package com.ats.tril.repository.stock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.GetCurrStockRol;
import com.ats.tril.model.GetCurrentStock;

public interface GetCurrentStockHeaderRepository extends JpaRepository<GetCurrentStock, Integer>{

	@Query(value=("SELECT "
			+ "m_item.item_id, CONCAT(m_item.item_code, ' ', m_item.item_desc) as item_code, coalesce((Select "
			+ "SUM(t_stock_detail.op_stock_qty) FROM t_stock_detail, t_stock_header where t_stock_header.date=:fromDate "
			+ "AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id AND m_item.item_id=t_stock_detail.item_id), 0) "
			+ "AS opening_stock, coalesce((Select SUM(t_stock_detail.op_stock_value) FROM t_stock_detail, t_stock_header where "
			+ "t_stock_header.date=:fromDate AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) AS op_stock_value, coalesce((Select SUM(t_mrn_detail.approve_qty) FROM "
			+ "t_mrn_detail, t_mrn_header where t_mrn_header.mrn_date between :fromDate and :toDate AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id "
			+ "AND m_item.item_id=t_mrn_detail.item_id and t_mrn_header.del_status=1 and t_mrn_detail.del_status=1), 0) AS approve_qty, "
			+ "coalesce((Select SUM(po_detail.item_rate*t_mrn_detail.approve_qty) FROM t_mrn_detail, t_mrn_header, po_detail where "
			+ "t_mrn_header.mrn_date between :fromDate and :toDate AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id "
			+ "AND m_item.item_id=t_mrn_detail.item_id and t_mrn_header.del_status=1 and t_mrn_detail.del_status=1 "
			+ "and po_detail.po_detail_id=t_mrn_detail.po_detail_id), 0) AS approved_qty_value, coalesce((Select "
			+ "SUM((po_detail.landing_cost/po_detail.item_qty)*t_mrn_detail.approve_qty) FROM t_mrn_detail, t_mrn_header, "
			+ "po_detail where t_mrn_header.mrn_date between :fromDate and :toDate AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id "
			+ "AND m_item.item_id=t_mrn_detail.item_id and t_mrn_header.del_status=1 and t_mrn_detail.del_status=1 "
			+ "and po_detail.po_detail_id=t_mrn_detail.po_detail_id), 0) AS approved_landing_value, coalesce((Select "
			+ "SUM(item_issue_detail.item_issue_qty) FROM item_issue_header, item_issue_detail WHERE item_issue_header.issue_date between"
			+ " :fromDate and :toDate AND item_issue_header.issue_id=item_issue_detail.issue_id AND m_item.item_id=item_issue_detail.item_id "
			+ "and item_issue_header.delete_status=1 and item_issue_detail.del_status=1), 0) AS issue_qty, coalesce((Select "
			+ "SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) FROM item_issue_header, item_issue_detail, t_mrn_detail, po_detail "
			+ "WHERE item_issue_header.issue_date between :fromDate and :toDate AND item_issue_header.issue_id=item_issue_detail.issue_id "
			+ "AND m_item.item_id=item_issue_detail.item_id and item_issue_header.delete_status=1 and item_issue_detail.del_status=1 "
			+ "and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id and po_detail.po_detail_id=t_mrn_detail.po_detail_id), "
			+ "0) AS issue_qty_value, coalesce((Select SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) "
			+ "FROM item_issue_header, item_issue_detail, t_mrn_detail, po_detail WHERE item_issue_header.issue_date between :fromDate and :toDate"
			+ " AND item_issue_header.issue_id=item_issue_detail.issue_id AND m_item.item_id=item_issue_detail.item_id "
			+ "and item_issue_header.delete_status=1 and item_issue_detail.del_status=1 and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id "
			+ "and po_detail.po_detail_id=t_mrn_detail.po_detail_id), 0) AS issue_landing_value, coalesce(0)  AS return_issue_qty, coalesce((Select "
			+ "SUM(t_damage.qty) FROM t_damage  WHERE t_damage.date between :fromDate and :toDate and t_damage.del_status=1 AND m_item.item_id=t_damage.item_id),0) AS damage_qty, "
			+ "coalesce((Select SUM(t_damage.qty*t_damage.value) FROM t_damage WHERE t_damage.date between :fromDate and :toDate "
			+ "and t_damage.del_status=1 AND m_item.item_id=t_damage.item_id),0) AS damage_value, coalesce(0) AS gatepass_qty, "
			+ "coalesce(0) AS gatepass_return_qty FROM m_item where m_item.is_used=1 "),nativeQuery=true)
	List<GetCurrentStock> getCurrentStock(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

	@Query(value=("SELECT "
			+ "m_item.item_id, CONCAT(m_item.item_code, ' ', m_item.item_desc) as item_code, coalesce((Select "
			+ "SUM(t_stock_detail.op_stock_qty) FROM t_stock_detail, t_stock_header where t_stock_header.date=:fromDate "
			+ "AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id AND m_item.item_id=t_stock_detail.item_id), 0) "
			+ "AS opening_stock, coalesce((Select SUM(t_stock_detail.op_stock_value) FROM t_stock_detail, t_stock_header where "
			+ "t_stock_header.date=:fromDate AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) AS op_stock_value, coalesce((Select SUM(t_mrn_detail.approve_qty) FROM "
			+ "t_mrn_detail, t_mrn_header where t_mrn_header.mrn_date between :fromDate and :toDate AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id "
			+ "AND m_item.item_id=t_mrn_detail.item_id and t_mrn_header.del_status=1 and t_mrn_detail.del_status=1), 0) AS approve_qty, "
			+ "coalesce((Select SUM(po_detail.item_rate*t_mrn_detail.approve_qty) FROM t_mrn_detail, t_mrn_header, po_detail where "
			+ "t_mrn_header.mrn_date between :fromDate and :toDate AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id "
			+ "AND m_item.item_id=t_mrn_detail.item_id and t_mrn_header.del_status=1 and t_mrn_detail.del_status=1 "
			+ "and po_detail.po_detail_id=t_mrn_detail.po_detail_id), 0) AS approved_qty_value, coalesce((Select "
			+ "SUM((po_detail.landing_cost/po_detail.item_qty)*t_mrn_detail.approve_qty) FROM t_mrn_detail, t_mrn_header, "
			+ "po_detail where t_mrn_header.mrn_date between :fromDate and :toDate AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id "
			+ "AND m_item.item_id=t_mrn_detail.item_id and t_mrn_header.del_status=1 and t_mrn_detail.del_status=1 "
			+ "and po_detail.po_detail_id=t_mrn_detail.po_detail_id), 0) AS approved_landing_value, coalesce((Select "
			+ "SUM(item_issue_detail.item_issue_qty) FROM item_issue_header, item_issue_detail WHERE item_issue_header.issue_date between"
			+ " :fromDate and :toDate AND item_issue_header.issue_id=item_issue_detail.issue_id AND m_item.item_id=item_issue_detail.item_id "
			+ "and item_issue_header.delete_status=1 and item_issue_detail.del_status=1), 0) AS issue_qty, coalesce((Select "
			+ "SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) FROM item_issue_header, item_issue_detail, t_mrn_detail, po_detail "
			+ "WHERE item_issue_header.issue_date between :fromDate and :toDate AND item_issue_header.issue_id=item_issue_detail.issue_id "
			+ "AND m_item.item_id=item_issue_detail.item_id and item_issue_header.delete_status=1 and item_issue_detail.del_status=1 "
			+ "and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id and po_detail.po_detail_id=t_mrn_detail.po_detail_id), "
			+ "0) AS issue_qty_value, coalesce((Select SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) "
			+ "FROM item_issue_header, item_issue_detail, t_mrn_detail, po_detail WHERE item_issue_header.issue_date between :fromDate and :toDate"
			+ " AND item_issue_header.issue_id=item_issue_detail.issue_id AND m_item.item_id=item_issue_detail.item_id "
			+ "and item_issue_header.delete_status=1 and item_issue_detail.del_status=1 and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id "
			+ "and po_detail.po_detail_id=t_mrn_detail.po_detail_id), 0) AS issue_landing_value, coalesce(0)  AS return_issue_qty, coalesce((Select "
			+ "SUM(t_damage.qty) FROM t_damage  WHERE t_damage.date between :fromDate and :toDate and t_damage.del_status=1 AND m_item.item_id=t_damage.item_id),0) AS damage_qty, "
			+ "coalesce((Select SUM(t_damage.qty*t_damage.value) FROM t_damage WHERE t_damage.date between :fromDate and :toDate "
			+ "and t_damage.del_status=1 AND m_item.item_id=t_damage.item_id),0) AS damage_value, coalesce(0) AS gatepass_qty, "
			+ "coalesce(0) AS gatepass_return_qty FROM m_item where m_item.is_used=1 and m_item.cat_id=:catId"),nativeQuery=true)
	List<GetCurrentStock> getStockBetweenDateWithCatId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("catId") int catId);



}
