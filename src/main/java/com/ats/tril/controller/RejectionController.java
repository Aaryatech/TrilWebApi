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
import com.ats.tril.model.GetpassDetail;
import com.ats.tril.model.GetpassHeader;
import com.ats.tril.model.rejection.RejectionMemo;
import com.ats.tril.model.rejection.RejectionMemoDetail;
import com.ats.tril.model.rejection.repo.RejectionMemoDetailRepo;
import com.ats.tril.model.rejection.repo.RejectionMemoRepo;

@RestController
public class RejectionController {

	@Autowired
	RejectionMemoRepo rejectionMemoRepo;

	@Autowired
	RejectionMemoDetailRepo rejectionMemoDetailRepo;

	@RequestMapping(value = { "/saveRejectionMemoHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody RejectionMemo saveRejectionMemoHeaderDetail(@RequestBody RejectionMemo rejectionMemo) {
		RejectionMemo rejMemo = new RejectionMemo();

		try {

			rejMemo = rejectionMemoRepo.saveAndFlush(rejectionMemo);

			for (int i = 0; i < rejMemo.getRejectionMemoDetailList().size(); i++)
				rejMemo.getRejectionMemoDetailList().get(i).setRejectionId(rejMemo.getRejectionId());

			List<RejectionMemoDetail> rejectionMemoDetail = rejectionMemoDetailRepo
					.saveAll(rejMemo.getRejectionMemoDetailList());
			System.out.println("rejectionMemoDetail" + rejectionMemoDetail.toString());
			rejMemo.setRejectionMemoDetailList(rejectionMemoDetail);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return rejectionMemo;

	}

	@RequestMapping(value = { "/getRejectionHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody RejectionMemo getGetpassItemHeaderAndDetail(@RequestParam("rejectionId") int rejectionId) {

		RejectionMemo rejectionMemo = new RejectionMemo();

		try {

			rejectionMemo = rejectionMemoRepo.findByRejectionId(rejectionId);
			List<RejectionMemoDetail> rejectionMemoDetailList = rejectionMemoDetailRepo.findByRejectionId(rejectionId);
			rejectionMemo.setRejectionMemoDetailList(rejectionMemoDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rejectionMemo;

	}

	@RequestMapping(value = { "/deleteRejectionMemo" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteRejectionMemo(@RequestParam("gpId") int gpId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = rejectionMemoRepo.deleteRejectionMemo(gpId);

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

}
