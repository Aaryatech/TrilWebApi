package com.ats.tril.repository.stock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tril.model.StockDetail;

public interface StockDetailRepository extends JpaRepository<StockDetail, Integer>{

	List<StockDetail> findByStockHeaderIdAndDelStatus(int stockId, int i);

}
