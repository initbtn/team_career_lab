package com.springCareer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springCareer.company.CompanyAdmin;
import com.springCareer.mapper.CompanyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
	
	private final CompanyMapper mapper;
	
	@Override
	public void insertAdmin(CompanyAdmin admin) {
		log.info("register......" + admin);
		mapper.insert(admin);
	}
	
//	@Override
//	public CompanyAdmin get(String email) {
//		log.info("get......" + email);
//		return mapper.read(email);
//	}
//
//	@Override
//	public boolean modify(CompanyAdmin company) {
//		log.info("modify......" + company);
//		return mapper.update(company) == 1;
//	}
//
//	@Override
//	public boolean remove(String c_id) {
//		log.info("remove......" + c_id);
//		return mapper.delete(c_id) == 1;
//	}
//
//	@Override
//	public List<CompanyAdmin> getList() {
//		log.info("getList......");
//		return mapper.getList();
//	}

	@Override
	public CompanyAdmin login(CompanyAdmin admin) {
		String email=admin.getUserid();
		String password=admin.getPassword();
		admin=mapper.login(admin);
		
		if(admin!=null)
			return admin;
		else
			return null;		
	}


}
