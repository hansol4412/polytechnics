<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<%@ page errorPage="error.jsp" %> 
<%@ page contentType="text/html; charset=utf-8" %> 
<%@ page import="java.sql.*, javax.sql.*,java.io.*" %> 
<html> 
<head> 
</head> 
<body> 
<h1>테이블 만들기OK</h1>
<%
	Class.forName ("com.mysql.cj.jdbc.Driver"); 
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kopo41", "root", "kopo41");
	Statement stmt = conn.createStatement(); 
	stmt.execute("create table IF NOT EXISTS examtable ("
	+ " name varchar (20),"
	+ " studentid int not null primary key,"
	+ " kor int,"
	+ " eng int,"
	+ " mat int) DEFAULT CHARSET=utf8;"); 
	stmt.close(); 
	stmt.close(); 
	conn.close();
%>
</body> 
</html>
