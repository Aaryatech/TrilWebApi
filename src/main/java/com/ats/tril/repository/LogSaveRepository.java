package com.ats.tril.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.tril.model.LogSave;

public interface LogSaveRepository extends JpaRepository<LogSave, Integer>{

	
	@Transactional
	@Modifying
	@Query("UPDATE LogSave SET edit_user_id=:userId,edit_date=:date,edit_date_time=:dateTime WHERE doc_type=:docId and doc_tran_id=:docTranId")
	int updateEditDateAndTime(@Param("docId")int docId,@Param("docTranId") int docTranId,@Param("dateTime") String dateTime,
			@Param("date")String date,@Param("userId") int userId);

	@Transactional
	@Modifying
	@Query("UPDATE LogSave SET del_user_id=:userId,del_date=:date,del_date_time=:dateTime WHERE doc_type=:docId and doc_tran_id=:docTranId")
	int updateDeleteDateAndTime(@Param("docId")int docId,@Param("docTranId") int docTranId,@Param("dateTime") String dateTime,
			@Param("date")String date,@Param("userId") int userId);

	@Transactional
	@Modifying
	@Query("UPDATE LogSave SET app1_user_id=:userId,app1_date=:date,app1_date_time=:dateTime WHERE doc_type=:docId and doc_tran_id=:docTranId")
	int updateAppv1DateAndTime(@Param("docId")int docId,@Param("docTranId") int docTranId,@Param("dateTime") String dateTime,
			@Param("date")String date,@Param("userId") int userId);

	@Transactional
	@Modifying
	@Query("UPDATE LogSave SET app2_user_id=:userId,app2_date=:date,app2_date_time=:dateTime WHERE doc_type=:docId and doc_tran_id=:docTranId")
	int updateAppv2DateAndTime(@Param("docId")int docId,@Param("docTranId") int docTranId,@Param("dateTime") String dateTime,
			@Param("date")String date,@Param("userId") int userId);

	@Transactional
	@Modifying
	@Query("UPDATE LogSave SET insp_user_id=:userId,insp_date=:date,insp_date_time=:dateTime WHERE doc_type=:docId and doc_tran_id=:docTranId")
	int updateInspDateAndTime(@Param("docId")int docId,@Param("docTranId") int docTranId,@Param("dateTime") String dateTime,
			@Param("date")String date,@Param("userId") int userId);

	@Transactional
	@Modifying
	@Query("UPDATE LogSave SET rej1_user_id=:userId,rej1_date=:date,rej1_date_time=:dateTime WHERE doc_type=:docId and doc_tran_id=:docTranId")
	int updateRej1DateAndTime(@Param("docId")int docId,@Param("docTranId") int docTranId,@Param("dateTime") String dateTime,
			@Param("date")String date,@Param("userId") int userId);

	@Transactional
	@Modifying
	@Query("UPDATE LogSave SET rej2_user_id=:userId,rej2_date=:date,rej2_date_time=:dateTime WHERE doc_type=:docId and doc_tran_id=:docTranId")
	int updateRej2DateAndTime(@Param("docId")int docId,@Param("docTranId") int docTranId,@Param("dateTime") String dateTime,
			@Param("date")String date,@Param("userId") int userId);
 

}
