package com.newlec.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req
				, HttpServletResponse res) 
				throws ServletException, IOException {
			
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = res.getWriter();
				
			
			int x = Integer.parseInt(req.getParameter("x"));
			int y = Integer.parseInt(req.getParameter("y"));
			int result = 0;
			String buttonName = req.getParameter("button");
			
			if(buttonName.equals("덧셈")) {
				result = x+y;
			}else {
				result = x-y;
			}
			out.print(buttonName);
			out.printf("result is %d", result);
			
			
		}
	
	
}
