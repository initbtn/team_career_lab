package com.springCareer.mapper;

import java.util.List;

import com.springCareer.company.CompanyAdmin;

public interface CompanyMapper {
	public CompanyAdmin getById(String email);
	
	public CompanyAdmin login(CompanyAdmin admin);

	public List<CompanyAdmin> getList();
	
	public void insert(CompanyAdmin admin);
	
	public CompanyAdmin read(String email);
	
	public int delete(String email);
	
	public int update(CompanyAdmin admin);

}
