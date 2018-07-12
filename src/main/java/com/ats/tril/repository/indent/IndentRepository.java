package com.ats.tril.repository.indent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.tril.model.indent.Indent;

public interface IndentRepository extends JpaRepository<Indent, Integer> {
	
	Indent save(Indent indent);
	
	@Transactional
	@Modifying
	@Query(" UPDATE Indent  SET achdId=:achdId,deptId=:deptId,subDeptId=:subDeptId,indIsdev=:indIsdev,indIsmonthly=:indIsmonthly "
			+ " WHERE indMId=:indMId ")
		int updateIndentHeader(@Param("achdId") 
		int achdId,@Param("deptId") int deptId,
		@Param("subDeptId") 
		int subDeptId,@Param("indIsdev") int indIsdev,
		@Param("indIsmonthly") 
		int indIsmonthly,@Param("indMId") int indMId);
	
}