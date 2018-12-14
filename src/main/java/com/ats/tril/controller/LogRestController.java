package com.ats.tril.controller;

import java.text.SimpleDateFormat;
import java.util.Date; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.ErrorMessage; 
import com.ats.tril.model.LogSave; 
import com.ats.tril.repository.LogSaveRepository;

@RestController
public class LogRestController {
	
	@Autowired
	LogSaveRepository  logSaveRepository;
	
	
	@RequestMapping(value = { "/saveLogRecord" }, method = RequestMethod.POST)
	public @ResponseBody LogSave saveLogRecord(@RequestBody LogSave LogSave) {

		LogSave res = new LogSave();

		try {
			
			Date date = new Date();
			SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			
			LogSave.setReqDate(dt.format(date));
			LogSave.setReqDateTime(dateTime.format(date));
			
			res = logSaveRepository.save(LogSave); 
			 
			
		} catch (Exception e) {

			e.printStackTrace();
			 
		}
		return res;

	}
	
	@RequestMapping(value = { "/updateEditDateAndTime" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateEditDateAndTime(@RequestParam("docId") int docId,@RequestParam("docTranId") int docTranId
			,@RequestParam("userId") int userId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			Date date = new Date();
			SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			
			System.out.println("dateTime.format(date) " + dateTime.format(date));
			System.out.println("dt.format(date) " + dt.format(date));
			int update = logSaveRepository.updateEditDateAndTime(docId,docTranId,dateTime.format(date),dt.format(date),userId);
			
			if(update==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("failed ");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("update ");
			} 
			 

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed"); 
		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/updateDeleteDateAndTime" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateDeleteDateAndTime(@RequestParam("docId") int docId,@RequestParam("docTranId") int docTranId
			,@RequestParam("userId") int userId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			Date date = new Date();
			SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			
			System.out.println("dateTime.format(date) " + dateTime.format(date));
			System.out.println("dt.format(date) " + dt.format(date));
			int update = logSaveRepository.updateDeleteDateAndTime(docId,docTranId,dateTime.format(date),dt.format(date),userId);
			
			if(update==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("failed ");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("update ");
			} 
			 

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed"); 
		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/updateAppv1DateAndTime" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateAppv1DateAndTime(@RequestParam("docId") int docId,@RequestParam("docTranId") int docTranId
			,@RequestParam("userId") int userId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			Date date = new Date();
			SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			
			System.out.println("dateTime.format(date) " + dateTime.format(date));
			System.out.println("dt.format(date) " + dt.format(date));
			int update = logSaveRepository.updateAppv1DateAndTime(docId,docTranId,dateTime.format(date),dt.format(date),userId);
			
			if(update==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("failed ");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("update ");
			} 
			 

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed"); 
		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/updateAppv2DateAndTime" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateAppv2DateAndTime(@RequestParam("docId") int docId,@RequestParam("docTranId") int docTranId
			,@RequestParam("userId") int userId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			Date date = new Date();
			SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			
			System.out.println("dateTime.format(date) " + dateTime.format(date));
			System.out.println("dt.format(date) " + dt.format(date));
			int update = logSaveRepository.updateAppv2DateAndTime(docId,docTranId,dateTime.format(date),dt.format(date),userId);
			
			if(update==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("failed ");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("update ");
			} 
			 

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed"); 
		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/updateInspDateAndTime" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateInspDateAndTime(@RequestParam("docId") int docId,@RequestParam("docTranId") int docTranId
			,@RequestParam("userId") int userId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			Date date = new Date();
			SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			
			System.out.println("dateTime.format(date) " + dateTime.format(date));
			System.out.println("dt.format(date) " + dt.format(date));
			int update = logSaveRepository.updateInspDateAndTime(docId,docTranId,dateTime.format(date),dt.format(date),userId);
			
			if(update==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("failed ");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("update ");
			} 
			 

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed"); 
		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/updateRej1DateAndTime" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateRej1DateAndTime(@RequestParam("docId") int docId,@RequestParam("docTranId") int docTranId
			,@RequestParam("userId") int userId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			Date date = new Date();
			SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			
			System.out.println("dateTime.format(date) " + dateTime.format(date));
			System.out.println("dt.format(date) " + dt.format(date));
			int update = logSaveRepository.updateRej1DateAndTime(docId,docTranId,dateTime.format(date),dt.format(date),userId);
			
			if(update==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("failed ");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("update ");
			} 
			 

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed"); 
		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/updateRej2DateAndTime" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateRej2DateAndTime(@RequestParam("docId") int docId,@RequestParam("docTranId") int docTranId
			,@RequestParam("userId") int userId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			Date date = new Date();
			SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			
			System.out.println("dateTime.format(date) " + dateTime.format(date));
			System.out.println("dt.format(date) " + dt.format(date));
			int update = logSaveRepository.updateRej2DateAndTime(docId,docTranId,dateTime.format(date),dt.format(date),userId);
			
			if(update==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("failed ");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("update ");
			} 
			 

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed"); 
		}
		return errorMessage;

	}

}
