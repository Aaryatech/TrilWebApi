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
import com.ats.tril.model.PoDetail;
import com.ats.tril.model.indent.DashIndentDetails;
import com.ats.tril.model.indent.GetIndents;
import com.ats.tril.model.mrn.GetMrnDetail;
import com.ats.tril.model.mrn.GetMrnHeader;
import com.ats.tril.model.mrn.MrnDetail;
import com.ats.tril.model.mrn.MrnHeader;
import com.ats.tril.model.rejection.RejectionMemo;
import com.ats.tril.model.rejection.RejectionMemoDetail;
import com.ats.tril.repository.PoDetailRepository;
import com.ats.tril.repository.PoHeaderRepository;
import com.ats.tril.repository.mrn.GetMrnDetailRepository;
import com.ats.tril.repository.mrn.GetMrnHeaderRepository;
import com.ats.tril.repository.mrn.MrnDetailRepo;
import com.ats.tril.repository.mrn.MrnHeaderRepository;

@RestController
public class MrnApiController {

	@Autowired
	MrnHeaderRepository mrnHeaderRepository;

	@Autowired
	MrnDetailRepo mrnDetailRepo;

	@Autowired
	GetMrnHeaderRepository getMrnHeaderRepository;

	@Autowired
	GetMrnDetailRepository getMrnDetailRepository;

	@Autowired
	PoDetailRepository poDetailRepo;
	@Autowired
	PoHeaderRepository poHeaderRepository;

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
				MrnDetail mrnDetailRes = mrnDetailRepo.save(detail);

				PoDetail poDetail = poDetailRepo.findByPoDetailId(mrnDetailRes.getPoDetailId());

