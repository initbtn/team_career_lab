package com.springCareer.mapper;

import java.util.List;

import com.springCareer.domain.FollowVO;

public interface FollowMapper {

	public List<FollowVO> getFollowers(String userId);

	public List<FollowVO> getFollowings(String userId);

	public int getFollower(String userId);

	public int getFollowing(String userId);

	public void follow(FollowVO follow);

	public int unfollow(FollowVO follow);

	public FollowVO following(FollowVO follow);

	public FollowVO follower(FollowVO follow);
	
	public FollowVO deleteFollow(FollowVO follow);

}
