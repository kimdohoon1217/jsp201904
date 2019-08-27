package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public interface IUserService {
	
	/**
//	 * Method : getUserList
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 사용자 리스트 조회
	 */
	List<User> getUserList();
	
	/**
	 * Method : getUser
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 상세조회
	 */
	User getUser(String userId);
	
	/**
	 * Method : getUserListHalf
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 리스트 조회(절반)
	 */
	List<User> getUserListHalf();
	
	

	/**
	 * Method : getUserPagingList
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param page
	 * @return
	 * Method 설명 :사용자 페이징 리스트 조회
	 */
	Map<String, Object> getUserPagingList(Page page);
	
	
	int insertUser(User user);
	
	int deleteUser(String userId);
	
	int modifyUser(User user);
	
}
