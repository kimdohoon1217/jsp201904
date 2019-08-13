package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

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
	

}
