package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.POReportDetail;

public interface POReportDetailRepo extends JpaRepository<POReportDetail, Integer> {
	@Query(value = "SELECT * FROM po_detail WHERE po_detail.po_id IN(:poIdList) ", nativeQuery = true)
	List<POReportDetail> getPOReportDetailList(@Param("poIdList") List<Integer> poIdList);

}
