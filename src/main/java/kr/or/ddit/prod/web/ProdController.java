package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.repository.IProdDao;
import kr.or.ddit.prod.repository.ProdDao;

/**
 * Servlet implementation class ProdController
 */
@WebServlet("/prod")
public class ProdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IProdDao prodDao;
  

	@Override
		public void init() throws ServletException {
			prodDao = new ProdDao();
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodLgu = request.getParameter("prod");
		
		List<Map> list = prodDao.getProd(prodLgu);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/prod/prodList.jsp").forward(request, response);
		
	}

	

}
