package com.ats.tril.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tril.model.SettingValue;

public interface SettingValueRepository extends JpaRepository<SettingValue, Integer>{

	SettingValue findAllByName(String name);

}
