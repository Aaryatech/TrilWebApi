package com.ats.tril.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.tril.model.mrn.GetMrnHeader;
import com.ats.tril.model.mrn.MrnHeader;

public interface MrnHeaderRepository extends JpaRepository<MrnHeader, Integer>{
	
	MrnHeader save(MrnHeader mrnHeader);

	@Transactional
	@Modifying
	@Query("UPDATE MrnHeader SET mrn_status=2  WHERE mrn_id=:mrnId ")
	int updateMrnStatus(@Param("mrnId") int mrnId);
	
	@Transactional
	@Modifying
	@Query("UPDATE MrnHeader SET mrn_status=1  WHERE mrn_id=:mrnId ")
	int updateMrnStatusAsPartial(@Param("mrnId")int mrnId);

	

	List<MrnHeader> findAllByDelStatus(int i);


}
