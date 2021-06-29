<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*,java.text.*, java.util.Date" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script>
        function find(obj){
            var title = $(obj).text().replaceAll(" ","");
            var regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi;
            if(regExp.test(title)){
                title = title.replace(regExp, "");
            }
            $("td[title="+title+"]").css("background", "pink");
        }

         function notfind(obj){
              $("td").css("background", "white");
        }

        const clickedObjects = new Set();

        function on(obj) {
            var title = $(obj).text();
            var originalTitle = title;
            var artist = $(obj).attr('class');
            var album = $(obj).attr('id');
            $(obj).html("<b>곡명 : </b>"+title+"<br> <b>아티스트 : </b>"+artist+" <br><b>앨범명 : </b>"+ album);  
        }

        function off(obj) {
            var originalTitle =  $(obj).attr('attribute');
            console.log(originalTitle);
            obj.style.background = "white";
            $(obj).html("<center>"+originalTitle+"</center>");
        }

        function changeMenu(obj) {   
            if (clickedObjects.has(obj)) {
                clickedObjects.delete(obj);
            } else {
                clickedObjects.clear();
                clickedObjects.add(obj);
            }      

            var menuContents = document.getElementsByName('info');

            for (var i = 0; i < menuContents.length; i++) {
                if (clickedObjects.has(menuContents[i])) {
                    on(menuContents[i]);
                } else {
                    off(menuContents[i]);
                }
            }

        }

    </script>
</head>
<body>
    <div class="container">
    <div class="row-fluid">
    <% 
        Date nowDate = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    %>
    <br><br><h1 class="display-2 text-center"><% out.println(sd.format(nowDate));%></h1>
    <% 
        Class.forName ("com.mysql.cj.jdbc.Driver");  
	    Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	    Statement stmt = conn.createStatement(); 
        ResultSet rset = null;
        Statement stmt1 = conn.createStatement(); 
        ResultSet rset1 = null;
        Statement stmt2 = conn.createStatement(); 
        ResultSet rset2 = null;
        Statement stmt3 = conn.createStatement(); 
        ResultSet rset3 = null;
        
    %>
    <br><br>
    <table class="table" id="tableOO" width=600 >
        <thead>
        <tr>
            <td width=100>
                <p align=center><img src="https://blog.kakaocdn.net/dn/xljhB/btqyRNVdQWH/tWu2M7hQfKY3YdWJ1vqJRk/img.jpg" height="50" width="100"></p>
            </td>
            <td width=100>
                <p align=center><img src="https://blog.kakaocdn.net/dn/bqoZvd/btqyRNAXIGn/X0OFrAsG6Ok5nYaHWJpUj1/img.jpg" height="50" width="100"></p>
            </td>
            <td width=100>
                <p align=center><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Bugs%21_logo.jpg/250px-Bugs%21_logo.jpg" height="50" width="100"></p>
            </td>
            <td width=100>
                <p align=center><img src="https://blog.kakaocdn.net/dn/cYZHl9/btqBOsfzqLf/1Qy0g0ZvJ9gUWelFG0psT1/img.png" height="50" width="100"></p>
            </td>
        </tr> 
        </thead>
        <%  String titleClass;
            String originalTitle;
            String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
	        for(int i =0; i<=100; i++){
                rset = stmt.executeQuery("select * from melon where ranking="+i+";");
                rset1 = stmt1.executeQuery("select * from genie where ranking="+i+";");
                rset2 = stmt2.executeQuery("select * from bugs where ranking="+i+";");
                rset3 = stmt3.executeQuery("select * from vibe where ranking="+i+";");
                out.println("<tr>");
                while (rset.next()) {
                originalTitle = rset.getString(2);
                titleClass = originalTitle.replaceAll(" ","");
                titleClass =titleClass.replaceAll(match, ""); 
                out.println("<td width=100  name ='info' attribute = '"+rset.getString(2)+"' title='"+titleClass+"'class='"+rset.getString(3)+"' id='"+rset.getString(4)+"' onclick ='changeMenu(this)' onmouseover='find(this)' onmouseout ='notfind(this)'>");
		        out.println("<p align=center >"+rset.getString(2)+"</p>");
                out.println("</td>");
	            }
                while (rset1.next()) {
                originalTitle = rset1.getString(2);
                titleClass =  originalTitle.replaceAll(" ","");
                titleClass =titleClass.replaceAll(match, "");  
                out.println("<td width=100  name ='info'  attribute = '"+rset1.getString(2)+"' title='"+titleClass+"' class='"+rset1.getString(3)+"' id='"+rset1.getString(4)+"' onclick ='changeMenu(this)' onmouseover='find(this)' onmouseout ='notfind(this)'>");
		        out.println("<p align=center>"+rset1.getString(2)+"</p>");
                out.println("</td>");
	            }
                while (rset2.next()) {
                originalTitle = rset2.getString(2);
                titleClass =  originalTitle.replaceAll(" ","");
                titleClass =titleClass.replaceAll(match, "");  
                out.println("<td width=100  name ='info'  attribute = '"+rset2.getString(2)+"' title='"+titleClass+"' class='"+rset2.getString(3)+"' id='"+rset2.getString(4)+"' onclick ='changeMenu(this)' onmouseover='find(this)' onmouseout ='notfind(this)'>");
		        out.println("<p align=center>"+rset2.getString(2)+"</p>");
                out.println("</td>");
	            }
                while (rset3.next()) {
                originalTitle = rset3.getString(2);
                titleClass =  originalTitle.replaceAll(" ","");
                titleClass =titleClass.replaceAll(match, "");  
                out.println("<td width=100 name ='info'   attribute = '"+rset3.getString(2)+"' title='"+titleClass+"' class='"+rset3.getString(3)+"' id='"+rset3.getString(4)+"' onclick ='changeMenu(this)' onmouseover='find(this)' onmouseout ='notfind(this)'>");
		        out.println("<p align=center>"+rset3.getString(2)+"</p>");
                out.println("</td>");
	            }
                out.println("<tr>");
            }
           
        %>
    </table>
    
    
    <div>
    <div>
    
    <%
        rset.close(); 
		stmt.close();
        rset1.close(); 
		stmt1.close();
        rset2.close(); 
		stmt2.close();
        rset3.close(); 
		stmt3.close();
		conn.close();
    %>
</body>
</html>