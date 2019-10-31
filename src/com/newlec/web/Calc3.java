package com.newlec.web;
 
import java.io.IOException;

import javax.management.StringValueExp;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req
				, HttpServletResponse res) 
				throws ServletException, IOException {
			
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
				//expCookie.setMaxAge(0); //쿠키삭제
				
			}else {
				
				exp += (value == null)?"":value;
				exp += (op == null)?"":op;
				exp += (dot == null)?"":dot;
				
			}
			
			
			Cookie expCookie = new Cookie("exp", exp); // 들어온 값이나 연산이 추가된 쿠키가 새로 생성
			if(op != null && op.equals("C")) {
				expCookie.setMaxAge(0); //쿠키삭제
			}
			res.addCookie(expCookie);
			res.sendRedirect("calcPage");
			
			
			
			//자바스크립트 엔진을 써서 eval로 연산식 스트링을 한번에 계산한다.
			
			
			//결과값 전송
		}
	
	
}
