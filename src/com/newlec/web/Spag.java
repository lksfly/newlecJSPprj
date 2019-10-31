package com.newlec.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.MappingChange.Map;

@WebServlet("/spag")
public class Spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String result;
    	String num_ = request.getParameter("num");
    	int num = 2;
    	if(num_ !=null && !num_.equals("")){
    		num = Integer.parseInt(num_);
    	}
    	
    	if(num%2 == 0)
    		result = "짝수";
    	else
    		result = "홀수";
    	
    	request.setAttribute("reqqq", result);
    	
    	
    	
    	String[] names = {"kslee", "jo", "sdf"};
		request.setAttribute("names", names);
    	
		HashMap<String, Object> notice = new HashMap<String, Object>();
		notice.put("id",1);
		notice.put("title","el은 좋아염");
		request.setAttribute("notice", notice);
    	//redirect 새로운요청을 하게 만듬.
    	//forward  현재작업했던 내용을 이어가게 할 수있도록 뭔가 공유
    	
    	//요청을 jsp로 전달
    	RequestDispatcher dispatcher 
    		= request.getRequestDispatcher("spag.jsp"); //같은 디렉토리에 있기때문에 경로면 안씀.
    	dispatcher.forward(request, response);
	}
	
}
