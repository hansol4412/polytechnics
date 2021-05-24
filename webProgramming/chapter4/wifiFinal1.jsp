<%@ page import="java.io.*"  contentType="text/html; charset=UTF-8" %>
<HTML> 
<HEAD> 
	 
</HEAD> 
<BODY>
	<h1>와이파이</h1>
	<%
			String _from = request.getParameter("from");
			String _cnt = request.getParameter("cnt"); 
			
			int start = Integer.parseInt(_from);
			int cnt = Integer.parseInt(_cnt);
			
			try{
			PrintWriter pw = response.getWriter();
			File kopo41_f = new File("/var/lib/tomcat9/webapps/ROOT/chapter4/wifiData.txt"); 
			BufferedReader kopo41_br = new BufferedReader(new FileReader(kopo41_f));
			
			String kopo41_readtxt; 
			if((kopo41_readtxt = kopo41_br.readLine())== null) {
				//빈 파일 일 경우
				pw.printf("빈 파일 입니다.\n");
				return;
			}
			String[] kopo41_fieldName = kopo41_readtxt.split("\t");
			
			int kopo41_LineCnt = 0; 
			
			double k41_lat = 37.3860521; //경도
			double k41_lng = 127.1214038; //위도
	%>
	
	<table border=1>
		<tr bgcolor=gray>
			<td align=center><b>번호<b/></td>
			<td align=center><b>주소<b/></td>
			<td align=center><b>위도<b/></td>
			<td align=center><b>경도<b/></td>
			<td align=center><b>거리<b/></td>
		</tr> 
	
	<%
			while((kopo41_readtxt = kopo41_br.readLine())!= null) { 
				if(kopo41_LineCnt >= start && kopo41_LineCnt < start+cnt){
					String[] kopo41_field = kopo41_readtxt.split("\t");
					double kopo41_dist= Math.sqrt(Math.pow(Double.parseDouble(kopo41_field[13])-k41_lat, 2)
											+Math.pow(Double.parseDouble(kopo41_field[14])-k41_lng, 2));
	%>
		<tr>
			<td align=center>
			<%= kopo41_field[0] %> 
			</td>
			<td align=center>
			<%= kopo41_field[9] %> 
			</td>
			<td align=center>
			<%= kopo41_field[13] %> 
			</td>
			<td align=center>
			<%= kopo41_field[14] %> 
			</td>
			<td align=center>
			<%= kopo41_dist %> 
			</td>
		</tr>
	
	<%
				
				}
				
				kopo41_LineCnt++; // 데이터 갯수를 알기 위한 변수
			}

		
	%>
		</table>
		<br>
		
		<a href=wifiFinal1.jsp?from=<%=0%>&cnt=<%=cnt%> >&lt;&lt;</a>
	<%
		for(int i = 1; i < 11; i++) {
	%>
		<a href=wifiFinal1.jsp?from=<%=(i-1) * cnt%>&cnt=<%=cnt%>><%=i%></a>
	<%
		}
	%>
		<a href=wifiFinal1.jsp?from=<%=(cnt*10)%>&cnt=<%=cnt%> >&gt;&gt;</a>
	<%
			
			kopo41_br.close(); //파일 읽기 종료
			}catch(IOException e){
				out.println("error==>"+e+"<========<br>");
			} 
	%>
	
		
		
		
		
	

</BODY> 
</HTML>