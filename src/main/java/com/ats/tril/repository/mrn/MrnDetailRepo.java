package com.ats.tril.repository.mrn;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tril.model.mrn.MrnDetail;

public interface MrnDetailRepo extends JpaRepository<MrnDetail, Integer> {
	
	MrnDetail save(MrnDetail mrnDetail);

}
