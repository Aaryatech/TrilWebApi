package com.ats.tril.service;

import java.util.List;

import com.ats.tril.model.Department;
import com.ats.tril.model.GetUserType;
import com.ats.tril.model.Info;
import com.ats.tril.model.LoginResponse;
import com.ats.tril.model.User;



public interface UserService {

	public LoginResponse findUserByUsername(String username,String password);

	public String save(User user);

	public Info insertUser(User user);

	public List<Department> getAllDept();

	public List<GetUserType> getAllUserType();
}
