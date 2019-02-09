package com.ats.tril.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.report.AprLogBook;
import com.ats.tril.model.report.PoStatusReportDetail;
import com.ats.tril.model.report.PoStatusReportHeader;
import com.ats.tril.repository.newreport.PoStatusReportDetailRepo;
import com.ats.tril.repository.newreport.PoStatusReportHeaderRepo;
import com.ats.tril.repository.report.AprLogBookRepo;

@RestController
public class NewReportControllerApi {

	@Autowired
	PoStatusReportHeaderRepo getPoStatusReportHeaderRepo;

	@RequestMapping(value = { "/getPoStatusReportHeader" }, method = RequestMethod.POST)
	public @ResponseBody List<PoStatusReportHeader> stockValueationReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("typeId") int typeId,
			@RequestParam("catId") int catId) {

		List<PoStatusReportHeader> finalList = new ArrayList<PoStatusReportHeader>();

		try {

			if (typeId != 0) {
				finalList = getPoStatusReportHeaderRepo.getPoStatusReportHeader(fromDate, toDate, typeId, catId);
			} else {
				finalList = getPoStatusReportHeaderRepo.stockValueationReportAllType(fromDate, toDate, catId);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}

	@Autowired
	PoStatusReportDetailRepo getPoStatusReportDetailRepo;

	@RequestMapping(value = { "/getPoStatusReportDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<PoStatusReportDetail> getPoStatusReportDetail(
			@RequestParam("poDetailId") int poDetailId) {
		List<PoStatusReportDetail> finalList = new ArrayList<PoStatusReportDetail>();

		try {
			finalList = getPoStatusReportDetailRepo.getPoStatusReportDetail(poDetailId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalList;
	}

	@Autowired
	AprLogBookRepo getAprLogBookRepo;

	@RequestMapping(value = { "/getAprLogBook" }, method = RequestMethod.POST)
	public @ResponseBody List<AprLogBook> getAprLogBook(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("typeIdList") List<String> typeIdList,
			@RequestParam("docId") int docId) {

		List<AprLogBook> finalList = new ArrayList<AprLogBook>();

		try {
			finalList = getAprLogBookRepo.getAprLogBook(fromDate, toDate, docId, typeIdList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}

}
