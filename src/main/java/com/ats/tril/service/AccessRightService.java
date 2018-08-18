package com.ats.tril.service;

import java.util.List;

import com.ats.tril.model.AccessRightModule;
import com.ats.tril.model.AssignRoleDetailList;
import com.ats.tril.model.Info;
import com.ats.tril.model.User;

public interface AccessRightService {

	List<AccessRightModule> getAllModulAndSubModule();

	Info saveAssignRole(AssignRoleDetailList assignRoleDetailList);

	List<AssignRoleDetailList> getAllAccessRole();
	
	Info updateRoleIdByEmpId(int id, int roleId);

	List<User> getAllUser();

	String getRoleJson(int usrId);

	
	
}
