<meta http-equiv="Content-Type" content text/html; charset-utf-8" /> 
<%@ page contentType="text/html; charset=utf-8" %> 
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%> 
<%@ page errorPage="error.jsp" %> 
<html>
<head> 
</head> 
<body>
<%
	Class.forName ("com.mysql.cj.jdbc.Driver");  
	Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	Statement stmt = conn.createStatement(); 
	ResultSet rset = stmt.executeQuery("select * from examtable;");
%>
<h1>조회</h1>
<table cellspacing=1 width 600 border=1>
	<tr>
		<td width=50><p align=center>이름</p></td> 
		<td width=50><p align=center>학번</p></td>
		<td width=50><p align=center>국어</p></td>
		<td width=50><p align=center>영어</p></td>
		<td width=50><p align=center>수학</p></td>
	</tr>
<%
	while (rset.next()) {
		out.println("<tr>"); 
		out.println("<td width=50><p align=center><a href = AllviewDB.jsp?key=" + rset.getString(1)+">" + rset.getString(1) +"</p></td>");
		out.println("<td width=100><p align=center>" + Integer.toString(rset.getInt(2))+"</p></td>"); 
		out.println("<td width=50><p align=center>" + Integer.toString(rset.getInt(3))+"</p></td>"); 
		out.println("<td width=50><p align=center>" + Integer.toString(rset.getInt(4))+"</p></td>");  
		out.println("<td width=50><p align=center>" + Integer.toString(rset.getInt(5))+"</p></td>"); 
		out.println("</tr>");
		}
		rset.close(); 
		stmt.close(); 
		conn.close();
%>
</body> 
</html>