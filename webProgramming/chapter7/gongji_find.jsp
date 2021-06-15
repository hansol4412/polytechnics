<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*,java.text.*, java.util.Date" %>
<html>
<head> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="row-fluid">
    <% 
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    %>
    <% 
        String criteria = request.getParameter( "criteria" ); 
        String find = request.getParameter("find"); 


        Class.forName ("com.mysql.cj.jdbc.Driver");  
	    Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	    Statement stmt = conn.createStatement(); 
        Statement stmt1 = conn.createStatement(); 
        
        
        String sql= null;
        if(criteria.equals("title")){
            out.println("<h3 class='display-2 text-center'>제목 : ");
            sql = "select * from gongji where title like '%"+find+"%' order by id desc;";
        } else if (criteria.equals("content")){
            out.println("<h3 class='display-2 text-center'>내용 : ");
            sql = "select * from gongji where content like '%"+find+"%' order by id desc;";
        } else if (criteria.equals("double")){
            out.println("<h3 class='display-2 text-center'>제목 + 내용 : ");
            sql = "select * from gongji where (title like '%"+find+"%') or (content like '%"+find+"%') order by id desc;";
        } 
        out.println(find+"</h3><br><br>");

        ResultSet rset = stmt.executeQuery(sql);

    %>
    <table class="table table-hover">
        <thead>
        <tr class="table-secondary">
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
        </thead>
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
                rset1.close();
                
                out.println("</td>");
                out.println("<td width=100>"); 
                out.println("<p align=center>"+rset.getString(5)+"</p>");
                out.println("</td>");
                out.println("<td width=100>"); 
                out.println("<p align=center>"+rset.getString(3)+"</p>");
                out.println("</td>");
                out.println("</tr>");
	        }
        %>
    </table>
     <div class="float-end">
        <input type=button  class="btn btn-primary" value="목록" OnClick="window.location='gongji_list.jsp'">
    </div>

    <% 
        
		rset.close();
        stmt.close();
        stmt1.close();
		conn.close();
    %>
</div>
</div>
</body>
</html>