package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.util.MybatisUtil;

public class UserService implements IUserService {

	private IUserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	@Override
	public List<User> getUserList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<User> userList = userDao.getUserList(sqlSession);
		sqlSession.close();
		
		return userList;
	}

	@Override
	public User getUser(String userId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		User user = userDao.getUser(sqlSession, userId);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> getUserListHalf() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<User> userHalfList = userDao.getUserListHalf(sqlSession);
		sqlSession.close();
		return userHalfList;
	}

	@Override
	public Map<String,Object> getUserPagingList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<User> pageList = userDao.getUserPagingList(sqlSession, page);
		int totalCnt = userDao.getUserTotalCnt(sqlSession);
		
		map.put("userList", pageList);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt / page.getPagesize()));
		
		sqlSession.close();
		
		return map;
	}

	@Override
	public int insertUser(User user) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insert = userDao.insertUser(sqlSession, user);
		sqlSession.commit();
		sqlSession.close();
		
		return insert;
	}

	@Override
	public int deleteUser(String userId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int delete = userDao.deleteUser(sqlSession, userId);
		sqlSession.commit();
		sqlSession.close();
		
		return delete;
	}

	@Override
	public int modifyUser(User user) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int modify = userDao.modifyUser(sqlSession, user);
		sqlSession.commit();
		sqlSession.close();
		
		return modify;
	}

}
