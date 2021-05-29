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
	Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	Statement stmt = conn.createStatement(); 
	ResultSet rset = stmt.executeQuery("select * from hubo;");
%>
<table cellspacing=3 width=600 border=1>
	<tr> 
		<form method="post" action="voteInsert.jsp">
			<td width=200><p align=center> 
			<select name=choice required>
<%
	while (rset.next()) {
		out.println("<option value="+Integer.toString(rset.getInt(1))+">"+Integer.toString(rset.getInt(1))+" "+rset.getString(2));
	}
%>
			</select>
			
			<select name=age required>
				<option value='1'>10대
				<option value='2'>20대
				<option value='3'>30대
				<option value='4'>40대
				<option value='5'>50대
				<option value='6'>60대
				<option value='7'>70대
				<option value='8'>80대
				<option value='9'>90대
			</select>
			
			</p>
			</td> 
			<td> 
				<input type=submit value="투표하기"> 
			</td>
		</form>
	</tr>
</table> 
<%
		rset.close(); 
		stmt.close(); 
		conn.close();
%>
</body> 
</html>