package com.springCareer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springCareer.domain.FollowVO;
import com.springCareer.mapper.FollowMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class FollowServiceImpl implements FollowService {

	private FollowMapper mapper;

	@Override
	public void follow(FollowVO follow) {
		// TODO Auto-generated method stub
		log.info("follow : " + follow);
		mapper.follow(follow);

	}

	@Override
	public boolean unfollow(FollowVO follow) {
		// TODO Auto-generated method stub
		log.info("unfollow : " + follow);
		return mapper.unfollow(follow) == 1;
	}

	@Override
	public List<FollowVO> getFollowers(String userId) {
		// TODO Auto-generated method stub
		log.info(userId + "<-Followers List");
		return mapper.getFollowers(userId);
	}

	@Override
	public List<FollowVO> getFollowings(String userId) {
		// TODO Auto-generated method stub
		log.info(userId + "<-Followings List");
		return mapper.getFollowings(userId);
	}

	@Override
	public int getFollower(String userId) {
		// TODO Auto-generated method stub
		log.info(userId + "<- 팔로워 수");
		return mapper.getFollower(userId);
	}

	@Override
	public int getFollowing(String userId) {
		// TODO Auto-generated method stub
		log.info(userId + "<- 팔로잉 수");
		return mapper.getFollowing(userId);
	}

	@Override
	public FollowVO following(String userId, String userId2) {
		// TODO Auto-generated method stub
		log.info(userId2 + "following인지 확인");
		FollowVO followVO = new FollowVO();
		followVO.setFollowing(userId2);
		followVO.setFollower(userId);
		log.info(userId + "following인지 확인");
		return mapper.following(followVO);
	}

	@Override
	public FollowVO follower(String userId, String userId2) {
		// TODO Auto-generated method stub
		log.info(userId2 + "follower인지 확인");
		FollowVO followVO = new FollowVO();
		followVO.setFollowing(userId);
		followVO.setFollower(userId2);
		log.info(userId + "following인지 확인");
		return mapper.following(followVO);
	}

}
