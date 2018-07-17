package com.ats.tril.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.tril.model.mrn.GetMrnDetail;
@Repository
public interface GetMrnDetailRepository extends JpaRepository<GetMrnDetail, Integer>{
	
	
	@Query(value="select d.mrn_detail_id,d.mrn_id,d.item_id,i.item_desc as item_name,i.item_code,d.po_id,d.po_no,d.indent_qty,d.po_qty,d.mrn_qty,d.approve_qty,d.reject_qty,d.reject_remark,d.mrn_detail_status,d.batch_no,d.issue_qty,d.remaining_qty,d.del_status  from t_mrn_detail d,m_item i where d.mrn_id=:mrnId and d.del_status=1 and i.item_id=d.item_id and d.mrn_detail_status=:mrnDetailStatus",nativeQuery=true)
	List<GetMrnDetail> getMrnDetailList(@Param("mrnId")int mrnId,@Param("mrnDetailStatus") int mrnDetailStatus);

	List<GetMrnDetail> findByMrnId(int mrnId);
}
