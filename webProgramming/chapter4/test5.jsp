<HTML> 
<HEAD> 
<%! 
	private class AA{ 
		private int sum (int i, int j) {
			return i + j;
			}
	}
	AA aa = new AA(); 
%> 
</HEAD> 
<BODY> 
	<% out.println("2+3=" + aa.sum(2,3));%> <br> 
	Good... 
</BODY> 
</HTML>