package kyd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileOutput {
	public boolean isFileExist;
	public BufferedWriter writer;
	
	public FileOutput() throws IOException{
		File file = new File("C:\\Users\\sol\\Desktop\\exchange.csv");
		if(file.exists() ) { //존재하면
			isFileExist = true; 
		} else {
			isFileExist = false;
		}
		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\sol\\Desktop\\exchange.csv",true), "euc-kr"));
	}
	
	public void headerWrite() throws IOException{
		if(!isFileExist) {
			String header = "날짜,환전대상,금액,환전결과,거스름돈\n"; 
			writer.write(header);
		}
	}
	
	public void dataWrite(Variable val) throws IOException{ //데이터 쓰기
		
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); 
		Calendar calt = Calendar.getInstance(); 
		
		String choiceM="";
		if(val.choice==1) {
			choiceM="USD";
		} else if(val.choice==2) {
			choiceM="EUR";
		} else if(val.choice==3){
			choiceM="JPY";
		} else {
			choiceM="USD";
		}
		
		String s = sdt.format(calt.getTime())+","+choiceM+","+val.input+","+val.exchange_moneyInt+","+val.wonChange+"\n";
		writer.write(s);	
	}
	
	public void fileClose() throws IOException{ //파일 쓰기 종료
		writer.close();
	}
}
