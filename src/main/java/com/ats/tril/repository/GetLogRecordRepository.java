package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.GetLogRecord;

public interface GetLogRecordRepository extends JpaRepository<GetLogRecord, Integer>{

	
	@Query(value = "select l.log_id,l.doc_type,l.doc_tran_id,l.req_user_id,l.req_date,l.req_date_time,u.usr_name,\n" + 
			"CASE WHEN l.edit_user_id!=0 THEN (select usr_name from m_user where l.edit_user_id=usr_id) ELSE \"-\" END AS edit_user_name,l.edit_user_id,l.edit_date,l.edit_date_time,\n" + 
			"CASE WHEN l.del_user_id!=0 THEN (select usr_name from m_user where l.del_user_id=usr_id) ELSE \"-\" END AS delete_user_name,l.del_user_id,l.del_date,l.del_date_time,\n" + 
			"CASE WHEN l.app1_user_id!=0 THEN (select usr_name from m_user where l.app1_user_id=usr_id) ELSE \"-\" END AS app1_user_name,l.app1_user_id,l.app1_date,l.app1_date_time,\n" + 
			"CASE WHEN l.app2_user_id!=0 THEN (select usr_name from m_user where l.app2_user_id=usr_id) ELSE \"-\" END AS app2_user_name,l.app2_user_id,l.app2_date,l.app2_date_time,\n" + 
			"CASE WHEN l.insp_user_id!=0 THEN (select usr_name from m_user where l.insp_user_id=usr_id) ELSE \"-\" END AS insp_user_name,l.insp_user_id,l.insp_date,l.insp_date_time,\n" + 
			"CASE WHEN l.rej1_user_id!=0 THEN (select usr_name from m_user where l.rej1_user_id=usr_id) ELSE \"-\" END AS rej1_user_name,l.rej1_user_id,l.rej1_date,l.rej1_date_time,\n" + 
			"CASE WHEN l.rej2_user_id!=0 THEN (select usr_name from m_user where l.rej2_user_id=usr_id) ELSE \"-\" END AS rej2_user_name,l.rej2_user_id,l.rej2_date,l.rej2_date_time,\n" + 
			"extra1,extra2,extra_var1,extra_var2\n" + 
			"from t_log l,m_user u where u.usr_id=l.req_user_id and l.doc_tran_id in (:docTranId) and l.doc_type=:docId", nativeQuery = true)
	List<GetLogRecord> getLogsRecordBydocTypeAndTranIds(@Param("docId") int docId,@Param("docTranId") List<Integer> docTranId);

}
