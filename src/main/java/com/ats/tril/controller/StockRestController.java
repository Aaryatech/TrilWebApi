package com.ats.tril.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.CurrentDamageDetail;
import com.ats.tril.model.CurrentIssueDetail; 
import com.ats.tril.model.CurrentMrnDetail;
import com.ats.tril.model.CurrentOpeningDetail;
import com.ats.tril.model.GetCurrentStock;
import com.ats.tril.model.GetItem;
import com.ats.tril.model.ItemListWithCurrentStock;
import com.ats.tril.model.MinAndRolLevelReport;
import com.ats.tril.model.StockDetail;
import com.ats.tril.model.StockHeader;
import com.ats.tril.repository.CurrentDamageDetailRepository;
import com.ats.tril.repository.CurrentIssueDetailRepository;
import com.ats.tril.repository.CurrentMrnDetailRepository;
import com.ats.tril.repository.CurrentOpeningDetailRepository;
import com.ats.tril.repository.GetItemRepository;
import com.ats.tril.repository.ItemListWithCurrentStockRepository;
import com.ats.tril.repository.MinAndRolLevelReportRepository;
import com.ats.tril.repository.stock.GetCurrentStockHeaderRepository;
import com.ats.tril.repository.stock.StockDetailRepository;
import com.ats.tril.repository.stock.StockHeaderRepository;

@RestController
public class StockRestController {
	
	@Autowired
	ItemListWithCurrentStockRepository itemListWithCurrentStockRepository;
	
	
	@Autowired
	StockHeaderRepository stockHeaderRepository;

	@Autowired
	StockDetailRepository stockDetailRepository;
	
	@Autowired
	GetCurrentStockHeaderRepository getCurrentStockHeaderRepository;
	
	@Autowired
	GetItemRepository getItemRepository;
	
	@Autowired
	MinAndRolLevelReportRepository minAndRolLevelReportRepository;
	
	@Autowired
	CurrentOpeningDetailRepository currentOpeningDetailRepository;
	
	@Autowired
	CurrentMrnDetailRepository currentMrnDetailRepository;

	@Autowired
	CurrentIssueDetailRepository currentIssueDetailRepository;
	
	@Autowired
	CurrentDamageDetailRepository currentDamageDetailRepository;
	
