package com.ats.tril.repository.indent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.tril.model.indent.IndentReport;

public interface IndentReportRepository extends JpaRepository<IndentReport, Integer> {
	@Query(value = "SELECT indent.ind_m_id,indent.ind_m_no,indent.ind_m_date,indent.cat_id,indent.ind_isdev,indent.ind_ismonthly,"
			+ "indent.ind_m_type,indent.achd_id ,indent.dept_id,indent.sub_dept_id, DATEDIFF(CURDATE(),indent.ind_m_date) as "
			+ "no_of_days ,  m_category.cat_desc,indent.ind_m_status FROM indent,m_category WHERE indent.del_status=1 AND indent.ind_m_date BETWEEN "
			+ ":fromDate AND :toDate AND indent.cat_id=m_category.cat_id AND indent.cat_id IN (:catIdList) ", nativeQuery = true)
	List<IndentReport> getIndentReportList(@Param("catIdList") List<Integer> catIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT indent.ind_m_id,indent.ind_m_no,indent.ind_m_date,indent.cat_id,indent.ind_isdev,indent.ind_ismonthly,"
			+ "indent.ind_m_type,indent.achd_id ,indent.dept_id,indent.sub_dept_id, DATEDIFF(CURDATE(),indent.ind_m_date) as "
			+ "no_of_days ,  m_category.cat_desc,indent.ind_m_status FROM indent,m_category WHERE indent.del_status=1 AND indent.ind_m_date BETWEEN "
			+ ":fromDate AND :toDate AND indent.cat_id=m_category.cat_id  ", nativeQuery = true)
	List<IndentReport> getAllIndentReportList(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
