package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.tril.model.ConsumptionReportData;

@Repository
public interface ConsumptionReportRepository extends JpaRepository<ConsumptionReportData, Integer>{

	@Query(value="select c.cat_id,c.cat_desc,c.monthly_limit as target,coalesce((select SUM(h.total_value) as value from po_header h where h.del_status=1 and h.po_date between :fromDate and :toDate and h.po_type=:poType and (select cat_id from indent where ind_m_id=h.ind_id limit 1)=c.cat_id),0) as total_value from m_category c where  c.is_used=1 order by cat_id",nativeQuery=true)
	List<ConsumptionReportData> findByPoTypeAndDate(@Param("poType")int poType,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
