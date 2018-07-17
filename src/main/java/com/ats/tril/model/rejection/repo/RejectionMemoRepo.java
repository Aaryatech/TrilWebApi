package com.ats.tril.model.rejection.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tril.model.rejection.RejectionMemo;

public interface RejectionMemoRepo extends JpaRepository<RejectionMemo, Integer> {

}
