package com.ats.tril.repository.indent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.IndentReport;
import com.ats.tril.model.report.IndentReportDetail;

public interface IndentReportDetailRepository extends JpaRepository<IndentReportDetail, Integer> {

	@Query(value = "SELECT d.* FROM indtrans d WHERE d.ind_m_id IN(:indentIdList) AND d.del_status=1 ", nativeQuery = true)
	List<IndentReportDetail> getIndentReportDetailList(@Param("indentIdList") List<Integer> indentIdList);

}
