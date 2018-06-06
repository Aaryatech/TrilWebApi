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

import com.ats.tril.model.AccountHead;
import com.ats.tril.model.Category;
import com.ats.tril.model.DeliveryTerms;
import com.ats.tril.model.Dept;
import com.ats.tril.model.DispatchMode;
import com.ats.tril.model.ErrorMessage;
import com.ats.tril.model.FinancialYears;
import com.ats.tril.model.GetItemGroup;
import com.ats.tril.model.GetItemSubGrp;
import com.ats.tril.model.GetSubDept;
import com.ats.tril.model.ItemGroup;
import com.ats.tril.model.ItemSubGroup;
import com.ats.tril.model.PaymentTerms;
import com.ats.tril.model.SubDept;
import com.ats.tril.model.TaxForm;
import com.ats.tril.repository.AccountHeadRepository;
import com.ats.tril.repository.CategoryRepository;
import com.ats.tril.repository.DeliveryTermsRepository;
import com.ats.tril.repository.DeptRepository;
import com.ats.tril.repository.DispatchModeRepository;
import com.ats.tril.repository.FinancialYearsRepository;
import com.ats.tril.repository.GetItemGroupRepository;
import com.ats.tril.repository.GetItemSubGrpRepository;
import com.ats.tril.repository.GetSubDeptRepository;
import com.ats.tril.repository.ItemGroupRepository;
import com.ats.tril.repository.ItemSubGroupRepository;
import com.ats.tril.repository.PaymentTermsRepository;
import com.ats.tril.repository.SubDeptRepository;
import com.ats.tril.repository.TaxFormRepository;

@RestController
public class MasterController {

	@Autowired
	DeptRepository deptRepository;

	@Autowired
	GetSubDeptRepository getSubDeptRepository;

	@Autowired
	FinancialYearsRepository financialYearsRepository;

	@Autowired
	SubDeptRepository subDeptRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	AccountHeadRepository accountHeadRepository;

	@Autowired
	DeliveryTermsRepository deliveryTermsRepository;

	@Autowired
	DispatchModeRepository dispatchModeRepository;

	@Autowired
	ItemGroupRepository itemGroupRepository;

	@Autowired
	ItemSubGroupRepository itemSubGroupRepository;

	@Autowired
	PaymentTermsRepository paymentTermsRepository;

	@Autowired
	GetItemSubGrpRepository getItemSubGrpRepository;

	@Autowired
	TaxFormRepository taxFormRepository;
	
	@Autowired
	GetItemGroupRepository getItemGroupRepository;

	// -------------------Dept------------------------

