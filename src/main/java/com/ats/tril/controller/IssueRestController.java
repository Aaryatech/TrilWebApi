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

import com.ats.tril.model.ErrorMessage;
import com.ats.tril.model.GetIssueDetail;
import com.ats.tril.model.GetIssueHeader;
import com.ats.tril.model.IssueDetail;
import com.ats.tril.model.IssueHeader;
import com.ats.tril.repository.GetIssueDetailRepository;
import com.ats.tril.repository.GetIssueHeaderRepository;
import com.ats.tril.repository.IssueDetailRepository;
import com.ats.tril.repository.IssueHeaderRepository;

@RestController
public class IssueRestController {
	
	
	@Autowired
	IssueHeaderRepository  issueHeaderRepository;
	
	@Autowired
	IssueDetailRepository issueDetailRepository;
	
	@Autowired
	GetIssueHeaderRepository getIssueHeaderRepository;
	
	@Autowired
	GetIssueDetailRepository getIssueDetailRepository;
	
	@RequestMapping(value = { "/saveIssueHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody IssueHeader saveIssueHeaderAndDetail(@RequestBody IssueHeader issueHeader) {

		IssueHeader res = new IssueHeader();

		try {

			res = issueHeaderRepository.save(issueHeader); 
			for(int i = 0 ; i<issueHeader.getIssueDetailList().size();i++)
				issueHeader.getIssueDetailList().get(i).setIssueId(res.getIssueId());
		 
			List<IssueDetail> issueDetailList = issueDetailRepository.saveAll(issueHeader.getIssueDetailList()); 
			res.setIssueDetailList(issueDetailList); 
			
		} catch (Exception e) {

			e.printStackTrace();
			 
		}
		return res;

	}
	
	@RequestMapping(value = { "/deleteHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteHeaderAndDetail(@RequestParam("issueId") int issueId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			int delete = issueHeaderRepository.delete(issueId);
			
			if(delete==0)
			{
				errorMessage.setError(false);
				errorMessage.setMessage("deleted");
			}
			else
			{
				errorMessage.setError(true);
				errorMessage.setMessage("failed");
			}
			 

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed"); 
		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/getIssueHeaderList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetIssueHeader> getIssueHeaderList(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetIssueHeader> list = new ArrayList<GetIssueHeader>();

		try {

			list = getIssueHeaderRepository.findByDeleteStatus(fromDate,toDate); 
			 
			
		} catch (Exception e) {

			e.printStackTrace();
			 
		}
		return list;

	}
	
	@RequestMapping(value = { "/getIssueHeaderAndDetailById" }, method = RequestMethod.POST)
	public @ResponseBody GetIssueHeader getIssueHeaderAndDetailById(@RequestParam("issueId") int issueId) {

		GetIssueHeader getIssueHeader = new GetIssueHeader();

		try {

			getIssueHeader = getIssueHeaderRepository.findByIssueId(issueId); 
			
			List<GetIssueDetail> getIssueDetailList = getIssueDetailRepository.findByIssueId(issueId);
			 
			getIssueHeader.setIssueDetailList(getIssueDetailList);
		} catch (Exception e) {

			e.printStackTrace();
			 
		}
		return getIssueHeader;

	}

}
