package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.IssueReport;

public interface IssueReportRepository extends JpaRepository<IssueReport, Integer> {

	@Query(value = "SELECT * FROM item_issue_header WHERE item_issue_header.issue_id IN(:issueIdList) AND delete_status=1 ", nativeQuery = true)
	List<IssueReport> getIssueReportList(@Param("issueIdList") List<Integer> issueIdList);

}
