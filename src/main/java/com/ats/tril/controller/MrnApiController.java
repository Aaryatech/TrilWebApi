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

import com.ats.tril.model.indent.DashIndentDetails;
import com.ats.tril.model.indent.GetIndents;
import com.ats.tril.model.mrn.GetMrnDetail;
import com.ats.tril.model.mrn.GetMrnHeader;
import com.ats.tril.model.mrn.MrnDetail;
import com.ats.tril.model.mrn.MrnHeader;
import com.ats.tril.repository.mrn.GetMrnDetailRepository;
import com.ats.tril.repository.mrn.GetMrnHeaderRepository;
import com.ats.tril.repository.mrn.MrnDetailRepo;
import com.ats.tril.repository.mrn.MrnHeaderRepository;

@RestController
public class MrnApiController {
	
	@Autowired
	MrnHeaderRepository  mrnHeaderRepository;
	
	@Autowired
	MrnDetailRepo mrnDetailRepo;
	
	@Autowired
	GetMrnHeaderRepository getMrnHeaderRepository;
	
	@Autowired
	GetMrnDetailRepository getMrnDetailRepository;
	
	
	
	@RequestMapping(value = { "/saveMrnHeadAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody MrnHeader saveMrnHeadAndDetail(@RequestBody MrnHeader mrnHeader) {
		System.err.println("inside web api save saveMrnHeadAndDetail");
		MrnHeader res = new MrnHeader();

		try {

			res = mrnHeaderRepository.saveAndFlush(mrnHeader);

			List<MrnDetail> mrnDetailList = mrnHeader.getMrnDetailList();

			int mrnId = res.getMrnId();

			for (int i = 0; i < mrnDetailList.size(); i++) {

				MrnDetail detail = mrnDetailList.get(i);
				detail.setMrnId(mrnId);
				MrnDetail transRes = mrnDetailRepo.save(detail);
				
			}

		} catch (Exception e) {

			System.err.println("Exception in saving Mrn Header and Detail  " + e.getMessage());
			e.printStackTrace();

		}

		return res;
	}
	@RequestMapping(value = { "/getMrnHeaderList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMrnHeader> getMrnHeaderList(@RequestParam("venId") List<Integer> venId,@RequestParam("status") List<Integer> status) {

		List<GetMrnHeader> mrnHeaderList = new ArrayList<GetMrnHeader>();

		try {
           if(venId.contains(0) && !status.contains(0))
           {
			mrnHeaderList = getMrnHeaderRepository.getMrnHeaderListByStatus(status);
           }
           else  if(!venId.contains(0) && status.contains(0)){
        	   
        	   mrnHeaderList = getMrnHeaderRepository.getMrnHeaderListByVenId(venId);
        	   
           } else  if(!venId.contains(0) && !status.contains(0)){
        	   
        	   mrnHeaderList = getMrnHeaderRepository.getMrnHeaderListByVenIdAndStatus(venId,status);
           }
            else  if(venId.contains(0) && status.contains(0)){
        	   
        	   mrnHeaderList = getMrnHeaderRepository.getAllMrnHeaderList();
           }
           if(mrnHeaderList.size()>0) {
			for(int i=0;i<mrnHeaderList.size();i++)
			{
				/*List<GetMrnDetail> getMrnDetailList =getMrnDetailRepository.getMrnDetailList(mrnHeaderList.get(i).getMrnId(),0);
				
				mrnHeaderList.get(i).setGetMrnDetailList(getMrnDetailList);*/
			}
           }
		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeaderList;

	}
}
