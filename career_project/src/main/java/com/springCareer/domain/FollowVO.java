package com.springCareer.domain;

import java.util.List;

import lombok.Data;

@Data
public class FollowVO {

	private Long followId;
	private String following;
	private String follower;
	private List<FollowVO> followers;
}
