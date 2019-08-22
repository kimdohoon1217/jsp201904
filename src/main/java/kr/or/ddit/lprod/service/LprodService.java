package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.lprod.repository.ILprodDao;
import kr.or.ddit.lprod.repository.LprodDao;
import kr.or.ddit.util.MybatisUtil;

public class LprodService implements ILprodService {

	private ILprodDao lprodDao;
	
	public LprodService() {
		lprodDao = new LprodDao();
	}
	
	@Override
	public Map<String, Object> getLprodPagingList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<Lprod> lprodList = lprodDao.getLprodPagingList(sqlSession, page);
		int totalCnt = lprodDao.getLprodTotalCnt(sqlSession);
		
		map.put("list", lprodList);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt / page.getPagesize()));
		
		sqlSession.close();
		
		
		return map;
	}

}
