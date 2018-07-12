package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.GetEnquiryHeader;

public interface GetEnquiryHeaderRepository extends JpaRepository<GetEnquiryHeader, Integer>{

	@Query(value=("select h.*,v.vendor_name from enq_header h,m_vendor v where h.del_status=1 and v.vendor_id = h.vend_id"),nativeQuery=true)
	List<GetEnquiryHeader> getEnquiryHeaderList();
	
	@Query(value=("select h.*,v.vendor_name from enq_header h,m_vendor v where h.del_status=1 and v.vendor_id = h.vend_id and enq_id=:enqId"),nativeQuery=true)
	GetEnquiryHeader getEnquiryHeader(@Param("enqId") int enqId);

	@Query(value=("select h.*, v.vendor_name from enq_header h, m_vendor v  where enq_date between :fromDate and :toDate "
			+ "and h.del_status=1 and v.vendor_id = h.vend_id order by  enq_date asc"),nativeQuery=true)
	List<GetEnquiryHeader> getEnquiryHeaderListBetweenDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

}