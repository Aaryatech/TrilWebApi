package com.ats.tril.repository.mrn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.mrn.MrnDetail;

public interface MrnDetailRepo extends JpaRepository<MrnDetail, Integer> {
	
	MrnDetail save(MrnDetail mrnDetail);

	@Query(value="select count(*) as count from t_mrn_detail where mrn_id=:mrnId and mrn_detail_status=0",nativeQuery=true)
	int getDetailCount(@Param("mrnId")int mrnId);

}
