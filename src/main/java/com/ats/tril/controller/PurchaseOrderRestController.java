package com.ats.tril.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.ats.tril.model.PoDetail;
import com.ats.tril.model.PoHeader; 
import com.ats.tril.repository.PoDetailRepository;
import com.ats.tril.repository.PoHeaderRepository;

@RestController
public class PurchaseOrderRestController {
	
	@Autowired
	PoHeaderRepository poHeaderRepository;
	
	@Autowired
	PoDetailRepository poDetailRepository;
	 
	
	@RequestMapping(value = { "/savePoHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody PoHeader savePoHeaderAndDetail(@RequestBody  PoHeader  poHeader) {

		PoHeader save = new PoHeader();

		try {

			 
			save = poHeaderRepository.save(poHeader);
				
				for(int i=0 ; i<poHeader.getPoDetailList().size();i++)
				{
					poHeader.getPoDetailList().get(i).setPoId(save.getPoId());
				}
				
			List<PoDetail> poDetailList	= poDetailRepository.saveAll(poHeader.getPoDetailList());
			save.setPoDetailList(poDetailList);
			 

		} catch (Exception e) {

			e.printStackTrace();
			 
		}
		return save;

	}

}
