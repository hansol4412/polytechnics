<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*,java.text.*, java.util.Date" %>
<html>
<head>
</head>
<body>
    <h1>Gongji List</h1>
     <% 
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    %>
    <% 
        Class.forName ("com.mysql.cj.jdbc.Driver");  
	    Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	    Statement stmt = conn.createStatement(); 
        Statement stmt1 = conn.createStatement();
        ResultSet rset = stmt.executeQuery("select id, title, date, viewcnt from gongji order by id desc;");
        
    %>
    <table cellspacing=1 width=600 border=1>
        <tr>
            <td width=50>
                <p align=center>번호</p>
            </td>
            <td width=500>
                <p align=center>제목</p>
            </td>
            <td width=100>
                <p align=center>조회수</p>
            </td>
            <td width=100>
                <p align=center>등록일</p>
            </td>
        </tr> 
        <%
	        while (rset.next()) {
                out.println("<tr>");
                out.println("<td width=50>");
		        out.println("<p align=center>"+rset.getInt(1)+"</p>");
                out.println("</td>");
                out.println("<td width=500>");

                ResultSet rset1 = stmt1.executeQuery("select count(*) from reply where gongjiId ="+rset.getInt(1)+" ;");
                if(rset1.next()){
                    if(rset.getString(3).equals(sd.format(date))){
                        out.println("<p align=center><a href='gongji_view.jsp?key="+rset.getInt(1)+"'>"+rset.getString(2)+" ("+rset1.getInt(1)+") [New]</a></p>"); 
                    }else{
                        out.println("<p align=center><a href='gongji_view.jsp?key="+rset.getInt(1)+"'>"+rset.getString(2)+" ("+rset1.getInt(1)+")</a></p>");
                    }
                }
                

                out.println("</td>");
                out.println("<td width=100>"); 
                out.println("<p align=center>"+rset.getString(4)+"</p>");
                out.println("</td>");
                out.println("<td width=100>"); 
                out.println("<p align=center>"+rset.getString(3)+"</p>");
                out.println("</td>");
                out.println("</tr>");
	        }
        %>
 
    </table>
    <table width=650>
        <tr>
            <td width=550></td>
            <td>
                <input type=button value="신규" OnClick="window.location='gongji_insert.jsp'">
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