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
		<td width=100 ><a href="voteMain.jsp">투표</a></td>
		<td width=100 bgcolor="skyblue"><a href="resultVote.jsp">개표결과</a></td>
	</tr> 
</table>
<h1>후보별 득표 결과</h1>
<%
	Class.forName ("com.mysql.cj.jdbc.Driver");  
	Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	Statement stmt = conn.createStatement(); 
	Statement stmt1 = conn.createStatement(); 
	ResultSet rset1 = stmt.executeQuery("select count(*) from hubo");
	int huboCnt = 0;
	if (rset1.next()) {
		huboCnt = rset1.getInt(1);
	}
	ResultSet rset = stmt.executeQuery("select a.id, a.name, (count(b.id)-9), (count(b.id)-9)/(select (count(*)-9*"+huboCnt+") from tupyo)*100 from hubo as a left join tupyo as b on a.id = b.id group by a.id;");
%> 
<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=75><p align=center>이름</p></td>
		<td width=500><p align=center>인기도</p></td> 
	</tr>
<%
	while (rset.next()) {
		out.println("<tr>");
		out.println("<td width=75>");
		out.println("<a href = resultHubo.jsp?key="+rset.getInt(1)+"><p align=center>"+rset.getString(2)+"</p></a>");
		out.println("</td>");
		out.println("<td width=500>");
		int length = rset.getInt(4) * 4; 
		out.println("<p align=left><img src='bar.jpg' width="+(length)+" height=20>"+(rset.getInt(3))+"("+rset.getInt(4)+"%)</p>");
		out.println("</td>");
		out.println("</tr>");
	}
%>

</table>
<%
		rset.close(); 
		stmt.close(); 
		rset1.close(); 
		stmt1.close(); 
		conn.close();
%>
</body>
</html>