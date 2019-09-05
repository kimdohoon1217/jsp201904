package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.utill.FileuploadUtil;


@WebServlet("/userModify")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5) 
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static final Logger logger = LoggerFactory.getLogger(UserFormController.class);
    
    private IUserService userService;
    
    @Override
    public void init() throws ServletException {
    	userService = new UserService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("userId");
		
		User user = userService.getUser(id);
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/user/userModiForm.jsp").forward(request, response);
	}

	
	/**
	 * Method : doPost
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 사용자 등록 요청
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userNm = request.getParameter("userNm");
		String alias = request.getParameter("alias");
		String reg_dt = request.getParameter("reg_dt");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String pass = request.getParameter("pass");
		
		Date reg_dt_date = null;
		
		//파일가져올때는 getPart를 사용한다.
		Part picture = request.getPart("picture");
		
		
		User user1 = userService.getUser(userId);
		
		String filename = "";
		String path = "";
		//사용자가 파일을 업로드 한경우
		if(picture.getSize() > 0) {
			filename = FileuploadUtil.getFilename(picture.getHeader("Content-Disposition")); 	//사용자가 업로드한 파일명
			String realFilename = UUID.randomUUID().toString();
			String ext = FileuploadUtil.getFileExtension(picture.getHeader("Content-Disposition"));
			
			//실제저장할 경로에 UUID를 통해 중복을 피하고 파일을 저장하는것
			path = FileuploadUtil.getPath() + realFilename + ext;
			
			picture.write(path);
			
			new File(user1.getRealFilename()).delete();
		}else {
			
			
			// 파일 수정 안했을 떄
			filename = user1.getFilename();
			path = user1.getRealFilename();
		}
		
		try {
			reg_dt_date = new SimpleDateFormat("yyyy-MM-dd").parse(reg_dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		logger.debug("user parameter : {}, {}, {}, {}, {}, {}, {}, {}",
				userId, userNm, alias, reg_dt, addr1, addr2, zipcode, pass);
		
		//사용자 등록
		User user = new User(userId, userNm, alias, reg_dt_date, addr1, addr2, zipcode, pass, filename, path);
		int modiCnt = 0; 

		try {
			modiCnt = userService.modifyUser(user);
			if(modiCnt == 1) {
				response.sendRedirect(request.getContextPath() + "/user?userId=" + userId);
			}
		}catch(Exception e) {
			doGet(request, response);
		}
	}
}