				if (mrnDetailRes != null) {
					int remainingQty=0;
					
					if(detail.getMrnQtyBeforeEdit()==-1) {
						
						System.err.println("Inside mrn qty before Edit ==-1");
						
						 remainingQty = poDetail.getPendingQty() - mrnDetailRes.getMrnQty();
					
					}else {
						
						System.err.println("Inside mrn qty before edit is greater than 0");
						 remainingQty = poDetail.getPendingQty() -(detail.getMrnQtyBeforeEdit()- mrnDetailRes.getMrnQty());

					}
					
					poDetail.setPendingQty(remainingQty);
					int status = 1;

					if (remainingQty == 0) {
						System.err.println("Pending qty =0 keeping status=2");
						status = 2;
					}

					poDetail.setStatus(status);
					PoDetail poDetailStatusUpdate = poDetailRepo.save(poDetail);
					// int detailStatusUpdate=poDetailRepo.updateResponse(remainingQty, status,
					// mrnDetailRes.getPoDetailId());

					List<PoDetail> poDetailsList = poDetailRepo.findAllByStatusNotAndPoId(2, mrnDetailRes.getPoId());

					if (poDetailsList.isEmpty()) {

						System.err.println("Po Detail list is Empty so Update po Header Status for POId "
								+ mrnDetailRes.getPoId());

						int updateMrnHeaderStatus = poHeaderRepository.updateResponsePoHead(2, mrnDetailRes.getPoId());

					}

				}

			}

		} catch (Exception e) {

			System.err.println("Exception in saving Mrn Header and Detail  " + e.getMessage());
			e.printStackTrace();

		}

		return res;
	}

	@RequestMapping(value = { "/getMrnHeaderList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMrnHeader> getMrnHeaderList(@RequestParam("venId") List<Integer> venId,
			@RequestParam("status") List<Integer> status) {

		List<GetMrnHeader> mrnHeaderList = new ArrayList<GetMrnHeader>();

		try {
			if (venId.contains(0) && !status.contains(0)) {
				mrnHeaderList = getMrnHeaderRepository.getMrnHeaderListByStatus(status);
			} else if (!venId.contains(0) && status.contains(0)) {

				mrnHeaderList = getMrnHeaderRepository.getMrnHeaderListByVenId(venId);

			} else if (!venId.contains(0) && !status.contains(0)) {

				mrnHeaderList = getMrnHeaderRepository.getMrnHeaderListByVenIdAndStatus(venId, status);
			} else if (venId.contains(0) && status.contains(0)) {

				mrnHeaderList = getMrnHeaderRepository.getAllMrnHeaderList();
			}
			if (mrnHeaderList.size() > 0) {
				for (int i = 0; i < mrnHeaderList.size(); i++) {
					List<GetMrnDetail> getMrnDetailList = getMrnDetailRepository
							.getMrnDetailList(mrnHeaderList.get(i).getMrnId(), 0);

					mrnHeaderList.get(i).setGetMrnDetailList(getMrnDetailList);
				}
			}
		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeaderList;

	}

	@RequestMapping(value = { "/saveMrnData" }, method = RequestMethod.POST)
	public @ResponseBody List<MrnDetail> saveMrnData(@RequestBody List<MrnDetail> getMrnDetailList) {
		List<MrnDetail> res = new ArrayList<>();

		try {

			int mrnId = getMrnDetailList.get(0).getMrnId();
			boolean flag = false;
			for (int i = 0; i < getMrnDetailList.size(); i++) {

				MrnDetail mrnDetail = new MrnDetail();
				mrnDetail.setMrnDetailId(getMrnDetailList.get(i).getMrnDetailId());
				mrnDetail.setApproveQty(getMrnDetailList.get(i).getApproveQty());
				mrnDetail.setBatchNo(getMrnDetailList.get(i).getBatchNo());
				mrnDetail.setDelStatus(getMrnDetailList.get(i).getDelStatus());
				mrnDetail.setIndentQty(getMrnDetailList.get(i).getIndentQty());
				mrnDetail.setIssueQty(getMrnDetailList.get(i).getIssueQty());
				mrnDetail.setItemId(getMrnDetailList.get(i).getItemId());
				mrnDetail.setMrnDetailStatus(getMrnDetailList.get(i).getMrnDetailStatus());
				mrnDetail.setMrnId(getMrnDetailList.get(i).getMrnId());
				mrnDetail.setMrnQty(getMrnDetailList.get(i).getMrnQty());
				mrnDetail.setPoId(getMrnDetailList.get(i).getPoId());
				mrnDetail.setPoNo(getMrnDetailList.get(i).getPoNo());
				mrnDetail.setPoQty(getMrnDetailList.get(i).getPoQty());
				mrnDetail.setRejectQty(getMrnDetailList.get(i).getRejectQty());
				mrnDetail.setRejectRemark(getMrnDetailList.get(i).getRejectRemark());
				mrnDetail.setRemainingQty(getMrnDetailList.get(i).getRemainingQty());
				mrnDetail.setMrnDetailStatus(1);
				mrnDetail.setMrnId(getMrnDetailList.get(i).getMrnId());
				MrnDetail transRes = mrnDetailRepo.save(mrnDetail);
				flag = true;
				res.add(transRes);
			}
			if (flag == true) {
				int isUpdated = mrnHeaderRepository.updateMrnStatusAsPartial(mrnId);
			}
			int count = mrnDetailRepo.getDetailCount(mrnId);
			System.err.println(count);
			if (count == 0) {
				int isUpdated = mrnHeaderRepository.updateMrnStatus(mrnId);
			}

		} catch (Exception e) {

			System.err.println("Exception in saving Mrn Header and Detail  " + e.getMessage());
			e.printStackTrace();

		}

		return res;
	}

	@RequestMapping(value = { "/getMrnHeaderByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMrnHeader> getMrnHeaderByDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetMrnHeader> mrnHeaderList = new ArrayList<GetMrnHeader>();

		try {
			mrnHeaderList = getMrnHeaderRepository.getMrnHeaderByDate(fromDate, toDate);
			System.err.println("mrn Head List by Date =  " + mrnHeaderList.toString());

		} catch (Exception e) {

			System.err.println("Exception in getMrnHeaderByDate Mrn  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeaderList;

	}

	@RequestMapping(value = { "/getMrnDetailByMrnId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMrnDetail> getMrnDetailByMrnId(@RequestParam("mrnId") int mrnId) {

		List<GetMrnDetail> mrnDetailList = new ArrayList<GetMrnDetail>();

		try {
			mrnDetailList = getMrnDetailRepository.getMrnDetailByMrnId(mrnId);
			System.err.println("mrn mrnDetailList List by MrnId =  " + mrnDetailList.toString());

		} catch (Exception e) {

			System.err.println("Exception in getMrnDetailByMrnId Mrn  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnDetailList;

	}
	
	

	@RequestMapping(value = { "/getMrnList" }, method = RequestMethod.GET)
	public @ResponseBody List<MrnHeader> getMrnList() {

		List<MrnHeader> mrnHeaderList = new ArrayList<MrnHeader>();

		try {

			mrnHeaderList = mrnHeaderRepository.findAllByDelStatus(1);

		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeaderList;

	}

	@RequestMapping(value = { "/getMrnHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMrnHeader> getMrnHeaderDetail(@RequestParam("status") List<Integer> status) {

		List<GetMrnHeader> mrnHeaderList = new ArrayList<GetMrnHeader>();

		try {

			mrnHeaderList = getMrnHeaderRepository.getMrnHeaderByList(status);
			List<GetMrnDetail> getMrnDetailList = getMrnDetailRepository.getMrnDetailByList(status);
			
			for (int i = 0; i < mrnHeaderList.size(); i++) {

				List<GetMrnDetail> detailsList = new ArrayList<>();

				int mrnId = mrnHeaderList.get(i).getMrnId();

				for (int j = 0; j < getMrnDetailList.size(); j++) {

					int detailMRNId= getMrnDetailList.get(j).getMrnId();
					
					if(detailMRNId==mrnId) {
						

						detailsList.add(getMrnDetailList.get(j));
					}
					
					
				}
				
				mrnHeaderList.get(i).setGetMrnDetailList(detailsList);
				
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return mrnHeaderList;

	}
	
	
	@RequestMapping(value = { "/deleteMrnHeader" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteMrnHeader(@RequestParam("mrnId") int mrnId) {
		System.err.println("inside web api  deleteMrnHeader");
		ErrorMessage errMsg = new ErrorMessage();

		try {

			int delRes = mrnHeaderRepository.deleteMrnHeader(mrnId);
			
			if(delRes>0) {
				errMsg.setError(false);
				errMsg.setMessage("Mrn Header deleted Successfull");
			}else {
				errMsg.setError(true);
				errMsg.setMessage("Mrn Header delete failed ");
			}
			

		} catch (Exception e) {

			System.err.println("Exception in deleteMrnHeader  " + e.getMessage());
			e.printStackTrace();

		}

		return errMsg;
	}
	
	
	@RequestMapping(value = { "/deleteMrnDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteMrnDetail(@RequestParam("mrnDetailId") int mrnDetailId) {
		System.err.println("inside web api  deleteMrnDetail");
		ErrorMessage errMsg = new ErrorMessage();

		try {

			int delRes = mrnDetailRepo.deleteMrnDetail(mrnDetailId);
			
			if(delRes>0) {
				errMsg.setError(false);
				errMsg.setMessage("Mrn Detail deleted Successfull");
			}else {
				errMsg.setError(true);
				errMsg.setMessage("Mrn Detail delete failed ");
			}
			

		} catch (Exception e) {

			System.err.println("Exception in deleteMrnHeader  " + e.getMessage());
			e.printStackTrace();

		}

		return errMsg;
	}


}
