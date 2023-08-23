package com.springCareer.company;

import java.util.Date;
import java.util.List;

import com.springCareer.domain.UserVO;

import lombok.Data;
@Data
public class BookmarkJobPosting {
	private String userId;
	private long posting_no;
	private Date create_at;
	
	private List<BookmarkJobPosting> listBookmarkJob;
	private List<UserVO> listUser;
}
