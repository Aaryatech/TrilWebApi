package com.ats.tril.repository.indent;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.tril.model.indent.GetIndentByStatus;
import com.ats.tril.model.indent.IndentTrans;

public interface IndentTransRepo extends JpaRepository<IndentTrans, Integer> {
	
	IndentTrans save(IndentTrans indentTrans);
	
	List<IndentTrans> findByIndDStatus(int indDStatus);
	
	List<IndentTrans> findByIndMIdAndDelStatus(int indMId,int delStatus);
	
	@Transactional
	@Modifying
	@Query(" UPDATE IndentTrans  SET indQty=:indQty , indFyr=:indQty ,indItemSchd=:schDay , indItemSchddt=:schDate, indRemark=:remark WHERE indDId=:indDId ")
		int updateIndentDetail(@Param("indQty") 
		float indQty,@Param("indDId") int indDId,@Param("schDay")int schDay, @Param("schDate")Date schDate,@Param("remark")String remark);
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE IndentTrans  SET delStatus=:delStatus"
			+ " WHERE indDId=:indDId ")
		int delteIndentDetail(@Param("delStatus") 
		int delStatus,@Param("indDId") int indDId);

	List<IndentTrans> findByItemIdAndDelStatus(int itemId, int i);

	//List<IndentTrans> findByIndMId(int indId);
	
}
