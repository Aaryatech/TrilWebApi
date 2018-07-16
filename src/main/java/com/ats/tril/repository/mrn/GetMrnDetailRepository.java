package com.ats.tril.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.tril.model.mrn.GetMrnDetail;
@Repository
public interface GetMrnDetailRepository extends JpaRepository<GetMrnDetail, Integer>{

	/*@Query(value="",nativeQuery=true)
	List<GetMrnDetail> getMrnDetailList(@Param("mrnId")int mrnId,@Param("mrnDetailStatus") int mrnDetailStatus);
*/
	
	
	
	List<GetMrnDetail> findByMrnId(int mrnId);
}
