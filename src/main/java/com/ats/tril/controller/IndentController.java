package com.ats.tril.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.Dept;
import com.ats.tril.model.ErrorMessage;
import com.ats.tril.model.indent.GetIndent;
import com.ats.tril.model.indent.GetIndentByStatus;
import com.ats.tril.model.indent.Indent;
import com.ats.tril.model.indent.IndentTrans;
import com.ats.tril.repository.GetIndentByStatusRepo;
import com.ats.tril.repository.indent.GetIndentRepo;
import com.ats.tril.repository.indent.IndentRepository;
import com.ats.tril.repository.indent.IndentTransRepo;

@RestController
public class IndentController {

	@Autowired
	IndentRepository indentRepository;

	@Autowired
	IndentTransRepo indentTransRepo;

	@Autowired
	GetIndentRepo getIndentRepo;
	
	@Autowired
	GetIndentByStatusRepo getIndentByStatusRepo;

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
		
		ErrorMessage err=new ErrorMessage();
		int response=0;
		
		try {

			 response=indentRepository.updateIndentHeader(achdId, deptId, subDeptId, indIsdev, indIsmonthly, indMId);
			 
			 if(response>0) {
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

			indDetailList = indentTransRepo.findByIndMIdAndIndDStatus(indMId, delStatus);

			System.err.println("indDetailList List " + indDetailList.toString());
			
		} catch (Exception e) {

			System.err.println("Exception in getIndentDetailByIndMId  Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return indDetailList;

	}
	
	
	//edit Indent Detail for Indent Quantity
	
	@RequestMapping(value = { "/editIndentDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage editIndentDetail(@RequestParam("indQty") int indQty,
			@RequestParam("indDId") int indDId) {
		
		ErrorMessage err=new ErrorMessage();
		int response=0;
		
		try {

			 response=indentTransRepo.updateIndentDetail(indQty, indDId);
			 
			 if(response>0) {
				 
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
	
	@RequestMapping(value = { "/getIntendsByStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetIndentByStatus> getIntendsByStatus(@RequestParam("status") String status) {

		 

		List<GetIndentByStatus> indentList = new ArrayList<GetIndentByStatus>();

		try {

			indentList = getIndentByStatusRepo.getIntendsByStatus(status);

			 
		} catch (Exception e) {
 
			e.printStackTrace();

		}

		return indentList;

	}
	
	@RequestMapping(value = { "/getIntendsDetailByIntendId" }, method = RequestMethod.POST)
	public @ResponseBody List<IndentTrans> getIntendsDetailByIntendId(@RequestParam("indId") int indId) {
 
		List<IndentTrans> indentDetailList = new ArrayList<IndentTrans>();

		try {

			indentDetailList = indentTransRepo.findByIndMId(indId);

			 
		} catch (Exception e) {
 
			e.printStackTrace();

		}

		return indentDetailList;

	}
	
	
}
