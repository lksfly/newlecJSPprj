package com.newlec.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/myCalcPage")
public class My_CalcPage extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req
				, HttpServletResponse res) 
				throws ServletException, IOException {

			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8");
			
			
			HttpSession session = req.getSession();
			
			PrintWriter out = res.getWriter();
			
			
			Cookie[] cookies = req.getCookies();
			String[] cookieArr = new String[20] ;
			String expression ="";
			int result=0;
			String op ="";
			String v_ = "";
			
			//if(req.getParameterNames()==null)
			if(req.getParameter("value") != null) { //숫자면  -> 
				v_ = req.getParameter("value");
				Cookie valueCookie = new Cookie("value",v_);
				res.addCookie(valueCookie);
				//expression += v_;
				
				for(Cookie c : cookies) {
					if(c.getName().equals("operator")) { //전에 연산이 있었으면
						if(c.getValue().equals("+")) { //+이면
							result = result + Integer.parseInt(v_);
							System.out.println("result1:"+result);
							
						}else if(c.getValue().equals("-")) { //-이면
							result = result - Integer.parseInt(v_);
							
						}
						break;
					}else { //전에 연산이없었으면 => 처음 숫자입력이면
						result = Integer.parseInt(v_);
						expression += result;
						break;
					}
				}
			}else if(req.getParameter("operator") != null){ //연산이면
				op = req.getParameter("operator");
				if(op.equals("=")) {
					expression= String.valueOf(result);
					
				}else {
					Cookie opCookie = new Cookie("op", op);
					res.addCookie(opCookie);
					expression += op;
					
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
			out.write("<form action=\"myCalcPage\" method=\"post\">");
			out.write("<table>");
			out.write("<tr>");
			out.printf("<td class=\"output\" colspan=\"4\">%s</td>",expression);
								
			out.write("</tr>");	
			out.write("<tr>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"CE\"/></td>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"C\"/></td>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"BS\"/></td>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"÷\"/></td>");
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"7\"/></td>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"8\"/></td>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"9\"/></td>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"×\"/></td>");
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"4\"/></td>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"5\"/></td>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"6\"/></td>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"－\"/></td>");
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
	
	
}
