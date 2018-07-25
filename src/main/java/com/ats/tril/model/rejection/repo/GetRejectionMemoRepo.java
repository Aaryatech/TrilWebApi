package com.ats.tril.model.rejection.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.rejection.GetRejectionMemo;

public interface GetRejectionMemoRepo extends JpaRepository<GetRejectionMemo, Integer> {

	@Query(value = "SELECT t.*,v.vendor_name FROM t_rejection_memo t,m_vendor v WHERE v.vendor_id=t.vendor_id AND t.rejection_date BETWEEN  :fromDate AND :toDate  AND t.is_used=1"
			+ " ", nativeQuery = true)
	List<GetRejectionMemo> getRejectionMemoByDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	@Query(value = "SELECT t.*,v.vendor_name FROM t_rejection_memo t,m_vendor v WHERE v.vendor_id=t.vendor_id AND t.rejection_id=:rejectionId  AND t.is_used=1"
			+ " ", nativeQuery = true)
	GetRejectionMemo getRejectionMemoById(@Param("rejectionId") int rejectionId);


}
