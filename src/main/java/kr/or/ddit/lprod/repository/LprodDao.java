package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.util.MybatisUtil;

public class LprodDao implements ILprodDao{

	@Override
	public List<Lprod> getLprodList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Lprod> lprodList = sqlSession.selectList("lprod.getLprodList");
		
		sqlSession.close();
		
		return lprodList;
	}

	@Override
	public List<Lprod> getLprodPagingList(SqlSession sqlSession, Page page) {
		
		return sqlSession.selectList("lprod.getLprodPagingList", page);
	}

	@Override
	public int getLprodTotalCnt(SqlSession sqlSession) {

		return sqlSession.selectOne("lprod.getLprodTotalCnt");
	}
	

}
