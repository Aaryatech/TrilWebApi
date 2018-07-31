package com.ats.tril.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.report.IndentReport;
import com.ats.tril.model.report.MrnReport;
import com.ats.tril.model.report.POReport;
import com.ats.tril.repository.report.IndentReportRepo;
import com.ats.tril.repository.report.MrnReportrepo;
import com.ats.tril.repository.report.POReportRepository;

@RestController
public class ReportApiController {

	@Autowired
	IndentReportRepo indentReportRepo;

	@Autowired
	POReportRepository pOReportRepository;

	@Autowired
	MrnReportrepo mrnReportrepo;

	@RequestMapping(value = { "/getIndentListHeaderDetailReport" }, method = RequestMethod.POST)
	public @ResponseBody List<IndentReport> getIndentListHeaderDetailReport(

			@RequestParam("indentIdList") List<Integer> indentIdList) {

		List<IndentReport> indentList = new ArrayList<IndentReport>();

		try {

			indentList = indentReportRepo.getIndentReportList(indentIdList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return indentList;

	}

	@RequestMapping(value = { "/getPoListHeaderDetailReport" }, method = RequestMethod.POST)
	public @ResponseBody List<POReport> getPoListHeaderDetailReport(

			@RequestParam("poIdList") List<Integer> poIdList) {

		List<POReport> poList = new ArrayList<POReport>();

		try {

			poList = pOReportRepository.getPOReportList(poIdList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return poList;

	}

	@RequestMapping(value = { "/getMrnListHeaderDetailReport" }, method = RequestMethod.POST)
	public @ResponseBody List<MrnReport> getMrnListHeaderDetailReport(

			@RequestParam("mrnIdList") List<Integer> mrnIdList) {

		List<MrnReport> mrnList = new ArrayList<MrnReport>();

		try {

			mrnList = mrnReportrepo.getMrnReportList(mrnIdList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return mrnList;

	}

}
