package com.ats.tril.repository.doc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.tril.model.doc.DocumentBean;

@Repository
public interface DocumentBeanRepository extends JpaRepository<DocumentBean, Integer>{

	@Query(value="Select * from m_doc where from_date <=:date And to_date >=:date and doc_id=:docId and del_status=0",nativeQuery=true)
	 DocumentBean findByDocIdAndDate(@Param("docId") int docId,@Param("date") String date);

}