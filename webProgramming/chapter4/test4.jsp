<%@ page import="java.io.*" contentType="text/html; charset=UTF-8" %>
<HTML> 
<HEAD> 
	<%! 
		private String call1(){
		String a = "abc"; 
		String b = "efg"; 
			PrintWriter pw = response.getWriter();	
			:<%=문자열%>
		return (a+b);
		
		}
	%> 
</HEAD> 
<BODY>
	String연산 :<%=call1()%> <br> 
	Good...
</BODY> 
</HTML>