package com.ats.tril.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.Type;
import com.ats.tril.model.yearlyreport.CatWiseAmount;
import com.ats.tril.model.yearlyreport.MrnAndIssueData;
import com.ats.tril.model.yearlyreport.TypeWiseAmount;
import com.ats.tril.model.yearlyreport.YearlyReportMrnAndIssue;
import com.ats.tril.repository.TypeRepository;
import com.ats.tril.repository.doc.DocumentBeanRepository;
import com.ats.tril.repository.yearlyreport.MrnAndIssueDataRepo;

@RestController
public class MrnAndIssueYearlyReportController {

	@Autowired
	MrnAndIssueDataRepo mrnAndIssueDataRepo;

	@Autowired
	DocumentBeanRepository documentBeanRepository;

	@Autowired
	TypeRepository typeRepository;

	@RequestMapping(value = { "/getMrnAndIssueYearlyReport" }, method = RequestMethod.POST)
	public @ResponseBody List<YearlyReportMrnAndIssue> getMrnAndIssueYearlyReport(
			@RequestParam("fromToYear") String fromToYear, @RequestParam("catId") int catId) {

		List<YearlyReportMrnAndIssue> reportList = new ArrayList<YearlyReportMrnAndIssue>();
		try {

			int yearVal = Integer.parseInt(fromToYear);

			String firstDate = documentBeanRepository.getFirstDate(yearVal);
			String lastDate = documentBeanRepository.getLastDate(yearVal);

			System.err.println("----  FROM DATE " + firstDate + "             TO - " + lastDate);
			
			List<MrnAndIssueData> mrnData=new ArrayList<>();
			List<MrnAndIssueData> issueData=new ArrayList<>();
			
			if(catId==-1) {
				
				 mrnData = mrnAndIssueDataRepo.getTotalMRNData(firstDate, lastDate);
				 issueData = mrnAndIssueDataRepo.getTotalIssueData(firstDate, lastDate);
				 
			}else {

				 mrnData = mrnAndIssueDataRepo.getMRNData(firstDate, lastDate, catId);
				 issueData = mrnAndIssueDataRepo.getIssueData(firstDate, lastDate, catId);
				
			}
			

			List<Type> typeList = typeRepository.findAllByDelStatus(1);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar calFrom = Calendar.getInstance();
			Calendar calTo = Calendar.getInstance();

			Date d1 = sdf.parse(firstDate);
			Date d2 = sdf.parse(lastDate);

			calFrom.setTime(d1);
			calTo.setTime(d2);

			while (calFrom.before(calTo)) {

				System.err.println(
						"--------------------------------------------NEW-----------------------------------------------");

				SimpleDateFormat sdfMonthYear = new SimpleDateFormat("MMM-yyyy");

				int month = calFrom.get(Calendar.MONTH) + 1;
				int year = calFrom.get(Calendar.YEAR);

				YearlyReportMrnAndIssue data = new YearlyReportMrnAndIssue();
				data.setMonth(month);
				data.setYear("" + year);
				data.setDateStr(sdfMonthYear.format(calFrom.getTime()));
				System.err.println("MONTH - " + month);

				List<TypeWiseAmount> typeWiseAmtList = new ArrayList<>();

				if (typeList != null) {

					for (int i = 0; i < typeList.size(); i++) {

						TypeWiseAmount type = new TypeWiseAmount();
						type.setTypeId(typeList.get(i).getTypeId());
						type.setTypeName(typeList.get(i).getTypeName());


							if (mrnData != null) {
								for (int j = 0; j < mrnData.size(); j++) {

									MrnAndIssueData mrn = mrnData.get(j);

									if (mrn.getMonth() == month && mrn.getYear().equalsIgnoreCase(String.valueOf(year))
											&& mrn.getTypeId() == typeList.get(i).getTypeId()) {

										type.setCatId(mrn.getCatId());
										type.setMrnAmount(mrn.getAmount());

									} // IF - MRN MATCH

								} // FOR -mrnData

							} // IF -mrnData

							if (issueData != null) {
								for (int j = 0; j < issueData.size(); j++) {

									MrnAndIssueData issue = issueData.get(j);

									if (issue.getMonth() == month
											&& issue.getYear().equalsIgnoreCase(String.valueOf(year))
											&& issue.getTypeId() == typeList.get(i).getTypeId()) {

										type.setCatId(issue.getCatId());
										type.setIssueAmount(issue.getAmount());

									} // IF - MRN MATCH

								} // FOR -mrnData

							} // IF -mrnData


						typeWiseAmtList.add(type);
					} // FOR -typeList

				} // IF -typeList

				data.setTypeWiseAmount(typeWiseAmtList);
				reportList.add(data);

				calFrom.add(Calendar.MONTH, 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reportList;

	}

}
