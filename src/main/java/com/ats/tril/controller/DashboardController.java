package com.ats.tril.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.ConsumptionReportData;
import com.ats.tril.model.CurrentDamageDetail;
import com.ats.tril.model.CurrentIssueDetail;
import com.ats.tril.model.CurrentMrnDetail;
import com.ats.tril.model.CurrentOpeningDetail;
import com.ats.tril.model.GetCurrStockRol;
import com.ats.tril.model.GetCurrentStock;
import com.ats.tril.model.GetItem;
import com.ats.tril.model.GetPoHeader;
import com.ats.tril.model.PoHeader;
import com.ats.tril.model.indent.DashIndentDetails;
import com.ats.tril.model.indent.GetIndents;
import com.ats.tril.repository.ConsumptionReportRepository;
import com.ats.tril.repository.CurrentDamageDetailRepository;
import com.ats.tril.repository.CurrentIssueDetailRepository;
import com.ats.tril.repository.CurrentMrnDetailRepository;
import com.ats.tril.repository.CurrentOpeningDetailRepository;
import com.ats.tril.repository.GetCurrentStockHeaderResRepository;
import com.ats.tril.repository.GetItemRepository;
import com.ats.tril.repository.GetPoHeaderRepository;
import com.ats.tril.repository.PoHeaderRepository;
import com.ats.tril.repository.indent.GetIndentRepository;
import com.ats.tril.repository.indent.IndentTransRepository;
import com.ats.tril.repository.stock.GetCurrentStockHeaderRepository;

@RestController
public class DashboardController {

	@Autowired
	GetIndentRepository getIndentRepository;
	
	@Autowired
	IndentTransRepository indentTransRepository;
	
	@Autowired
	GetPoHeaderRepository getPoHeaderRepository;
	
	@Autowired
	ConsumptionReportRepository consumptionReportRepository;
	
	@Autowired
	GetItemRepository getItemRepository;
	
	@Autowired
	GetCurrentStockHeaderRepository getCurrentStockHeaderRepository;
	
