package kr.or.ddit.user.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public class UserDao implements IUserDao{

	/**
	 * Method : getUserList
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<User> getUserList(SqlSession sqlSession) {
		//db에서 조회가 되었다고 가정하고 가짜 객체를 리턴
//		List<UserVo> userList = new ArrayList<UserVo>();
//		userList.add(new UserVo("brown"));
//		userList.add(new UserVo("cony"));
//		userList.add(new UserVo("sally"));
//		userList.add(new UserVo("moon"));
//		userList.add(new UserVo("james"));
		
		
		//이미사용중인 커넥션이 해제가되어야 다른게 실행되기때문에
		//자원 닫기 해야함
		
		return sqlSession.selectList("user.getUserList");
	}

	@Override
	public User getUser(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("user.getUser", userId);
	}

	@Override
	public List<User> getUserListHalf(SqlSession sqlSession) {
		return sqlSession.selectList("user.getUserListHalf");
	}

	/**
	 * Method : getUserPagingList
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param page
	 * @return
	 * Method 설명 :사용자 페이징 리스트 조회
	 */
	@Override
	public List<User> getUserPagingList(SqlSession sqlSession, Page page) {
		return sqlSession.selectList("user.getUserPagingList", page);
	}

	
	
	/**
	 * Method : getUserTotalCnt
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 전체 사용자 건수 조회
	 */
	
	@Override
	public int getUserTotalCnt(SqlSession sqlSession) {
		
		return sqlSession.selectOne("user.getUserTotalCnt");
	}

	
	/**
	 * Method : insertUser
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param user
	 * @return
	 * Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(SqlSession sqlSession, User user) {
		int insert = sqlSession.insert("user.insertUser", user);
		
		
		return insert;
				
		
	}

	/**
	 * Method : deleteUser
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 삭제
	 */
	@Override
	public int deleteUser(SqlSession sqlSession, String userId) {
		return sqlSession.delete("user.deleteUser", userId); 
	}

	/**
	 * Method : modifyUser
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param sqlSession
	 * @param map
	 * @return
	 * Method 설명 : 사용자 수정
	 */
	@Override
	public int modifyUser(SqlSession sqlSession, User user) {
		return sqlSession.update("user.modifyUser", user);
	}
	

}
