package com.springCareer.domain;

import java.util.List;

import lombok.Data;

@Data
public class CareerBoardVO {

	private Long crbId;
	private String userId;
	private String prIntro;
	private String prPic;
	private String createAt;
	private List<UserVO> userList;

}
