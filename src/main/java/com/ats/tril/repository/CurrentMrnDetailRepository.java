package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.CurrentMrnDetail;

public interface CurrentMrnDetailRepository extends JpaRepository<CurrentMrnDetail, Integer>{

	@Query(value=("Select\n" + 
			"            t_mrn_detail.item_id,SUM(t_mrn_detail.approve_qty) as approve_qty,SUM(po_detail.item_rate*t_mrn_detail.approve_qty) as approved_landing_value,SUM((po_detail.landing_cost/po_detail.item_qty)*t_mrn_detail.approve_qty)  as approved_qty_value\n" + 
			"        FROM\n" + 
			"            t_mrn_detail,\n" + 
			"            t_mrn_header,\n" + 
			"            po_detail\n" + 
			"        where\n" + 
			"            t_mrn_header.mrn_date between :fromDate and :toDate \n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id  \n" + 
			"            and t_mrn_header.del_status=1 \n" + 
			"            and t_mrn_detail.del_status=1\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \n" + 
			"            AND t_mrn_detail.mrn_detail_status = 4\n" + 
			"    group by t_mrn_detail.item_id"),nativeQuery=true)
	List<CurrentMrnDetail> mrnDetail(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value=("Select\n" + 
			"            t_mrn_detail.item_id,SUM(t_mrn_detail.approve_qty) as approve_qty,SUM(po_detail.item_rate*t_mrn_detail.approve_qty) as approved_landing_value,SUM((po_detail.landing_cost/po_detail.item_qty)*t_mrn_detail.approve_qty)  as approved_qty_value\n" + 
			"        FROM\n" + 
			"            t_mrn_detail,\n" + 
			"            t_mrn_header,\n" + 
			"            po_detail,m_item\n" + 
			"        where\n" + 
			"            t_mrn_header.mrn_date between :fromDate and :toDate \n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id  \n" + 
			"            and t_mrn_header.del_status=1 \n" + 
			"            and t_mrn_detail.del_status=1\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \n" + 
			"            AND t_mrn_detail.mrn_detail_status = 4"
			+ "          and m_item.item_id=t_mrn_detail.item_id and  m_item.cat_id=:catId\n" + 
			"    group by t_mrn_detail.item_id"),nativeQuery=true)
	List<CurrentMrnDetail> mrnDetailByCatId(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("catId") int catId);

	@Query(value=("Select\n" + 
			"            t_mrn_detail.item_id,SUM(t_mrn_detail.approve_qty) as approve_qty,SUM(po_detail.item_rate*t_mrn_detail.approve_qty) as approved_landing_value,SUM((po_detail.landing_cost/po_detail.item_qty)*t_mrn_detail.approve_qty)  as approved_qty_value\n" + 
			"        FROM\n" + 
			"            t_mrn_detail,\n" + 
			"            t_mrn_header,\n" + 
			"            po_detail,m_item\n" + 
			"        where\n" + 
			"            t_mrn_header.mrn_date between :fromDate and :toDate \n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id  \n" + 
			"            and t_mrn_header.del_status=1 \n" + 
			"            and t_mrn_detail.del_status=1\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \n" + 
			"            AND t_mrn_detail.mrn_detail_status = 4 and t_mrn_header.mrn_type=:typeId"
			+ "          and m_item.item_id=t_mrn_detail.item_id and  m_item.cat_id=:catId\n" + 
			"    group by t_mrn_detail.item_id"),nativeQuery=true)
	List<CurrentMrnDetail> mrnDetailByCatIdAndTypeId(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("catId") int catId,@Param("typeId") int typeId);

}
