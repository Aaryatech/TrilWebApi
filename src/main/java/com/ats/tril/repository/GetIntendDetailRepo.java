package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.GetIntendDetail;

public interface GetIntendDetailRepo extends JpaRepository<GetIntendDetail, Integer>{

	@Query(value=("Select i.*,m.item_code from indtrans i,m_item m where i.ind_m_id=:indId and m.item_id=i.item_id"),nativeQuery=true)
	List<GetIntendDetail> findByIndMId(@Param("indId")int indId);

}