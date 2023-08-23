package com.springCareer.company;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class Company {
	private String business_no;
	private String name;
	private String business_license; //사업자등록증,file upload
	private String address;
	private String address1;		//상세주소용-초기 pending
	private String discription;		//회사소개-2000자
	private String industry;		//산업군
	private String employee_size;	//직원수
	private String annual_sales_volume;	//연매출
	private String investment_volume;	//누적투자금액
	private String homepage;			//홈페이지
	private List<TagCompany> representative_company;	//회사태그
	private String logo;				//회사로고,file upload
	private String representative_image;	//대표이미지,file upload
	private String created_at;			//생성일
	private String status; 				//승인대기,승인실패 waitingForApproval, approvalFailed, 

	private List<CompanyAdmin> companyAdmin;
}
