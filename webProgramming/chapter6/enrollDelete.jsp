<meta http-equiv="Content-Type" content "text/html; charset=utf-8" /> 
<%@ page contentType="text/html; charset=utf-8" %> 
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*" %> 
<html> 
<head> 
<script>    
	function characterCheck(obj){
	  var regExp = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g; 

	  if( regExp.test(obj.value) ){
		 alert("한글만 입력할 수 있습니다.");
		 obj.value = "";
	  }
	}
</script>
</head> 
<body>
<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=100 bgcolor="skyblue"><a href="enrollMain.jsp">후보등록</a></td> 
		<td width=100><a href="voteMain.jsp">투표</a></td>
		<td width=100><a href="resultVote.jsp">개표결과</a></td>
	</tr> 
</table>
<h1>후보 삭제 성공</h1>
<%
	Class.forName ("com.mysql.cj.jdbc.Driver"); 
	Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	Statement stmt = conn.createStatement(); 
	
	String cTmp = request.getParameter( "id" ); 
	
	String sql1="delete from tupyo where id = " + cTmp;
	stmt.executeUpdate( sql1 );
	
	String sql="delete from hubo where id =" + cTmp;
	stmt.executeUpdate( sql );
	ResultSet rset = stmt.executeQuery("select * from hubo;");
%>
<table cellspacing=3 width=600 border=1> 
	<tr><td>
		<p align=center>후보명 입력</p>
	</td></tr> 
<%
	while (rset.next()) {
		out.println("<tr>");
		out.println("<td>");
		out.println("<form method='post' action='enrollDelete.jsp'>");
		out.println("기호: <input type=text name='id' value="+Integer.toString(rset.getInt(1))+" readonly>");
		out.println("이름 : <input type=text name='name' value="+rset.getString(2)+" readonly>");
		out.println("<input type='submit' value='삭제'> ");
		out.println("</form>");
		out.println("</td>");
		out.println("</tr>");
	}
%>	

	<tr>
		<td> 
			<form method="post" action="enrollInsert.jsp"> 
				기호: <input type="text" name="id" value="자동부여" readonly> 
				이름 : <input type="text" name="name" value="" onkeyup="characterCheck(this)" id="inputName" maxlength='8' required > 
				<input type="submit" value="추가"> 
			</form> 
		</td>
	</tr> 
</table> 
<%
		rset.close(); 
		stmt.close(); 
		conn.close();
%>
</body> 
</html>