package com.ats.tril.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.common.DateConvertor;
import com.ats.tril.model.IssueAndMrnGroupWise;
import com.ats.tril.model.IssueAndMrnItemWise;
import com.ats.tril.model.ItemQtyWithRecieptNo;
import com.ats.tril.model.ItemValuationList;
import com.ats.tril.model.StockValuationCategoryWise;
import com.ats.tril.repository.IssueAndMrnGroupWiseRepository;
import com.ats.tril.repository.IssueAndMrnItemWiseRepository;
import com.ats.tril.repository.ItemQtyWithRecieptNoRepository;
import com.ats.tril.repository.StockValuationCategoryWiseRepository; 

@RestController
public class ValueationRestController {
	
	@Autowired
	ItemQtyWithRecieptNoRepository itemQtyWithRecieptNoRepository;
	
	@Autowired
	StockValuationCategoryWiseRepository stockValuationCategoryWiseRepository;
	
	@Autowired
	IssueAndMrnGroupWiseRepository issueAndMrnGroupWiseRepository;
	
	@Autowired
	IssueAndMrnItemWiseRepository issueAndMrnItemWiseRepository;
	
	@RequestMapping(value = { "/valueationReportDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemValuationList> valueationReportDetail(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("itemId") int itemId) {
		
		 List<ItemValuationList> finalList = new  ArrayList<ItemValuationList>();

		try {
			 
		 
			 

					 List<Date> dates = new ArrayList<Date>(); 
					 DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
					 Date  startDate = (Date)formatter.parse(fromDate); 
					 Date  endDate = (Date)formatter.parse(toDate);

					 long interval = 24*1000 * 60 * 60; 
					 long endTime =endDate.getTime() ; 
					 long curTime = startDate.getTime();

					 while (curTime <= endTime) {

					     dates.add(new Date(curTime)); 
					     curTime += interval;

					 }

					 for(int i=0;i<dates.size();i++){

					     Date lDate =(Date)dates.get(i); 
					     String ds = formatter.format(lDate);
 
					     List<ItemQtyWithRecieptNo> getMrnDataByDate = new ArrayList<>(); 
					     getMrnDataByDate = itemQtyWithRecieptNoRepository.getMrnDataByDate(DateConvertor.convertToYMD(ds),itemId); 
					     for(int j = 0 ; j< getMrnDataByDate.size() ; j++)
					     {
					    	 ItemValuationList itemValuationList = new ItemValuationList();
					    	 itemValuationList.setDate(ds);
					    	 itemValuationList.setTypeName("MRN APPROVED QTY");
					    	 itemValuationList.setReceptNo(getMrnDataByDate.get(j).getReceptNo());
					    	 itemValuationList.setQty(getMrnDataByDate.get(j).getQty());
					    	 itemValuationList.setType(1);
					    	 finalList.add(itemValuationList);
					     }
					     
					     List<ItemQtyWithRecieptNo> getIssueDataByDate = new ArrayList<>(); 
					     getIssueDataByDate = itemQtyWithRecieptNoRepository.getIssueDataByDate(DateConvertor.convertToYMD(ds),itemId); 
					     for(int j = 0 ; j< getIssueDataByDate.size() ; j++)
					     {
					    	 ItemValuationList itemValuationList = new ItemValuationList();
					    	 itemValuationList.setDate(ds);
					    	 itemValuationList.setTypeName("ISSUE QTY");
					    	 itemValuationList.setReceptNo(getIssueDataByDate.get(j).getReceptNo());
					    	 itemValuationList.setQty(getIssueDataByDate.get(j).getQty());
					    	 itemValuationList.setType(0);
					    	 finalList.add(itemValuationList);
					     }
					     
					     List<ItemQtyWithRecieptNo> getDamageDataByDate = new ArrayList<>(); 
					     getDamageDataByDate = itemQtyWithRecieptNoRepository.getDamageDataByDate(DateConvertor.convertToYMD(ds),itemId); 
					     for(int j = 0 ; j< getDamageDataByDate.size() ; j++)
					     {
					    	 ItemValuationList itemValuationList = new ItemValuationList();
					    	 itemValuationList.setDate(ds);
					    	 itemValuationList.setTypeName("DAMAGE QTY");
					    	 itemValuationList.setReceptNo(getDamageDataByDate.get(j).getReceptNo());
					    	 itemValuationList.setQty(getDamageDataByDate.get(j).getQty());
					    	 itemValuationList.setType(0);
					    	 finalList.add(itemValuationList);
					     }
					     
					     /*List<ItemQtyWithRecieptNo> getReturnGatePassDataByDate = new ArrayList<>(); 
					     getReturnGatePassDataByDate = itemQtyWithRecieptNoRepository.getReturnGatePassDataByDate(DateConvertor.convertToYMD(ds),itemId); 
					     for(int j = 0 ; j< getReturnGatePassDataByDate.size() ; j++)
					     {
					    	 ItemValuationList itemValuationList = new ItemValuationList();
					    	 itemValuationList.setDate(ds);
					    	 itemValuationList.setTypeName("RETURN GATEPASS QTY");
					    	 itemValuationList.setReceptNo(getReturnGatePassDataByDate.get(j).getReceptNo());
					    	 itemValuationList.setQty(getReturnGatePassDataByDate.get(j).getQty());
					    	 itemValuationList.setType(1);
					    	 finalList.add(itemValuationList);
					     }*/

					 }
					 
					 System.out.println("finalList   "  + finalList);
 
				 
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}
	
	@RequestMapping(value = { "/stockValueationReport" }, method = RequestMethod.POST)
	public @ResponseBody List<StockValuationCategoryWise> stockValueationReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId) {
		
		 List<StockValuationCategoryWise> finalList = new  ArrayList<StockValuationCategoryWise>();

		try {
			  
					  if(typeId==0) {
						  finalList = stockValuationCategoryWiseRepository.stockValueationReport(fromDate,toDate);  
					  }
					  else {
						  finalList = stockValuationCategoryWiseRepository.stockValueationReport(fromDate,toDate,typeId); 
					  }
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}
	
	@RequestMapping(value = { "/issueAndMrnCatWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<StockValuationCategoryWise> issueAndMrnCatWiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId,@RequestParam("isDev") int isDev) {
		
		 List<StockValuationCategoryWise> finalList = new  ArrayList<StockValuationCategoryWise>();

		try {
			  
					  
					  if(typeId!=0 && isDev!=-1){
						  finalList = stockValuationCategoryWiseRepository.issueAndMrnCatWiseReport(fromDate,toDate,typeId,isDev); 
					  }
					  else if(typeId!=0 && isDev==-1) {
						  finalList = stockValuationCategoryWiseRepository.issueAndMrnCatWiseReport(fromDate,toDate,typeId); 
					  }
					  else if(typeId==0 && isDev!=-1){
						  finalList = stockValuationCategoryWiseRepository.issueAndMrnCatWiseReportWithIsDev(fromDate,toDate,isDev); 
					  }
					  else{
						  finalList = stockValuationCategoryWiseRepository.issueAndMrnCatWiseReport(fromDate,toDate);  
					  }
					   
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}
	
	@RequestMapping(value = { "/issueAndMrnGroupWisReportByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueAndMrnGroupWise> issueAndMrnGroupWisReportByCatId(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId,@RequestParam("isDev") int isDev,
			@RequestParam("catId") int catId) {
		
		 List<IssueAndMrnGroupWise> finalList = new  ArrayList<IssueAndMrnGroupWise>();

		try {
			   
					  if(typeId!=0 && isDev!=-1){
						  finalList = issueAndMrnGroupWiseRepository.issueAndMrnGroupWisReportByCatId(fromDate,toDate,typeId,isDev,catId); 
					  }
					  else if(typeId!=0 && isDev==-1) {
						  finalList = issueAndMrnGroupWiseRepository.issueAndMrnGroupWisReportByCatIdWithAllDevelopment(fromDate,toDate,typeId,catId); 
					  }
					  else if(typeId==0 && isDev!=-1){
						  finalList = issueAndMrnGroupWiseRepository.issueAndMrnGroupWisReportByCatIdWithAllType(fromDate,toDate,isDev,catId); 
					  }
					  else{
						  finalList = issueAndMrnGroupWiseRepository.issueAndMrnGroupWisReportByCatId(fromDate,toDate,catId);  
					  }
					   
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}
	
	@RequestMapping(value = { "/issueAndMrnItemWiseReportByGroupId" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueAndMrnItemWise> issueAndMrnItemWiseReportByGroupId(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId,@RequestParam("isDev") int isDev,
			@RequestParam("groupId") int groupId) {
		
		 List<IssueAndMrnItemWise> finalList = new  ArrayList<IssueAndMrnItemWise>();

		try {
			   
					  if(typeId!=0 && isDev!=-1){
						  finalList = issueAndMrnItemWiseRepository.issueAndMrnItemWiseReportByGroupIdWithTypeIdAndIsDev(fromDate,toDate,typeId,isDev,groupId); 
					  }
					  else if(typeId!=0 && isDev==-1) {
						  finalList = issueAndMrnItemWiseRepository.issueAndMrnGroupWisReportByGroupWithAllDevelopment(fromDate,toDate,typeId,groupId); 
					  }
					  else if(typeId==0 && isDev!=-1){
						  finalList = issueAndMrnItemWiseRepository.issueAndMrnGroupWisReportByCatIdWithAllType(fromDate,toDate,isDev,groupId); 
					  }
					  else{
						  finalList = issueAndMrnItemWiseRepository.issueAndMrnGroupWisReportByCatId(fromDate,toDate,groupId);  
					  }
					   
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}

}
