package com.springCareer.company;


import lombok.Data;

@Data
public class CompanyAdmin {
	private String userid;
	private String business_no;
	private String password;
	private String name;
	private String belong;
	private String phone;
	private String grade;	// 슈퍼/일반-접근허용된 공고에 대한 열람만 가능
	private String created_at;
	
	private Company company;
}
