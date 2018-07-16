package com.ats.tril.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.ConsumptionReportData;
import com.ats.tril.model.GetPoHeader;
import com.ats.tril.model.PoHeader;
import com.ats.tril.model.indent.DashIndentDetails;
import com.ats.tril.model.indent.GetIndents;
import com.ats.tril.repository.ConsumptionReportRepository;
import com.ats.tril.repository.GetPoHeaderRepository;
import com.ats.tril.repository.PoHeaderRepository;
import com.ats.tril.repository.indent.GetIndentRepository;
import com.ats.tril.repository.indent.IndentTransRepository;

@RestController
public class DashboardController {

	@Autowired
	GetIndentRepository getIndentRepository;
	
	@Autowired
	IndentTransRepository indentTransRepository;
	
	@Autowired
	GetPoHeaderRepository getPoHeaderRepository;
	
	@Autowired
	ConsumptionReportRepository consumptionReportRepository;
	
	@RequestMapping(value = { "/getIndentList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetIndents> getIndentList(@RequestParam("status") List<Integer> status) {

		List<GetIndents> indentList = new ArrayList<GetIndents>();

		try {
            System.out.println(status);
			indentList = getIndentRepository.getIndentList(status);
			
			for(int i=0;i<indentList.size();i++)
			{System.err.println("indent List " + indentList.get(i).getIndMId()+"status "+status);
				List<DashIndentDetails> dashIndentDetailList =indentTransRepository.findByIndMIdAndIndDStatusIn(indentList.get(i).getIndMId(),status);
				System.err.println("indent List "+dashIndentDetailList.toString());
				indentList.get(i).setDashIndentDetailList(dashIndentDetailList);
			}

			System.err.println("indent List " + indentList.toString());
		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return indentList;

	}
	
	@RequestMapping(value = { "/getPoHeaderDashList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoHeader> getPOHeaderList(@RequestParam("poType") int poType,@RequestParam("status") int status) {

		List<GetPoHeader> poHeaderList = new ArrayList<GetPoHeader>();

		try {

			 
			poHeaderList = getPoHeaderRepository.findByPoTypeAndPoStatusAndDelStatus(poType, status);
				

		} catch (Exception e) {
			
			System.err.println("Exception /getPOHeaderList @PurchaseOrderRestControlle ");

			e.printStackTrace();
			 
		}
		return poHeaderList;

	}
	@RequestMapping(value = { "/getConsumptionData" }, method = RequestMethod.POST)
	public @ResponseBody List<ConsumptionReportData> getConsumptionData(@RequestParam("poType") int poType,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {

		List<ConsumptionReportData> consumptionReportData = new ArrayList<ConsumptionReportData>();

		try {

			 
			consumptionReportData = consumptionReportRepository.findByPoTypeAndDate(poType,fromDate,toDate);
				

		} catch (Exception e) {
			

			e.printStackTrace();
			 
		}
		return consumptionReportData;

	}
	
}
