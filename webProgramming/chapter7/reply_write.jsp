<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*,java.text.*, java.util.Date" %>
<html>
<head> 
</head>
<body>
    <h1>reply write</h1>
    <head>
    
</head>

<body>
    <% 
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    %>
    <% 
        String mode = request.getParameter( "key" ); 
        String gongjiId = request.getParameter( "gongjiId" ); 
        String replyId = request.getParameter( "replyId" ); 
        String replyContent = request.getParameter( "replyContent" ); 
	    String replyContentHan = new String(replyContent.getBytes("8859_1"), "utf-8");

        Class.forName ("com.mysql.cj.jdbc.Driver");  
	    Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	    Statement stmt = conn.createStatement(); 


        if(mode.equals("insert")){
            String sql="";
            sql="insert into reply(gongjiId,replyId, date, content) values("+gongjiId+","+replyId+", date(now()), '"+replyContentHan+"')";
            stmt.execute(sql); 
        } else if(mode.equals("update")){
            String sql = "update reply set date ='"+sd.format(date)+"', content='"+replyContentHan+"' where gongjiId= "+gongjiId+" and replyId= "+replyId+";";
            stmt.execute(sql); 
        } else if(mode.equals("delete")){
            String sql="delete from reply where gongjiId="+gongjiId+" and replyId= "+replyId+";";
            stmt.execute(sql); 
        }
    %>
    <% 
		stmt.close();
		conn.close();
        response.sendRedirect("gongji_view.jsp?key="+gongjiId+"");
    %>
</body>
</html>