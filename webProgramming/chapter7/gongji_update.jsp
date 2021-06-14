<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <SCRIPT LANGUAGE="JavaScript">
        function submitForm(mode) {
            if (mode == "write") {
                fm.action = "gongji_write.jsp?key=UPDATE";
            } else if (mode == "delete") {
                fm.action = "gongji_write.jsp?key=DELETE";
            }
            fm.submit();
        }
    </SCRIPT>
</head>

<body>
    <div class="container">
    <div class="row-fluid">
    <% 
        int num = Integer.parseInt(request.getParameter( "key" )); 
        Class.forName ("com.mysql.cj.jdbc.Driver");  
	    Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	    Statement stmt = conn.createStatement(); 
        ResultSet rset = stmt.executeQuery("select * from gongji where id="+num+";");
    %>
    <h1 class="display-2 text-center">Update</h1><br>
    <FORM METHOD=POST name='fm'>
        <table class="table">
        <%
            while (rset.next()) {
                out.println("<tr><td><b>번호</b></td>");
                out.println("<td><input type='text' name='id' class='form-control' aria-label='Sizing example input' aria-describedby='inputGroup-sizing-sm' value="+rset.getInt(1)+" readonly></td>");
                out.println("</tr>");
                out.println("<tr><td><b>제목</b></td>");
                out.println("<td><input type=text name=title class='form-control' aria-label='Sizing example input' aria-describedby='inputGroup-sizing-sm'  maxlength=70 value="+rset.getString(2)+"></td>");
                out.println("</tr>");
                out.println("<tr><td><b>일자</b></td>");
                out.println("<td><input type=hidden name=date value="+rset.getString(3)+">"+rset.getString(3)+"</td>");
                out.println("</tr>");
                out.println("<tr><td><b>내용</b></td>");
                out.println("<td><textarea class='form-control' aria-label='Sizing example input' aria-describedby='inputGroup-sizing-sm' style=' height: 250px;' name=content>"+rset.getString(4)+"</textarea></td>");
                out.println("</tr>");
            }
        %>
        </table>
        <div class="float-end">
                   <input type=button value="취소" class="btn btn-primary btn-sm" OnClick="location.href='gongji_list.jsp'">
                   <input type=button value="수정" class="btn btn-secondary btn-sm" OnClick="submitForm('write')">
                   <input type=button value="삭제" class="btn btn-warning btn-sm" OnClick="submitForm('delete')">
        </div>
    </FORM>
    </div>
    </div>
</body>
</html>