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

public class Test5 {
	//XML 파싱 날씨
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException{
		DocumentBuilder kopo41_docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		// 파싱을 위한 준비
		Document kopo41_doc = kopo41_docBuilder.parse(new File("C:\\Users\\sol\\Desktop\\kopo41_whether.txt")); 
		// 파일 가져오기
		
		String kopo41_seq=""; // 48시간 중 몇 번째인지 알려줌
		String kopo41_hour=""; // 동네 예보 3시간 단위
		String kopo41_day="" ; // 1번째 날 (0: 오늘, 1: 내일, 2:모레)
		String kopo41_temp=""; //현재 시간 온도
		String kopo41_tmx=""; // 최고온도
		String kopo41_tmn=""; //최저 온도
		String kopo41_sky=""; //하늘 상태 코드 (1: 맑음, 2: 구름조금, 3: 구름많음, 4:흐림)
		String kopo41_pty=""; //강수 상태 코드 (0: 없음, 1: 비, 2: 비/눈, 3:눈/비, 4: 눈)
		String kopo41_wfKor=""; //날씨 한국어
		String kopo41_wfEn=""; // 날씨 영어
		String kopo41_pop=""; //강수 확률 %
		String kopo41_r12=""; //12시간 예상 강수량
		String kopo41_s12=""; //12시간 예상 적설량
		String kopo41_ws=""; // 풍속 m/s
		String kopo41_wd=""; //풍향 (0~7: 북, 북동, 동, 남동, 남, 남서, 서, 북서)
		String kopo41_wdKor=""; // 풍향 한국어
		String kopo41_wdEn=""; // 풍향 영어
		String kopo41_reh=""; // 습도 %
		String kopo41_r06=""; //6시간 예상 강수량
		String kopo41_s06=""; //6시간 예상 적설량
		
		Element kopo41_root = kopo41_doc.getDocumentElement();
		//root 태그 가져오기 (맨꼭대기) => 여기서는 사용 안함
		NodeList kopo41_tag_001 = kopo41_doc.getElementsByTagName("data"); 
		//xml의 루트를 기준으로 데이터 태그를 찾는다.
		
		for(int kopo41_i=0; kopo41_i<kopo41_tag_001.getLength(); kopo41_i++) {
			
			Element kopo41_elmt = (Element)kopo41_tag_001.item(kopo41_i);
			//data 태그가 여러개 있는데 하나를 선택해 어트리뷰트가 seq를 찾고 그것의 값을 갖게한다.
			//data seq="0", data seq="1"을 보고 0,1,2,3 값이 나온다. 
			
			kopo41_seq = kopo41_tag_001.item(kopo41_i).getAttributes().getNamedItem("seq").getNodeValue(); 
			//루트를 기준인 데이터 kopo41_tag_001의 kopo41_i번째에서 seq를 찾아 값을 뽑는다.
			kopo41_hour = kopo41_elmt.getElementsByTagName("hour").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 hour인 것에서 첫번째 자식을 추출한다.
			kopo41_day = kopo41_elmt.getElementsByTagName("day").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 day인 것에서 첫번째 자식을 추출한다.
			// 상태코드를 한글로 변환한다.
			if(kopo41_day.equals("0")) {
				kopo41_day="오늘";
			} else if(kopo41_day.equals("1")) {
				kopo41_day="내일";
			} else {
				kopo41_day="모레";
			}
			kopo41_temp = kopo41_elmt.getElementsByTagName("temp").item(0).getFirstChild().getNodeValue(); 
			// 태그 이름이 temp인 것에서 첫번째 자식을 추출한다.
			kopo41_tmx = kopo41_elmt.getElementsByTagName("tmx").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 tmx인 것에서 첫번째 자식을 추출한다.
			kopo41_tmn = kopo41_elmt.getElementsByTagName("tmn").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 tmn인 것에서 첫번째 자식을 추출한다.
			kopo41_sky = kopo41_elmt.getElementsByTagName("sky").item(0).getFirstChild().getNodeValue(); 
			// 태그 이름이 sky인 것에서 첫번째 자식을 추출한다.
			// 상태코드를 한글로 변환한다.
			if(kopo41_sky.equals("1")) {
				kopo41_sky="맑음";
			} else if(kopo41_sky.equals("2")) {
				kopo41_sky="구름조금";
			} else if(kopo41_sky.equals("3")) {
				kopo41_sky="구름많음";
			} else {
				kopo41_sky="흐림";
			}
			kopo41_pty = kopo41_elmt.getElementsByTagName("pty").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 pty인 것에서 첫번째 자식을 추출한다.
			// 상태코드를 한글로 변환한다.
			if(kopo41_pty.equals("0")) {
				kopo41_pty="맑음";
			} else if(kopo41_pty.equals("1")) {
				kopo41_pty="비";
			} else if(kopo41_pty.equals("2")) {
				kopo41_pty="비/눈";
			}else if(kopo41_pty.equals("3")) {
				kopo41_pty="눈/비";
			} else {
				kopo41_pty="눈";
			}
			kopo41_wfKor = kopo41_elmt.getElementsByTagName("wfKor").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 wfKor인 것에서 첫번째 자식을 추출한다.
			kopo41_wfEn = kopo41_elmt.getElementsByTagName("wfEn").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 wfEn인 것에서 첫번째 자식을 추출한다.
			kopo41_pop = kopo41_elmt.getElementsByTagName("pop").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 pop인 것에서 첫번째 자식을 추출한다.
			kopo41_r12 = kopo41_elmt.getElementsByTagName("r12").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 r12인 것에서 첫번째 자식을 추출한다.
			kopo41_s12 = kopo41_elmt.getElementsByTagName("s12").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 s12인 것에서 첫번째 자식을 추출한다.
			kopo41_ws = kopo41_elmt.getElementsByTagName("ws").item(0).getFirstChild().getNodeValue(); 
			// 태그 이름이 ws인 것에서 첫번째 자식을 추출한다.
			kopo41_wd = kopo41_elmt.getElementsByTagName("wd").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 wd인 것에서 첫번째 자식을 추출한다.
			// 상태코드를 한글로 변환한다.
			if(kopo41_wd.equals("0")) {
				kopo41_wd="북";
			} else if(kopo41_wd.equals("1")) {
				kopo41_wd="북동";
			} else if(kopo41_wd.equals("2")) {
				kopo41_wd="동";
			} else if(kopo41_wd.equals("3")) {
				kopo41_wd="남동";
			} else if(kopo41_wd.equals("4")) {
				kopo41_wd="남";
			} else if(kopo41_wd.equals("5")) {
				kopo41_wd="남서";
			} else if(kopo41_wd.equals("6")) {
				kopo41_wd="서";
			} else {
				kopo41_wd="북서";
			}
			kopo41_wdKor = kopo41_elmt.getElementsByTagName("wdKor").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 wdKor인 것에서 첫번째 자식을 추출한다.
			kopo41_wdEn = kopo41_elmt.getElementsByTagName("wdEn").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 wdEn인 것에서 첫번째 자식을 추출한다.
			kopo41_reh = kopo41_elmt.getElementsByTagName("reh").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 reh인 것에서 첫번째 자식을 추출한다.
			kopo41_r06 = kopo41_elmt.getElementsByTagName("r06").item(0).getFirstChild().getNodeValue(); 
			// 태그 이름이 r06인 것에서 첫번째 자식을 추출한다.
			kopo41_s06 = kopo41_elmt.getElementsByTagName("s06").item(0).getFirstChild().getNodeValue();
			// 태그 이름이 s06인 것에서 첫번째 자식을 추출한다.
			
			//날씨 정보 출력
				System.out.printf("*************************************************\n");
				System.out.printf("순서 : %s\n",kopo41_seq);
				System.out.printf("동네예보 3시간 단위 : %s시\n",kopo41_hour);
				System.out.printf("날짜: %s\n",kopo41_day);
				System.out.printf("현재시간온도 : %s°C\n",kopo41_temp);
				System.out.printf("최고온도 : %s°C\n",kopo41_tmx);
				System.out.printf("최저온도 : %s°C\n",kopo41_tmn);
				System.out.printf("하늘 상태 : %s\n",kopo41_sky);
				System.out.printf("강수 상태 : %s\n",kopo41_pty);
				System.out.printf("날씨 한국어 : %s\n",kopo41_wfKor);
				System.out.printf("날씨 영어 : %s\n",kopo41_wfEn);
				System.out.printf("강수 확률 : %s%%\n",kopo41_pop);
				System.out.printf("12시간 예상 강수량 : %smm\n",kopo41_r12);
				System.out.printf("12시간 예상 적설량 : %smm\n",kopo41_s12);
				System.out.printf("풍속 (m/s) : %sm/s\n",kopo41_ws);
				System.out.printf("풍향: %s\n",kopo41_wd);
				System.out.printf("풍향 한국어 : %s\n",kopo41_wdKor);
				System.out.printf("풍향 영어 : %s\n",kopo41_wdEn);
				System.out.printf("습도 : %s%%\n",kopo41_reh);
				System.out.printf("6시간 예상 강수량 : %smm\n",kopo41_r06);
				System.out.printf("6시간 예상 적설량 : %smm\n",kopo41_s06);
				System.out.printf("*************************************************\n");
			
		}

	}

}
