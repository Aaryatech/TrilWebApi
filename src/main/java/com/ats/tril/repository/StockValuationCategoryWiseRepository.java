package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.StockValuationCategoryWise;

public interface StockValuationCategoryWiseRepository extends JpaRepository<StockValuationCategoryWise, Integer>{

	@Query(value=("SELECT \r\n" + 
			"        m_category.cat_id,\r\n" + 
			"        m_category.cat_desc, \r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_stock_detail.op_stock_qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header,\r\n" + 
			"            m_item\r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:fromDate \r\n" + 
			"            AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS opening_stock,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_stock_detail.op_stock_value) \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header,\r\n" + 
			"            m_item\r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:fromDate \r\n" + 
			"            AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS op_stock_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_mrn_detail.approve_qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            t_mrn_header,\r\n" + 
			"            m_item \r\n" + 
			"        where\r\n" + 
			"            t_mrn_header.mrn_date between :fromDate and :toDate \r\n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id \r\n" + 
			"            AND m_item.item_id=t_mrn_detail.item_id \r\n" + 
			"            and t_mrn_header.del_status=1 \r\n" + 
			"            and t_mrn_detail.del_status=1 and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS approve_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(po_detail.item_rate*t_mrn_detail.approve_qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            t_mrn_header,\r\n" + 
			"            po_detail,\r\n" + 
			"            m_item  \r\n" + 
			"        where\r\n" + 
			"            t_mrn_header.mrn_date between :fromDate and :toDate\r\n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id \r\n" + 
			"            AND m_item.item_id=t_mrn_detail.item_id \r\n" + 
			"            and t_mrn_header.del_status=1 \r\n" + 
			"            and t_mrn_detail.del_status=1 \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS approved_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*t_mrn_detail.approve_qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            t_mrn_header,\r\n" + 
			"            po_detail,\r\n" + 
			"            m_item   \r\n" + 
			"        where\r\n" + 
			"            t_mrn_header.mrn_date between :fromDate and :toDate\r\n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id \r\n" + 
			"            AND m_item.item_id=t_mrn_detail.item_id \r\n" + 
			"            and t_mrn_header.del_status=1 \r\n" + 
			"            and t_mrn_detail.del_status=1 \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS approved_landing_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty) \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            m_item    \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate\r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id \r\n" + 
			"            AND m_item.item_id=item_issue_detail.item_id \r\n" + 
			"            and item_issue_header.delete_status=1 \r\n" + 
			"            and item_issue_detail.del_status=1 and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            m_item    \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id \r\n" + 
			"            AND m_item.item_id=item_issue_detail.item_id \r\n" + 
			"            and item_issue_header.delete_status=1 \r\n" + 
			"            and item_issue_detail.del_status=1 \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            m_item    \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id \r\n" + 
			"            AND m_item.item_id=item_issue_detail.item_id \r\n" + 
			"            and item_issue_header.delete_status=1 \r\n" + 
			"            and item_issue_detail.del_status=1 \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS issue_landing_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_damage.qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_damage,\r\n" + 
			"            m_item     \r\n" + 
			"        WHERE\r\n" + 
			"            t_damage.date between :fromDate and :toDate \r\n" + 
			"            and t_damage.del_status=1 \r\n" + 
			"            AND m_item.item_id=t_damage.item_id and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS damage_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_damage.qty*t_damage.value) \r\n" + 
			"        FROM\r\n" + 
			"            t_damage,\r\n" + 
			"            m_item   \r\n" + 
			"        WHERE\r\n" + 
			"            t_damage.date between :fromDate and :toDate \r\n" + 
			"            and t_damage.del_status=1 \r\n" + 
			"            AND m_item.item_id=t_damage.item_id and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS damage_value  \r\n" + 
			"    FROM\r\n" + 
			"        m_category \r\n" + 
			"    where\r\n" + 
			"        m_category.is_used=1  "),nativeQuery=true)
	List<StockValuationCategoryWise> stockValueationReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

