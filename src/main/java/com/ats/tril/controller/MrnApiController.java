package com.ats.tril.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.mrn.MrnDetail;
import com.ats.tril.model.mrn.MrnHeader;
import com.ats.tril.repository.mrn.MrnDetailRepo;
import com.ats.tril.repository.mrn.MrnHeaderRepository;

@RestController
public class MrnApiController {
	
	@Autowired
	MrnHeaderRepository  mrnHeaderRepository;
	
	@Autowired
	MrnDetailRepo mrnDetailRepo;
	
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
	
}
