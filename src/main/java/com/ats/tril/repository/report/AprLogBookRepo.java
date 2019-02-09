package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.AprLogBook;

public interface AprLogBookRepo extends JpaRepository<AprLogBook, Integer> {
	
	@Query(value="Select ", nativeQuery=true)
	List<AprLogBook> getAprLogBook(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("docId") int docId, @Param("typeIdList") List<String> typeIdList);

}
