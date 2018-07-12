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

import com.ats.tril.common.DateConvertor;
import com.ats.tril.model.EnquiryDetail;
import com.ats.tril.model.EnquiryHeader;
import com.ats.tril.model.ErrorMessage;
import com.ats.tril.model.GetEnquiryDetail;
import com.ats.tril.model.GetEnquiryHeader;
import com.ats.tril.repository.EnquiryDetailRepository;
import com.ats.tril.repository.EnquiryHeaderRepository;
import com.ats.tril.repository.GetEnquiryDetailRepository;
import com.ats.tril.repository.GetEnquiryHeaderRepository;

@RestController
public class EnquiryRestController {
	
	
	@Autowired
	EnquiryHeaderRepository enquiryHeaderRepository;
	
	@Autowired
	EnquiryDetailRepository enquiryDetailRepository;
	
	@Autowired
	GetEnquiryHeaderRepository getEnquiryHeaderRepository;
	
	@Autowired
	GetEnquiryDetailRepository  getEnquiryDetailRepository;
	
	@RequestMapping(value = { "/saveEnquiryHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveEnquiryHeaderAndDetail(@RequestBody List<EnquiryHeader> enquiryHeaderList) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			for(int i = 0 ; i<enquiryHeaderList.size();i++)
			{
				EnquiryHeader enquiryHeader = enquiryHeaderRepository.save(enquiryHeaderList.get(i));
				
				for(int j=0 ; j<enquiryHeaderList.get(i).getEnquiryDetailList().size();j++)
				{
					enquiryHeaderList.get(i).getEnquiryDetailList().get(j).setEnqId(enquiryHeader.getEnqId());
					enquiryHeaderList.get(i).getEnquiryDetailList().get(j).setVendId(enquiryHeader.getVendId());
					enquiryHeaderList.get(i).getEnquiryDetailList().get(j).setEnqDetailDate(DateConvertor.convertToYMD(enquiryHeaderList.get(i).getEnquiryDetailList().get(j).getEnqDetailDate()));
				}
				
				List<EnquiryDetail> enquiryDetailsList = enquiryDetailRepository.saveAll(enquiryHeaderList.get(i).getEnquiryDetailList()); 
			}
			
			errorMessage.setError(false);
			errorMessage.setMessage("successfully Saved ");

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/getEnquiryHeaderList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetEnquiryHeader> getEnquiryHeaderList() {

		List<GetEnquiryHeader> enquiryHeaderList = new ArrayList<GetEnquiryHeader>();

		try {

			enquiryHeaderList = getEnquiryHeaderRepository.getEnquiryHeaderList();
			 

		} catch (Exception e) {

			e.printStackTrace();
			 

		}
		return enquiryHeaderList;

	}
	
	@RequestMapping(value = { "/getEnquiryHeaderListBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEnquiryHeader> getEnquiryHeaderListBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetEnquiryHeader> enquiryHeaderList = new ArrayList<GetEnquiryHeader>();

		try {

			enquiryHeaderList = getEnquiryHeaderRepository.getEnquiryHeaderListBetweenDate(fromDate,toDate);
			 

		} catch (Exception e) {

			e.printStackTrace();
			 

		}
		return enquiryHeaderList;

	}
	
	@RequestMapping(value = { "/getEnquiryHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody  GetEnquiryHeader  getEnquiryHeaderAndDetail(@RequestParam("enqId") int enqId) {

		 GetEnquiryHeader  enquiryHeader = new  GetEnquiryHeader ();

		try {

			enquiryHeader = getEnquiryHeaderRepository.getEnquiryHeader(enqId); 
			List<GetEnquiryDetail> enquiryDetailList = getEnquiryDetailRepository.getEnquiryDetail(enqId);
			enquiryHeader.setEnquiryDetailList(enquiryDetailList);

		} catch (Exception e) {

			e.printStackTrace();
			 

		}
		return enquiryHeader;

	}
	
	@RequestMapping(value = { "/deleteEnquiryHeader" }, method = RequestMethod.POST)
	public @ResponseBody  ErrorMessage  deleteEnquiryHeader(@RequestParam("enqId") int enqId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			int update =  enquiryHeaderRepository.delete(enqId);
			
			if(update==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("failed to Delete ");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("  Deleted ");
			}
			 

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Delete ");
			 

		}
		return errorMessage;

	}

}