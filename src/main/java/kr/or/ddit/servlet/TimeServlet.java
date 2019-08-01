package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeServlet extends HttpServlet {
	
	//인터페이스 로거를 사용
	private static final Logger logger = LoggerFactory.getLogger(TimeServlet.class);
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("TimesTablesServlet doGet()");
		
		String method = req.getMethod();
		
		//로거를 사용할때는 {} ", 값  
		//값이 늘어날때는 {}로와 값을 더 추가해줘야한다.
		logger.debug("debug TimesTablesServlet doGet() {} {}", method, method+"test");
		logger.trace("trace TimesTablesServlet doGet()");
		logger.info("info TimesTablesServlet doGet()");
		logger.warn("warn TimesTablesServlet doGet()");
		logger.error("error TimesTablesServlet doGet()");
		
		resp.setContentType("text/html; charset=utf-8");
		  
		  
		      
	      PrintWriter pw = resp.getWriter();
	      pw.write("<html>");
	      pw.write("<style>");
	      pw.write("   td{ padding : 10px};");
	      pw.write("</style>");
	      pw.write("   <body>"); 
	      pw.write("      <h1>구구단 테이블</h1>");
	      pw.write(" <table border = 1>");
	      for(int i = 1; i <= 9; i++) {
	    	  pw.write("          <tr> ");
	    	  for(int j = 2; j <= 9; j++) {
	    		  pw.write("<td>" + j + "  *  " + i + " = " + (j*i) + "</td>");
	    	  }
	    	  pw.write("           </tr>");
	      }
	      pw.write("    </table>");
	      
	      pw.write("   </body>"); 
	      pw.write("</html>");
	      
	
	}
	
}