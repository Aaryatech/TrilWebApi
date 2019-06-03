package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.IssueReportItemwise;

public interface IssueReportItemwiseRepo extends JpaRepository<IssueReportItemwise, Integer> {

	@Query(value = "select ih.issue_id,ih.issue_no,i.item_code,i.item_desc,ih.item_category,ih.issue_date,ih.dept_id,"
			+ "ih.sub_dept_id,id.item_id,id.item_issue_qty,id.item_request_qty,id.item_pending_qty ,"
			+ "id.status,c.cat_desc,d.dept_desc,sd.sub_dept_desc from item_issue_header ih,"
			+ "item_issue_detail id,m_item i,m_category c,m_dept d,m_sub_dept sd where id.issue_id=ih.issue_id and "
			+ " i.item_id=id.item_id and c.cat_id=i.cat_id  AND d.dept_id=id.dept_id AND sd.sub_dept_id=id.sub_dept_id "
			+ "AND c.cat_id IN(:catIdList) AND id.dept_id =:deptId AND id.sub_dept_id =:subDeptId AND ih.item_category IN(:typeId) AND ih.status=:appStatus"
			+ " AND ih.issue_date BETWEEN :fromDate AND :toDate  "
			+ " GROUP BY id.item_id order by ih.issue_no ", nativeQuery = true)
	List<IssueReportItemwise> getIssueDetailReportList(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("typeId") List<String> typeId, @Param("deptId") int deptId,
			@Param("subDeptId") int subDeptId, @Param("catIdList") List<String> catIdList,
			@Param("appStatus") int appStatus);

	@Query(value = "select ih.issue_id,ih.issue_no,i.item_code,i.item_desc,ih.item_category,ih.issue_date,ih.dept_id,"
			+ "ih.sub_dept_id,id.item_id,id.item_issue_qty,id.item_request_qty,id.item_pending_qty ,"
			+ "id.status,c.cat_desc,d.dept_desc,sd.sub_dept_desc from item_issue_header ih,"
			+ "item_issue_detail id,m_item i,m_category c,m_dept d,m_sub_dept sd where id.issue_id=ih.issue_id and "
			+ " i.item_id=id.item_id and c.cat_id=i.cat_id  AND d.dept_id=id.dept_id AND sd.sub_dept_id=id.sub_dept_id "
			+ "AND c.cat_id IN(:catIdList)   AND ih.item_category IN(:typeId) AND ih.status=:appStatus"
			+ " AND ih.issue_date BETWEEN :fromDate AND :toDate  "
			+ " GROUP BY id.item_id order by ih.issue_no ", nativeQuery = true)
	List<IssueReportItemwise> getIssueDetailReportListDeptAll(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("typeId") List<String> typeId,
			@Param("catIdList") List<String> catIdList, @Param("appStatus") int appStatus);

	@Query(value = "select ih.issue_id,ih.issue_no,i.item_code,i.item_desc,ih.item_category,ih.issue_date,ih.dept_id,"
			+ "ih.sub_dept_id,id.item_id,id.item_issue_qty,id.item_request_qty,id.item_pending_qty ,"
			+ "id.status,c.cat_desc,d.dept_desc,sd.sub_dept_desc from item_issue_header ih,"
			+ "item_issue_detail id,m_item i,m_category c,m_dept d,m_sub_dept sd where id.issue_id=ih.issue_id and "
			+ " i.item_id=id.item_id and c.cat_id=i.cat_id  AND d.dept_id=id.dept_id AND sd.sub_dept_id=id.sub_dept_id "
			+ "AND c.cat_id IN(:catIdList)  AND id.dept_id =:deptId  AND ih.item_category IN(:typeId) AND ih.status=:appStatus"
			+ " AND ih.issue_date BETWEEN :fromDate AND :toDate  "
			+ " GROUP BY id.item_id order by ih.issue_no ", nativeQuery = true)
	List<IssueReportItemwise> getIssueDetailReportListSubDeptAll(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("typeId") List<String> typeId,
			@Param("catIdList") List<String> catIdList, @Param("appStatus") int appStatus, @Param("deptId") int deptId);

	@Query(value = "select ih.issue_id,ih.issue_no,i.item_code,i.item_desc,ih.item_category,ih.issue_date,ih.dept_id,"
			+ "ih.sub_dept_id,id.item_id,id.item_issue_qty,id.item_request_qty,id.item_pending_qty ,"
			+ "id.status,c.cat_desc,d.dept_desc,sd.sub_dept_desc from item_issue_header ih,"
			+ "item_issue_detail id,m_item i,m_category c,m_dept d,m_sub_dept sd where id.issue_id=ih.issue_id and "
			+ " i.item_id=id.item_id and c.cat_id=i.cat_id  AND d.dept_id=id.dept_id AND sd.sub_dept_id=id.sub_dept_id "
			+ "AND c.cat_id IN(:catIdList)  AND id.dept_id =:deptId  AND ih.item_category IN(:typeId)  "
			+ " AND ih.issue_date BETWEEN :fromDate AND :toDate  "
			+ " GROUP BY id.item_id  order by ih.issue_no", nativeQuery = true)
	List<IssueReportItemwise> getIssueDetailReportListStatus(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("typeId") List<String> typeId,
			@Param("catIdList") List<String> catIdList, @Param("deptId") int deptId);

	@Query(value = "select ih.issue_id,ih.issue_no,i.item_code,i.item_desc,ih.item_category,ih.issue_date,ih.dept_id,"
			+ "ih.sub_dept_id,id.item_id,id.item_issue_qty,id.item_request_qty,id.item_pending_qty ,"
			+ "id.status,c.cat_desc,d.dept_desc,sd.sub_dept_desc from item_issue_header ih,"
			+ "item_issue_detail id,m_item i,m_category c,m_dept d,m_sub_dept sd where id.issue_id=ih.issue_id and "
			+ " i.item_id=id.item_id and c.cat_id=i.cat_id  AND d.dept_id=id.dept_id AND sd.sub_dept_id=id.sub_dept_id "
			+ "AND c.cat_id IN(:catIdList)   AND ih.item_category IN(:typeId)  "
			+ " AND ih.issue_date BETWEEN :fromDate AND :toDate  "
			+ " GROUP BY id.item_id order by ih.issue_no ", nativeQuery = true)
	List<IssueReportItemwise> getIssueDetailReportListStatusAndDept(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("typeId") List<String> typeId,
			@Param("catIdList") List<String> catIdList);

}
