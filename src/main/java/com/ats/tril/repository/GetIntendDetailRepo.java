package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.GetIntendDetail;

public interface GetIntendDetailRepo extends JpaRepository<GetIntendDetail, Integer>{

	@Query(value=("Select i.*,CONCAT(m.item_code, '-', m.item_desc) as item_code from indtrans i,m_item m where i.ind_m_id=:indId and i.ind_d_status In(0,1,2) and m.item_id=i.item_id and i.del_status=1"),nativeQuery=true)
	List<GetIntendDetail> findByIndMId(@Param("indId")int indId);

	@Query(value=("select max(po_detail.item_rate) as rate from po_detail, po_header  WHERE po_header.po_id =po_detail.po_id "
			+ "AND po_header.del_status=1 and po_detail.item_id=:itemId "),nativeQuery=true)
	 float getLatestRateofItem(@Param("itemId")int itemId);

	@Query(value=("Select i.*,CONCAT(m.item_code, '-', m.item_desc) as item_code from indtrans i,m_item m where i.ind_m_id in (:indIds) and i.ind_d_status In(0,1,2) and m.item_id=i.item_id and i.del_status=1"),nativeQuery=true)
	List<GetIntendDetail> findByIndMIdIn(@Param("indIds")List<Integer> indIds);


	@Query(value=("select h.ind_m_no from indtrans d,indent h where d.item_id=:itemId and h.ind_m_id=d.ind_m_id and "
			+ "h.del_status=1 and d.ind_d_status in (0,1,2) and d.ind_fyr>0 and d.del_status=1 "),nativeQuery=true)
	List<String> getIndentItemInfo(@Param("itemId") int itemId);

	@Query(value=("select h.po_no from po_detail d,po_header h where d.item_id=:itemId and "
			+ "h.po_id=d.po_id and h.del_status=1 and d.status in (0,1,2) and d.pending_qty>0"),nativeQuery=true)
	List<String> getPoItemInfo(@Param("itemId") int itemId);

}
