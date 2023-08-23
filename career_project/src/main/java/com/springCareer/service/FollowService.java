package com.springCareer.service;

import java.util.List;

import com.springCareer.domain.FollowVO;

public interface FollowService {

	public void follow(FollowVO follow);

	public boolean unfollow(FollowVO follow);

	public FollowVO following(String userId, String userId2);

	public FollowVO follower(String userId, String userId2);

	public List<FollowVO> getFollowers(String userId);

	public List<FollowVO> getFollowings(String userId);

	public int getFollower(String userId);

	public int getFollowing(String userId);

}
