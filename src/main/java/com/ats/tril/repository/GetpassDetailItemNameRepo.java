package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.GetpassDetailItemName;

public interface GetpassDetailItemNameRepo extends JpaRepository<GetpassDetailItemName, Integer> {

	@Query(value = "SELECT h.*, i.item_code, c.cat_id, g.grp_id FROM t_gatepass_detail h , m_item i, m_category c, m_item_group g "
			+ "WHERE i.item_id=h.gp_item_id AND gp_id=:gpId and h.is_used=1 and c.cat_id=i.cat_id and g.grp_id = i.grp_id and h.gp_rem_qty !=0", nativeQuery = true)
	List<GetpassDetailItemName> getAllItemByGpId(@Param("gpId") int gpId);

}
