package com.newlec.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req
				, HttpServletResponse res) 
				throws ServletException, IOException {
			
			ServletContext application = req.getServletContext();
			HttpSession session = req.getSession();
		
			
			//쿠키읽기
			Cookie[] cookies = req.getCookies();  //브라우저에서 받아온 쿠키정보(배열)
			
					
			System.out.println("파라미터들:"+ req.getParameterNames());
			System.out.println("쿠키길이는 " + cookies.length);
			System.out.println(Arrays.toString(cookies));
			System.out.println(JsonUtil.toString(cookies[0]));
			System.out.println(JsonUtil.toString(cookies[0].getName()));
			//System.out.println(cookies[0]);
			//System.out.println(cookies[0]);
			
			String ck = req.getHeader("Cookie");
			System.out.println("쿠키헤더는"+ck);
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = res.getWriter();
			  
			
			
//			int v = Integer.parseInt(req.getParameter("v"));  //현재값
//			System.out.println(v);
//			String op = req.getParameter("operator");
//			System.out.println("현재op는 "+op);
//			
//			//계산
//			if(op.equals("=")) {
//				
//				int x= 0;
//				int result = 0;
//				String operator = "";
				
				//int x = (Integer) application.getAttribute("value");  //저장되있는 값
				//int x = (Integer) session.getAttribute("value");  //저장되있는 값
				
				//String operator = (String) application.getAttribute("op");  //저장되있는 연산
				//String operator = (String) session.getAttribute("op");
								
//				for(Cookie c : cookies) {
//					if(c.getName().equals("value")) {
//						x= Integer.parseInt(c.getValue());
//						int aaaa = Integer.parseInt(c.getValue());
//						System.out.println("aaaa:"+ aaaa);
//						System.out.println("x는 "+ x);
//						break;
//					}
//				}
//				PrintWriter script = res.getWriter();
//				script.println("<script>");
//				script.println("location.href = 'main.jsp'");
//				script.println("</script>");
//				
//				for(Cookie c : cookies) {
//					System.out.println(c.getValue());
//					if(c.getName().equals("op")) {
//						System.out.println("op는"+c.getValue());
//						operator = c.getValue();
//						System.out.println("operator는 "+operator);
//						break;
//					}
//					
//				}
//				
//				int y = v;  //현재 값
//				System.out.println("y는:" + y);
//				
//								
//				if(operator.equals("+")) {
//					result = x+y;
//					res.getWriter().printf("결과: %d",result);
//					
//				}else{
//					result=x-y;
//					res.getWriter().printf("결과: %d",result);
//				}
//				
//			//값을 저장	
//			}else {
//				//session.setAttribute("value", v);
//				//session.setAttribute("op", op);
//				
//				Cookie valueCookie = new Cookie("value", String.valueOf(v));  //쿠키는 반드시 문자열로만 저장되어야 한다. 
//				Cookie opCookie = new Cookie("op", op);
//				valueCookie.setPath("/calc2");
//				valueCookie.setMaxAge(24*60*60);
//				opCookie.setPath("/calc2");
//				
//				res.addCookie(valueCookie); //response header에 전해진다.
//				res.addCookie(opCookie);
				
//				PrintWriter script = res.getWriter();
//				script.println("<script>");
//				script.println("location.href = 'calc2.html'");
//				script.println("</script>");
				//res.sendRedirect("calc2.html");
				
//			}
			
			
			//int v = 0;  //초기값 설정
			
			
			
		}
	
	
}
