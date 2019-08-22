package kr.or.ddit.lprod.repository.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.repository.ILprodDao;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.user.model.User;

public class LprodServiceTest {
	
	private ILprodService lprodService;
	
	public void setup() {
		lprodService = new LprodService();
	}
	
	public void getLprodPagingList() {
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(5);

		/***When***/
		Map<String, Object> resultMap = lprodService.getLprodPagingList(page);
		List<User> lprodList = (List<User>)resultMap.get("list");
		int paginationSize = (Integer)resultMap.get("paginationSize");

		/***Then***/
		assertEquals(5, lprodList.size());
		assertEquals("1", lprodList.get(0).getUserId());
		assertEquals(2, paginationSize);
	}
	
	@Test
	public void ceilingTest() {
		/***Given***/
		int totalCnt = 10;
		int pagesize = 5;
		
		/***When***/
		double paginationSize = Math.ceil((double)totalCnt / pagesize);

		/***Then***/
		assertEquals(2, (int)paginationSize);
	}
	

	
}
