package com.ats.tril.repository.doc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.tril.model.doc.SubDocument;
@Repository
public interface SubDocumentRepository extends JpaRepository<SubDocument, Integer>{

	SubDocument findByMIdAndCatIdAndDelStatus(int id, int catId, int i);
	
	SubDocument findByMIdAndCatIdAndDelStatusAndDocId(int id, int catId, int i, int typeId);

	List<SubDocument> findByMIdAndDelStatus(int id, int i);

	@Transactional
	@Modifying
	@Query("UPDATE SubDocument SET printPostfix=:enabled,categoryPostfix=:limitValue WHERE subDocId=:subDocId ")
	int updateEnabledAndDisabled(@Param("subDocId")int subDocId,@Param("enabled") String enabled,@Param("limitValue") String limitValue);
 

}
