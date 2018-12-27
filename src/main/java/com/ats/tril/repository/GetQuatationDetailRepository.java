package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import com.ats.tril.model.GetQuatationDetail; 

public interface GetQuatationDetailRepository extends JpaRepository<GetQuatationDetail, Integer>{

	@Query(value=(" select d.enq_detail_id,d.enq_id,d.enq_detail_date,d.ind_id,d.vend_id,d.item_id,d.enq_qty,i.item_uom as enq_uom,d.enq_item_desc,d.enq_remark,d.ind_no,d.del_status,CONCAT(i.item_code, '-', i.item_desc) "
			+ "as item_code from t_quotation_detail d,m_item i  where d.del_status=1 and d.enq_id=:enqId and i.item_id=d.item_id"),nativeQuery=true)
	List<GetQuatationDetail> getQuatationDetail(@Param("enqId")int enqId);
}
