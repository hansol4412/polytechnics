<meta http-equiv="Content-Type" content "text/html; charset=utf-8" /> 
<%@ page errorPage="insertError.jsp" %> 
<%@ page contentType="text/html; charset=utf-8" %> 
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*" %> 

<html> 
<head> 
</head> 
<body>
<%
	Class.forName ("com.mysql.cj.jdbc.Driver"); 
	Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	Statement stmt = conn.createStatement(); 
	
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
	
	String sql = "update examtable set name='"+cTmpHan+"', kor = "+request.getParameter("korean")+", eng="+request.getParameter("english")+", mat="+request.getParameter("mathmatic")+" where studentid="+request.getParameter("studentid")+";";
	stmt.executeUpdate(sql);
	
	ResultSet rset = stmt.executeQuery("select * from examtable;");
%>
<table cellspacing=1 width=600 border=1> 
	<tr>
		<td width=50><p align=center>이름</p></td> 
		<td width=50><p align=center>학번</p></td> 
		<td width=50><p align=center>국어</p></td> 
		<td width=50><p align=center>영어</p></td> 
		<td width=50><p align=center>수학</p></td> 
	</tr>
<%
	while (rset.next()) {
		if(request.getParameter( "studentid" ).equals(Integer.toString(rset.getInt(2)))) {
			out.println("<tr bgcolor = '#fff00'>"); 
			out.println("<td width=50><p align=center><a href='AllviewDB.jsp?key="+rset.getString(1)+"'> "+rset.getString(1) +"</a></p></td>"); 
			out.println("<td width=50><p align=center>" +Integer.toString(rset.getInt(2))+"</p></td>"); 
			out.println("<td width=50><p align=center>" +Integer.toString(rset.getInt(3)) + "</p></td>"); 
			out.println("<td width=50><p align=center>" +Integer.toString(rset.getInt(4) ) +"</p></td>"); 
			out.println("<td width=50><p align=center>" +Integer.toString(rset.getInt(5)) +"</p></td>"); 
			out.println("</tr>");
		} else{
			out.println("<tr>");
			out.println("<td width=50><p align=center><a href='AllviewDB.jsp?key="
					+rset.getString(1)+"'> "+rset.getString(1) +"</a></p></td>"); 
			out.println("<td width=50><p align=center>" +Integer.toString(rset.getInt(2))+"</p></td>"); 
			out.println("<td width=50><p align=center>" +Integer.toString(rset.getInt(3)) + "</p></td>"); 
			out.println("<td width=50><p align=center>" +Integer.toString(rset.getInt(4) ) +"</p></td>"); 
			out.println("<td width=50><p align=center>" +Integer.toString(rset.getInt(5)) +"</p></td>"); 
			out.println("</tr>");
		}
	}
	rset.close(); 
	stmt.close(); 
	conn.close();
%>
</body> 
</html>
