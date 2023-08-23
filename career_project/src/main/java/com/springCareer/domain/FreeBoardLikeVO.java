package com.springCareer.domain;

import java.sql.Date;


import lombok.Data;

@Data
public class FreeBoardLikeVO {

	private Long like_id;
	private Long post_id;
	private String userId;
	private Date created_at;
	private Long likecheck;
}
