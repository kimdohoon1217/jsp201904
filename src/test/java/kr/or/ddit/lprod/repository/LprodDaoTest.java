package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.lprod.model.Lprod;

public class LprodDaoTest {

	@Test
	public void getLprodListTest() {
		/***Given***/
		ILprodDao lprodDao = new LprodDao();
		
		/***When***/
		List<Lprod> lprodList = lprodDao.getLprodList();

		/***Then***/
		assertEquals(10, lprodList.size());
	}

}
