package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tril.model.PoHeader;

public interface PoHeaderRepository extends JpaRepository<PoHeader, Integer>{

	
	List<PoHeader> findByVendIdAndDelStatusAndPoStatusIn(int vendId,int delStatus,List<Integer> statusList);
}
