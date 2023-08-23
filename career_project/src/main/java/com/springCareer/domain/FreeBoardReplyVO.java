package com.springCareer.domain;

import java.sql.Date;


import lombok.Data;

@Data
public class FreeBoardReplyVO {

	private Long comment_id;
	private Long post_id;
	private String userId;
	private String content;
	private Date created_at;
}
