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
import com.ats.tril.model.GetEnquiryDetail;
import com.ats.tril.model.GetEnquiryHeader;
import com.ats.tril.model.GetpassDetail;
import com.ats.tril.model.GetpassDetailItemName;
import com.ats.tril.model.GetpassHeader;
import com.ats.tril.model.GetpassItem;
import com.ats.tril.model.GetpassItemVen;
import com.ats.tril.model.GetpassReturn;
import com.ats.tril.model.GetpassReturnDetail;
import com.ats.tril.model.GetpassReturnVendor;
import com.ats.tril.repository.GetpassDetailItemNameRepo;
import com.ats.tril.repository.GetpassDetailRepo;
import com.ats.tril.repository.GetpassHeaderItemName;
import com.ats.tril.repository.GetpassHeaderItemNameRepo;
import com.ats.tril.repository.GetpassHeaderRepo;
import com.ats.tril.repository.GetpassItemRepo;
import com.ats.tril.repository.GetpassItemVenRepo;
import com.ats.tril.repository.GetpassReturnDetailRepo;
import com.ats.tril.repository.GetpassReturnRepo;
import com.ats.tril.repository.GetpassReturnVendorRepo;

@RestController
public class GetPassController {

	@Autowired
	GetpassItemRepo getpassItemRepo;

	@Autowired
	GetpassReturnVendorRepo getpassReturnVendorRepo;

	@Autowired
	GetpassDetailItemNameRepo getpassDetailItemNameRepo;

	@Autowired
	GetpassHeaderItemNameRepo getpassHeaderItemNameRepo;

	@Autowired
	GetpassReturnRepo getpassReturnRepo;

	@Autowired
	GetpassReturnDetailRepo getpassReturnDetailRepo;

	@Autowired
	GetpassItemVenRepo getpassItemVenRepo;

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

			System.err.println("exce in saving get pass item " + e.getMessage());

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

