package kr.or.ddit.prod.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;

public class ProdDao implements IProdDao {

	@Override
	public List<Map> getProd(String id) {
		List<Map> list = null;
		
		SqlSession sqlSession = MybatisUtil.getSession();
		list = sqlSession.selectList("prod.getProd", id);
		
		sqlSession.close();
				
		return list;
	}

}
