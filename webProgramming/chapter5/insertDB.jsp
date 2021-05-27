<meta http-equiv="Content-Type" content "text/html; charset=utf-8" /> 
<%@ page errorPage="insertError.jsp" %> 
<%@ page contentType="text/html; charset=utf-8" %> 
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*" %> 
<html> 
<head> 
</head> 
<body>
<%
	try{
	Class.forName ("com.mysql.cj.jdbc.Driver"); 
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	Statement stmt = conn.createStatement(); 
	int NewstdId=0;
	
	ResultSet rset = stmt.executeQuery("select max(studentid) from examtable"); 
	
	while (rset.next()) {
		if(rset.getInt(1)==0){
			NewstdId=209910;
		} else{
			NewstdId=rset.getInt(1)+1; 
		}
		
	}

	String cTmp = request.getParameter( "name" ); 
	String cTmpHan = new String(cTmp.getBytes("8859_1"), "utf-8");
	
	if((Integer.parseInt(request.getParameter("korean"))> 100) || (Integer.parseInt(request.getParameter("korean"))< 0)){  
		throw new Exception("잘못된 값을 입력했습니다.");
	}
	if((Integer.parseInt(request.getParameter("english"))> 100) || (Integer.parseInt(request.getParameter("english"))< 0)){  
		throw new Exception("잘못된 값을 입력했습니다.");
	}
	if((Integer.parseInt(request.getParameter("mathmatic"))> 100) || (Integer.parseInt(request.getParameter("mathmatic"))< 0)){  
		throw new Exception("잘못된 값을 입력했습니다.");
	}
	
	
	
	
	
	stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('"+
	cTmpHan +"',"+ 
	Integer.toString(NewstdId) +","+ 
	request.getParameter ("korean") +"," + 
	request.getParameter("english") + "," + 
	request.getParameter("mathmatic")+" );");
	
	stmt.close(); 
	conn.close();
%>
<h1>성적입력추가완료</h1> 
<form method="post" action='inputForm1.html'> 
<table cellspacing=1 width=400 border=0>
	<tr>
		<td width=300></td>
		<td width=100><input type="submit" value="뒤로가기"></td> 
	</tr>
</table>
<table cellspacing=1 width=400 border=1>
	<tr>
		<td width=100><p align=center>이름</p></td> 
		<td width=300><p align=center>
			<input type='text' name='name' value='<%=cTmpHan%>' readonly></p>
		</td> 
	</tr>
	<tr>
		<td width=100><p align=center>학번</p></td> 
		<td width=300><p align=center>
			<input type='text' name='studentid' value='<%=Integer.toString(NewstdId)%>' readonly></p>
		</td>
	</tr>
	<tr>
		<td width=100><p align=center>국어</p></td> 
		<td width=300><p align=center>
			<input type='text' name='korean' value='<%=request.getParameter("korean")%>' readonly></p>
		</td>
	</tr>
	<tr>
		<td width=100><p align=center>영어</p></td> 
		<td width=300><p align=center>
			<input type='text' name='english' value='<%=request.getParameter("english")%>' readonly></p>
		</td>
	</tr>
	<tr>
		<td width=100><p align=center>수학</p></td> 
		<td width=300><p align=center>
			<input type='text' name='mathmatic' value='<%=request.getParameter("mathmatic")%>' readonly></p>
		</td>
	</tr>
</table>
<%
	}catch(java.sql.SQLSyntaxErrorException e){
		out.println("<h1>"); 
		out.println("테이블이 없습니다. 테이블을 생성하세요."); 
		out.println("</h1>"); 
	}
%>
</form> 
</body> 
</html>

