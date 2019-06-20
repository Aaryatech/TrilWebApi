package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.CurrentOpeningDetail;

public interface CurrentOpeningDetailRepository extends JpaRepository<CurrentOpeningDetail, Integer>{

	@Query(value=("Select\n" + 
			"            t_stock_detail.item_id,SUM(t_stock_detail.op_stock_qty) as opening_stock,SUM(t_stock_detail.op_stock_value) as op_stock_value  \n" + 
			"        FROM\n" + 
			"            t_stock_detail,\n" + 
			"            t_stock_header \n" + 
			"        where\n" + 
			"            t_stock_header.date=:fromDate \n" + 
			"            AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id \n" + 
			"            group by t_stock_detail.item_id"),nativeQuery=true)
	List<CurrentOpeningDetail> opningDetail(@Param("fromDate") String fromDate);

	@Query(value=(" Select\n" + 
			"        t_stock_detail.item_id,\n" + 
			"        SUM(t_stock_detail.op_stock_qty) as opening_stock,\n" + 
			"        SUM(t_stock_detail.op_stock_value) as op_stock_value           \n" + 
			"    FROM\n" + 
			"        t_stock_detail,\n" + 
			"        t_stock_header,\n" + 
			"        m_item\n" + 
			"    where\n" + 
			"        t_stock_header.date=:fromDate              \n" + 
			"        AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id\n" + 
			"        and m_item.item_id=t_stock_detail.item_id\n" + 
			"        and m_item.cat_id=:catId\n" + 
			"    group by\n" + 
			"        t_stock_detail.item_id"),nativeQuery=true)
	List<CurrentOpeningDetail> opningDetailByCatId(@Param("fromDate")String fromDate,@Param("catId") int catId);

}
