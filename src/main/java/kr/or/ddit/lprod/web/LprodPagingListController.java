package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodService;


@WebServlet("/lprodPagingList")
public class LprodPagingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ILprodService service;
	
	@Override
	public void init() throws ServletException {
		service = new LprodService();
	}
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageStr = request.getParameter("page");
		String pagesizeStr = request.getParameter("pagesize");
		
		
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pagesize = pagesizeStr == null ? 5 : Integer.parseInt(pagesizeStr);		
		
		
		Page p = new Page(page, pagesize);
		request.setAttribute("pageVo", p);
		
		
		Map<String, Object> resultMap = service.getLprodPagingList(p);
		List<Lprod> lprodList = (List<Lprod>) resultMap.get("list");
		int paginationSize = (int) resultMap.get("paginationSize");
		request.setAttribute("list", lprodList);
		request.setAttribute("paginationSize", paginationSize);
		
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(request, response);
	
	}

}
