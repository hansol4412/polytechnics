<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*" %>
<html>
<head>
</head>

        <body>
            <h1>Make table</h1>
            <% 
                Class.forName("com.mysql.jdbc.Driver"); 
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/kopo41", "root" , "kopo41" ); 
                Statement stmt = conn.createStatement(); 
            %>
            <% 
                try { 
                        stmt.execute("drop table reply");
                        stmt.execute("drop table gongji"); 
                        out.println("drop table gongji OK<br>"); 
                    }catch(Exception e) {
                        out.println("drop table gongji NOT OK<br>"); 
                        out.println( e.toString());
                    }
            %>
            <% 
                stmt.execute("create table gongji("
                    +"id int not null primary key auto_increment,"
                    +"title varchar(70),"
                    +"date date,"
                    +"content text"
                +")default charset=utf8;");
                stmt.execute("alter table gongji add viewcnt int;");

                /*
                stmt.execute("alter table gongji add rootid int;");
                stmt.execute("alter table gongji add relevel int;");
                stmt.execute("alter table gongji add recnt int;");
                
                */

                
                stmt.execute("create table reply("
                    +"gongjiId int not null,"
                    +"replyId int not null ,"
                    +"date date,"
                    +"content text,"
                    +"foreign key (gongjiId) references gongji(id)"
                +")default charset=utf8;");
                

            %>
            <%
                String sql=""; 
                sql="insert into gongji(title, date, content, viewcnt) values('공지사항1', date(now()), '공지사항내용1', 0)";
                stmt.execute(sql); 
                sql="insert into gongji(title, date, content, viewcnt) values('공지사항2', date(now()), '공지사항내용2', 0)";
                stmt.execute(sql); 
                sql="insert into gongji(title, date, content, viewcnt) values('공지사항3', date(now()), '공지사항내용3', 0)";
                stmt.execute(sql); 
                sql="insert into gongji(title, date, content, viewcnt) values('공지사항4', date(now()), '공지사항내용4', 0)";
                stmt.execute(sql); 
                sql="insert into gongji(title, date, content, viewcnt) values('공지사항5', date(now()), '공지사항내용5', 0)";
                stmt.execute(sql); 

                /*
                sql="insert into reply(gongjiId, replyId, date, content) values(1, 1, date(now()), '댓글1')";
                stmt.execute(sql); 
                sql="insert into reply(gongjiId, replyId, date, content) values(1, 2, date(now()), '댓글2')";
                stmt.execute(sql); 
                sql="insert into reply(gongjiId, replyId, date, content) values(2, 1, date(now()), '댓글1')";
                stmt.execute(sql); 
                sql="insert into reply(gongjiId, replyId, date, content) values(2, 2, date(now()), '댓글2')";
                stmt.execute(sql); 
                */


                /*
                sql="insert into gongji(title, date, content, rootid, relevel, recnt, viewcnt) values('공지사항2', date(now()), '공지사항내용2', 2, 0, 0, 0)";
                stmt.execute(sql);
                sql="insert into gongji(title, date, content, rootid, relevel, recnt, viewcnt) values('공지사항3', date(now()), '공지사항내용3', 3, 0, 0, 0)";
                stmt.execute(sql);
                sql="insert into gongji(title, date, content, rootid, relevel, recnt, viewcnt) values('공지사항4', date(now()), '공지사항내용4', 4, 0, 0, 0)";
                stmt.execute(sql);
                sql="insert into gongji(title, date, content, rootid, relevel, recnt, viewcnt) values('공지사항5', date(now()), '공지사항내용5', 5, 0, 0, 0)";
                stmt.execute(sql);
                */

                stmt.close(); 
                conn.close();
            %>
</body>
</html>