<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*, java.text.*, java.util.Date" %>
<html>
<head>

</head>
<body>
 <% 
        Date date1 = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    %>
    <% 
        String mode = request.getParameter( "key" ); 
        String id = request.getParameter( "id" ); 
        String title = request.getParameter( "title" ); 
	    String titleHan = new String(title.getBytes("8859_1"), "utf-8");
        String date = request.getParameter("date"); 
        String content = request.getParameter( "content" ); 
        String contentHan = new String(content.getBytes("8859_1"), "utf-8");

        Class.forName ("com.mysql.cj.jdbc.Driver");  
	    Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	    Statement stmt = conn.createStatement(); 
    %>
    <%
        if(mode.equals("INSERT")){
            out.println("<h1>추가</h1>");
            String sql="insert into gongji(title, date, content, viewcnt) values('"+titleHan+"', '"+date+"', '"+contentHan+"',0)";
            stmt.execute(sql); 
        } else if(mode.equals("UPDATE")){
            out.println("<h1>수정</h1>");
            String sql = "update gongji set title='"+titleHan+"', date ='"+date+"', content='"+contentHan+"' where id="+id+";";
            stmt.executeUpdate( sql );
        } else if(mode.equals("DELETE")){
            out.println("<h1>삭제</h1>");
            String sql="delete from gongji where id = " + id;
	        stmt.executeUpdate( sql );
        }
    %>

    <%
		stmt.close(); 
		conn.close();
        response.sendRedirect("gongji_list.jsp");
    %>
</body>
</html>