package com.newlec.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req
				, HttpServletResponse res) 
				throws ServletException, IOException {
			
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = res.getWriter();
			
			String[] num_ = req.getParameterValues("num");
			
			int result = 0;
			
			for(int i=0; i<num_.length; i++) {
				int num = Integer.parseInt(num_[i]);  //선언은 반복되지 않는다.
				result += num;
			}
			
			out.println("결과: "+ result);
			
			
		}
	
	
}
