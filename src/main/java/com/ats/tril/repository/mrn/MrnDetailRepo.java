package com.ats.tril.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.tril.model.mrn.MrnDetail;

public interface MrnDetailRepo extends JpaRepository<MrnDetail, Integer> {
	
	MrnDetail save(MrnDetail mrnDetail);

	@Query(value="select count(*) as count from t_mrn_detail where mrn_id=:mrnId and mrn_detail_status=0",nativeQuery=true)
	int getDetailCount(@Param("mrnId")int mrnId);

	
	@Transactional
	@Modifying
	@Query("UPDATE MrnDetail SET del_status=0 WHERE mrn_detail_id=:mrnDetailId ")
	int deleteMrnDetail(@Param("mrnDetailId")int mrnDetailId);

	List<MrnDetail> findByItemIdAndDelStatusAndMrnDetailStatus(int itemId, int i, int j);

	@Query(value="select * from t_mrn_detail where mrn_detail_id in (:mrnDetailList) and del_status=1",nativeQuery=true)
	List<MrnDetail> getMrnDetailListByMrnDetailId(@Param("mrnDetailList")List<Integer> mrnDetailList);

}
