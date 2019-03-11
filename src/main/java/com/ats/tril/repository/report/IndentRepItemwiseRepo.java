package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.IndentRepItemwise;

public interface IndentRepItemwiseRepo extends JpaRepository<IndentRepItemwise, Integer> {

	@Query(value = "SELECT indtrans.ind_d_id,indtrans.ind_item_schddt,indtrans.item_id,i.item_code,indtrans.ind_qty,"
			+ "indtrans.ind_item_desc, indent.ind_m_id,indent.Ind_m_no,indent.ind_m_date,indent.ind_m_type,"
			+ " m_category.cat_desc,indtrans.ind_d_status ,DATEDIFF(CURDATE(),indtrans.ind_item_schddt) as "
			+ "excess_days ,indtrans.ind_remark FROM indent,m_category ,indtrans,m_item i WHERE  indent.cat_id=m_category.cat_id AND  "
			+ "indtrans.ind_m_id=indent.ind_m_id AND  indtrans.ind_d_status IN  (:statusList) AND indent.cat_id IN(:catIdList) "
			+ "AND indent.ind_m_date BETWEEN :fromDate AND :toDate AND indent.ind_m_type IN(:typeIdList) AND i.item_id=indtrans.item_id", nativeQuery = true)
	List<IndentRepItemwise> getIndentReportItemwise(@Param("catIdList") List<String> catIdList,
			@Param("statusList") List<String> statusList, @Param("typeIdList") List<String> typeIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	@Query(value = "SELECT indtrans.ind_d_id,indtrans.ind_item_schddt,indtrans.item_id,i.item_code,indtrans.ind_qty,"
			+ "indtrans.ind_item_desc, indent.ind_m_id,indent.Ind_m_no,indent.ind_m_date,indent.ind_m_type,"
			+ " m_category.cat_desc,indtrans.ind_d_status ,DATEDIFF(CURDATE(),indtrans.ind_item_schddt) as "
			+ "excess_days ,indtrans.ind_remark FROM indent,m_category ,indtrans,m_item i WHERE  indent.cat_id=m_category.cat_id AND  "
			+ "indtrans.ind_m_id=indent.ind_m_id   AND indent.cat_id IN(:catIdList) "
			+ "AND indent.ind_m_date BETWEEN :fromDate AND :toDate AND ind_m_type IN(:typeIdList)", nativeQuery = true)
	List<IndentRepItemwise> getIndentReportItemwiseByStatus(@Param("catIdList") List<String> catIdList,
		  @Param("typeIdList") List<String> typeIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
