package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//J2EE ����� �� ���ø����̼� ���� �� main method�� ���� �������� �ʴ´�.
/*
   - �츮�� �ۼ��� �� ���ø����̼���(war) was(tomcat)�� webapps ���� �ؿ� �̵��� �����ָ�
       ������ �⵿ �� �� �ش� ���ø����̼��� �ڵ����� �ε�
   - �� ���ø����̼��� ���� ����  context path�� �ȴ�.(�� ���ø����̼� �̸�)
   
   *** ���� ������ ���ؼ� ������� �ٸ� context path�� �ο��ϴ� �� ���
      (������ �츮�� ���� �����Ͼ �ƴϱ� ������ �ش� �κб����� ���� �ʴ´�.)

   - Ư�� url�� ȣ���ϸ�, url�� ó�� �� �� �� �ִ� servlet�� ȣ���Ͽ� ������ �����Ѵ�.
   
   * servlet ���� ���
   1. class �� ����
   2. HttpServlet Ŭ������ ����� �Ѵ�.(J2EE spec�� ������.)
   3. doGet, doPost �޼ҵ带 �������̵� �Ѵ�.
   4. � url�� �ش� �������� ó�� �� �� ����
   (web.xml, servlet 3.0 ���� ���ʹ� servlet class ������̼����� ����)
   
*/

public class HelloServlet extends HttpServlet {

	private Logger logger = LoggerFactory.getLogger(HelloServlet.class);
	
	
   @Override
	public void init() throws ServletException {
	   logger.debug("HelloServlet init()");
//	   System.out.println("HelloServlet init()");
   }

@Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html; charset=utf-8");
      
      PrintWriter pw = resp.getWriter();
      pw.write("<html>");
      pw.write("   <head>"); 
      pw.write("      <title>helloServlet</title>"); 
      pw.write("   </head>"); 
      pw.write("   <body>"); 
      pw.write("      <h1>hello, world �ѱ� �׽�Ʈ</h1>"); 
      pw.write("   </body>"); 
      pw.write("</html>");
   }
   
   
}