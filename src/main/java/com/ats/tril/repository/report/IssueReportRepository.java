package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.IssueReport;

public interface IssueReportRepository extends JpaRepository<IssueReport, Integer> {

	@Query(value = "SELECT d.issue_detail_id ,h.*,d.item_group_id,d.dept_id,d.sub_dept_id,d. acc_head,d.item_id,d.item_issue_qty ,"
			+ "d.item_request_qty,d.item_pending_qty,i.item_code,i.item_desc ,dp.dept_desc,sd.sub_dept_desc,a.acc_head_desc "
			+ "FROM item_issue_header h,item_issue_detail d ,m_item i ,m_dept dp,m_sub_dept sd,m_account_head a WHERE  "
			+ "h.issue_id IN(:issueIdList) AND d.issue_id=h.issue_id AND i.item_id=d.item_id AND dp.dept_id=d.dept_id AND "
			+ "sd.sub_dept_id=d.sub_dept_id AND a.acc_head_id=d. acc_head ", nativeQuery = true)
	List<IssueReport> getIssueReportList(@Param("issueIdList") List<Integer> issueIdList);

}
