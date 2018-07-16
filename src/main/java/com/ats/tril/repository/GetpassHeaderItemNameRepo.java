package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GetpassHeaderItemNameRepo extends JpaRepository<GetpassHeaderItemName, Integer> {

	@Query(value = "SELECT h.* FROM t_gatepass_header h ,m_item i WHERE gp_id=:gpId ", nativeQuery = true)
	GetpassHeaderItemName getAllHeaderItemByGpId(@Param("gpId") int gpId);

}
