package com.ats.tril.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.common.DateConvertor;
import com.ats.tril.model.report.ApproveStatusMrnReport;
import com.ats.tril.model.report.ApproveStatusMrnReportDetail;
import com.ats.tril.model.report.GatepassReport;
import com.ats.tril.model.report.GatepassReportDetail;
import com.ats.tril.model.report.IndentRepItemwise;
import com.ats.tril.model.report.IndentReport;
import com.ats.tril.model.report.IndentReportDetail;
import com.ats.tril.model.report.IssueReport;
import com.ats.tril.model.report.IssueReportDetail;
import com.ats.tril.model.report.IssueReportItemwise;
import com.ats.tril.model.report.ItemEnqAgQuotReport;
import com.ats.tril.model.report.MrnCatwiseReport;
import com.ats.tril.model.report.MrnReport;
import com.ats.tril.model.report.MrnReportDetail;
import com.ats.tril.model.report.POReport;
import com.ats.tril.model.report.POReportDetail;
import com.ats.tril.model.report.QuotReport;
import com.ats.tril.model.report.RejectionReport;
import com.ats.tril.model.report.RejectionReportDetail;
import com.ats.tril.repository.indent.IndentReportDetailRepository;
import com.ats.tril.repository.report.ApproveMrnDetailRepository;
import com.ats.tril.repository.report.ApproveStatusMrnReportRepo;
import com.ats.tril.repository.report.GatepassReportDetailRepo;
import com.ats.tril.repository.report.GatepassReportRepository;
import com.ats.tril.repository.report.IndentRepItemwiseRepo;
import com.ats.tril.repository.report.IndentReportRepo;
import com.ats.tril.repository.report.IssueReportDetailRepository;
import com.ats.tril.repository.report.IssueReportItemwiseRepo;
import com.ats.tril.repository.report.IssueReportRepository;
import com.ats.tril.repository.report.ItemEnqAgQuotReportRepo;
import com.ats.tril.repository.report.MrnCatwiseReportRepo;
import com.ats.tril.repository.report.MrnReportDetailRepo;
import com.ats.tril.repository.report.MrnReportrepo;
import com.ats.tril.repository.report.POReportDetailRepo;
import com.ats.tril.repository.report.POReportRepository;
import com.ats.tril.repository.report.QuotReportRepo;
import com.ats.tril.repository.report.RejectionReportDetailRepo;
import com.ats.tril.repository.report.RejectionReportRepository;

@RestController
public class ReportApiController {

	@Autowired
	IndentReportRepo indentReportRepo;

	@Autowired
	GatepassReportDetailRepo gatepassReportDetailRepo;

	@Autowired
	GatepassReportRepository gatepassReportRepository;

	@Autowired
	RejectionReportDetailRepo rejectionReportDetailRepo;

	@Autowired
	ApproveMrnDetailRepository approveMrnDetailRepository;

	@Autowired
	MrnReportDetailRepo mrnReportDetailRepo;

	@Autowired
	IndentReportDetailRepository indentReportDetailRepository;

	@Autowired
	RejectionReportRepository rejectionReportRepository;

	@Autowired
	POReportRepository pOReportRepository;

	@Autowired
	POReportDetailRepo pOReportDetailRepo;

	@Autowired
	MrnReportrepo mrnReportrepo;

	@Autowired
	ApproveStatusMrnReportRepo approveStatusMrnReportRepo;

	@Autowired
	IssueReportRepository issueReportRepository;
	@Autowired
	IssueReportDetailRepository issueReportDetailRepository;

	@Autowired
	IssueReportItemwiseRepo issueReportItemwiseRepo;

	@Autowired
	MrnCatwiseReportRepo mrnCatwiseReportRepo;

	@Autowired
	QuotReportRepo quotReportRepo;

	@Autowired
	ItemEnqAgQuotReportRepo itemEnqAgQuotReportRepo;

	@Autowired
	IndentRepItemwiseRepo indentRepItemwiseRepo;

