<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*" %>
<html>
<head>
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
    <% 
        int num = Integer.parseInt(request.getParameter( "key" )); 
        Class.forName ("com.mysql.cj.jdbc.Driver");  
	    Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	    Statement stmt = conn.createStatement(); 
        ResultSet rset = stmt.executeQuery("select * from gongji where id="+num+";");
    %>
    <FORM METHOD=POST name='fm'>
        <table width=650 border=1 cellspacing=0 cellpadding=5>
        <%
            while (rset.next()) {
                out.println("<tr><td><b>번호</b></td>");
                out.println("<td><input type=text name=id size=70 maxlength=70 value="+rset.getInt(1)+" readonly></td>");
                out.println("</tr>");
                out.println("<tr><td><b>제목</b></td>");
                out.println("<td><input type=text name=title size=70 maxlength=70 value="+rset.getString(2)+"></td>");
                out.println("</tr>");
                out.println("<tr><td><b>일자</b></td>");
                out.println("<td><input type=hidden name=date value="+rset.getString(3)+">"+rset.getString(3)+"</td>");
                out.println("</tr>");
                out.println("<tr><td><b>내용</b></td>");
                out.println("<td><textarea style='width:500px; height: 250px;' name=content cols=70 row=600>"+rset.getString(4)+"</textarea></td>");
                out.println("</tr>");
            }
        %>
        </table>
        <table width=650>
            <tr>
                <td width=600></td>
                <td><input type=button value="취소" OnClick="location.href='gongji_list.jsp'"></td> 
                <td><input type=button value="수정" OnClick="submitForm('write')"></td>
                <td><input type=button value="삭제" OnClick="submitForm('delete')"></td>
            </tr>
        </table>
    </FORM>
</body>
</html>