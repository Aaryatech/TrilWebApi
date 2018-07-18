package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import com.ats.tril.model.GetPoHeaderList; 

public interface GetPoHeaderListRepository extends JpaRepository<GetPoHeaderList, Integer>{

	
	@Query(value = " select p.*,v.vendor_name from po_header p,m_vendor v where p.po_date between :fromDate and :toDate and del_status=1 and v.vendor_id =p.vend_id", nativeQuery = true)
	List<GetPoHeaderList> getPoHeaderListBetweenDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

	@Query(value = "select p.*,v.vendor_name from po_header p,m_vendor v where po_id=:poId and del_status=1 and v.vendor_id =p.vend_id", nativeQuery = true)
	GetPoHeaderList getPoHeaderAndDetailByHeaderId(@Param("poId")int poId);
	
	

}
