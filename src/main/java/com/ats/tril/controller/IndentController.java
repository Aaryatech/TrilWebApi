package com.ats.tril.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.common.DateConvertor;
import com.ats.tril.model.ErrorMessage;
import com.ats.tril.model.GetIntendDetail;
import com.ats.tril.model.indent.GetIndent;
import com.ats.tril.model.indent.GetIndentByStatus;
import com.ats.tril.model.indent.GetIndentDetail;
import com.ats.tril.model.indent.Indent;
import com.ats.tril.model.indent.IndentReport;
import com.ats.tril.model.indent.IndentTrans;
import com.ats.tril.repository.GetIndentByStatusRepo;
import com.ats.tril.repository.GetIntendDetailRepo;
import com.ats.tril.repository.indent.GetIndentDetailRepo;
import com.ats.tril.repository.indent.GetIndentRepo;
import com.ats.tril.repository.indent.IndentReportRepository;
import com.ats.tril.repository.indent.IndentRepository;
import com.ats.tril.repository.indent.IndentTransRepo;

@RestController
public class IndentController {

	@Autowired
	IndentRepository indentRepository;

	@Autowired
	IndentReportRepository indentReportRepository;

	@Autowired
	IndentTransRepo indentTransRepo;

	@Autowired
	GetIndentRepo getIndentRepo;

	@Autowired
	GetIndentByStatusRepo getIndentByStatusRepo;

