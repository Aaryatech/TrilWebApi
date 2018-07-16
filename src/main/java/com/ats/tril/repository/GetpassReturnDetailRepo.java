package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tril.model.GetpassReturnDetail;

public interface GetpassReturnDetailRepo extends JpaRepository<GetpassReturnDetail, Integer> {

	List<GetpassReturnDetail> findByReturnId(int returnId);

}