	@Autowired
	GetCurrentStockHeaderResRepository getCurrentStockHeaderResRepository;
	
	
	@RequestMapping(value = { "/getIndentList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetIndents> getIndentList(@RequestParam("status") List<Integer> status) {

		List<GetIndents> indentList = new ArrayList<GetIndents>();

		try {
            //System.out.println(status);
			indentList = getIndentRepository.getIndentList(status);
			
			/*for(int i=0;i<indentList.size();i++)
			{ 
				List<DashIndentDetails> dashIndentDetailList =indentTransRepository.findByIndMIdAndIndDStatusIn(indentList.get(i).getIndMId(),status);
				 
				indentList.get(i).setDashIndentDetailList(dashIndentDetailList);
			}*/

			List<DashIndentDetails> dashIndentDetailList =indentTransRepository.findByIndMIdAndIndDStatusIn(status);
			
			
			for(int i=0;i<indentList.size();i++) { 
				
				List<DashIndentDetails> list = new ArrayList<>();
				
				for(int j=0;j<dashIndentDetailList.size();j++) { 
					
					if(indentList.get(i).getIndMId()==dashIndentDetailList.get(j).getIndMId()) {
						
						list.add(dashIndentDetailList.get(j));
					}
					
				}
				
				indentList.get(i).setDashIndentDetailList(list);
				 
			}
			
			//System.err.println("indent List " + indentList.toString());
		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return indentList;

	}
	
	@RequestMapping(value = { "/getPoHeaderDashList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoHeader> getPOHeaderList(@RequestParam("poType") int poType,@RequestParam("status") int status) {

		List<GetPoHeader> poHeaderList = new ArrayList<GetPoHeader>();

		try {

			 
			poHeaderList = getPoHeaderRepository.findByPoTypeAndPoStatusAndDelStatus(poType, status);
				

		} catch (Exception e) {
			
			System.err.println("Exception /getPOHeaderList @PurchaseOrderRestControlle ");

			e.printStackTrace();
			 
		}
		return poHeaderList;

	}
	/*@RequestMapping(value = { "/getConsumptionData" }, method = RequestMethod.POST)
	public @ResponseBody List<ConsumptionReportData> getConsumptionData(@RequestParam("poType") int poType,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {

		List<ConsumptionReportData> consumptionReportData = new ArrayList<ConsumptionReportData>();

		try {

			consumptionReportData = consumptionReportRepository.findByPoTypeAndDate(poType,fromDate,toDate);
				

		} catch (Exception e) {
			

			e.printStackTrace();
			 
		}
		return consumptionReportData;

	}*/
	
	@Autowired
	CurrentOpeningDetailRepository currentOpeningDetailRepository;
	
	@Autowired
	CurrentMrnDetailRepository currentMrnDetailRepository;

	@Autowired
	CurrentIssueDetailRepository currentIssueDetailRepository;
	
	@Autowired
	CurrentDamageDetailRepository currentDamageDetailRepository;
	
	@RequestMapping(value = { "/getItemsLessThanROLForDashB" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCurrStockRol> getItemsLessThanROLForDashB(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		
		List<GetCurrStockRol> getCurrentStock = new ArrayList<GetCurrStockRol>();
		List<GetCurrentStock> getCurrentStock1 = new ArrayList<GetCurrentStock>();
		try {
			
			List<GetItem>  itemList = getItemRepository.getAllItems();

			/*getCurrentStock = getCurrentStockHeaderResRepository.getCurrentStockForDash(fromDate,toDate);
			
			for(int i = 0 ; i<itemList.size() ; i++)
			{
				for(int j = 0 ; j<getCurrentStock.size() ; j++)
				{ 
					if(itemList.get(i).getItemId()==getCurrentStock.get(j).getItemId())
					{
						getCurrentStock.get(j).setItemName(itemList.get(i).getItemDesc());
						getCurrentStock.get(j).setCatId(itemList.get(i).getCatId());
						getCurrentStock.get(j).setItemUom(itemList.get(i).getItemUom());
						getCurrentStock.get(j).setItemMaxLevel(itemList.get(i).getItemMaxLevel());
						getCurrentStock.get(j).setItemMinLevel(itemList.get(i).getItemMinLevel());
						if(itemList.get(i).getItemRodLevel()>(getCurrentStock.get(j).getOpeningStock()+getCurrentStock.get(j).getApproveQty()-
									getCurrentStock.get(j).getIssueQty()+getCurrentStock.get(j).getReturnIssueQty()-getCurrentStock.get(j).getDamageQty()-
									getCurrentStock.get(j).getGatepassQty()+getCurrentStock.get(j).getGatepassReturnQty()) && itemList.get(i).getItemRodLevel()>0)
							
						{
							getCurrentStock.get(j).setRolLevel(itemList.get(i).getItemRodLevel()); 
						}
						else
						{
							
							getCurrentStock.remove(j);
						}
						
						break;
					} 
				}
			}*/
			
			
			getCurrentStock1 = getCurrentStockHeaderRepository.getCurrentStockItem();
			
			List<CurrentOpeningDetail> opningDetail = currentOpeningDetailRepository.opningDetail(fromDate);
			
			List<CurrentMrnDetail> mrnDetail = currentMrnDetailRepository.mrnDetail(fromDate,toDate);
			
			List<CurrentIssueDetail> issueDetail = currentIssueDetailRepository.issueDetail(fromDate,toDate);
			
			List<CurrentDamageDetail> damageDetail = currentDamageDetailRepository.damageDetail(fromDate,toDate);
			
			
			for(int i=0 ; i<getCurrentStock1.size(); i++) {
				
				GetCurrStockRol getCurrStockRol = new GetCurrStockRol();
				getCurrStockRol.setItemId(getCurrentStock1.get(i).getItemId());
				
				
				for(int j=0 ; j<opningDetail.size() ;j++) {
					
					if(opningDetail.get(j).getItemId()==getCurrentStock1.get(i).getItemId()) {
						
						getCurrentStock1.get(i).setOpeningStock(opningDetail.get(j).getOpeningStock());
						getCurrentStock1.get(i).setOpStockValue(opningDetail.get(j).getOpStockValue());
						break;
					}
				}
				
				
				
				for(int j=0 ; j<mrnDetail.size() ;j++) {
					
					if(mrnDetail.get(j).getItemId()==getCurrentStock1.get(i).getItemId()) {
						
						getCurrentStock1.get(i).setApproveQty(mrnDetail.get(j).getApproveQty());
						getCurrentStock1.get(i).setApprovedQtyValue(mrnDetail.get(j).getApprovedQtyValue());
						getCurrentStock1.get(i).setApprovedLandingValue(mrnDetail.get(j).getApprovedLandingValue());
						break;
					}
				}
				
				
				
				for(int j=0 ; j<issueDetail.size() ;j++) {
					
					if(issueDetail.get(j).getItemId()==getCurrentStock1.get(i).getItemId()) {
						
						getCurrentStock1.get(i).setIssueQty(issueDetail.get(j).getIssueQty());
						getCurrentStock1.get(i).setIssueQtyValue(issueDetail.get(j).getIssueQtyValue());
						getCurrentStock1.get(i).setIssueLandingValue(issueDetail.get(j).getIssueLandingValue());
						break;
					}
				}
				
				for(int j=0 ; j<damageDetail.size() ;j++) {
					
					if(damageDetail.get(j).getItemId()==getCurrentStock1.get(i).getItemId()) {
						
						getCurrentStock1.get(i).setDamageQty(damageDetail.get(j).getDamageQty());
						getCurrentStock1.get(i).setDamagValue(damageDetail.get(j).getDamagValue());
						break;
					}
				}
				
				getCurrStockRol.setOpeningStock(getCurrentStock1.get(i).getOpeningStock());
				getCurrStockRol.setApproveQty(getCurrentStock1.get(i).getApproveQty());
				getCurrStockRol.setIssueQty(getCurrentStock1.get(i).getIssueQty());
				getCurrStockRol.setDamageQty(getCurrentStock1.get(i).getDamageQty());
				getCurrentStock.add(getCurrStockRol);
			}
			
			
			for(int i = 0 ; i<itemList.size() ; i++)
			{
				for(int j = 0 ; j<getCurrentStock.size() ; j++)
				{ 
					if(itemList.get(i).getItemId()==getCurrentStock.get(j).getItemId())
					{
						getCurrentStock.get(j).setItemName(itemList.get(i).getItemDesc());
						getCurrentStock.get(j).setCatId(itemList.get(i).getCatId());
						getCurrentStock.get(j).setItemUom(itemList.get(i).getItemUom());
						getCurrentStock.get(j).setItemMaxLevel(itemList.get(i).getItemMaxLevel());
						getCurrentStock.get(j).setItemMinLevel(itemList.get(i).getItemMinLevel());
						if(itemList.get(i).getItemRodLevel()>(getCurrentStock.get(j).getOpeningStock()+getCurrentStock.get(j).getApproveQty()-
									getCurrentStock.get(j).getIssueQty()+getCurrentStock.get(j).getReturnIssueQty()-getCurrentStock.get(j).getDamageQty()-
									getCurrentStock.get(j).getGatepassQty()+getCurrentStock.get(j).getGatepassReturnQty()) && itemList.get(i).getItemRodLevel()>0)
							
						{
							getCurrentStock.get(j).setRolLevel(itemList.get(i).getItemRodLevel()); 
						}
						else
						{
							
							getCurrentStock.remove(j);
						}
						
						break;
					} 
				}
			}
 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getCurrentStock;

	}
	
}
