package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tril.model.GetpassDetail;

public interface GetpassDetailRepo extends JpaRepository<GetpassDetail, Integer> {

	List<GetpassDetail> findByGpId(int gpId);

}
