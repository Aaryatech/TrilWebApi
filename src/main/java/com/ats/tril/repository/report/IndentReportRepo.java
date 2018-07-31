package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.IndentReport;

public interface IndentReportRepo extends JpaRepository<IndentReport, Integer> {

	@Query(value = "SELECT d.ind_d_id,  h.*,d.item_id,d.ind_item_uom,d.ind_item_desc,d.ind_item_curstk,d.ind_item_schd,"
			+ "d. ind_item_schddt,d.ind_qty,c.cat_desc,a.acc_head_desc,p.dept_desc,s.sub_dept_desc  FROM indent h,indtrans d"
			+ ",m_category c,m_account_head a,m_dept p ,m_sub_dept  s WHERE h.del_status=1 AND h.ind_m_id IN(:indentIdList) "
			+ "AND h.ind_m_id=d.ind_m_id AND h.cat_id=c.cat_id AND a.acc_head_id=h.achd_id AND h.dept_id=p.dept_id AND "
			+ "h.sub_dept_id=s.sub_dept_id GROUP BY d.ind_d_id ", nativeQuery = true)
	List<IndentReport> getIndentReportList(@Param("indentIdList") List<Integer> indentIdList);
}
