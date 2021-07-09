<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*,java.text.*, java.util.Date" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
    <div class="row-fluid">
    <h1 class="display-2 text-center">전국 캠퍼스</h1>
    <% 
        String[][] pagelist = { 
			{"서울정수캠퍼스","https://www.kopo.ac.kr/jungsu/index.do"},
			{"서울강서캠퍼스","https://www.kopo.ac.kr/kangseo/index.do"},
			{"성남캠퍼스","https://www.kopo.ac.kr/seongnam/index.do"},
			{"분당융합기술교육원","https://www.kopo.ac.kr/ctc/index.do"},
			{"인천캠퍼스","https://www.kopo.ac.kr/incheon/index.do"},
			{"남인천캠퍼스","https://www.kopo.ac.kr/namincheon/index.do"},
			{"화성캠퍼스","https://www.kopo.ac.kr/hwaseong/index.do"},
			{"광명융합기술원","https://www.kopo.ac.kr/gm/index.do"},
			{"반도체융합캠퍼스","https://www.kopo.ac.kr/semi/index.do"},
			{"춘천캠퍼스","https://www.kopo.ac.kr/chuncheon/index.do"},
			{"원주캠퍼스","https://www.kopo.ac.kr/wonju/index.do"},
			{"강릉캠퍼스","https://www.kopo.ac.kr/gangneung/index.do"},
			{"대전캠퍼스","https://www.kopo.ac.kr/daejeon/index.do"},
			{"청주캠퍼스","https://www.kopo.ac.kr/cheongju/index.do"},
			{"아산캠퍼스","https://www.kopo.ac.kr/asan/index.do"},
			{"홍성캠퍼스","https://www.kopo.ac.kr/hongseong/index.do"},
			{"충주캠퍼스","https://www.kopo.ac.kr/chungju/index.do"},
			{"바이오캠퍼스","https://www.kopo.ac.kr/bio/index.do"},
			{"다솜고등학교","https://www.kopo.ac.kr/dasom/index.do"},
			{"광주캠퍼스","https://www.kopo.ac.kr/gwangju/index.do"},
			{"전북캠퍼스","https://www.kopo.ac.kr/jb/index.do"},
			{"전남캠퍼스","https://www.kopo.ac.kr/jeonnam/index.do"},
			{"익산캠퍼스","https://www.kopo.ac.kr/iksan/index.do"},
			{"순천캠퍼스","https://www.kopo.ac.kr/suncheon/index.do"},
			{"신기술교육원","https://www.kopo.ac.kr/int/index.do"},
			{"인재원","https://www.kopo.ac.kr/namwon/index.do"},
			{"대구캠퍼스","https://www.kopo.ac.kr/daegu/index.do"},
			{"구미캠퍼스","https://www.kopo.ac.kr/gumi/index.do"},
			{"남대구캠퍼스","https://www.kopo.ac.kr/namdaegu/index.do"},
			{"포항캠퍼스","https://www.kopo.ac.kr/pohang/index.do"},
			{"영주캠퍼스","https://www.kopo.ac.kr/yeongju/index.do"},
			{"영남융합기술캠퍼스","https://www.kopo.ac.kr/yct/index.do"},
			{"로봇캠퍼스","https://www.kopo.ac.kr/robot/index.do"},
			{"창원캠퍼스","https://www.kopo.ac.kr/changwon/index.do"},
			{"부산캠퍼스","https://www.kopo.ac.kr/busan/index.do"},
			{"울산캠퍼스","https://www.kopo.ac.kr/ulsan/index.do"},
			{"동부산캠퍼스","https://www.kopo.ac.kr/dongbusan/index.do"},
			{"진주캠퍼스","https://www.kopo.ac.kr/jinju/index.do"},
			{"석유화학공정기술교육원","https://www.kopo.ac.kr/pptc/index.do"},
			{"항공캠퍼스","https://www.kopo.ac.kr/kapc/index.do"},
			{"제주캠퍼스","https://www.kopo.ac.kr/jeju/index.do"},
	};    
    %>
    
    <ul class="nav nav-tabs justify-content-end">
        <li class="nav-item active">
            <a class="nav-link" href="home.jsp">HOME</a>
        </li>
        <li class="nav-item ">
            <a class="nav-link" href="news.jsp">언론보도</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="gongji.jsp">공지사항</a>
        </li>
    </ul>
   
    <table class="table table-hover" width=200 >
        <thead>
        <tr class="table-secondary">
            <td width=100>
                <p align=center>캠퍼스</p>
            </td>
        </tr> 
        </thead>
        <%
                for(int i =0; i<pagelist.length; i++){
                    out.println("<tr>");
                    out.println("<td width=100>");
                    out.println("<center><a href='"+pagelist[i][1]+"''>"+pagelist[i][0]+"</a></center>");
                    out.println("</td>");
                    out.println("</tr>");
                }
                
	        
        %>
    </table>

    <div>
    <div>
</body>
</html>