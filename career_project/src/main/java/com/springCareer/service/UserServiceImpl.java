package com.springCareer.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.springCareer.domain.CareerBoardVO;
import com.springCareer.domain.FollowVO;
import com.springCareer.domain.UserVO;
import com.springCareer.mapper.CareerBoardMapper;
import com.springCareer.mapper.FollowMapper;
import com.springCareer.mapper.FreeBoardMapper;
import com.springCareer.mapper.FreeLikeMapper;
import com.springCareer.mapper.FreeReplyMapper;
import com.springCareer.mapper.UserMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserMapper mapper;
	private FreeBoardMapper boardMapper;
	private FreeLikeMapper likeMapper;
	private FreeReplyMapper replyMapper;
	private CareerBoardMapper careerMapper;
	private FollowMapper followMapper;

	@Override
	public boolean checkUserId(String userId) {
		// TODO Auto-generated method stub
		log.info("유저 ID 중복여부 : " + userId);
		if (mapper.checkUserId(userId) != null) { // 중복
			return true;
		} else { // 가능
			return false;
		}
	}

	@Override
	public void registerUser(UserVO user, HttpSession session) {
		// TODO Auto-generated method stub
		log.info("등록 -> " + user);

		mapper.insertUser(user);
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("userName", user.getUserName());

	}

	@Override
	public UserVO getUser(String userId) {
		// TODO Auto-generated method stub
		log.info("유저ID -> " + userId);
		return mapper.readUser(userId);
	}

	@Override
	public List<UserVO> getList() {
		// TODO Auto-generated method stub
		log.info("유저들 -> ");
		return mapper.getUserList();
	}

	@Override
	public boolean modifyUser(UserVO user) {
		// TODO Auto-generated method stub
		log.info("유저 수정 ->" + user);
		return mapper.updateUser(user) == 1;
	}

	@Override
	public boolean removeUser(String userId) {
		// TODO Auto-generated method stub
		log.info("유저 삭제 -> " + userId);
		
		Long postId = boardMapper.getPostId(userId);
		CareerBoardVO career = new CareerBoardVO();
		career.setCrbId(-1L);
		career.setPrIntro("");
		career.setPrPic("");
		if(careerMapper.readCareer(userId) != null) {
			career = careerMapper.readCareer(userId);
			careerMapper.deleteCareer(career.getCrbId());
		} 
		if(postId != null) {
		likeMapper.delete(postId);
		replyMapper.deleteReply(postId);
		boardMapper.delete(postId);
		}
		
		FollowVO follow = new FollowVO();
		follow.setFollowing(userId);
		follow.setFollower(userId);
		
		if((followMapper.following(follow) != null) || (followMapper.follower(follow) != null)) {
		followMapper.deleteFollow(follow);
		}
		return mapper.deleteUser(userId) == 1;
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate();
	}

	@Override
	public UserVO login(UserVO user, HttpSession session) {
		// TODO Auto-generated method stub
		UserVO user2 = mapper.loginUser(user);
		log.info(user.getUserPassword() + "<비밀번호 체크>" + user2.getUserPassword());
		if (user.getUserPassword().equals(user2.getUserPassword())) {
			session.setAttribute("userId", user2.getUserId());
			session.setAttribute("userName", user2.getUserName());
			return user2;
		} else {
			user = null;
			log.info("로그인 불가 " + user);
			return user;
		}
	}

}
