package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.AprLogBook;

public interface AprLogBookRepo extends JpaRepository<AprLogBook, Integer> {
	// Indent Log Book 1
	@Query(value = " SELECT t_log.doc_tran_id, t_log.log_id,t_log.doc_type,t_log.req_date,t_log.app1_date AS apr_date1,t_log.app2_date AS apr_date2,"
			+ " COALESCE((SELECT m_user.usr_name FROM m_user WHERE m_user.usr_id=t_log.app1_user_id),0) as apr_user1,"
			+ " COALESCE((SELECT m_user.usr_name FROM m_user WHERE m_user.usr_id=t_log.app2_user_id),0) as apr_user2,"
			+ " indent.ind_m_no as doc_no,indent.ind_m_date as doc_date " + " FROM t_log,indent "
			+ " WHERE t_log.doc_tran_id=indent.ind_m_id AND t_log.doc_type=1 AND indent.ind_m_type IN (:typeIdList) AND "
			+ " t_log.req_date BETWEEN :fromDate AND :toDate ", nativeQuery = true)
	List<AprLogBook> getAprLogBookInd(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("typeIdList") List<String> typeIdList);

	// Po Log Book 2
	@Query(value = " SELECT t_log.doc_tran_id, t_log.log_id,t_log.doc_type,t_log.req_date,t_log.app1_date AS apr_date1,"
			+ " t_log.app2_date AS apr_date2, COALESCE((SELECT m_user.usr_name FROM m_user WHERE m_user.usr_id=t_log.app1_user_id),0) "
			+ " as apr_user1, COALESCE((SELECT m_user.usr_name FROM m_user WHERE m_user.usr_id=t_log.app2_user_id),0) as apr_user2, "
			+ " po_header.po_no as doc_no,po_header.po_date as doc_date FROM t_log,po_header "
			+ " WHERE t_log.doc_tran_id=po_header.po_id AND t_log.doc_type=2 AND po_header.po_type"
			+ " IN (:typeIdList) AND t_log.req_date BETWEEN :fromDate AND :toDate ", nativeQuery = true)
	List<AprLogBook> getAprLogBookPO(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("typeIdList") List<String> typeIdList);

	// Mrn Log Book 3

	@Query(value = " SELECT t_log.doc_tran_id, t_log.log_id,t_log.doc_type,t_log.req_date,t_log.app1_date AS apr_date1,t_log.app2_date AS apr_date2, "
			+ " COALESCE((SELECT m_user.usr_name FROM m_user WHERE m_user.usr_id=t_log.app1_user_id),0) as apr_user1,"
			+ " COALESCE((SELECT m_user.usr_name FROM m_user WHERE m_user.usr_id=t_log.app2_user_id),0) as apr_user2,"
			+ " t_mrn_header.mrn_no as doc_no,t_mrn_header.mrn_date as doc_date FROM t_log,t_mrn_header "
			+ " WHERE t_log.doc_tran_id=t_mrn_header.mrn_id AND t_log.doc_type=3 AND t_mrn_header.mrn_type IN "
			+ " (:typeIdList) AND t_log.req_date BETWEEN :fromDate AND :toDate ", nativeQuery = true)
	List<AprLogBook> getAprLogBookMrn(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("typeIdList") List<String> typeIdList);

	// Issue Log Book 4

	@Query(value = " SELECT t_log.doc_tran_id, t_log.log_id,t_log.doc_type,t_log.req_date,t_log.app1_date AS apr_date1,t_log.app2_date AS apr_date2,"
			+ " COALESCE((SELECT m_user.usr_name FROM m_user WHERE m_user.usr_id=t_log.app1_user_id),0) as apr_user1,"
			+ " COALESCE((SELECT m_user.usr_name FROM m_user WHERE m_user.usr_id=t_log.app2_user_id),0) as apr_user2,"
			+ " item_issue_header.issue_no as doc_no,item_issue_header.issue_date as doc_date" + ""
			+ " FROM t_log,item_issue_header "
			+ " WHERE t_log.doc_tran_id=item_issue_header.issue_id AND t_log.doc_type=4 AND item_issue_header.item_category IN (:typeIdList) AND "
			+ " t_log.req_date BETWEEN :fromDate AND :toDate ", nativeQuery = true)
	List<AprLogBook> getAprLogBookIssue(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("typeIdList") List<String> typeIdList);

}