	@Autowired
	GetIntendDetailRepo getIntendDetailRepo;
	
	
	@RequestMapping(value = { "/saveIndentTras" }, method = RequestMethod.POST)
	public @ResponseBody List<GetIndentDetail> saveIndentTras(@RequestBody IndentTrans indDetail) {

		System.err.println("inside web api /getIndents indent");

		//List<IndentTrans> indDetailList = new ArrayList<IndentTrans>();
		List<GetIndentDetail> indDetailList = new ArrayList<GetIndentDetail>();

		try {
			IndentTrans transRes=indentTransRepo.save(indDetail);
			
			//indDetailList = indentTransRepo.findByIndMIdAndDelStatus(indDetail.getIndMId(),1);

				indDetailList = getIndentDetailRepo.getIndentDetail(indDetail.getIndMId());

				System.err.println("indDetailList List " + indDetailList.toString());

			System.err.println("indDetailList List " + indDetailList.toString());
		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return indDetailList;

	}

	
	
	
	@RequestMapping(value = { "/getIndentByIndId" }, method = RequestMethod.POST)
	public @ResponseBody Indent getIndentByIndId(@RequestParam("indMId") int indMId) {
		
		Indent indResponse = null;
		
		
		try {
			indResponse=indentRepository.findByIndMId(indMId);
			
		}catch (Exception e) {
			System.err.println("Exception in /getIndentByIndId   " +e.getMessage());
			e.printStackTrace();
		}
		return indResponse;
		
		
		
		
		
	}
	
	@RequestMapping(value = { "/saveIndentAndTrans" }, method = RequestMethod.POST)
	public @ResponseBody Indent saveIndentsHeaderDetail(@RequestBody Indent indent) {
		System.err.println("inside web api save indent");
		Indent res = new Indent();

		try {

			res = indentRepository.saveAndFlush(indent);

			List<IndentTrans> indTransList = indent.getIndentTrans();

			int indMId = res.getIndMId();

			for (int i = 0; i < indTransList.size(); i++) {

				IndentTrans indTrans = indTransList.get(i);
				indTrans.setIndMId(indMId);
				IndentTrans transRes = indentTransRepo.save(indTrans);

			}

		} catch (Exception e) {

			System.err.println("Exception in saving Indent and Detail Trans " + e.getMessage());

			e.printStackTrace();

		}

		return res;

	}

	@RequestMapping(value = { "/deleteIndent" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteIndent(@RequestParam("indId") int indId) {
		ErrorMessage res = new ErrorMessage();

		try {

			int delete = indentRepository.delete(indId);

			if (delete != 0) {
				res.setError(false);
				res.setMessage("delete");
			} else {
				res.setError(true);
				res.setMessage(" failed delete");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return res;

	}

	@RequestMapping(value = { "/getIndents" }, method = RequestMethod.POST)
	public @ResponseBody List<GetIndent> getIndents(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("status") List<String> status) {

		System.err.println("inside web api /getIndents indent");

		List<GetIndent> indentList = new ArrayList<GetIndent>();

		try {

			indentList = getIndentRepo.getIndent(fromDate, toDate, status);

			System.err.println("indent List " + indentList.toString());
		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return indentList;

	}

	@RequestMapping(value = { "/editIndentHeader" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage editIndentHeader(@RequestParam("achdId") int achdId,
			@RequestParam("deptId") int deptId, @RequestParam("subDeptId") int subDeptId,
			@RequestParam("indIsdev") int indIsdev, @RequestParam("indIsmonthly") int indIsmonthly,
			@RequestParam("indMId") int indMId) {

		ErrorMessage err = new ErrorMessage();
		int response = 0;

		try {

			response = indentRepository.updateIndentHeader(achdId, deptId, subDeptId, indIsdev, indIsmonthly, indMId);

			if (response > 0) {
				err.setError(false);
				err.setMessage("success editIndent Header");
			}

			else {

				err.setError(true);
				err.setMessage("failed editIndent Header");
			}

		} catch (Exception e) {

			System.err.println("Exception in editIndentHeader   " + e.getMessage());
			e.printStackTrace();
		}

		return err;
	}

	@RequestMapping(value = { "/getIndentDetailByIndMId" }, method = RequestMethod.POST)
	public @ResponseBody List<IndentTrans> getIndentDetailByIndMId(@RequestParam("indMId") int indMId,
			@RequestParam("delStatus") int delStatus) {

		System.err.println("inside web api /getIndentDetailByIndMId indent");

		List<IndentTrans> indDetailList = new ArrayList<IndentTrans>();

		try {

			indDetailList = indentTransRepo.findByIndMIdAndDelStatus(indMId,1);

			System.err.println("indDetailList List " + indDetailList.toString());

		} catch (Exception e) {

			System.err.println("Exception in getIndentDetailByIndMId  Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return indDetailList;

	}
//new bean and service to display item code and uom on edit indent page for indent Items
	
	@Autowired
	GetIndentDetailRepo getIndentDetailRepo;
	
	@RequestMapping(value = { "/getIndentDetailByIndentId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetIndentDetail> getIndentDetailByIndentId(@RequestParam("indMId") int indMId,
			@RequestParam("delStatus") int delStatus) {

		System.err.println("inside web api /getIndentDetailByIndMId indent");

		List<GetIndentDetail> indDetailList = new ArrayList<GetIndentDetail>();

		try {

			indDetailList = getIndentDetailRepo.getIndentDetail(indMId);

			System.err.println("indDetailList List " + indDetailList.toString());

		} catch (Exception e) {

			System.err.println("Exception in getIndentDetailByIndentId  Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return indDetailList;

	}
	
	
	// edit Indent Detail for Indent Quantity

	@RequestMapping(value = { "/editIndentDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage editIndentDetail(@RequestParam("indQty") int indQty,
			@RequestParam("indDId") int indDId,@RequestParam("schDay") int schDay,@RequestParam("remark") String remark
			,@RequestParam("indentId") int indentId) {

		ErrorMessage err = new ErrorMessage();
		int response = 0;

		try {

			
			//IndentTrans indDetail=indentTransRepo.getOne(indDId);
			
			Indent indResponse=indentRepository.findByIndMId(indentId);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date tempDate =indResponse.getIndMDate();
			Calendar c = Calendar.getInstance();
			c.setTime(tempDate); // Now use today date.//before new Date() now tempDate
			c.add(Calendar.DATE, schDay); // Adding days
			
			String schDate = sdf.format(c.getTime());
			
			Date scDate=sdf.parse(schDate);
			System.err.println("Date  " +schDate );
			response = indentTransRepo.updateIndentDetail(indQty, indDId,schDay,scDate,remark);

			if (response > 0) {

				err.setError(false);
				err.setMessage("success editIndent Detail");

			}

			else {

				err.setError(true);
				err.setMessage("failed editIndent Detail");

			}

		} catch (Exception e) {

			System.err.println("Exception in editIndentDetail   " + e.getMessage());
			e.printStackTrace();

		}

		return err;
	}

	// sac

	@RequestMapping(value = { "/delteIndentDetailItem" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage delteIndentDetailItem(@RequestParam("delStatus") int delStatus,
			@RequestParam("indDId") int indDId) {

		ErrorMessage err = new ErrorMessage();
		int response = 0;

		try {

			response = indentTransRepo.delteIndentDetail(delStatus, indDId);

			if (response > 0) {

				err.setError(false);
				err.setMessage("success delete Indent Detail");

			}

			else {

				err.setError(true);
				err.setMessage("failed delete Indent Detail");

			}

		} catch (Exception e) {

			System.err.println("Exception in delteIndentDetailItem   " + e.getMessage());
			e.printStackTrace();

		}

		return err;
	}

	@RequestMapping(value = { "/getIntendsByStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetIndentByStatus> getIntendsByStatus(@RequestParam("status") List<Integer> status,
			@RequestParam("poType") int poType) {

		List<GetIndentByStatus> indentList = new ArrayList<GetIndentByStatus>();

		try {

			indentList = getIndentByStatusRepo.getIntendsByStatus(status,poType);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return indentList;

	}

	@RequestMapping(value = { "/getIntendsDetailByIntendId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetIntendDetail> getIntendsDetailByIntendId(@RequestParam("indId") int indId) {

		List<GetIntendDetail> indentDetailList = new ArrayList<GetIntendDetail>();

		try {

			indentDetailList = getIntendDetailRepo.findByIndMId(indId);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return indentDetailList;

	}

	@RequestMapping(value = { "/updateIndendPendingQty" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateIndendPendingQty(@RequestBody List<IndentTrans> intendDetailList) {

		ErrorMessage errorMessage = new ErrorMessage();
		try {

			int status = 2;
			List<IndentTrans> transRes = indentTransRepo.saveAll(intendDetailList);

			for (int i = 0; i < intendDetailList.size(); i++) {
				if (intendDetailList.get(i).getIndDStatus() == 1) {
					status = 1;
					break;
				}
				else if (intendDetailList.get(i).getIndDStatus() == 0) {
					status = 0; 
				}
			}
			int update = indentRepository.updateStatus(intendDetailList.get(0).getIndMId(), status);

			errorMessage.setError(false);
			errorMessage.setMessage("update");

		} catch (Exception e) {

			errorMessage.setError(true);
			errorMessage.setMessage("failed");

			e.printStackTrace();

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/getIndentListReport" }, method = RequestMethod.POST)
	public @ResponseBody List<IndentReport> getIndentListReport(

			@RequestParam("catIdList") List<Integer> catIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("indIsmonthly") int indIsmonthly,
			@RequestParam("indIsdev") int indIsdev) {

		List<IndentReport> indentList = new ArrayList<IndentReport>();

		try {

			if (catIdList.contains(0) && indIsmonthly == 2 && indIsdev == 2) {
				indentList = indentReportRepository.getAllIndentReportList(fromDate, toDate);

			} else if (catIdList.contains(0) && indIsmonthly == 2) {
				indentList = indentReportRepository.getIndentReportListByIsDev(fromDate, toDate, indIsdev);

			} else if (catIdList.contains(0) && indIsdev == 2) {
				indentList = indentReportRepository.getIndentReportListByIsMonthly(fromDate, toDate, indIsmonthly);

			}

			else if (indIsmonthly == 2 && indIsdev == 2) {
				indentList = indentReportRepository.getIndentReportListByCatIdList(catIdList, fromDate, toDate);

			} else if (indIsdev == 2) {
				indentList = indentReportRepository.getIndentByCatIdListAndindIsmonthly(catIdList, fromDate, toDate,
						indIsmonthly);

			} else if (indIsmonthly == 2) {
				indentList = indentReportRepository.getIndentByCatIdListAndindIsDev(catIdList, fromDate, toDate,
						indIsdev);

			} else if (catIdList.contains(0)) {
				indentList = indentReportRepository.getIndentReportListByIsMonthlyAndIsDev(fromDate, toDate,
						indIsmonthly, indIsdev);

			} else {

				indentList = indentReportRepository.getIndentReportList(catIdList, fromDate, toDate, indIsmonthly,
						indIsdev);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return indentList;

	}

}