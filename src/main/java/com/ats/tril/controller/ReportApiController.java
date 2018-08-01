package com.ats.tril.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.GetpassDetail;
import com.ats.tril.model.GetpassHeader;
import com.ats.tril.model.rejection.RejectionReport;
import com.ats.tril.model.report.ApproveStatusMrnReport;
import com.ats.tril.model.report.IndentReport;
import com.ats.tril.model.report.IndentReportDetail;
import com.ats.tril.model.report.IssueReport;
import com.ats.tril.model.report.MrnReport;
import com.ats.tril.model.report.POReport;
import com.ats.tril.repository.indent.IndentReportDetailRepository;
import com.ats.tril.repository.report.ApproveStatusMrnReportRepo;
import com.ats.tril.repository.report.IndentReportRepo;
import com.ats.tril.repository.report.IssueReportRepository;
import com.ats.tril.repository.report.MrnReportrepo;
import com.ats.tril.repository.report.POReportRepository;
import com.ats.tril.repository.report.RejectionReportRepository;

@RestController
public class ReportApiController {

	@Autowired
	IndentReportRepo indentReportRepo;

	@Autowired
	IndentReportDetailRepository indentReportDetailRepository;

	@Autowired
	RejectionReportRepository rejectionReportRepository;

	@Autowired
	POReportRepository pOReportRepository;

	@Autowired
	MrnReportrepo mrnReportrepo;

	@Autowired
	ApproveStatusMrnReportRepo approveStatusMrnReportRepo;

	@Autowired
	IssueReportRepository issueReportRepository;

	@RequestMapping(value = { "/getIndentListHeaderDetailReport" }, method = RequestMethod.POST)
	public @ResponseBody List<IndentReport> getIndentListHeaderDetailReport(

			@RequestParam("indentIdList") List<Integer> indentIdList) {

		List<IndentReport> indentList = new ArrayList<IndentReport>();

		try {

			indentList = indentReportRepo.getIndentHeaderReportList(indentIdList);
			
			

			List<IndentReportDetail> list = indentReportDetailRepository.getIndentReportDetailList(indentIdList);
			
			for(int i=0;i<indentList.size();i++)
			{
				List<IndentReportDetail> listRes=new ArrayList<>();
				for(int j =0;j<list.size();j++)
				{
					if(indentList.get(i).getIndMId()==list.get(j).getIndMId())
					{
						listRes.add(list.get(j));
					}
				}
				indentList.get(i).setIndentReportDetailList(listRes);
			
			}

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

	@RequestMapping(value = { "/getMrnApproveStatusReportList" }, method = RequestMethod.POST)
	public @ResponseBody List<ApproveStatusMrnReport> getMrnApproveStatusReportList(

			@RequestParam("mrnIdList") List<Integer> mrnIdList) {

		List<ApproveStatusMrnReport> mrnList = new ArrayList<ApproveStatusMrnReport>();

		try {

			mrnList = approveStatusMrnReportRepo.getApproveStatusMrnReport(mrnIdList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return mrnList;

	}

	@RequestMapping(value = { "/getIssueReportList" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueReport> getIssueReportList(

			@RequestParam("issueIdList") List<Integer> issueIdList) {

		List<IssueReport> issueList = new ArrayList<IssueReport>();

		try {

			issueList = issueReportRepository.getIssueReportList(issueIdList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return issueList;

	}

	@RequestMapping(value = { "/getRejectionReportList" }, method = RequestMethod.POST)
	public @ResponseBody List<RejectionReport> getRejectionReportList(

			@RequestParam("rejectionIdList") List<Integer> rejectionIdList) {

		List<RejectionReport> rejList = new ArrayList<RejectionReport>();

		try {

			rejList = rejectionReportRepository.getRejReportList(rejectionIdList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rejList;

	}

}
