package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.GetIntendDetail;

public interface GetIntendDetailRepo extends JpaRepository<GetIntendDetail, Integer>{

	@Query(value=("Select i.*,CONCAT(m.item_code, '-', m.item_desc) as item_code from indtrans i,m_item m where i.ind_m_id=:indId and i.ind_d_status In(0,1,2) and m.item_id=i.item_id and i.del_status=1"),nativeQuery=true)
	List<GetIntendDetail> findByIndMId(@Param("indId")int indId);

}