	@RequestMapping(value = { "/insertStock" }, method = RequestMethod.POST)
	public @ResponseBody StockHeader insertStock(@RequestBody StockHeader stockHeader) {
		
		StockHeader save = new StockHeader();

		try {

			save = stockHeaderRepository.saveAndFlush(stockHeader);

			for (int i = 0; i < stockHeader.getStockDetailList().size(); i++)
				stockHeader.getStockDetailList().get(i).setStockHeaderId(save.getStockHeaderId());

			List<StockDetail> StockDetails = stockDetailRepository.saveAll(stockHeader.getStockDetailList());
			 
			save.setStockDetailList(StockDetails);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return save;

	}
	
	
	@RequestMapping(value = { "/getItemListByItemIdWithStock" }, method = RequestMethod.POST)
	public @ResponseBody  ItemListWithCurrentStock  getItemListByItemIdWithStock(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("itemId") int itemId) {
		
		 ItemListWithCurrentStock  itemListWithCurrentStock = new ItemListWithCurrentStock();

		try {
			
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("dd");
			SimpleDateFormat yy = new SimpleDateFormat("yyyy");
			SimpleDateFormat mm = new SimpleDateFormat("MM");
			
			int days =  Integer.parseInt(sf.format(date));
			String year =   yy.format(date);
			int month =  Integer.parseInt(mm.format(date));
			String firstDate = year+"-"+month+"-01";

			itemListWithCurrentStock = itemListWithCurrentStockRepository.getItemListByItemIdWithStock(firstDate,fromDate,toDate,itemId);
			
			 
			itemListWithCurrentStock.setClsQty(itemListWithCurrentStock.getOpeningStock()+itemListWithCurrentStock.getApproveQty()-itemListWithCurrentStock.getIssueQty()
						+itemListWithCurrentStock.getIssueReturnQty()-itemListWithCurrentStock.getDamageQty());
			itemListWithCurrentStock.setAvgIssueQty(itemListWithCurrentStock.getIssueQtyAvg()/days);
			 
 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemListWithCurrentStock;

	}
	
	
	@RequestMapping(value = { "/getCurrentStock" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCurrentStock> getCurrentStock(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		
		List<GetCurrentStock> getCurrentStock = new ArrayList<GetCurrentStock>();

		try {

			/*getCurrentStock = getCurrentStockHeaderRepository.getCurrentStock(fromDate,toDate);*/
			
			getCurrentStock = getCurrentStockHeaderRepository.getCurrentStockItem();
			
			List<CurrentOpeningDetail> opningDetail = currentOpeningDetailRepository.opningDetail(fromDate);
			
			List<CurrentMrnDetail> mrnDetail = currentMrnDetailRepository.mrnDetail(fromDate,toDate);
			
			List<CurrentIssueDetail> issueDetail = currentIssueDetailRepository.issueDetail(fromDate,toDate);
			
			List<CurrentDamageDetail> damageDetail = currentDamageDetailRepository.damageDetail(fromDate,toDate);
			
			
			for(int i=0 ; i<getCurrentStock.size(); i++) {
				
				for(int j=0 ; j<opningDetail.size() ;j++) {
					
					if(opningDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
						
						getCurrentStock.get(i).setOpeningStock(opningDetail.get(j).getOpeningStock());
						getCurrentStock.get(i).setOpStockValue(opningDetail.get(j).getOpStockValue());
						break;
					}
				}
				
				for(int j=0 ; j<mrnDetail.size() ;j++) {
					
					if(mrnDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
						
						getCurrentStock.get(i).setApproveQty(mrnDetail.get(j).getApproveQty());
						getCurrentStock.get(i).setApprovedQtyValue(mrnDetail.get(j).getApprovedQtyValue());
						getCurrentStock.get(i).setApprovedLandingValue(mrnDetail.get(j).getApprovedLandingValue());
						break;
					}
				}
				
				for(int j=0 ; j<issueDetail.size() ;j++) {
					
					if(issueDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
						
						getCurrentStock.get(i).setIssueQty(issueDetail.get(j).getIssueQty());
						getCurrentStock.get(i).setIssueQtyValue(issueDetail.get(j).getIssueQtyValue());
						getCurrentStock.get(i).setIssueLandingValue(issueDetail.get(j).getIssueLandingValue());
						break;
					}
				}
				
				for(int j=0 ; j<damageDetail.size() ;j++) {
					
					if(damageDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
						
						getCurrentStock.get(i).setDamageQty(damageDetail.get(j).getDamageQty());
						getCurrentStock.get(i).setDamagValue(damageDetail.get(j).getDamagValue());
						break;
					}
				}
			}
 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getCurrentStock;

	}
	
	@RequestMapping(value = { "/getCurrentStockByItemId" }, method = RequestMethod.POST)
	public @ResponseBody GetCurrentStock getCurrentStockByItemId(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("itemId") int itemId) {
		
		 GetCurrentStock  getCurrentStock = new  GetCurrentStock ();

		try {

			getCurrentStock = getCurrentStockHeaderRepository.getCurrentStockByItemId(fromDate,toDate,itemId);
 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getCurrentStock;

	}
	
	@RequestMapping(value = { "/getCurrentRunningMonthAndYear" }, method = RequestMethod.GET)
	public @ResponseBody StockHeader getCurrentRunningMonthAndYear() {
		
		StockHeader getCurrentRunningMonthAndYear = new StockHeader();

		try {

			getCurrentRunningMonthAndYear = stockHeaderRepository.findByStatusAndDelStatus(0,1);
			
			if(getCurrentRunningMonthAndYear==null)
			{
				getCurrentRunningMonthAndYear = new StockHeader();
			}
 
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getCurrentRunningMonthAndYear;

	}
	
	@RequestMapping(value = { "/getStockDetailByStockId" }, method = RequestMethod.POST)
	public @ResponseBody List<StockDetail> getStockDetailByStockId(@RequestParam("stockId") int stockId) {
		
		List<StockDetail> StockDetails = new ArrayList<>();

		try {
 
			 StockDetails = stockDetailRepository.findByStockHeaderIdAndDelStatus(stockId,1);
			  
		} catch (Exception e) {

			e.printStackTrace();

		}
		return StockDetails;

	}
	
	@RequestMapping(value = { "/getItemListLessThanROL" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCurrentStock> getItemListLessThanROL(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		
		List<GetCurrentStock> getCurrentStock = new ArrayList<GetCurrentStock>();

		try {
			
			List<GetItem>  itemList = getItemRepository.getAllItems();

			getCurrentStock = getCurrentStockHeaderRepository.getCurrentStock(fromDate,toDate);
			
			for(int i = 0 ; i<itemList.size() ; i++)
			{
				for(int j = 0 ; j<getCurrentStock.size() ; j++)
				{
					if(itemList.get(i).getItemId()==getCurrentStock.get(j).getItemId())
					{
						if(itemList.get(i).getItemRodLevel()<(getCurrentStock.get(j).getOpeningStock()+getCurrentStock.get(j).getApproveQty()-
									getCurrentStock.get(j).getIssueQty()+getCurrentStock.get(j).getReturnIssueQty()-getCurrentStock.get(j).getDamageQty()-
									getCurrentStock.get(j).getGatepassQty()+getCurrentStock.get(j).getGatepassReturnQty()))
							
						{
							getCurrentStock.remove(j);
						}
						else
						{
							getCurrentStock.get(j).setRolLevel(itemList.get(i).getItemRodLevel());
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
	
	@RequestMapping(value = { "/getStockBetweenDateWithCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCurrentStock> getStockBetweenDateWithCatId(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("catId") int catId) {
		
		List<GetCurrentStock> getCurrentStock = new ArrayList<GetCurrentStock>();

		try {

			//getCurrentStock = getCurrentStockHeaderRepository.getStockBetweenDateWithCatId(fromDate,toDate,catId);
 
			getCurrentStock = getCurrentStockHeaderRepository.getCurrentStockItemByCatId(catId);
			
			List<CurrentOpeningDetail> opningDetail = currentOpeningDetailRepository.opningDetailByCatId(fromDate,catId);
			
			List<CurrentMrnDetail> mrnDetail = currentMrnDetailRepository.mrnDetailByCatId(fromDate,toDate,catId);
			
			List<CurrentIssueDetail> issueDetail = currentIssueDetailRepository.issueDetailByCatId(fromDate,toDate,catId);
			
			List<CurrentDamageDetail> damageDetail = currentDamageDetailRepository.damageDetailByCatId(fromDate,toDate,catId);
			
			
			for(int i=0 ; i<getCurrentStock.size(); i++) {
				
				for(int j=0 ; j<opningDetail.size() ;j++) {
					
					if(opningDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
						
						getCurrentStock.get(i).setOpeningStock(opningDetail.get(j).getOpeningStock());
						getCurrentStock.get(i).setOpStockValue(opningDetail.get(j).getOpStockValue());
						break;
					}
				}
				
				for(int j=0 ; j<mrnDetail.size() ;j++) {
					
					if(mrnDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
						
						getCurrentStock.get(i).setApproveQty(mrnDetail.get(j).getApproveQty());
						getCurrentStock.get(i).setApprovedQtyValue(mrnDetail.get(j).getApprovedQtyValue());
						getCurrentStock.get(i).setApprovedLandingValue(mrnDetail.get(j).getApprovedLandingValue());
						break;
					}
				}
				
				for(int j=0 ; j<issueDetail.size() ;j++) {
					
					if(issueDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
						
						getCurrentStock.get(i).setIssueQty(issueDetail.get(j).getIssueQty());
						getCurrentStock.get(i).setIssueQtyValue(issueDetail.get(j).getIssueQtyValue());
						getCurrentStock.get(i).setIssueLandingValue(issueDetail.get(j).getIssueLandingValue());
						break;
					}
				}
				
				for(int j=0 ; j<damageDetail.size() ;j++) {
					
					if(damageDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
						
						getCurrentStock.get(i).setDamageQty(damageDetail.get(j).getDamageQty());
						getCurrentStock.get(i).setDamagValue(damageDetail.get(j).getDamagValue());
						break;
					}
				}
			}
			
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getCurrentStock;

	}
	
	@RequestMapping(value = { "/getStockBetweenDateWithCatIdAndTypeId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCurrentStock> getStockBetweenDateWithCatIdAndTypeId(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("catId") int catId,@RequestParam("typeId") int typeId) {
		
		List<GetCurrentStock> getCurrentStock = new ArrayList<GetCurrentStock>();

		try {

			 /*if(typeId==0) {
			 getCurrentStock = getCurrentStockHeaderRepository.getStockBetweenDateWithCatId(fromDate,toDate,catId);
			}
			else {
			 getCurrentStock = getCurrentStockHeaderRepository.getStockBetweenDateWithCatId(fromDate,toDate,catId,typeId);
			} */
			  if(typeId==0) {
				   
					getCurrentStock = getCurrentStockHeaderRepository.getCurrentStockItemByCatId(catId);
					
					List<CurrentOpeningDetail> opningDetail = currentOpeningDetailRepository.opningDetailByCatId(fromDate,catId);
					
					List<CurrentMrnDetail> mrnDetail = currentMrnDetailRepository.mrnDetailByCatId(fromDate,toDate,catId);
					
					List<CurrentIssueDetail> issueDetail = currentIssueDetailRepository.issueDetailByCatId(fromDate,toDate,catId);
					
					List<CurrentDamageDetail> damageDetail = currentDamageDetailRepository.damageDetailByCatId(fromDate,toDate,catId);
					
					
					for(int i=0 ; i<getCurrentStock.size(); i++) {
						
						for(int j=0 ; j<opningDetail.size() ;j++) {
							
							if(opningDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
								
								getCurrentStock.get(i).setOpeningStock(opningDetail.get(j).getOpeningStock());
								getCurrentStock.get(i).setOpStockValue(opningDetail.get(j).getOpStockValue());
								break;
							}
						}
						
						for(int j=0 ; j<mrnDetail.size() ;j++) {
							
							if(mrnDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
								
								getCurrentStock.get(i).setApproveQty(mrnDetail.get(j).getApproveQty());
								getCurrentStock.get(i).setApprovedQtyValue(mrnDetail.get(j).getApprovedQtyValue());
								getCurrentStock.get(i).setApprovedLandingValue(mrnDetail.get(j).getApprovedLandingValue());
								break;
							}
						}
						
						for(int j=0 ; j<issueDetail.size() ;j++) {
							
							if(issueDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
								
								getCurrentStock.get(i).setIssueQty(issueDetail.get(j).getIssueQty());
								getCurrentStock.get(i).setIssueQtyValue(issueDetail.get(j).getIssueQtyValue());
								getCurrentStock.get(i).setIssueLandingValue(issueDetail.get(j).getIssueLandingValue());
								break;
							}
						}
						
						for(int j=0 ; j<damageDetail.size() ;j++) {
							
							if(damageDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
								
								getCurrentStock.get(i).setDamageQty(damageDetail.get(j).getDamageQty());
								getCurrentStock.get(i).setDamagValue(damageDetail.get(j).getDamagValue());
								break;
							}
						}
					}
			}else {
				
				getCurrentStock = getCurrentStockHeaderRepository.getCurrentStockItemByCatId(catId);
				
				List<CurrentOpeningDetail> opningDetail = currentOpeningDetailRepository.opningDetailByCatId(fromDate,catId);
				
				List<CurrentMrnDetail> mrnDetail = currentMrnDetailRepository.mrnDetailByCatIdAndTypeId(fromDate,toDate,catId,typeId);
				
				List<CurrentIssueDetail> issueDetail = currentIssueDetailRepository.issueDetailByCatIdAndTypeId(fromDate,toDate,catId,typeId);
				
				List<CurrentDamageDetail> damageDetail = currentDamageDetailRepository.damageDetailByCatId(fromDate,toDate,catId);
				
				
				for(int i=0 ; i<getCurrentStock.size(); i++) {
					
					for(int j=0 ; j<opningDetail.size() ;j++) {
						
						if(opningDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
							
							getCurrentStock.get(i).setOpeningStock(opningDetail.get(j).getOpeningStock());
							getCurrentStock.get(i).setOpStockValue(opningDetail.get(j).getOpStockValue());
							break;
						}
					}
					
					for(int j=0 ; j<mrnDetail.size() ;j++) {
						
						if(mrnDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
							
							getCurrentStock.get(i).setApproveQty(mrnDetail.get(j).getApproveQty());
							getCurrentStock.get(i).setApprovedQtyValue(mrnDetail.get(j).getApprovedQtyValue());
							getCurrentStock.get(i).setApprovedLandingValue(mrnDetail.get(j).getApprovedLandingValue());
							break;
						}
					}
					
					for(int j=0 ; j<issueDetail.size() ;j++) {
						
						if(issueDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
							
							getCurrentStock.get(i).setIssueQty(issueDetail.get(j).getIssueQty());
							getCurrentStock.get(i).setIssueQtyValue(issueDetail.get(j).getIssueQtyValue());
							getCurrentStock.get(i).setIssueLandingValue(issueDetail.get(j).getIssueLandingValue());
							break;
						}
					}
					
					for(int j=0 ; j<damageDetail.size() ;j++) {
						
						if(damageDetail.get(j).getItemId()==getCurrentStock.get(i).getItemId()) {
							
							getCurrentStock.get(i).setDamageQty(damageDetail.get(j).getDamageQty());
							getCurrentStock.get(i).setDamagValue(damageDetail.get(j).getDamagValue());
							break;
						}
					}
				}
				
			}
 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getCurrentStock;

	}
	
	@RequestMapping(value = { "/getStockBetweenDateWithItemIdList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCurrentStock> getStockBetweenDateWithItemIdList(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("ItemIds") List<Integer> ItemIds) {
		
		List<GetCurrentStock> getCurrentStock = new ArrayList<GetCurrentStock>();

		try {

			 
			 getCurrentStock = getCurrentStockHeaderRepository.getStockBetweenDateWithItemIdList(fromDate,toDate,ItemIds); 
 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getCurrentStock;

	}
	
	@RequestMapping(value = { "/minQtyAndRolQtyLevelReport" }, method = RequestMethod.POST)
	public @ResponseBody List<MinAndRolLevelReport> minQtyAndRolQtyLevelReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("catId") int catId) {
		
		List<MinAndRolLevelReport> getCurrentStock = new ArrayList<MinAndRolLevelReport>();

		try {

			if(catId!=0) {
				getCurrentStock = minAndRolLevelReportRepository.getCurrentStock(fromDate,toDate,catId);
			}
			else {
				getCurrentStock = minAndRolLevelReportRepository.getCurrentStock(fromDate,toDate);
			}
			
 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getCurrentStock;

	}
	
	@RequestMapping(value = { "/getItemListByItemIds" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItem> getItemListByItemIds(@RequestParam("itemId") List<Integer> itemIds ) {
		
		List<GetItem>  itemList = new ArrayList<>();

		try {
			
		 itemList = getItemRepository.getItemListByItemIds(itemIds);
 
 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

}
