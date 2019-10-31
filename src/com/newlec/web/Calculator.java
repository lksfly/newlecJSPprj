package com.newlec.web;

import java.io.IOException;
import java.io.PrintWriter;
  
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calculator") //사용자가 이 url로 요청을 한다!
public class Calculator extends HttpServlet{
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		if(req.getMethod().equals("GET")) { //반드시 대문자로 비교!
//			System.out.println("get요청");
//		} else if(req.getMethod().equals("POST")) {
//			System.out.println("post요청");
//			
//		}
//		super.service(req, resp);
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet요청");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		Cookie[] cookies = req.getCookies();  // ?? req??
		String exp = "0";
		 

		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
					
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("input{");
		out.write("width:50px;");
		out.write("heigth:50px;");
		out.write("}");
		out.write(".output{");
		out.write("height:50px;");
		out.write("background:#e9e9e9;");
		out.write("font-size:24px;");
		out.write("text-align:right;");
		out.write("padding:0px 5px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("<form action=\"calculator\" method=\"post\">");  //post를 담당했던 url이 달라서 action을 지정한거지 같다면 안 써도 된다.
		out.write("<table>");
		out.write("<tr>");
		out.printf("<td class=\"output\" colspan=\"4\">%s</td>",exp);
		
							
		out.write("</tr>");	
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"CE\"/></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"C\"/></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"BS\"/></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"/\"/></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"7\"/></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"8\"/></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"9\"/></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"*\"/></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"4\"/></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"5\"/></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"6\"/></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"-\"/></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"1\"/></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"2\"/></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"3\"/></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"+\"/></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"0\"/></td>");
		out.write("<td><input type=\"submit\" name=\"dot\" value=\".\"/></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"=\"/></td>");
		out.write("</tr>");
		out.write("</table>");

				   
		out.write("</form>");
		out.write("</body>");
		out.write("</html> ");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost요청");
		Cookie[] cookies = req.getCookies();  //브라우저에서 받아온 쿠키정보(배열)
		
		String value = req.getParameter("value");
		String op = req.getParameter("operator");
		String dot = req.getParameter("dot");
		String exp = ""; //0
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		if(op != null && op.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp)); 
			} catch (ScriptException e) {
				
				e.printStackTrace();
			}
					
		}else if(op != null && op.equals("C")) {
			exp = "";
			
		}else {
			
			exp += (value == null)?"":value;
			exp += (op == null)?"":op;
			exp += (dot == null)?"":dot;
			
		}
		
		
		Cookie expCookie = new Cookie("exp", exp); // 들어온 값이나 연산이 추가된 쿠키가 새로 생성
		if(op != null && op.equals("C")) {
			expCookie.setMaxAge(0); //쿠키삭제
		}
		expCookie.setPath("/calculator");
		res.addCookie(expCookie);
		res.sendRedirect("calculator"); //get요청
		
		
		
		//자바스크립트 엔진을 써서 eval로 연산식 스트링을 한번에 계산한다.
		
		
		//결과값 전송
	}


	
}
