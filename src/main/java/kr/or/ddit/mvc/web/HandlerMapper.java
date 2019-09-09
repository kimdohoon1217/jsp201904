package kr.or.ddit.mvc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.model.UrlMapping;
import kr.or.ddit.mvc.repository.IUrlMappingDao;
import kr.or.ddit.mvc.repository.UrlMappingDao;

public class HandlerMapper {
	
	private Map<String, IController> uriMapping;
	
	public HandlerMapper() {
		
		//아래 데이터는 데이터베이스의 정보를 바탕으로 생성 되었다고 가정 - 현재는 하드코딩
		uriMapping = new HashMap<String, IController>();
		
		IUrlMappingDao dao = new UrlMappingDao();
		
		// url, controller의 full name --> 인스턴스 생성
		List<UrlMapping> urlMappingList = dao.getUrlMapping();
		
		for(UrlMapping urlMapping : urlMappingList) {
			String controllerStr = urlMapping.getController();
			
			//new 
			//new UserListController 해주는방법을 동적으로하기위해서 밑에방법사용
			
			try {
				//return class타입의 객체 class는 자바용어에잇으므로 clazz를 사용한다
				Class clazz = Class.forName(controllerStr);
				//Object타입반환
				IController controller = (IController)clazz.newInstance();
				uriMapping.put(urlMapping.getUrl(), controller);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		//uriMapping.put("/mvc/userList.do", new UserListController());
		//uriMapping.put("/mvc/memberList.do", new MemberListController());
		//uriMapping.put("/mvc/user.do", new UserController());
		//uriMapping.put("/mvc/userForm.do", new UserFormController());
	}

	/**
	 * Method : getContoller
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param uri
	 * @return
	 * Method 설명 : uri를 처리해주는 컨트롤러를 리턴
	 */
	public IController getContoller(String uri) {
		return uriMapping.get(uri);
	}
	
}
