package com.ats.tril.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.Dept;
import com.ats.tril.model.ErrorMessage;
import com.ats.tril.model.FinancialYears;
import com.ats.tril.model.doc.DocumentBean;
import com.ats.tril.model.doc.SubDocument;
import com.ats.tril.repository.doc.DocumentBeanRepository;
import com.ats.tril.repository.doc.SubDocumentRepository;

@RestController
public class DocumentController {

	@Autowired
	DocumentBeanRepository documentBeanRepository;

	@Autowired
	SubDocumentRepository subDocumentRepository;

	
	//sachin 21 aug 2018
	@RequestMapping(value = { "/getDocumentInfo" }, method = RequestMethod.POST)
	public @ResponseBody DocumentBean getDocumentInfo(@RequestParam("docId") int docId,
			@RequestParam("date") String date) {

		DocumentBean documentBean = null;
		try {

			documentBean = documentBeanRepository.findByDocIdAndDate(docId, date);

			
		}catch (Exception e) {
			
			System.err.println("Exception in getting /getDocumentInfo " +e.getMessage());
			
			e.printStackTrace();
			
		}
		return documentBean;
	}
	
	@RequestMapping(value = { "/getDocumentData" }, method = RequestMethod.POST)
	public @ResponseBody DocumentBean getDocumentData(@RequestParam("docId") int docId,
			@RequestParam("date") String date, @RequestParam("catId") int catId, @RequestParam("typeId") int typeId) {

		DocumentBean documentBean = null;
		try {

			documentBean = documentBeanRepository.findByDocIdAndDate(docId, date);

			if (documentBean != null) {

				SubDocument subDocumentRes = subDocumentRepository.findByMIdAndCatIdAndDelStatusAndDocId(documentBean.getId(),
						catId, 0,typeId);
				documentBean.setSubDocument(subDocumentRes);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return documentBean;

	}

	@RequestMapping(value = { "/getDocumentDataForPO" }, method = RequestMethod.POST)
	public @ResponseBody DocumentBean getDocumentDataForPO(@RequestParam("date") String date) {

		DocumentBean documentBean = null;
		try {
			Date now = new Date();

			documentBean = documentBeanRepository.findByDocIdAndDateForPO(date);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return documentBean;

	}

	@RequestMapping(value = { "/getDocumentDataForMrn" }, method = RequestMethod.POST)
	public @ResponseBody DocumentBean getDocumentDataForMrn(@RequestParam("date") String date) {

		DocumentBean documentBean = null;
		try {
			Date now = new Date();

			documentBean = documentBeanRepository.findByDocIdAndDateForMrn(date);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return documentBean;

	}

	@RequestMapping(value = { "/saveSubDoc" }, method = RequestMethod.POST)
	public @ResponseBody SubDocument updateSubDoc(@RequestBody SubDocument subDocument) {

		SubDocument res = new SubDocument();

		try {

			res = subDocumentRepository.saveAndFlush(subDocument);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/postDocumentData" }, method = RequestMethod.POST)
	public @ResponseBody DocumentBean postDocumentData(@RequestParam("docId") int docId,
			@RequestParam("date") String date, @RequestParam("catId") int catId) {

		DocumentBean documentBean = null;
		try {

			documentBean = documentBeanRepository.findByDocIdAndDate(docId, date);

			if (documentBean != null) {

				SubDocument subDocumentRes = subDocumentRepository.findByMIdAndCatIdAndDelStatus(documentBean.getId(),
						catId, 0);
				subDocumentRepository.save(subDocumentRes);
				documentBean.setSubDocument(subDocumentRes);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return documentBean;

	}
	
	@RequestMapping(value = { "/getIndentDocumentForSetting" }, method = RequestMethod.POST)
	public @ResponseBody List<SubDocument> getIndentDocumentForSetting(@RequestParam("docId") int docId,
			@RequestParam("date") String date ) {

		List<SubDocument> list = new ArrayList<SubDocument>();
		 
		try {

			DocumentBean documentBean = documentBeanRepository.findByDocIdAndDate(docId, date);

			if (documentBean != null) {

				 list = subDocumentRepository.findByMIdAndDelStatus(documentBean.getId(),0);
				 
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}
	
	@RequestMapping(value = { "/updateEnabledAndDisabled" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateEnabledAndDisabled(@RequestParam("subDocId") int subDocId,
			@RequestParam("enabled") String enabled, @RequestParam("limitValue") String limitValue ) {

		ErrorMessage errorMessage = new ErrorMessage();
		 
		try {

			int update = subDocumentRepository.updateEnabledAndDisabled(subDocId, enabled,limitValue);
			
			if (update == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("updated");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("updated Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return errorMessage;

	}
}
