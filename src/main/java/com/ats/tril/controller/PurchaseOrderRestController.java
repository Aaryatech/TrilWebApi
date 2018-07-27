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
import com.ats.tril.model.GetPODetail;
import com.ats.tril.model.GetPoDetailList;
import com.ats.tril.model.GetPoHeaderList;
import com.ats.tril.model.PoDetail;
import com.ats.tril.model.PoHeader;
import com.ats.tril.repository.GetPoDetailListRepository;
import com.ats.tril.repository.GetPoHeaderListRepository;
import com.ats.tril.repository.PoDetailRepository;
import com.ats.tril.repository.PoHeaderRepository;
import com.ats.tril.repository.getpodetail.GetPODetailRepo;

@RestController
public class PurchaseOrderRestController {

	@Autowired
	PoHeaderRepository poHeaderRepository;

	@Autowired
	PoDetailRepository poDetailRepository;

	@Autowired
	GetPODetailRepo getPODetailRepo;

	@Autowired
	GetPoHeaderListRepository getPoHeaderListRepository;

	@Autowired
	GetPoDetailListRepository getPoDetailListRepository;

	@RequestMapping(value = { "/getPODetailList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPODetail> getPODetails(@RequestParam("poIdList") List<Integer> poIdList) {

		System.err.println("Inside getPODetailList ");
		List<GetPODetail> poDetailList = new ArrayList<GetPODetail>();

		try {

			poDetailList = getPODetailRepo.getPoDetailsByPoIds(poIdList);
			System.err.println("poDetailList  " + poDetailList.toString());

		} catch (Exception e) {

			System.err.println("Exception /getPODetailList @PurchaseOrderRestControlle ");

			e.printStackTrace();

		}
		return poDetailList;

	}

	// Sachin 12-07-2018
	@RequestMapping(value = { "/getPOHeaderList" }, method = RequestMethod.POST)
	public @ResponseBody List<PoHeader> getPOHeaderList(@RequestParam("vendId") int vendId,
			@RequestParam("delStatus") int delStatus, @RequestParam("statusList") List<Integer> statusList) {

		List<PoHeader> poHeaderList = new ArrayList<PoHeader>();

		try {

			poHeaderList = poHeaderRepository.findByVendIdAndDelStatusAndPoStatusIn(vendId, delStatus, statusList);

		} catch (Exception e) {

			System.err.println("Exception /getPOHeaderList @PurchaseOrderRestControlle ");

			e.printStackTrace();

		}
		return poHeaderList;

	}

	@RequestMapping(value = { "/savePoHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody PoHeader savePoHeaderAndDetail(@RequestBody PoHeader poHeader) {

		PoHeader save = new PoHeader();

		try {

			save = poHeaderRepository.save(poHeader);

			for (int i = 0; i < poHeader.getPoDetailList().size(); i++) {
				poHeader.getPoDetailList().get(i).setPoId(save.getPoId());
				poHeader.getPoDetailList().get(i).setVendId(save.getVendId());
			}

			List<PoDetail> poDetailList = poDetailRepository.saveAll(poHeader.getPoDetailList());
			save.setPoDetailList(poDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return save;

	}

	@RequestMapping(value = { "/deletePo" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deletePo(@RequestParam("poId") int poId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			int delete = poHeaderRepository.delete(poId);
			if (delete != 0) {
				errorMessage.setError(false);
				errorMessage.setMessage("deleted");
			} else {
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

	@RequestMapping(value = { "/getPoHeaderListBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoHeaderList> getPoHeaderListBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetPoHeaderList> list = new ArrayList<GetPoHeaderList>();

		try {

			list = getPoHeaderListRepository.getPoHeaderListBetweenDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@RequestMapping(value = { "/getPoHeaderAndDetailByHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody GetPoHeaderList getPoHeaderAndDetailByHeaderId(@RequestParam("poId") int poId) {

		GetPoHeaderList getPoHeaderList = new GetPoHeaderList();

		try {

			getPoHeaderList = getPoHeaderListRepository.getPoHeaderAndDetailByHeaderId(poId);

			List<GetPoDetailList> poDetailList = getPoDetailListRepository.getDetail(poId);
			getPoHeaderList.setPoDetailList(poDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getPoHeaderList;

	}

	@RequestMapping(value = { "/getPoHeaderListReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoHeaderList> getPoHeaderListReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("vendorIdList") List<Integer> vendorIdList,
			@RequestParam("poTypeList") List<Integer> poTypeList, @RequestParam("poStatus") List<Integer> poStatus) {

		List<GetPoHeaderList> list = new ArrayList<GetPoHeaderList>();

		try {
			if (vendorIdList.contains(0) && poTypeList.contains(0) && poStatus.contains(0)) {

				list = getPoHeaderListRepository.getPoHeaderListBetweenDate(fromDate, toDate);
			} else if (vendorIdList.contains(0) && poTypeList.contains(0) && !poStatus.contains(0)) {

				list = getPoHeaderListRepository.getPoHeaderByStatus(fromDate, toDate, poStatus);
			} else if (vendorIdList.contains(0) && !poTypeList.contains(0) && !poStatus.contains(0)) {

				list = getPoHeaderListRepository.getPoHeaderByStatusAndPoTypeList(fromDate, toDate, poStatus,
						poTypeList);
			} else if (!vendorIdList.contains(0) && poTypeList.contains(0) && !poStatus.contains(0)) {

				list = getPoHeaderListRepository.getPoHeaderByVendorAndPoType(fromDate, toDate, vendorIdList,
						poTypeList);
			}

			else if (!vendorIdList.contains(0) && poTypeList.contains(0) && poStatus.contains(0)) {

				list = getPoHeaderListRepository.getPoHeaderByVendor(fromDate, toDate, vendorIdList);
			}

			else if (!vendorIdList.contains(0) && !poTypeList.contains(0) && poStatus.contains(0)) {

				list = getPoHeaderListRepository.getPoHeaderByVendorAndPoTypeList(fromDate, toDate, vendorIdList,
						poTypeList);
			}

			else {

				list = getPoHeaderListRepository.getPoHeaderByStatusAndPoTypeAndVendorList(fromDate, toDate, poStatus,
						poTypeList, vendorIdList);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

}
