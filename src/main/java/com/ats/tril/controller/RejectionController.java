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
import com.ats.tril.model.GetpassDetail;
import com.ats.tril.model.GetpassHeader;
import com.ats.tril.model.mrn.GetMrnHeader;
import com.ats.tril.model.rejection.GetRejectionMemo;
import com.ats.tril.model.rejection.GetRejectionMemoDetail;
import com.ats.tril.model.rejection.RejectionMemo;
import com.ats.tril.model.rejection.RejectionMemoDetail;
import com.ats.tril.model.rejection.repo.GetRejectionMemoDetailRepo;
import com.ats.tril.model.rejection.repo.GetRejectionMemoRepo;
import com.ats.tril.model.rejection.repo.RejectionMemoDetailRepo;
import com.ats.tril.model.rejection.repo.RejectionMemoRepo;

@RestController
public class RejectionController {

	@Autowired
	RejectionMemoRepo rejectionMemoRepo;

	@Autowired
	GetRejectionMemoRepo getRejectionMemoRepo;

	@Autowired
	GetRejectionMemoDetailRepo getRejectionMemoDetailRepo;

	@Autowired
	RejectionMemoDetailRepo rejectionMemoDetailRepo;

	@RequestMapping(value = { "/saveRejectionMemoHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<RejectionMemo> saveRejectionMemoHeaderDetail(
			@RequestBody List<RejectionMemo> rejectionMemoList) {
		RejectionMemo rejMemo = new RejectionMemo();

		try {
			for (int j = 0; j < rejectionMemoList.size(); j++) {

				rejMemo = rejectionMemoRepo.saveAndFlush(rejectionMemoList.get(j));
				System.out.println("List" + rejMemo);
				for (int i = 0; i < rejectionMemoList.get(j).getRejectionMemoDetailList().size(); i++)
					rejectionMemoList.get(j).getRejectionMemoDetailList().get(i).setRejectionId(rejMemo.getRejectionId());

				List<RejectionMemoDetail> rejectionMemoDetail = rejectionMemoDetailRepo
						.saveAll(rejectionMemoList.get(j).getRejectionMemoDetailList());
				System.out.println("rejectionMemoDetail" + rejectionMemoDetail.toString());
				rejMemo.setRejectionMemoDetailList(rejectionMemoDetail);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return rejectionMemoList;

	}

	@RequestMapping(value = { "/getRejectionHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody GetRejectionMemo getGetpassItemHeaderAndDetail(@RequestParam("rejectionId") int rejectionId) {

		GetRejectionMemo rejectionMemo = new GetRejectionMemo();

		try {

			rejectionMemo = getRejectionMemoRepo.getRejectionMemoById(rejectionId);
			List<GetRejectionMemoDetail> rejectionMemoDetailList = getRejectionMemoDetailRepo
					.getRejectionMemoDetailById(rejectionId);
			rejectionMemo.setGetRejectionMemoDetail(rejectionMemoDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rejectionMemo;

	}

	@RequestMapping(value = { "/deleteRejectionMemo" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteRejectionMemo(@RequestParam("rejectionId") int rejectionId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = rejectionMemoRepo.deleteRejectionMemo(rejectionId);

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

	@RequestMapping(value = { "/getRejectionMemoByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRejectionMemo> getRejectionMemoByDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetRejectionMemo> rejectionMemoList = new ArrayList<GetRejectionMemo>();

		try {
			rejectionMemoList = getRejectionMemoRepo.getRejectionMemoByDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return rejectionMemoList;

	}

}
