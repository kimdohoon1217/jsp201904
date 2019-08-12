package kr.or.ddit.dbConnection;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//loadOnStartup 속성 설정에 의해
// /DbcpServlet으로 최초 요청이 오지 않더라도
// 서버가 가동되는 과정에서 init메소드를 호출이 이루어 진다.
@WebServlet( urlPatterns = "/DbcpServlet", loadOnStartup = 1)
public class DbcpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private static final Logger logger = LoggerFactory.getLogger(DbcpServlet.class);

	//connection pool을 참조할수있게 servletConfig로 한다
	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.debug("DbcpServlet init()");
		
		//servlet application(servletContext) 얻어오기
		//JSP : application / session / request / pageContext(page)
		//serlvet : ???? / request.getSession() / request / N/A
		
		//application (서버상 하나밖에 없는 스코프)
		ServletContext application = config.getServletContext();
		
		//database connection pool 객체를 생성
		//pool 에다가 dbConnection 객체를 넣어두고 필요할때마다 사용하는것 
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("KDH");
		ds.setPassword("java");
		ds.setInitialSize(10);
		
		//응용프로그램단위페이지에 ds객체를 만든것 응용프로그램 전체에서 사용가능
		application.setAttribute("ds", ds);
	}
	
	
}
