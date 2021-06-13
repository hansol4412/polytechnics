<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*, java.text.*, java.util.Date" %>
<html>
<head>
    <SCRIPT LANGUAGE="JavaScript">
        function submitForm(mode) {
            fm.action = "gongji_write.jsp?key=INSERT";
            fm.submit();
        }
    </SCRIPT>
</head>
<body>
    <h1>Gongji Insert</h1>
    <% 
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    %>

    <FORM METHOD=POST name='fm'>
        <table width=650 border=1 cellspacing=0 cellpadding=5>
            <tr>
                <td><b>번호</b></td>
                <td>신규(insert)<input type=hidden name=id value='INSERT'></td>
            </tr>
            <tr>
                <td><b>제목</b></td>
                <td><input type=text name=title size=70 maxlength=70></td>
            </tr>
            <tr>
                <td><b>일자</b></td>
                <td><%out.println(sd.format(date));%><input type=hidden name=date value='<%out.println(sd.format(date));%>'></td>
            </tr>
            <tr>
                <td><b>내용</b></td>
                <td><textarea style='width:500px; height: 250px;' name=content cols=70 row=600></textarea></td>
        </table>
        <table width=650>
            <tr>
                <td width=600></td>
                <td><input type=button value="취소" OnClick="location.href='gongji_list.jsp'"></td>
                <td><input type=button value="쓰기" OnClick="submitForm('write')"></td>
            </tr>
        </table>
    </FORM>
</body>
</html>