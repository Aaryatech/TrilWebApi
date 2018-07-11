package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tril.model.GetpassHeader;

public interface GetpassHeaderRepo extends JpaRepository<GetpassHeader, Integer> {

	List<GetpassHeader> findAllByIsUsed(int i);

	GetpassHeader findByGpId(int gpId);

}
