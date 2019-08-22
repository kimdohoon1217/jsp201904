package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.util.MybatisUtil;

public class LprodDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(LprodDaoTest.class);
	
	private ILprodDao lprodDao;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		logger.debug("before");
		lprodDao = new LprodDao();
		sqlSession = MybatisUtil.getSession();
	}
	
	//테스트에 공톡적으로 사용한 자원을 해제
	@After
	public void tearDown() {
		logger.debug("after");
		sqlSession.close();
	}

	@Test
	public void getLprodListTest() {
		/***Given***/
		
		/***When***/
		List<Lprod> lprodList = lprodDao.getLprodList();

		/***Then***/
		assertEquals(10, lprodList.size());
	}
	
	@Test
	public void getLprodPagingListTest() {
		
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(5);

		/***When***/
		List<Lprod> lprodList = lprodDao.getLprodPagingList(sqlSession, page);

		/***Then***/
		assertEquals("1", lprodList.get(0).getLprod_id());
		assertEquals(5, lprodList.size());
	}
	

}