	@Query(value=("SELECT \r\n" + 
			"        m_category.cat_id,\r\n" + 
			"        m_category.cat_desc, \r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_stock_detail.op_stock_qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header,\r\n" + 
			"            m_item\r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:fromDate \r\n" + 
			"            AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS opening_stock,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_stock_detail.op_stock_value) \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header,\r\n" + 
			"            m_item\r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:fromDate \r\n" + 
			"            AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS op_stock_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_mrn_detail.approve_qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            t_mrn_header,\r\n" + 
			"            m_item \r\n" + 
			"        where\r\n" + 
			"            t_mrn_header.mrn_date between :fromDate and :toDate \r\n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id \r\n" + 
			"            AND m_item.item_id=t_mrn_detail.item_id \r\n" + 
			"            and t_mrn_header.del_status=1 \r\n" + 
			"            and t_mrn_detail.del_status=1 and m_item.cat_id=m_category.cat_id and t_mrn_header.mrn_type=:typeId),\r\n" + 
			"        0) AS approve_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(po_detail.item_rate*t_mrn_detail.approve_qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            t_mrn_header,\r\n" + 
			"            po_detail,\r\n" + 
			"            m_item  \r\n" + 
			"        where\r\n" + 
			"            t_mrn_header.mrn_date between :fromDate and :toDate\r\n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id \r\n" + 
			"            AND m_item.item_id=t_mrn_detail.item_id \r\n" + 
			"            and t_mrn_header.del_status=1 \r\n" + 
			"            and t_mrn_detail.del_status=1 \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and m_item.cat_id=m_category.cat_id and t_mrn_header.mrn_type=:typeId),\r\n" + 
			"        0) AS approved_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*t_mrn_detail.approve_qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            t_mrn_header,\r\n" + 
			"            po_detail,\r\n" + 
			"            m_item   \r\n" + 
			"        where\r\n" + 
			"            t_mrn_header.mrn_date between :fromDate and :toDate\r\n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id \r\n" + 
			"            AND m_item.item_id=t_mrn_detail.item_id \r\n" + 
			"            and t_mrn_header.del_status=1 \r\n" + 
			"            and t_mrn_detail.del_status=1 \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and m_item.cat_id=m_category.cat_id and t_mrn_header.mrn_type=:typeId),\r\n" + 
			"        0) AS approved_landing_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty) \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            m_item    \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate\r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id \r\n" + 
			"            AND m_item.item_id=item_issue_detail.item_id \r\n" + 
			"            and item_issue_header.delete_status=1 \r\n" + 
			"            and item_issue_detail.del_status=1 and m_item.cat_id=m_category.cat_id and item_issue_header.item_category=:typeId),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            m_item    \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id \r\n" + 
			"            AND m_item.item_id=item_issue_detail.item_id \r\n" + 
			"            and item_issue_header.delete_status=1 \r\n" + 
			"            and item_issue_detail.del_status=1 \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and m_item.cat_id=m_category.cat_id and item_issue_header.item_category=:typeId),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            m_item    \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id \r\n" + 
			"            AND m_item.item_id=item_issue_detail.item_id \r\n" + 
			"            and item_issue_header.delete_status=1 \r\n" + 
			"            and item_issue_detail.del_status=1 \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and m_item.cat_id=m_category.cat_id and item_issue_header.item_category=:typeId),\r\n" + 
			"        0) AS issue_landing_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_damage.qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_damage,\r\n" + 
			"            m_item     \r\n" + 
			"        WHERE\r\n" + 
			"            t_damage.date between :fromDate and :toDate \r\n" + 
			"            and t_damage.del_status=1 \r\n" + 
			"            AND m_item.item_id=t_damage.item_id and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS damage_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_damage.qty*t_damage.value) \r\n" + 
			"        FROM\r\n" + 
			"            t_damage,\r\n" + 
			"            m_item   \r\n" + 
			"        WHERE\r\n" + 
			"            t_damage.date between :fromDate and :toDate \r\n" + 
			"            and t_damage.del_status=1 \r\n" + 
			"            AND m_item.item_id=t_damage.item_id and m_item.cat_id=m_category.cat_id),\r\n" + 
			"        0) AS damage_value  \r\n" + 
			"    FROM\r\n" + 
			"        m_category \r\n" + 
			"    where\r\n" + 
			"        m_category.is_used=1  "),nativeQuery=true)
	List<StockValuationCategoryWise> stockValueationReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("typeId") int typeId);

}