	@RequestMapping(value = { "/saveDept" }, method = RequestMethod.POST)
	public @ResponseBody Dept saveDept(@RequestBody Dept dept) {

		Dept res = new Dept();

		try {

			res = deptRepository.saveAndFlush(dept);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getDeptByDeptId" }, method = RequestMethod.POST)
	public @ResponseBody Dept getDeptByDeptId(@RequestParam("deptId") int deptId) {

		Dept dept = null;
		try {
			dept = deptRepository.findDeptByDeptId(deptId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dept;

	}

	@RequestMapping(value = { "/getAllDeptByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Dept> getAllDeptByIsUsed() {

		List<Dept> dept = new ArrayList<Dept>();

		try {

			dept = deptRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dept;

	}

	@RequestMapping(value = { "/deleteDept" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteDept(@RequestParam("deptId") int deptId,
			@RequestParam("deptDeletedIn") int deptDeletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = deptRepository.deleteDept(deptId, deptDeletedIn);

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

	// ------------------Financial Years------------------------

	@RequestMapping(value = { "/saveFinancialYears" }, method = RequestMethod.POST)
	public @ResponseBody FinancialYears saveFinancialYears(@RequestBody FinancialYears financialYears) {

		FinancialYears res = new FinancialYears();

		try {

			res = financialYearsRepository.saveAndFlush(financialYears);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getFinancialYearsByFYId" }, method = RequestMethod.POST)
	public @ResponseBody FinancialYears getFinancialYearsByFYId(@RequestParam("finYearId") int finYearId) {

		FinancialYears financialYears = null;
		try {
			financialYears = financialYearsRepository.findFinancialYearsByFinYearId(finYearId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return financialYears;

	}

	@RequestMapping(value = { "/getAllFinancialYears" }, method = RequestMethod.GET)
	public @ResponseBody List<FinancialYears> getAllFinancialYears() {

		List<FinancialYears> financialYearsList = new ArrayList<FinancialYears>();

		try {

			financialYearsList = financialYearsRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return financialYearsList;

	}

	@RequestMapping(value = { "/deleteFinancialYears" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteFinancialYears(@RequestParam("finYearId") int finYearId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = financialYearsRepository.deleteFinancialYears(finYearId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Year Deleted Successfully");
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

	// -------------------SubDept------------------------

	@RequestMapping(value = { "/saveSubDept" }, method = RequestMethod.POST)
	public @ResponseBody SubDept saveSubDept(@RequestBody SubDept subDept) {

		SubDept res = new SubDept();

		try {

			res = subDeptRepository.saveAndFlush(subDept);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllSubDept" }, method = RequestMethod.GET)
	public @ResponseBody List<GetSubDept> getAllSubDept() {

		List<GetSubDept> subDeptList = new ArrayList<GetSubDept>();

		try {

			subDeptList = getSubDeptRepository.getAllSubDeptList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return subDeptList;

	}

	@RequestMapping(value = { "/getSubDeptBySubDeptId" }, method = RequestMethod.POST)
	public @ResponseBody GetSubDept getSubDeptBySubDeptId(@RequestParam("subDeptId") int subDeptId) {

		GetSubDept getSubDept = null;
		try {
			getSubDept = getSubDeptRepository.getSubDeptbySubDeptId(subDeptId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getSubDept;

	}

	@RequestMapping(value = { "/deleteSubDept" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteSubDept(@RequestParam("subDeptId") int subDeptId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = subDeptRepository.deleteSubDept(subDeptId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("SubDept Deleted Successfully");
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

	// -------------------Categroy-----------------------

	@RequestMapping(value = { "/saveCategory" }, method = RequestMethod.POST)
	public @ResponseBody Category saveCategory(@RequestBody Category category) {

		Category res = new Category();

		try {

			res = categoryRepository.saveAndFlush(category);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getCatByCatId" }, method = RequestMethod.POST)
	public @ResponseBody Category getCatByCatId(@RequestParam("catId") int catId) {

		Category category = null;
		try {
			category = categoryRepository.findCatByCatId(catId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return category;

	}

	@RequestMapping(value = { "/getAllCategoryByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategoryByIsUsed() {

		List<Category> category = new ArrayList<Category>();

		try {

			category = categoryRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return category;

	}

	@RequestMapping(value = { "/deleteCategory" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteCategory(@RequestParam("catId") int catId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = categoryRepository.deleteCategory(catId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
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

	// -------------------Account Head ---------------------

	@RequestMapping(value = { "/saveAccountHead" }, method = RequestMethod.POST)
	public @ResponseBody AccountHead saveAccountHead(@RequestBody AccountHead accountHead) {

		AccountHead res = new AccountHead();

		try {

			res = accountHeadRepository.saveAndFlush(accountHead);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAccontHeadByAccHeadId" }, method = RequestMethod.POST)
	public @ResponseBody AccountHead getAccontHeadByAccHeadId(@RequestParam("accHeadId") int accHeadId) {

		AccountHead accountHead = null;
		try {
			accountHead = accountHeadRepository.findCatByAccHeadId(accHeadId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return accountHead;

	}

	@RequestMapping(value = { "/getAllAccountHeadByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<AccountHead> getAllAccountHeadByIsUsed() {

		List<AccountHead> accountHead = new ArrayList<AccountHead>();

		try {

			accountHead = accountHeadRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return accountHead;

	}

	@RequestMapping(value = { "/deleteAccountHead" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteAccountHead(@RequestParam("accHeadId") int accHeadId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = accountHeadRepository.deleteAccountHead(accHeadId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Account Head Deleted Successfully");
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

	// -----------------DeliveryTerms--------------------------

	@RequestMapping(value = { "/saveDeliveryTerms" }, method = RequestMethod.POST)
	public @ResponseBody DeliveryTerms saveDeliveryTerms(@RequestBody DeliveryTerms deliveryTerms) {

		DeliveryTerms res = new DeliveryTerms();

		try {

			res = deliveryTermsRepository.saveAndFlush(deliveryTerms);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getDeliveryTermsByTermId" }, method = RequestMethod.POST)
	public @ResponseBody DeliveryTerms getDeliveryTermsByTermId(@RequestParam("deliveryTermId") int deliveryTermId) {

		DeliveryTerms deliveryTerms = null;
		try {
			deliveryTerms = deliveryTermsRepository.findDeliveryTermsByDeliveryTermId(deliveryTermId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return deliveryTerms;

	}

	@RequestMapping(value = { "/getAllDeliveryTermsByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<DeliveryTerms> getAllDeliveryTermsByIsUsed() {

		List<DeliveryTerms> deliveryTermsList = new ArrayList<DeliveryTerms>();

		try {

			deliveryTermsList = deliveryTermsRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return deliveryTermsList;

	}

	@RequestMapping(value = { "/deleteDeliveryTerms" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteDeliveryTerms(@RequestParam("deliveryTermId") int deliveryTermId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = deliveryTermsRepository.deleteDeliveryTerms(deliveryTermId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
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

	// -----------------DispatchMode-------------------------

	@RequestMapping(value = { "/saveDispatchMode" }, method = RequestMethod.POST)
	public @ResponseBody DispatchMode saveDispatchModes(@RequestBody DispatchMode dispatchMode) {

		DispatchMode res = new DispatchMode();

		try {

			res = dispatchModeRepository.saveAndFlush(dispatchMode);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getDispatchModeByTermId" }, method = RequestMethod.POST)
	public @ResponseBody DispatchMode getDispatchModeByTermId(@RequestParam("dispModeId") int dispModeId) {

		DispatchMode dispatchMode = null;
		try {
			dispatchMode = dispatchModeRepository.findByDispModeId(dispModeId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dispatchMode;

	}

	@RequestMapping(value = { "/getAllDispatchModesByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<DispatchMode> getAllDispatchModesByIsUsed() {

		List<DispatchMode> dispatchModeList = new ArrayList<DispatchMode>();

		try {

			dispatchModeList = dispatchModeRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dispatchModeList;

	}

	@RequestMapping(value = { "/deleteDispatchMode" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteDispatchMode(@RequestParam("dispModeId") int dispModeId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = dispatchModeRepository.deleteDispatchMode(dispModeId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
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

	// ------------------Item Group----------------------

	@RequestMapping(value = { "/saveItemGroup" }, method = RequestMethod.POST)
	public @ResponseBody ItemGroup saveItemGroup(@RequestBody ItemGroup itemGroup) {

		ItemGroup res = new ItemGroup();

		try {

			res = itemGroupRepository.saveAndFlush(itemGroup);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getItemGroupByGrpId" }, method = RequestMethod.POST)
	public @ResponseBody GetItemGroup getItemGroupByGrpId(@RequestParam("grpId") int grpId) {

		GetItemGroup itemGroup = null;
		try {
			itemGroup = getItemGroupRepository.getItemGrpByGrpId(grpId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemGroup;

	}

	@RequestMapping(value = { "/getAllItemGroupByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<GetItemGroup> getAllItemGroupByIsUsed() {

		List<GetItemGroup> itemGroupList = new ArrayList<GetItemGroup>();

		try {

			itemGroupList =getItemGroupRepository.getAllItemGrpList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemGroupList;

	}

	@RequestMapping(value = { "/deleteItemGroup" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteItemGroup(@RequestParam("grpId") int grpId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = itemGroupRepository.deleteItemGroup(grpId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
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

	// ------------------Item Sub Group----------------------

	@RequestMapping(value = { "/saveItemSubGroup" }, method = RequestMethod.POST)
	public @ResponseBody ItemSubGroup saveItemSubGroup(@RequestBody ItemSubGroup itemSubGroup) {

		ItemSubGroup res = new ItemSubGroup();

		try {

			res = itemSubGroupRepository.saveAndFlush(itemSubGroup);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getItemSubGrpBysubgrpId" }, method = RequestMethod.POST)
	public @ResponseBody GetItemSubGrp getItemSubGrpBysubgrpId(@RequestParam("subgrpId") int subgrpId) {

		GetItemSubGrp getItemSubGrp = null;
		try {
			getItemSubGrp = getItemSubGrpRepository.getSubItemBySubGroupId(subgrpId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getItemSubGrp;

	}

	@RequestMapping(value = { "/getAllItemSubGroup" }, method = RequestMethod.GET)
	public @ResponseBody List<GetItemSubGrp> getAllItemSubGroup() {

		List<GetItemSubGrp> getItemSubGrpList = new ArrayList<GetItemSubGrp>();

		try {

			getItemSubGrpList = getItemSubGrpRepository.getAllItemSubGrpList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getItemSubGrpList;

	}

	@RequestMapping(value = { "/deleteItemSubGroup" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteItemSubGroup(@RequestParam("subgrpId") int subgrpId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = itemSubGroupRepository.deleteItemSubGroup(subgrpId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
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

	// -----------------Payment Terms---------------------

	@RequestMapping(value = { "/savePaymentTerms" }, method = RequestMethod.POST)
	public @ResponseBody PaymentTerms savePaymentTerms(@RequestBody PaymentTerms paymentTerms) {

		PaymentTerms res = new PaymentTerms();

		try {

			res = paymentTermsRepository.saveAndFlush(paymentTerms);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllPaymentTermsByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<PaymentTerms> getAllPaymentTermsByIsUsed() {

		List<PaymentTerms> paymentTermsList = new ArrayList<PaymentTerms>();

		try {

			paymentTermsList = paymentTermsRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return paymentTermsList;

	}

	@RequestMapping(value = { "/getPaymetTermsByPaymentTermId" }, method = RequestMethod.POST)
	public @ResponseBody PaymentTerms getPaymetTermsByPaymentTermId(@RequestParam("pymtTermId") int pymtTermId) {

		PaymentTerms paymentTerms = null;
		try {
			paymentTerms = paymentTermsRepository.findByPymtTermId(pymtTermId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return paymentTerms;

	}

	@RequestMapping(value = { "/deletePaymentTerms" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deletePaymentTerms(@RequestParam("pymtTermId") int pymtTermId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = paymentTermsRepository.deletePaymentTerms(pymtTermId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
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

	// ----------------Tax Form--------------------

	@RequestMapping(value = { "/saveTaxForm" }, method = RequestMethod.POST)
	public @ResponseBody TaxForm saveTaxForm(@RequestBody TaxForm taxForm) {

		TaxForm res = new TaxForm();

		try {

			res = taxFormRepository.saveAndFlush(taxForm);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}
	
	@RequestMapping(value = { "/getTaxFormByTaxId" }, method = RequestMethod.POST)
	public @ResponseBody TaxForm getTaxFormByTaxId(@RequestParam("taxId") int taxId) {

		TaxForm taxForm = null;
		try {
			taxForm = taxFormRepository.findByTaxId(taxId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return taxForm;

	}

	@RequestMapping(value = { "/getAllTaxForms" }, method = RequestMethod.GET)
	public @ResponseBody List<TaxForm> getAllTaxForms() {

		List<TaxForm> taxFormList = new ArrayList<TaxForm>();

		try {

			taxFormList = taxFormRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return taxFormList;

	}
	
	@RequestMapping(value = { "/deleteTaxForm" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteTaxForm(@RequestParam("taxId") int taxId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = taxFormRepository.deleteTaxForm(taxId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
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
