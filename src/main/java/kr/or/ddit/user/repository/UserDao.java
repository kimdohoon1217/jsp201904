package kr.or.ddit.user.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.MybatisUtil;

public class UserDao implements IUserDao{

	/**
	 * Method : getUserList
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<UserVo> getUserList() {
		//db에서 조회가 되었다고 가정하고 가짜 객체를 리턴
//		List<UserVo> userList = new ArrayList<UserVo>();
//		userList.add(new UserVo("brown"));
//		userList.add(new UserVo("cony"));
//		userList.add(new UserVo("sally"));
//		userList.add(new UserVo("moon"));
//		userList.add(new UserVo("james"));
		
		SqlSession sqlSession = MybatisUtil.getSession();
		List<UserVo> userList = sqlSession.selectList("user.getUserList");
		
		//이미사용중인 커넥션이 해제가되어야 다른게 실행되기때문에
		//자원 닫기 해야함
		sqlSession.close();
		
		return userList;
	}

	@Override
	public UserVo getUser(String userId) {
		SqlSession sqlSession =  MybatisUtil.getSession();
		UserVo userVo = sqlSession.selectOne("user.getUser", userId);
		
		sqlSession.close();
		
		return userVo;
	}

}
