package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/jsp/sumInput.jsp");
//		int sum = 0;
//		int s = Integer.parseInt( request.getParameter("start"));
//		int e = Integer.parseInt( request.getParameter("end"));
//		
//		for(int i = s; i <= e; i++) {
//			sum += i;
//		}
//		
//		logger.debug(String.valueOf(sum));
//		
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("sumResult", sum);
//		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sum = 0;
		if(request.getParameter("start") == null) {
			
		}
		
		int s = Integer.parseInt( request.getParameter("start"));
		int e = Integer.parseInt( request.getParameter("end"));
		
		
		for(int i = s; i <= e; i++) {
			sum += i;
		}
		
//		logger.debug(String.valueOf(sum));
		logger.debug("sum : {}", sum);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sum);
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
	}

}
