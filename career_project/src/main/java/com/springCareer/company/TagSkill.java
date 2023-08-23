package com.springCareer.company;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class TagSkill {
	private String skill;
	private Long posting_no;
	
	private JobPosting jobPosting;
}
