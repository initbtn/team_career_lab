package com.springCareer.company;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class AccessJobPosting {
	private String email; 
	private long postingNo;
	private Date create_at;
	
	private List<BookmarkJobPosting> listAccessJob;
	private List<CompanyAdmin> listAdmin;
}
