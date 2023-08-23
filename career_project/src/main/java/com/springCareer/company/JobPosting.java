package com.springCareer.company;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class JobPosting {
	private long posting_no;
	private String business_number;
	private String position;	//공고제목
	private List<TagJob> job;	//직군/직무-5개 가능
	private TagSkill skill;		//skill 10개 가능
	private String career;
	private int salary;
	private int welcome_bonus;
	private String work_area;
	private String work_area1;
	private Date deadline;		//null이면 Deadline when recruiting
	private String description; //공고설명-100자
	private String responsibility;	//주요업무(책임)-1000자
	private String basic_qualifications;	//자격요건-1000자
	private String prefered_qualifications;	//우대조건-1000자
	private String benefits;	//혜택-1000자
	private String additional_comment;	//미래동료에게 한마디-1000자
	private String status;		//임시저장,승인대기,승인실패 draft, waitingForApproval, approvalFailed, 
								//모집중, 접수마감,채용종료 recruiting, closedNow, endOfEmployment
	
	private Company company;
}