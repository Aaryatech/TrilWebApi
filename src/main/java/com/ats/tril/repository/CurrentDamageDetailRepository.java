package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.CurrentDamageDetail;

public interface CurrentDamageDetailRepository extends JpaRepository<CurrentDamageDetail, Integer>{

	@Query(value=("Select\n" + 
			"            t_damage.item_id,SUM(t_damage.qty) AS damage_qty , SUM(t_damage.qty*t_damage.value) as damage_value \n" + 
			"        FROM\n" + 
			"            t_damage  \n" + 
			"        WHERE\n" + 
			"            t_damage.date between :fromDate and :toDate  \n" + 
			"            and t_damage.del_status=1 \n" + 
			"        group by t_damage.item_id"),nativeQuery=true)
	List<CurrentDamageDetail> damageDetail(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value=("Select\n" + 
			"            t_damage.item_id,SUM(t_damage.qty) AS damage_qty , SUM(t_damage.qty*t_damage.value) as damage_value \n" + 
			"        FROM\n" + 
			"            t_damage,m_item  \n" + 
			"        WHERE\n" + 
			"            t_damage.date between :fromDate and :toDate  \n" + 
			"            and t_damage.del_status=1 and m_item.item_id=t_damage.item_id and  m_item.cat_id=:catId\n" + 
			"        group by t_damage.item_id"),nativeQuery=true)
	List<CurrentDamageDetail> damageDetailByCatId(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("catId") int catId);

}
