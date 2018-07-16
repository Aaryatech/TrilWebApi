package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.tril.model.PoDetail;

public interface PoDetailRepository extends JpaRepository<PoDetail, Integer>{
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE PoDetail  SET pendingQty=:pendingQty,status=:status "
			+ " WHERE poDetailId=:poDetailId ")
	int updateResponse(@Param("pendingQty") int pendingQty,@Param("status") int status,@Param("poDetailId") int poDetailId);
	

	List<PoDetail> findAllByStatusNotAndPoId(int status,int poId);

	
}
