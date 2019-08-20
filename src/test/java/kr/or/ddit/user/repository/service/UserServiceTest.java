package kr.or.ddit.user.repository.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

public class UserServiceTest {
	
	private IUserService userService;
	
	@Before
	public void setup() {
		userService = new UserService();
	}

	@Test
	public void getUserListTest() {
		/***Given***/
		
		/***When***/
		List<User> userList = userService.getUserList();
		
		/***Then***/
		assertEquals(105, userList.size());
		
	}
	
	
	
	/**
	 * Method : getUserTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		//한개의메서드만 실행하고싶으면 클래스위에서 ctrl + F11을 한다
		/***Given***/
		String userId = "brown";
		
		/***When***/
		User userVo = userService.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
		assertEquals("brown1234", userVo.getPass());
		
		
		
	}
	
	/**
	 * Method : getUserListHalf
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 사용자 전체리스트중에 절반(50 개만)출력
	 */
	
	@Test
	public void getUserListHalf() {
		/***Given***/
		
		/***When***/
		List<User> userList = userService.getUserListHalf();
		
		/***Then***/
		assertEquals(50, userList.size());
	}

}
