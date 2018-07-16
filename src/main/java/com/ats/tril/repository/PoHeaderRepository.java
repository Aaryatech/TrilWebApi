package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.tril.model.PoHeader;

public interface PoHeaderRepository extends JpaRepository<PoHeader, Integer>{

	
	List<PoHeader> findByVendIdAndDelStatusAndPoStatusIn(int vendId,int delStatus,List<Integer> statusList);

	List<PoHeader> findByPoTypeAndPoStatusAndDelStatus(int poType, int status, int i);
	
	@Transactional
	@Modifying
	@Query(" UPDATE PoHeader  SET poStatus=:poStatus "
			+ " WHERE poId=:poId ")
	int updateResponsePoHead(@Param("poStatus") int poStatus,@Param("poId") int poId); 
	
	
	
}
