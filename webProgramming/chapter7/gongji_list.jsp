<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*,java.text.*, java.util.Date" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <SCRIPT>
        function findContent(){
            var findc = document.getElementById("findc").value;
            if((findc == null) || (findc == "")){
                return;
            } else {
                document.getElementById("find").action = "gongji_find.jsp";
                document.getElementById("find").submit();
            }
        }
    </SCRIPT>
</head>
<body>
    <div class="container">
    <div class="row-fluid">
    <h1 class="display-2 text-center">Board</h1>
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
        <div class="float-end">
                    <input type=button  class="btn btn-primary" value="신규" OnClick="window.location='gongji_insert.jsp'">
        </div>
        <br><br>
    <table class="table table-hover" width=600 >
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
                out.println("<p align=center>"+rset.getString(4)+"</p>");
                out.println("</td>");
                out.println("<td width=100>"); 
                out.println("<p align=center>"+rset.getString(3)+"</p>");
                out.println("</td>");
                out.println("</tr>");
	        }
        %>
    
 
    </table>
    
    <div class="float-end">
        
                <form id='find' class="row row-cols-lg-auto g-3 align-items-center">
                    <div class="col-12">
                    <select class="form-select form-select-default mb-1" aria-label=".form-select-lg example" name="criteria">
                        <option value="title" />제목</option>
                        <option value="content" />내용</option>
                        <option value="double" />제목+내용</option>
                    </select>
                    </div class="col-12">
                    <div>
                    <input type=text name="find" id ='findc' class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm"> 
                    </div>
                    <div class="col-12">
                    <button class="btn btn-primary" OnClick ="findContent()">찾기</button>
                    </div>
                <form>
    </div>
    <div>
    <div>
    
    <%
        rset.close(); 
		stmt.close(); 
        stmt1.close(); 
		conn.close();
    %>
</body>
</html>