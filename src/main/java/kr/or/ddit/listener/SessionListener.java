package kr.or.ddit.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;

public class SessionListener implements HttpSessionAttributeListener{
	
	private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		//사용자가 정상적으로 로그인 했을때 session 에 추가되는 S_USERVO값을 기준으로
		//S_USERVO 속성이 세션에 추가 될떄 application객체에 사용자를 추가를 해서
		//현재 접속한 사용자 리스트를 보여주는 화면을 개발
		String attrName = event.getName();	//session에 추가된 속성 이름
		//logger.debug("attributeAdded, {}", attrName);
		if(attrName.equals("S_USERVO")) {
			
			//session객체를 통해 application객체에 접근
			ServletContext sc = event.getSession().getServletContext();
			List<User> s_uservo_list = (List<User>) sc.getAttribute("S_USERVO_LIST");
			s_uservo_list.add((User)event.getValue());
			//logger.debug("attributeAdded, {}", ((User)event.getValue()).getUserId());
			
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		logger.debug("attributeRemoved");
		
		//사용자가 로그아웃 한 경우 
		//S_USERVO_LIST에서 해당 사용자 정보를 제거한다
		String attrName = event.getName();
		if(attrName.equals("S_USERVO")) {
			ServletContext sc = event.getSession().getServletContext();
			List<User> userList = (List<User>) sc.getAttribute("S_USERVO_LIST");
			
			//unbind 되는 값을 빼준다
			userList.remove(event.getValue());
		}
			
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
		String attrName = event.getName();	//session에 추가된 속성 이름
		//logger.debug("attributeAdded, {}", attrName);
		if(attrName.equals("S_USERVO")) {
		
			//새롭게 변경된 사용자 세션 정보
			HttpSession session = (HttpSession)event.getSource();
			User user = (User)session.getAttribute("S_USERVO");
			
			//기존 사용자 세션 정보
			User oldUser = (User)event.getValue();
			
			ServletContext sc = event.getSession().getServletContext();
			List<User> s_uservo_list = (List<User>)sc.getAttribute("S_USERVO_LIST");
			
			s_uservo_list.remove(oldUser);	//기존 사용자 제거
			s_uservo_list.add(user);		//신규 사용자 등록
		}
	}

}
