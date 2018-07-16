package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.GetpassDetailItemName;

public interface GetpassDetailItemNameRepo extends JpaRepository<GetpassDetailItemName, Integer> {

	@Query(value = "SELECT h.*,i.item_code FROM t_gatepass_detail h ,m_item i WHERE i.item_id=h.gp_item_id AND gp_id=:gpId ", nativeQuery = true)
	List<GetpassDetailItemName> getAllItemByGpId(@Param("gpId") int gpId);

}
