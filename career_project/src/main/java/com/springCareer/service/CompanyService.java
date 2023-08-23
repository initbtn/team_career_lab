package com.springCareer.service;

import java.util.List;

import com.springCareer.company.CompanyAdmin;

public interface CompanyService {
	public void insertAdmin(CompanyAdmin company);
	
//	public CompanyAdmin get(String email);
//	
//	public boolean modify(CompanyAdmin company);
//	
//	public boolean remove(String c_id);
//	
//	public List<CompanyAdmin> getList();

	public CompanyAdmin login(CompanyAdmin admin);
}
