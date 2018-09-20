package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.IndentValueLimit;

public interface IndentValueLimitRepository extends JpaRepository<IndentValueLimit, Integer>{

	
	@Query(value="select indtrans.item_id,sum(indtrans.ind_qty) as qty, po_detail.item_rate as rate\r\n" + 
			"from indtrans , indent,po_detail \r\n" + 
			"inner join (\r\n" + 
			"  select \r\n" + 
			"    po_detail.item_id, max(po_detail.po_detail_id) as latest \r\n" + 
			"  from po_detail,po_header WHERE po_header.po_id =po_detail.po_id AND po_header.del_status=1   \r\n" + 
			"  group by po_detail.item_id\r\n" + 
			") g\r\n" + 
			"  on (po_detail.po_detail_id = g.latest and po_detail.item_id = g.item_id) \r\n" + 
			" WHERE indtrans.item_id=po_detail.item_id AND indent.ind_m_id=indtrans.ind_m_id and indent.cat_id=:catId AND indent.ind_m_type=:typeId AND indtrans.ind_d_status IN (0,1,2) AND "
			+ " indtrans.ind_m_id = indent.ind_m_id AND indent.ind_m_date BETWEEN :fromDate AND :toDate    GROUP BY indtrans.item_id",nativeQuery=true)
	List<IndentValueLimit> getIndentValueLimit(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("typeId")String typeId,@Param("catId") String catId);

}
