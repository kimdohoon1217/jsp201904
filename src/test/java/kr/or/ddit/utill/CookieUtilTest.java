package kr.or.ddit.utill;

import static org.junit.Assert.*;

import org.junit.Test;

public class CookieUtilTest {

	/**
	 * Method : getCookieTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 쿠기 가져오기 테스트
	 */
	@Test
	public void getCookieTest() {
		/***Given***/
		String cookieString = "userId=brown; rememberme=Y; test=testValue";
		
		/***When***/
		String cookieValue = CookieUtil.getCookie(cookieString, "userId");
		String rememberMecookieValue = CookieUtil.getCookie(cookieString, "rememberme");
		String testCookieValue = CookieUtil.getCookie(cookieString, "test");
		String notExistsCookieValue = CookieUtil.getCookie(cookieString, "notExists");

		/***Then***/
		assertEquals("brown", cookieValue);
		assertEquals("Y", rememberMecookieValue);
		assertEquals("testValue", testCookieValue);
		assertNull(notExistsCookieValue);
	}

}
