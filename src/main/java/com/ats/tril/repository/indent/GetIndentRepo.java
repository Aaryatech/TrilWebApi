package com.ats.tril.repository.indent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.tril.model.indent.GetIndent;
import com.ats.tril.model.indent.IndentReport;

@Repository
public interface GetIndentRepo extends JpaRepository<GetIndent, Integer> {

	@Query(value = " SELECT indent.ind_m_id,indent.ind_m_no,indent.ind_m_date,indent.ind_isdev,indent.ind_ismonthly,indent.ind_m_type,indent.achd_id ,"
			+ "indent.dept_id,indent.sub_dept_id, "
			+ " m_category.cat_desc,indent.ind_m_status FROM indent,m_category WHERE indent.ind_m_date BETWEEN :fromDate AND :toDate "
			+ " AND indent.cat_id=m_category.cat_id AND indent.ind_m_status IN (:status) ", nativeQuery = true)

	List<GetIndent> getIndent(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("status") List<String> status);

}