	@RequestMapping(value = { "/deleteGetpassHeader" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteGetpassHeader(@RequestParam("gpId") int gpId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = getpassHeaderRepo.deleteGetpassHeader(gpId);

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

			getPassRes = getpassHeaderRepo.saveAndFlush(getpassHeader);

			for (int i = 0; i < getPassRes.getGetpassDetail().size(); i++)
				getpassHeader.getGetpassDetail().get(i).setGpId(getPassRes.getGpId());

			List<GetpassDetail> getPassDetailList = getpassDetailRepo.saveAll(getpassHeader.getGetpassDetail());
			System.out.println("getPassDetailList" + getPassDetailList.toString());
			getPassRes.setGetpassDetail(getPassDetailList);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getpassHeader;

	}

	@RequestMapping(value = { "/getAllGetPassHeaderByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<GetpassHeader> getAllGetPassHeaderByIsUsed() {

		List<GetpassHeader> GetpassHeaderList = new ArrayList<GetpassHeader>();

		try {

			GetpassHeaderList = getpassHeaderRepo.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return GetpassHeaderList;

	}

	@RequestMapping(value = { "/getGetpassItemHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody GetpassHeader getGetpassItemHeaderAndDetail(@RequestParam("gpId") int gpId) {

		GetpassHeader getpassHeader = new GetpassHeader();

		try {

			getpassHeader = getpassHeaderRepo.findByGpId(gpId);
			List<GetpassDetail> getpassDetailList = getpassDetailRepo.findByGpId(gpId);
			getpassHeader.setGetpassDetail(getpassDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getpassHeader;

	}

	@RequestMapping(value = { "/getGetpassNonReturnable" }, method = RequestMethod.POST)
	public @ResponseBody List<GetpassItemVen> getGetpassNonReturnable(@RequestParam("vendId") int vendId) {

		List<GetpassItemVen> getpassHeader = new ArrayList<>();

		try {
			if (vendId != 0) {
				getpassHeader = getpassItemVenRepo.getpassNonListByVendId(vendId);

			} else {
				getpassHeader = getpassItemVenRepo.getpassAllNonListByVendId();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getpassHeader;

	}

	@RequestMapping(value = { "/getGetpassReturnable" }, method = RequestMethod.POST)
	public @ResponseBody List<GetpassItemVen> getGetpassReturnable(@RequestParam("vendId") int vendId,
			@RequestParam("gpStatusList") List<Integer> gpStatusList) {

		List<GetpassItemVen> getpassHeader = new ArrayList<>();

		try {
			if (vendId != 0 && !gpStatusList.contains(0)) {
				getpassHeader = getpassItemVenRepo.getpassListByVendIdAndStatus(vendId, gpStatusList);

			} else if (vendId == 0 && !gpStatusList.contains(0)) {
				getpassHeader = getpassItemVenRepo.getpassListByStatus(gpStatusList);
			} else if (vendId != 0 && gpStatusList.contains(0)) {
				getpassHeader = getpassItemVenRepo.getpassListByVendId(vendId);
			} else {
				getpassHeader = getpassItemVenRepo.getpassAllList();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getpassHeader;

	}

	// --------------Return Getpass-----------
	@RequestMapping(value = { "/saveGetPassReturnHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody GetpassReturn saveGetPassReturnHeaderDetail(@RequestBody GetpassReturn getpassReturn) {

		GetpassReturn getpassReturnRes = new GetpassReturn();

		try {

			getpassReturnRes = getpassReturnRepo.saveAndFlush(getpassReturn);

			for (int i = 0; i < getpassReturnRes.getGetpassReturnDetailList().size(); i++)
				getpassReturn.getGetpassReturnDetailList().get(i).setReturnId(getpassReturnRes.getReturnId());

			List<GetpassReturnDetail> getPassReturnDetailList = getpassReturnDetailRepo
					.saveAll(getpassReturn.getGetpassReturnDetailList());
			System.out.println("getPassReturnDetailList" + getPassReturnDetailList.toString());
			getpassReturnRes.setGetpassReturnDetailList(getPassReturnDetailList);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getpassReturnRes;

	}

	@RequestMapping(value = { "/getGetpassReturnItemHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody GetpassReturn getGetpassReturnItemHeaderAndDetail(@RequestParam("returnId") int returnId) {

		GetpassReturn getpassReturn = new GetpassReturn();

		try {

			getpassReturn = getpassReturnRepo.findByReturnId(returnId);
			List<GetpassReturnDetail> getpassReturnDetailList = getpassReturnDetailRepo.findByReturnId(returnId);
			getpassReturn.setGetpassReturnDetailList(getpassReturnDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getpassReturn;

	}

	@RequestMapping(value = { "/deleteGetpassReturn" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteGetpassReturn(@RequestParam("returnId") int returnId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = getpassReturnRepo.deleteGetpassReturn(returnId);

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

	@RequestMapping(value = { "/getGetpassItemHeaderAndDetailWithItemName" }, method = RequestMethod.POST)
	public @ResponseBody GetpassHeaderItemName getGetpassItemHeaderAndDetailWithItemName(
			@RequestParam("gpId") int gpId) {

		GetpassHeaderItemName getpassHeader = new GetpassHeaderItemName();

		try {

			getpassHeader = getpassHeaderItemNameRepo.getAllHeaderItemByGpId(gpId);
			List<GetpassDetailItemName> getpassDetailList = getpassDetailItemNameRepo.getAllItemByGpId(gpId);
			getpassHeader.setGetpassDetailItemNameList(getpassDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getpassHeader;

	}

	@RequestMapping(value = { "/saveGatePassDetailList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetpassDetail> saveGatePassDetail(@RequestBody List<GetpassDetail> getpassDetailList) {
		System.err.println("Inside Save Gate Pass Item ");
		List<GetpassDetail> detailList = new ArrayList<>();

		try {
			int gpId = getpassDetailList.get(0).getGpId();
			for (int i = 0; i < getpassDetailList.size(); i++) {
				GetpassDetail res = getpassDetailRepo.save(getpassDetailList.get(i));
				detailList.add(res);
			}
			// Query
			int count = getpassDetailRepo.getpassDetailCount(gpId);
			if (count == 0) {
				int r = getpassHeaderRepo.updateGetpassHeaderStatus(gpId);
				System.out.println("R" + r);
			}

		} catch (Exception e) {

			System.err.println("exce in saving get pass item " + e.getMessage());

			e.printStackTrace();

		}
		return detailList;

	}

	@RequestMapping(value = { "/getGetpassReturnVendor" }, method = RequestMethod.POST)
	public @ResponseBody List<GetpassReturnVendor> getGetpassReturnVendor(@RequestParam("vendId") int vendId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetpassReturnVendor> getpassReturnVendor = new ArrayList<>();

		try {
			if (vendId == 0) {
				getpassReturnVendor = getpassReturnVendorRepo.getAllHeaderWithVendor(fromDate, toDate);

			} else {
				getpassReturnVendor = getpassReturnVendorRepo.getAllHeaderByVendId(fromDate, toDate, vendId);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getpassReturnVendor;

	}

}
