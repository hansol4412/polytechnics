package amusement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//���� ��� Ŭ����
public class OutputFile {
	public boolean isFileExist;
	public BufferedWriter writer;
	
	public OutputFile() throws IOException{
		File file = new File(ConstValue.FILEPATH);
		if(file.exists()) { //�����ϸ�
			isFileExist = true; 
		} else {
			isFileExist = false;
		}
		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ConstValue.FILEPATH,true), "euc-kr"));
	}
	
	public void headerWrite() throws IOException{
		if(!isFileExist) {
			String header = "��¥,����,���ɱ���,����,����,������\n"; 
			writer.write(header);
		}
	}
	
	public void dataWrite(SaveValue saveV) throws IOException{ //������ ����
		
		SimpleDateFormat sdt = new SimpleDateFormat("YYYYMMdd"); 
		Calendar calt = Calendar.getInstance(); 
	
		String s = sdt.format(calt.getTime())+","+saveV.ticketTypeCode+","+saveV.ageCode+","+saveV.ticketCount+","+saveV.finalPrice+","+saveV.discountType+"\n";
		writer.write(s);
	}
	
	public void fileClose() throws IOException{ //���� ���� ����
		writer.close();
	}
}
