<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*" %>
<html>
<head> 

</head>
<body>
    <h1>Gongji view</h1>
    <head>
    <SCRIPT LANGUAGE="JavaScript">
        function submitForm(mode) {
            if (mode == "insert") {
                document.getElementById("fmI").action = "reply_write.jsp?key=insert";
                document.getElementById("fmI").submit();
            } 
        }
        function checkReply(mode, gongjiId, replyId, replyContent){
            
            document.write("<FORM METHOD=POST id='fmC'>");
            document.write("<input type=hidden id=reply name= replyContent value="+replyContent+">");
            document.write("<input type=hidden name= gongjiId value="+gongjiId+">");
            document.write("<input type=hidden name= replyId value="+replyId+">");
            document.write("</FORM>");
            
            var fmC = document.getElementById("fmC");
            if(mode=='delete'){
                if (confirm("정말 삭제하시겠습니까??") == true){ 
                    fmC.action = "reply_write.jsp?key=delete";
                    fmC.submit();
                } else {   //취소
                    return;
                }
            } else if(mode =='update'){
                 var text = prompt("댓글을 수정하시겠습니까",replyContent);
                 if(text==null || text==""){
                     return;
                 } else{
                    document.getElementById("reply").value = text;
                    fmC.action = "reply_write.jsp?key=update";
                    fmC.submit();
                 }
            }
        }
    </SCRIPT>
</head>

<body>
    <% 
        int num = Integer.parseInt(request.getParameter( "key" )); 
        Class.forName ("com.mysql.cj.jdbc.Driver");  
	    Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	    Statement stmt = conn.createStatement(); 
        Statement stmt1 = conn.createStatement();  //조회수
        Statement stmt2 = conn.createStatement(); 
        Statement stmt3 = conn.createStatement(); 
        ResultSet rset = stmt.executeQuery("select * from gongji where id="+num+";");
        ResultSet rset2 = stmt2.executeQuery("select * from reply where gongjiId="+num+";");
        ResultSet rset3 = stmt3.executeQuery("select replyId from reply where gongjiId = "+num+" order by replyId desc limit 1;");
    %>
        <table width=650 border=1 cellspacing=0 cellpadding=5>
            <%
                while (rset.next()) {
                    out.println("<tr>");
                    out.println("<td><b>번호</b></td>");
                    out.println("<td>"+rset.getInt(1)+"</td>");
                    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<td><b>제목</b></td>");
                    out.println("<td>"+rset.getString(2)+"</td>");
                    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<td><b>일자</b></td>");
                    out.println("<td>"+rset.getString(3)+"</td>");
                    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<td><b>내용</b></td>");
                    out.println("<td>"+rset.getString(4)+"</td>");
                    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<td><b>댓글</b></td>");
                    out.println("<td>");
                        out.println("<table>");
                            
                            //정보보기
                            while (rset2.next()) {
                                out.println("<tr>");
                                out.println("<td>"+rset2.getString(4)+"</td>");
                                out.println("<td><button OnClick=checkReply('update',"+rset.getInt(1)+","+rset2.getInt(2)+",'"+rset2.getString(4)+"')>수정</button></td>");
                                out.println("<td><button OnClick=checkReply('delete',"+rset.getInt(1)+","+rset2.getInt(2)+",'"+rset2.getString(4)+"')>삭제</button></td>");
                                out.println("<td>("+rset2.getString(3)+")</td>");
                                out.println("</tr>");
                            } 

                        out.println("</table>");
                        
                        String replyId = null;

                        while (rset3.next()) {
                            replyId = rset3.getInt(1)+"";
                        }
                        
                        out.println("<FORM METHOD=POST id='fmI'>");
                        out.println("<input type=text name='replyContent'>");
                        out.println("<input type=hidden name=gongjiId value="+rset.getInt(1)+">");

                        if(replyId==null){
                            out.println("<input type=hidden name=replyId value=1>");
                        } else{
                            int replyIdInt = Integer.parseInt(replyId) +1;
                            out.println("<input type=hidden name=replyId value="+replyIdInt+">");
                        }
                        out.println("<input type=button value=댓글등록 OnClick=submitForm('insert')>");
                        out.println("</FORM>");


                    out.println("</td>");
                    out.println("</tr>");

                    int cnt = 0;
                    cnt = rset.getInt(5);
                    String sql = "update gongji set viewcnt="+(cnt+1)+" where id="+num+";";
                    stmt1.executeUpdate( sql );
                }
            %>
        </table>
        <table width=650>
            <td width=600></td>
            <td><input type=button value="목록" OnClick="location.href='gongji_list.jsp'"></td>
            <%
                out.println("<td><input type=button value='수정' OnClick=location.href='gongji_update.jsp?key="+num+"'></td>");
               
            %>
        </table>
    <%
        rset.close(); 
        rset2.close(); 
        rset3.close();
		stmt.close();
        stmt1.close(); 
        stmt2.close();
        stmt3.close();
		conn.close();
    %>
</body>
</html>