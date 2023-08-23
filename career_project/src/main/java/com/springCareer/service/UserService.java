package com.springCareer.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.springCareer.domain.UserVO;

public interface UserService {

	public void registerUser(UserVO user, HttpSession session);

	public List<UserVO> getList();

	public UserVO getUser(String userId);

	public UserVO login(UserVO user, HttpSession session);

	public boolean checkUserId(String userId);

	public boolean modifyUser(UserVO user);

	public boolean removeUser(String userId);

	public void logout(HttpSession session);

}
