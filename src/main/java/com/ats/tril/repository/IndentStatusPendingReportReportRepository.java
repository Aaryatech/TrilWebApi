package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.IndentStatusPendingReport;

public interface IndentStatusPendingReportReportRepository extends JpaRepository<IndentStatusPendingReport, Integer>{

	@Query(value = "select\n" + 
			"        @a\\:=@a+1 sr,\n" + 
			"        id.ind_d_id,\n" + 
			"        i.ind_m_no,\n" + 
			"        i.ind_m_date,\n" + 
			"        id.item_id,\n" + 
			"        concat(m.item_code,\n" + 
			"        ' ',\n" + 
			"        m.item_desc) as item_code,\n" + 
			"        id.ind_item_schddt,\n" + 
			"        coalesce(' ') as remark ,\n" + 
			"        DATEDIFF(:fromDate,\n" + 
			"        id.ind_item_schddt) AS excess_days,\n" + 
			"        id.ind_qty,\n" + 
			"        m.item_cl_rate as rate,id.ind_fyr as bal_qty\n" + 
			"    from\n" + 
			"        indent i,\n" + 
			"        indtrans id,\n" + 
			"        m_item m ,\n" + 
			"        (SELECT\n" + 
			"            @a\\:=:index) AS a \n" + 
			"    where\n" + 
			"        id.ind_m_id=i.ind_m_id \n" + 
			"        and m.item_id=id.item_id \n" + 
			"        and i.del_status=1 \n" + 
			"        and id.del_status=1 \n" + 
			"        and id.ind_d_status in (\n" + 
			"            :detailStatus\n" + 
			"        )and i.ind_m_status in (\n" + 
			"            :headerStatus\n" + 
			"        )and i.ind_m_type=:typeId and i.cat_id=:catId \n" + 
			"        and i.ind_m_date between :fromDate and :toDate", nativeQuery = true)
	List<IndentStatusPendingReport> indentPendig(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("index") int index, 
			@Param("detailStatus")List<Integer> detailStatus, @Param("headerStatus") List<Integer> headerStatus,@Param("typeId") int typeId,
			@Param("catId")int catId);
	
	

}
