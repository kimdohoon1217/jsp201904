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
	
	//�������̽� �ΰŸ� ���
	private static final Logger logger = LoggerFactory.getLogger(TimeServlet.class);
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("TimesTablesServlet doGet()");
		
		String method = req.getMethod();
		
		//�ΰŸ� ����Ҷ��� {} ", ��  
		//���� �þ���� {}�ο� ���� �� �߰�������Ѵ�.
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
	      pw.write("      <h1>������ ���̺�</h1>");
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
