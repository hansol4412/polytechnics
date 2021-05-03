package chapter9;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test4 {
	//XML 파싱 날씨
		public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
			DocumentBuilder kopo41_docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			// 파싱을 위한 준비
			Document kopo41_doc = kopo41_docBuilder.parse(new File("C:\\Users\\sol\\Desktop\\kopo41_whether.txt")); 
			// 파일 가져오기
			Element kopo41_root = kopo41_doc.getDocumentElement();
			//root 태그 가져오기 (맨꼭대기) => 여기서는 사용 안함
			
			//NodeList kopo41_seq = kopo41_doc.getElementsByTagName("data seq"); 
			NodeList kopo41_hour = kopo41_doc.getElementsByTagName("hour"); 
			NodeList kopo41_day = kopo41_doc.getElementsByTagName("day"); 
			NodeList kopo41_temp = kopo41_doc.getElementsByTagName("temp"); 
			NodeList kopo41_tmx = kopo41_doc.getElementsByTagName("tmx"); 
			NodeList kopo41_tmn = kopo41_doc.getElementsByTagName("tmn"); 
			NodeList kopo41_sky = kopo41_doc.getElementsByTagName("sky"); 
			NodeList kopo41_pty = kopo41_doc.getElementsByTagName("pty"); 
			NodeList kopo41_wfKor = kopo41_doc.getElementsByTagName("wfKor"); 
			NodeList kopo41_wfEn = kopo41_doc.getElementsByTagName("wfEn"); 
			NodeList kopo41_pop = kopo41_doc.getElementsByTagName("pop"); 
			NodeList kopo41_r12 = kopo41_doc.getElementsByTagName("r12"); 
			NodeList kopo41_s12 = kopo41_doc.getElementsByTagName("s12"); 
			NodeList kopo41_ws = kopo41_doc.getElementsByTagName("ws"); 
			NodeList kopo41_wd = kopo41_doc.getElementsByTagName("wd"); 
			NodeList kopo41_wdKor = kopo41_doc.getElementsByTagName("wdKor"); 
			NodeList kopo41_wdEn = kopo41_doc.getElementsByTagName("wdEn"); 
			NodeList kopo41_reh = kopo41_doc.getElementsByTagName("reh");
			NodeList kopo41_r06 = kopo41_doc.getElementsByTagName("r06"); 
			NodeList kopo41_s06 = kopo41_doc.getElementsByTagName("s06");
			
			System.out.printf("*************************************************\n");
			for(int kopo41_i=0; kopo41_i<kopo41_hour.getLength(); kopo41_i++) {
				//System.out.printf("순서 : %s\n",kopo41_seq.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_name의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("동네예보 3시간 단위 : %s\n",kopo41_hour.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_studentid의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("(0:오늘 / 1:내일 / 2:모레) : %s\n",kopo41_day.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_kor의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("현재시간온도 : %s\n",kopo41_temp.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_eng의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("최고온도 : %s\n",kopo41_tmx.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_mat의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("최저온도 : %s\n",kopo41_tmn.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_name의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("하늘 상태코드 : %s\n",kopo41_sky.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_studentid의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("강수 상태코드 : %s\n",kopo41_pty.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_kor의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("날씨 한국어 : %s\n",kopo41_wfKor.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_eng의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("날씨 영어 : %s\n",kopo41_wfEn.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_mat의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("강수 확률 : %s\n",kopo41_pop.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_name의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("12시간 예상 강수량 : %s\n",kopo41_r12.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_studentid의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("12시간 예상 적설량 : %s\n",kopo41_s12.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_kor의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("풍속 (m/s) : %s\n",kopo41_ws.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_eng의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("풍향: %s\n",kopo41_wd.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_mat의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("풍향 한국어 : %s\n",kopo41_wdKor.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_name의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("풍향 영어 : %s\n",kopo41_wdEn.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_studentid의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("습도 : %s\n",kopo41_reh.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_kor의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("6시간 예상 강수량 : %s\n",kopo41_r06.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_eng의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("6시간 예상 적설량 : %s\n",kopo41_s06.item(kopo41_i).getFirstChild().getNodeValue());
				//kopo41_tag_mat의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
				System.out.printf("*************************************************\n");
			}
			

		}

}
