package com.ats.tril.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tril.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

	Company findByComId(int i);

}
