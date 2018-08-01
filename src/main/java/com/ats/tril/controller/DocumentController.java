package com.ats.tril.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.Dept;
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
	
	@RequestMapping(value = { "/getDocumentData" }, method = RequestMethod.POST)
	public @ResponseBody DocumentBean getDocumentData(@RequestParam("docId") int docId,@RequestParam("date") String date,@RequestParam("catId") int catId) {

		DocumentBean documentBean = null;
		try {
			
			documentBean = documentBeanRepository.findByDocIdAndDate(docId,date);
            
			if(documentBean!=null) {
			
            	SubDocument subDocumentRes=subDocumentRepository.findByMIdAndCatIdAndDelStatus(documentBean.getId(),catId,0);
			    documentBean.setSubDocument(subDocumentRes);
            
            }
		
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
	public @ResponseBody DocumentBean postDocumentData(@RequestParam("docId") int docId,@RequestParam("date") String date,@RequestParam("catId") int catId) {

		DocumentBean documentBean = null;
		try {
			
			documentBean = documentBeanRepository.findByDocIdAndDate(docId,date);
            
			if(documentBean!=null) {
			
            	SubDocument subDocumentRes=subDocumentRepository.findByMIdAndCatIdAndDelStatus(documentBean.getId(),catId,0);
            	subDocumentRepository.save(subDocumentRes);
            	documentBean.setSubDocument(subDocumentRes);
            
            }
		
		} catch (Exception e) {

			e.printStackTrace();

		}
		return documentBean;

	}
}