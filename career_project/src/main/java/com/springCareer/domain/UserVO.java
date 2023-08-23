package com.springCareer.domain;

import lombok.Data;

@Data
public class UserVO {

	private String userId;
	private String userPassword;
	private String userName;
	private String userEmail;
	private String userNickname;
	private String userAddress;
	private String userPhone;
	private String userCreatedAt;

}
