package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.GetItem;

public interface GetItemRepository extends JpaRepository<GetItem, Integer>{

	@Query(value = " select * from m_item where is_used=1 ", nativeQuery = true)
	List<GetItem> getAllItems();

	@Query(value = " select * from m_item where item_id=:itemId ", nativeQuery = true)
	GetItem getItemByItemId(@Param("itemId") int itemId);

}
