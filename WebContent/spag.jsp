<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--     <%
    	String statement = "";
    	String num_ = request.getParameter("num");
    	int num = 2;
    	if(num_ !=null && !num_.equals("")){
    		num = Integer.parseInt(num_);
    	}
    	
    	if(num%2 == 0)
    		statement = "짝수";
    	else
    		statement = "홀수";
    	
    
    %> --%>
<!-- --------------------------------------------------------------------- -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
pageContext.setAttribute("aa","hello");
pageContext.setAttribute("names","hi~!~!~!~!~!");
%>
<body>
	<%=request.getAttribute("reqqq")%>입니다요.<br>
	${reqqq}입니다잉.<br>
	${requestScope.names[0]}<br>
	${names}<br>
	파라미터값 num은?<%=request.getParameter("num") %>	<br>
	${notice.title}<br>
	${aa}<br>
	${param.num lt"3"}<br>
	empty 체크 ${empty param.num}<br>
	삼항연산자 사용 ${empty param.num ? '값이비어있습니다': param.num }<br>
	
	${header.accept}
	
	
</body>
</html>