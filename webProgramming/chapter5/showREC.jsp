<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 

<%@ page contentType="text/html; charset=utf-8" %> 
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*" %> 
<html> 
<head>
<script>    
	function characterCheck(obj){
	  var regExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi; 

	  if( regExp.test(obj.value) ){
		 alert("특수문자는 입력하실수 없습니다.");
		 obj.value = "";
	  }
	}
</script>
</head> 
<body>
<%	
	try{
	Class.forName ("com.mysql.cj.jdbc.Driver"); 
	Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	Statement stmt = conn.createStatement(); 
	
	
		String name="", studentid="", kor="", eng="", mat="";
		String ctmp = request.getParameter( "searchid" ); 
		if (ctmp.length()==0) ctmp="0"; 
		ResultSet rset = stmt.executeQuery("select * from examtable where studentid = "+ctmp); 
		name="해당학번없음"; 
		while (rset.next()){
			name=rset.getString(1); 
			studentid=Integer.toString(rset.getInt(2)); 
			kor=Integer.toString(rset.getInt(3)); 
			eng=Integer.toString(rset.getInt(4)); 
			mat=Integer.toString(rset.getInt(5));
		}
		
	stmt.close(); 
	conn.close();
%>
<h1>성적 조회후 정정 / 삭제</h1> 
<form method="post" action='showREC.jsp'> 
<table cellspacing=1 width=400 border=0>
	<tr>
		<td width=100><p align=center>조회할 학번</p></td>
		<td width=200><p align=center><input type='number' name='searchid' value=''></p></td>
		<td width=100><input type="submit" value="조회"></td> 
	</tr>
</table>
</form>
<form method="post" action='./' id='myformN'>
	<table cellspacing=1 width=400 border=1>
		<tr>
			<td width=100><p align=center>이름</p></td>
			<td width=300><p align=center><input type='text' name='name' value='<%=name%>' onkeyup="characterCheck(this)" id="inputName" maxlength='8' required/></p></td> 
		</tr>
		<tr>
			<td width=100><p align=center>학번</p></td> 
			<td width=300><p align=center><input type='text' name='studentid' value='<%=studentid%>' readonly required /></p></td>  
		</tr>
		<tr>
			<td width=100><p align=center>국어</p></td>
			<td width=300><p align=center><input type='number' name='korean' min='0' max='100'value='<%=kor%>' required /></p></td>
		</tr>
		<tr>
			<td width=100><p align=center>영어</p></td>
			<td width=300><p align=center><input type='number' name='english' min='0' max='100' value='<%=eng%>' required /></p></td>
		</tr>
		<tr>
			<td width=100><p align=center>수학</p></td>
			<td width=300><p align=center><input type='number' name='mathmatic' min='0' max='100' value='<%=mat%>' required /></p></td>
		</tr>
		</table>
<%
	if (studentid.length() !=0){
		out.println("<table cellspacing=1 width=400 border0>"); 
		out.println("<tr>") ;
		out.println("<td width=200></td>"); 
		out.println("<td width=100><p align=center><button type=submit formaction=updateDB.jsp>수정</button></p></td>"); 
		out.println("<td width=100><p align=center><button type=submit formaction=deleteDB.jsp>삭제</button></p></td>"); 
		out.println("</tr>"); 
		out.println("</table>");
	}
	} catch(java.sql.SQLSyntaxErrorException e){
		out.println("<h1>"); 
		out.println("테이블이 없습니다. 테이블을 생성하세요."); 
		out.println("</h1>"); 
	}

%>
</form> 
</body> 
</html>