	@RequestMapping(value = { "/getIndentListHeaderDetailReport" }, method = RequestMethod.POST)
	public @ResponseBody List<IndentReport> getIndentListHeaderDetailReport(

			@RequestParam("indentIdList") List<Integer> indentIdList) {

		List<IndentReport> indentList = new ArrayList<IndentReport>();

		try {

			indentList = indentReportRepo.getIndentHeaderReportList(indentIdList);

			List<IndentReportDetail> list = indentReportDetailRepository.getIndentReportDetailList(indentIdList);

			for (int i = 0; i < indentList.size(); i++) {
				List<IndentReportDetail> listRes = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					if (indentList.get(i).getIndMId() == list.get(j).getIndMId()) {
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

	@RequestMapping(value = { "/getAllPoListHeaderDetailReport" }, method = RequestMethod.POST)
	public @ResponseBody List<POReport> getAllPoListHeaderDetailReport(

			@RequestParam("poIdList") List<Integer> poIdList) {

		List<POReport> poList = new ArrayList<POReport>();

		try {

			poList = pOReportRepository.getPOReportHeaderList(poIdList);

			List<POReportDetail> list = pOReportDetailRepo.getPOReportDetailList(poIdList);

			for (int i = 0; i < poList.size(); i++) {
				List<POReportDetail> listRes = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					if (poList.get(i).getPoId() == list.get(j).getPoId()) {
						listRes.add(list.get(j));
					}
				}
				poList.get(i).setpOReportDetailList(listRes);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return poList;

	}

	@RequestMapping(value = { "/getAllMrnListHeaderDetailReport" }, method = RequestMethod.POST)
	public @ResponseBody List<MrnReport> getAllMrnListHeaderDetailReport(

			@RequestParam("mrnIdList") List<Integer> mrnIdList) {

		List<MrnReport> mrnList = new ArrayList<MrnReport>();

		try {

			mrnList = mrnReportrepo.getHeaderMrnReportList(mrnIdList);

			List<MrnReportDetail> list = mrnReportDetailRepo.getMrnDetailReportList(mrnIdList);

			for (int i = 0; i < mrnList.size(); i++) {
				List<MrnReportDetail> listRes = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					if (mrnList.get(i).getMrnId() == list.get(j).getMrnId()) {
						listRes.add(list.get(j));
					}
				}
				mrnList.get(i).setMrnReportDetailList(listRes);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return mrnList;

	}

	@RequestMapping(value = { "/getIssueHeaderDetailReport" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueReport> getIssueHeaderDetailReport(

			@RequestParam("issueIdList") List<Integer> issueIdList) {

		List<IssueReport> issList = new ArrayList<IssueReport>();

		try {

			issList = issueReportRepository.getIssueReportList(issueIdList);

			List<IssueReportDetail> list = issueReportDetailRepository.getIssueDetailReportList(issueIdList);

			for (int i = 0; i < issList.size(); i++) {
				List<IssueReportDetail> listRes = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					if (issList.get(i).getIssueId() == list.get(j).getIssueId()) {
						listRes.add(list.get(j));
					}
				}
				issList.get(i).setIssueReportDetailList(listRes);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return issList;

	}

	@RequestMapping(value = { "/getApproveStatusReport" }, method = RequestMethod.POST)
	public @ResponseBody List<ApproveStatusMrnReport> getApproveStatusReport(

			@RequestParam("mrnIdList") List<Integer> mrnIdList) {

		List<ApproveStatusMrnReport> appList = new ArrayList<ApproveStatusMrnReport>();

		try {

			appList = approveStatusMrnReportRepo.getApproveStatusMrnHeaderReport(mrnIdList);

			List<ApproveStatusMrnReportDetail> list = approveMrnDetailRepository
					.getApproveStatusMrnDetailReport(mrnIdList);

			for (int i = 0; i < appList.size(); i++) {
				List<ApproveStatusMrnReportDetail> listRes = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					if (appList.get(i).getMrnId() == list.get(j).getMrnId()) {
						listRes.add(list.get(j));
					}
				}
				appList.get(i).setApproveStatusMrnReportDetail(listRes);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return appList;

	}

	@RequestMapping(value = { "/getAllRejectionListReport" }, method = RequestMethod.POST)
	public @ResponseBody List<RejectionReport> getAllRejectionListReport(

			@RequestParam("rejectionIdList") List<Integer> rejectionIdList) {

		List<RejectionReport> rejList = new ArrayList<RejectionReport>();

		try {

			rejList = rejectionReportRepository.getRejHeaderReportList(rejectionIdList);

			List<RejectionReportDetail> list = rejectionReportDetailRepo.getRejDetailReportList(rejectionIdList);

			for (int i = 0; i < rejList.size(); i++) {
				List<RejectionReportDetail> listRes = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					if (rejList.get(i).getRejectionId() == list.get(j).getRejectionId()) {
						listRes.add(list.get(j));
					}
				}
				rejList.get(i).setRejReportDetailList(listRes);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rejList;

	}

	@RequestMapping(value = { "/getGatepassListReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GatepassReport> getGatepassListReport(

			@RequestParam("gpIdList") List<Integer> gpIdList) {

		List<GatepassReport> gpList = new ArrayList<GatepassReport>();

		try {

			gpList = gatepassReportRepository.gatepassReportHeader(gpIdList);

			List<GatepassReportDetail> list = gatepassReportDetailRepo.gatepassReportDetail(gpIdList);

			for (int i = 0; i < gpList.size(); i++) {
				List<GatepassReportDetail> listRes = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					if (gpList.get(i).getGpId() == list.get(j).getGpId()) {
						listRes.add(list.get(j));
					}
				}
				gpList.get(i).setGatepassReportDetailList(listRes);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return gpList;

	}

	@RequestMapping(value = { "/getGatepassListReturnableReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GatepassReport> getGatepassListReturnableReport(

			@RequestParam("gpIdList") List<Integer> gpIdList) {

		List<GatepassReport> gpList = new ArrayList<GatepassReport>();

		try {

			gpList = gatepassReportRepository.gatepassReportHeaderReturnable(gpIdList);

			List<GatepassReportDetail> list = gatepassReportDetailRepo.gatepassReportDetailReturnable(gpIdList);

			for (int i = 0; i < gpList.size(); i++) {
				List<GatepassReportDetail> listRes = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					if (gpList.get(i).getGpId() == list.get(j).getGpId()) {
						listRes.add(list.get(j));
					}
				}
				gpList.get(i).setGatepassReportDetailList(listRes);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return gpList;

	}

	@RequestMapping(value = { "/getIssueHeaderDetailItemwiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueReportItemwise> getIssueHeaderDetailItemwiseReport(

			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("typeId") List<String> typeId, @RequestParam("deptId") int deptId,
			@RequestParam("subDeptId") int subDeptId, @RequestParam("catIdList") List<String> catIdList,
			@RequestParam("appStatus") int appStatus) {

		List<IssueReportItemwise> issList = new ArrayList<IssueReportItemwise>();

		try {

			System.out.println(fromDate + " " + toDate + " " + typeId + " " + deptId + " " + subDeptId + "" + catIdList
					+ "" + appStatus);

			if (deptId != 0 && subDeptId != 0 && appStatus != -1) {

				issList = issueReportItemwiseRepo.getIssueDetailReportList(fromDate, toDate, typeId, deptId, subDeptId,
						catIdList, appStatus);
			} else if (deptId == 0 && subDeptId == 0 && appStatus != -1) {
				issList = issueReportItemwiseRepo.getIssueDetailReportListDeptAll(fromDate, toDate, typeId, catIdList,
						appStatus);
			}

			else if (deptId != 0 && subDeptId == 0 && appStatus != -1) {
				issList = issueReportItemwiseRepo.getIssueDetailReportListSubDeptAll(fromDate, toDate, typeId,
						catIdList, appStatus, deptId);
			}

			else if (deptId != 0 && subDeptId == 0 && appStatus == -1) {
				issList = issueReportItemwiseRepo.getIssueDetailReportListStatus(fromDate, toDate, typeId, catIdList,
						deptId);
			}

			else if (deptId == 0 && subDeptId == 0 && appStatus == -1) {
				issList = issueReportItemwiseRepo.getIssueDetailReportListStatusAndDept(fromDate, toDate, typeId,
						catIdList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return issList;

	}

	@RequestMapping(value = { "/getMrnReportCatwise" }, method = RequestMethod.POST)
	public @ResponseBody List<MrnCatwiseReport> getMrnReportCatwise(

			@RequestParam("catIdList") List<String> catIdList) {

		List<MrnCatwiseReport> issList = new ArrayList<MrnCatwiseReport>();

		try {

			if (catIdList.contains("0")) {

				issList = mrnCatwiseReportRepo.getMrnReport();

			} else {

				issList = mrnCatwiseReportRepo.getMrnReportCatwiseList(catIdList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return issList;

	}

	@RequestMapping(value = { "/getQuotReport" }, method = RequestMethod.POST)
	public @ResponseBody List<QuotReport> getQuotReport(

			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") List<String> status) {

		List<QuotReport> issList = new ArrayList<QuotReport>();

		try {

			if (status.contains("-1")) {

				issList = quotReportRepo.getQuotReportBetDAte(fromDate, toDate);

			} else {

				issList = quotReportRepo.getQuotReportBetDAteAndStatus(fromDate, toDate, status);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return issList;

	}

	@RequestMapping(value = { "/getEnqAgQuotReport" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemEnqAgQuotReport> getEnqAgQuotReport(

			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") int status, @RequestParam("vendorIdList") List<String> vendorIdList) {

		List<ItemEnqAgQuotReport> issList = new ArrayList<ItemEnqAgQuotReport>();

		try {

			if (vendorIdList.contains("0")) {

				issList = itemEnqAgQuotReportRepo.getQuotReportBetDAte(fromDate, toDate, status);

			} else {

				issList = itemEnqAgQuotReportRepo.getQuotReportBetDAteAndStatus(fromDate, toDate, status, vendorIdList);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return issList;

	}

	@RequestMapping(value = { "/getIndentItemwiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<IndentRepItemwise> getIndentItemwiseReport(

			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("typeIdList") List<String> typeIdList, @RequestParam("catIdList") List<String> catIdList,
			@RequestParam("statusList") List<String> statusList) {

		List<IndentRepItemwise> issList = new ArrayList<IndentRepItemwise>();

		try {

			System.out.println(fromDate + " " + toDate + " " + typeIdList + " " + "" + catIdList + "" + statusList);

			issList = indentRepItemwiseRepo.getIndentReportItemwise(catIdList, typeIdList, statusList, fromDate,
					toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return issList;

	}

}
