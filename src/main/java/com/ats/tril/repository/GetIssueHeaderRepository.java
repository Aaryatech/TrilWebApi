package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.GetIssueHeader;

public interface GetIssueHeaderRepository extends JpaRepository<GetIssueHeader, Integer>{

	@Query(value=("select * from item_issue_header where delete_status = 1  and issue_date between :fromDate and :toDate"),nativeQuery=true)
	List<GetIssueHeader> findByDeleteStatus(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value=("select * from item_issue_header where delete_status = 1 and issue_id =:issueId"),nativeQuery=true)
	GetIssueHeader findByIssueId(@Param("issueId") int issueId);

}
