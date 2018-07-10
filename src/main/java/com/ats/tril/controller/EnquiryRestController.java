package com.ats.tril.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.common.DateConvertor;
import com.ats.tril.model.EnquiryDetail;
import com.ats.tril.model.EnquiryHeader;
import com.ats.tril.model.ErrorMessage;
import com.ats.tril.repository.EnquiryDetailRepository;
import com.ats.tril.repository.EnquiryHeaderRepository;

@RestController
public class EnquiryRestController {
	
	
	@Autowired
	EnquiryHeaderRepository enquiryHeaderRepository;
	
	@Autowired
	EnquiryDetailRepository enquiryDetailRepository;
	
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

}
