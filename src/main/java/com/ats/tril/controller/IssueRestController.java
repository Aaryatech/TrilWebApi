package com.ats.tril.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.ErrorMessage;
import com.ats.tril.model.IssueDetail;
import com.ats.tril.model.IssueHeader; 
import com.ats.tril.repository.IssueDetailRepository;
import com.ats.tril.repository.IssueHeaderRepository;

@RestController
public class IssueRestController {
	
	
	@Autowired
	IssueHeaderRepository  issueHeaderRepository;
	
	@Autowired
	IssueDetailRepository issueDetailRepository;
	
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

}
