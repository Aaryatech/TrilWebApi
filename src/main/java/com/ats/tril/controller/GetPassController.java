package com.ats.tril.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.ErrorMessage;
import com.ats.tril.model.GetpassDetail;
import com.ats.tril.model.GetpassHeader;
import com.ats.tril.model.GetpassItem;
import com.ats.tril.repository.GetpassDetailRepo;
import com.ats.tril.repository.GetpassHeaderRepo;
import com.ats.tril.repository.GetpassItemRepo;

@RestController
public class GetPassController {

	@Autowired
	GetpassItemRepo getpassItemRepo;

	@Autowired
	GetpassHeaderRepo getpassHeaderRepo;

	@Autowired
	GetpassDetailRepo getpassDetailRepo;

	// -------------------GetPassItem----------------------

	@RequestMapping(value = { "/saveGatePass" }, method = RequestMethod.POST)
	public @ResponseBody GetpassItem saveGetPassItem1(@RequestBody GetpassItem getpassItem) {
System.err.println("Inside Save Gate Pass Item ");
		GetpassItem res = new GetpassItem();

		try {

			res = getpassItemRepo.save(getpassItem);

		} catch (Exception e) {
			
			System.err.println("exce in saving get pass item " +e.getMessage());

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getGpItemByGetPassId" }, method = RequestMethod.POST)
	public @ResponseBody GetpassItem getGpItemByGetPassId(@RequestParam("gpItemId") int gpItemId) {

		GetpassItem getpassItem = null;
		try {
			getpassItem = getpassItemRepo.findByGpItemIdAndIsUsed(gpItemId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getpassItem;

	}

	@RequestMapping(value = { "/hello" }, method = RequestMethod.GET)
	public @ResponseBody String getGpItemByGetPassId() {
		
		return "Hello";
		
	}
	

	
	@RequestMapping(value = { "/getAllGpItemByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<GetpassItem> getAllGpItemByIsUsed() {

		List<GetpassItem> dept = new ArrayList<GetpassItem>();

		try {

			dept = getpassItemRepo.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dept;

	}

	@RequestMapping(value = { "/deleteGetpassItem" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteDept(@RequestParam("gpItemId") int gpItemId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = getpassItemRepo.deleteGetpassItem(gpItemId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Dept Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/saveGetPassHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody GetpassHeader saveGetPassHeaderDetail(@RequestBody GetpassHeader getpassHeader) {

		GetpassHeader getPassRes = new GetpassHeader();

		try {

			Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strDateTime = simpleDateFormat.format(simpleDateFormat);

			getPassRes = getpassHeaderRepo.saveAndFlush(getpassHeader);

			for (int i = 0; i < getPassRes.getGetpassDetail().size(); i++)
				getPassRes.getGetpassDetail().get(i).setGpId(getPassRes.getGpId());

			List<GetpassDetail> getPassDetailList = getpassDetailRepo.saveAll(getPassRes.getGetpassDetail());
			System.out.println("getPassDetailList" + getPassDetailList.toString());

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getpassHeader;

	}

}
