package com.ats.tril.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.model.ErrorMessage;
import com.ats.tril.model.GetLogRecord;
import com.ats.tril.model.LogSave;
import com.ats.tril.repository.GetLogRecordRepository;
import com.ats.tril.repository.LogSaveRepository;

@RestController
public class LogRestController {
	
	@Autowired
	LogSaveRepository  logSaveRepository;
	
	@Autowired
	GetLogRecordRepository getLogRecordRepository;
	
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
	
	@RequestMapping(value = { "/getLogsRecordBydocTypeAndTranIds" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLogRecord> getLogsRecordBydocTypeAndTranIds(@RequestParam("docId") int docId,@RequestParam("docTranId") List<Integer> docTranId ) {

		List<GetLogRecord> list = new ArrayList<>();

		try {

			 
			list = getLogRecordRepository.getLogsRecordBydocTypeAndTranIds(docId,docTranId);
			
			 
			 

		} catch (Exception e) {

			 
		}
		return list;

	}
	/*select l.log_id,l.doc_type,l.doc_tran_id,l.req_user_id,l.req_date,l.req_date_time,u.usr_name,
	CASE WHEN l.edit_user_id!=0 THEN (select usr_name from m_user where l.edit_user_id=usr_id) ELSE "No Edit" END AS edit_user_name,l.edit_user_id,l.edit_date,l.edit_date_time,
	CASE WHEN l.del_user_id!=0 THEN (select usr_name from m_user where l.del_user_id=usr_id) ELSE "No Delete" END AS delete_user_name,l.del_user_id,l.del_date,l.del_date_time,
	CASE WHEN l.app1_user_id!=0 THEN (select usr_name from m_user where l.app1_user_id=usr_id) ELSE "No Approve1" END AS app1_user_name,l.app1_user_id,l.app1_date,l.app1_date_time,
	CASE WHEN l.app2_user_id!=0 THEN (select usr_name from m_user where l.app2_user_id=usr_id) ELSE "No Approve2" END AS app2_user_name,l.app2_user_id,l.app2_date,l.app2_date_time,
	CASE WHEN l.insp_user_id!=0 THEN (select usr_name from m_user where l.insp_user_id=usr_id) ELSE "No Inspection" END AS insp_user_name,l.insp_user_id,l.insp_date,l.insp_date_time,
	CASE WHEN l.rej1_user_id!=0 THEN (select usr_name from m_user where l.rej1_user_id=usr_id) ELSE "No rejection1" END AS rej1_user_name,l.rej1_user_id,l.rej1_date,l.rej1_date_time,
	CASE WHEN l.rej2_user_id!=0 THEN (select usr_name from m_user where l.rej2_user_id=usr_id) ELSE "No rejection2" END AS rej2_user_name,l.rej2_user_id,l.rej2_date,l.rej2_date_time 
	from t_log l,m_user u where u.usr_id=l.req_user_id*/

}
