package com.ats.tril.repository.mrn;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tril.model.mrn.MrnHeader;

public interface MrnHeaderRepository extends JpaRepository<MrnHeader, Integer>{
	
	MrnHeader save(MrnHeader mrnHeader);

}
