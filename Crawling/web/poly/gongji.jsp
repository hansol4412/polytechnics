<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*,java.text.*, java.util.Date" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <SCRIPT>
        function findContent(){
            var findc = document.getElementById("findc").value;
            if((findc == null) || (findc == "")){
                return;
            } else {
                document.getElementById("find").action = "gongji.jsp";
                document.getElementById("find").submit();
            }
        }
    </SCRIPT>
</head>
<body>
    <div class="container">
    <div class="row-fluid">
    <h1 class="display-2 text-center">공지사항</h1>
    <% 
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    %>
    <% 
        String criteria = request.getParameter( "criteria" ); 
        String find = request.getParameter("find");
        
        Class.forName ("com.mysql.cj.jdbc.Driver");  
	    Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/kopo41", "root", "kopo41"); 
	    Statement stmt = conn.createStatement(); 
        Statement stmt1 = conn.createStatement();
        Statement stmt2 = conn.createStatement();

        String pageStr = null;

        if(criteria == null || find == null){
            pageStr = "select count(*) from gongjiP;";
        } else if(criteria.equals("campus")){
            pageStr = "select count(*) from gongjiP where campus like '%"+find+"%';";
        } else if (criteria.equals("title")){
            pageStr = "select count(*) from gongjiP where title like '%"+find+"%' ;";
        } else if (criteria.equals("writer")){
            pageStr = "select count(*) from gongjiP where writer like '%"+find+"%' ;";
        } 

          ResultSet rset2 = stmt2.executeQuery(pageStr);
        
    %>
    <%!
    // 페이지 처리
	public Integer toInt(String x){
		int a = 0;
		try{
			a = Integer.parseInt(x);
		}catch(Exception e){}
		return a;
	}
    %>
    
    <%
        int pageno = toInt(request.getParameter("pageno"));
        if(pageno<1){//현재 페이지
            pageno = 1;
        }
        int total_record = 0;
        if(rset2.next()){
            total_record = rset2.getInt(1);		   // 총 레코드 수
        }
        int page_per_record_cnt = 10;  // 페이지 당 레코드 수
        int group_per_page_cnt = 10;     // 페이지 당 보여줄 번호 수 
                                                

        int record_end_no = pageno*page_per_record_cnt;	// 한 페이지 내에서 끝 			
        int record_start_no = record_end_no-(page_per_record_cnt-1); //한 페이지 내에서 시작
        if(record_end_no>total_record){ 
            record_end_no = total_record;
        }
                                                                            
        int total_page = total_record / page_per_record_cnt + (total_record % page_per_record_cnt>0 ? 1 : 0); //총 페이지 수
        if(pageno>total_page){
            pageno = total_page;
        }

        int group_no = pageno/group_per_page_cnt+( pageno%group_per_page_cnt>0 ? 1:0);
    //		현재 그룹번호 = 현재페이지 / 페이지당 보여줄 번호수 (현재 페이지 % 페이지당 보여줄 번호 수 >0 ? 1:0)	
    //	ex) 	14		=	13(몫)		=	 (66 / 5)		1	(1(나머지) =66 % 5)			  
        
        int page_eno = group_no*group_per_page_cnt;		
    //		현재 그룹 끝 번호 = 현재 그룹번호 * 페이지당 보여줄 번호 
    //	ex) 	70		=	14	*	5
        int page_sno = page_eno-(group_per_page_cnt-1);	
    // 		현재 그룹 시작 번호 = 현재 그룹 끝 번호 - (페이지당 보여줄 번호 수 -1)
    //	ex) 	66	=	70 - 	4 (5 -1)
        
        if(page_eno>total_page){
    //	   현재 그룹 끝 번호가 전체페이지 수 보다 클 경우		
            page_eno=total_page;
    //	   현재 그룹 끝 번호와 = 전체페이지 수를 같게
        }
        
        int prev_pageno = page_sno-group_per_page_cnt;  // <<  *[이전]* [21],[22],[23]... [30] [다음]  >>
    //		이전 페이지 번호	= 현재 그룹 시작 번호 - 페이지당 보여줄 번호수	
    //	ex)		46		=	51 - 5				
        int next_pageno = page_sno+group_per_page_cnt;	// <<  [이전] [21],[22],[23]... [30] *[다음]*  >>
    //		다음 페이지 번호 = 현재 그룹 시작 번호 + 페이지당 보여줄 번호수
    //	ex)		56		=	51 - 5
        if(prev_pageno<1){
    //		이전 페이지 번호가 1보다 작을 경우		
            prev_pageno=1;
    //		이전 페이지를 1로
        }
        if(next_pageno>total_page){
    //		다음 페이지보다 전체페이지 수보가 클경우		
            next_pageno=total_page/group_per_page_cnt*group_per_page_cnt+1;
    //		next_pageno=total_page
    //		다음 페이지 = 전체페이지수 / 페이지당 보여줄 번호수 * 페이지당 보여줄 번호수 + 1 
    //	ex)			   = 	76 / 5 * 5 + 1	???????? 		
        }

    %>
    <% 
        String sql= null;
        //out.println((pageno-1)*page_per_record_cnt);
       // out.println(page_per_record_cnt);
        if(criteria == null || find == null){
            sql = "select * from gongjiP order by date desc limit "+((pageno-1)*page_per_record_cnt)+","+page_per_record_cnt+";";
        } else if(criteria.equals("campus")){
            sql = "select * from gongjiP where campus like '%"+find+"%' order by date desc limit "+((pageno-1)*page_per_record_cnt)+","+page_per_record_cnt+";";
        } else if (criteria.equals("title")){
            sql = "select * from gongjiP where title like '%"+find+"%' order by date desc limit "+((pageno-1)*page_per_record_cnt)+","+page_per_record_cnt+";";
        }  else if (criteria.equals("writer")){
            sql = "select * from gongjiP where writer like '%"+find+"%' order by date desc limit "+((pageno-1)*page_per_record_cnt)+","+page_per_record_cnt+";";
        }

        ResultSet rset = stmt.executeQuery(sql);

    %>
    
    <ul class="nav nav-tabs justify-content-end">
        <li class="nav-item">
            <a class="nav-link " href="home.jsp">HOME</a>
        </li>
        <li class="nav-item ">
            <a class="nav-link " href="news.jsp">언론보도</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="gongji.jsp">공지사항 (<%= rset2.getInt(1) %>건)</a>
        </li>
    </ul>

    <table class="table table-hover" width=600 >
        <thead>
        <tr class="table-secondary">
            <td width=100>
                <p align=center>캠퍼스</p>
            </td>
            <td width=500>
                <p align=center>제목</p>
            </td>
            <td width=100>
                <p align=center>작성자</p>
            </td>
            <td width=100>
                <p align=center>날짜</p>
            </td>
        </tr> 
        </thead>
        <%
	        while (rset.next()) {
                out.println("<tr>");
                out.println("<td width=100>");
		        out.println("<p align=center>"+rset.getString(1)+"</p>");
                out.println("</td>");
                out.println("<td width=500>");
                out.println("<p align=center><a href='"+rset.getString(5)+"'>"+rset.getString(2)+"</a></p>"); 
                out.println("</td>");
                out.println("<td width=100>"); 
                out.println("<p align=center>"+rset.getString(3)+"</p>");
                out.println("</td>");
                out.println("<td width=100>"); 
                out.println("<p align=center>"+rset.getString(4)+"</p>");
                out.println("</td>");
                out.println("</tr>");
	        }
        %>
    
 
    </table>
    
    <div class="float-end">
        
                <form id='find' class="row row-cols-lg-auto g-3 align-items-center">
                    <div class="col-12">
                    <select class="form-select form-select-default mb-1" aria-label=".form-select-lg example" name="criteria">
                        <option value="campus" />캠퍼스</option>
                        <option value="title" />제목</option>
                        <option value="writer" />작성자</option>
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

            <%
                if(criteria == null || find == null){
                    out.println("<a href='gongji.jsp?pageno=1' class='btn btn-outline-primary'>&lt;&lt;</a>");
                    out.println("<a href='gongji.jsp?pageno="+prev_pageno+"' class='btn btn-outline-primary'>&lt;</a>");
                }else{
                    out.println("<a href='gongji.jsp?pageno=1&criteria="+criteria+"&find="+find+"' class='btn btn-outline-primary'>&lt;&lt;</a>");
                    out.println("<a href='gongji.jsp?pageno="+prev_pageno+"&criteria="+criteria+"&find="+find+"' class='btn btn-outline-primary'>&lt;</a>");
                }
            %>
            <%
                if(criteria == null || find == null){
                    for(int i = page_sno; i<=page_eno; i++){
                        if(pageno == i){
                            out.println("<a class='btn btn-primary' href='gongji.jsp?pageno="+i+"'>"+i+"</a>");
                        } else {
                            out.println("<a class='btn btn-outline-primary' href='gongji.jsp?pageno="+i+"'>"+i+"</a>");
                        }
                    } 
                }else{
                    for(int i = page_sno; i<=page_eno; i++){
                        if(pageno == i){
                            out.println("<a class='btn btn-primary' href='gongji.jsp?pageno="+i+"&criteria="+criteria+"&find="+find+"'>"+i+"</a>");
                        } else {
                            out.println("<a class='btn btn-outline-primary' href='gongji.jsp?pageno="+i+"&criteria="+criteria+"&find="+find+"'>"+i+"</a>");
                        }
                    } 
                }     
            %> 
             <%
                if(criteria == null || find == null){
                    out.println("<a href='gongji.jsp?pageno="+next_pageno+"' class='btn btn-outline-primary'>&gt;</a>");
                    out.println("<a href='gongji.jsp?pageno="+total_page+"' class='btn btn-outline-primary'>&gt;&gt;</a>");
                }else{
                    out.println("<a href='gongji.jsp?pageno="+next_pageno+"&criteria="+criteria+"&find="+find+"' class='btn btn-outline-primary'>&gt;</a>");
                    out.println("<a href='gongji.jsp?pageno="+total_page+"&criteria="+criteria+"&find="+find+"' class='btn btn-outline-primary'>&gt;&gt;</a>");
                }
            %>
   
    <div>
    <div>
    
    <%
        rset.close(); 
		stmt.close(); 
        rset2.close(); 
		stmt2.close(); 
        stmt1.close(); 
		conn.close();
    %>
</body>
</html>