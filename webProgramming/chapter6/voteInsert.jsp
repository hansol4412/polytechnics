<meta http-equiv="Content-Type" content "text/html; charset=utf-8" />  
<%@ page contentType="text/html; charset=utf-8" %> 
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*" %> 
<html> 
<head>
</head> 
<body>
<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=100><a href="enrollMain.jsp">후보등록</a></td> 
		<td width=100 bgcolor="skyblue"><a href="voteMain.jsp">투표</a></td>
		<td width=100><a href="resultVote.jsp">개표결과</a></td>
	</tr> 
</table>
<h1>투표하기</h1>
<%
	Class.forName ("com.mysql.cj.jdbc.Driver"); 
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	Statement stmt = conn.createStatement(); 
	
	String choice = request.getParameter( "choice" ); 
	String age = request.getParameter( "age" ); 
	
	stmt.execute("insert into tupyo (id, age) values ("+choice+", '"+ age+"');");

	stmt.close(); 
	conn.close();
%>
<br>
<h1>투표를 완료하였습니다.</h1>
</body>
</html>