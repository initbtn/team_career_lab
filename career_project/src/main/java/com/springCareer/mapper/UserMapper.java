package com.springCareer.mapper;

import java.util.List;

import com.springCareer.domain.UserVO;

public interface UserMapper {

	public List<UserVO> getUserList();

	public UserVO readUser(String userId);
	
	public UserVO loginUser(UserVO user);

	public UserVO checkUserId(String userId);
	
	public UserVO checkUserPw(String userPassword);

	public void insertUser(UserVO user);
	
	public void deletePost(Long post_id);

	public int deleteUser(String userId);

	public int updateUser(UserVO user);

}
