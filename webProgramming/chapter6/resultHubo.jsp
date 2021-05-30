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

<%
	Class.forName ("com.mysql.cj.jdbc.Driver");  
	Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	Statement stmt = conn.createStatement(); 
	Statement stmt1 = conn.createStatement(); 
	String num = request.getParameter( "key" ); 
	int inum = Integer.parseInt(num);
	ResultSet rset1 = stmt1.executeQuery("select name from hubo where id="+inum+";");
	ResultSet rset = stmt.executeQuery("select age, (count(*)-1), (count(*)-1)/(select (count(*)-9) from tupyo where id ="+inum+" )*100 from tupyo where id ="+inum+" group by age order by age;");
	
	
	String name = null;
	if(rset1.next()) {
		name = rset1.getString(1);
	}
%> 
<h1>[<%=name%>] 연령별 득표 결과</h1>
<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=75><p align=center>연령대</p></td>
		<td width=500><p align=center>인기도</p></td> 
	</tr>
<%
	while (rset.next()) {
		out.println("<tr>");
		out.println("<td width=75>");
		out.println("<p align=center>"+rset.getInt(1)+"0대</p>");
		out.println("</td>");
		out.println("<td width=500>");
		int length = rset.getInt(3) * 4; 
		out.println("<p align=left><img src='bar.jpg' width="+length+" height=20>"+rset.getInt(2)+"("+rset.getInt(3)+"%)</p>");
		out.println("</td>");
		out.println("</tr>");
	}
%>

</table>
<%
		rset.close(); 
		rset1.close(); 
		stmt.close();
		stmt1.close(); 
		conn.close();
%>
</body>
</html>