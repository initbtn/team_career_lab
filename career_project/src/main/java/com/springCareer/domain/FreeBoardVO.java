package com.springCareer.domain;

import java.sql.Date;



import lombok.Data;

@Data
public class FreeBoardVO {

	private Long post_id;
	private String userId;
	private String title;
	private String content;
	private Long hit;
	private Date created_at;
}
