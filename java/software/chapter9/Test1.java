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

public class Test1 {
	//XML 파싱 기본
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilder kopo41_docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		// 파싱을 위한 준비
		Document kopo41_doc = kopo41_docBuilder.parse(new File("C:\\Users\\sol\\Desktop\\kopo41_score.txt")); 
		// 파일 가져오기
		Element kopo41_root = kopo41_doc.getDocumentElement();
		//root 태그 가져오기 (맨꼭대기) => 여기서는 사용 안함
		
		NodeList kopo41_tag_name = kopo41_doc.getElementsByTagName("name"); // 이름 가져오기
		NodeList kopo41_tag_studentid = kopo41_doc.getElementsByTagName("studentid"); // 학번 가져오기
		NodeList kopo41_tag_kor = kopo41_doc.getElementsByTagName("kor"); // 국어 점수 가져오기
		NodeList kopo41_tag_eng = kopo41_doc.getElementsByTagName("eng"); // 영어 점수 가져오기
		NodeList kopo41_tag_mat = kopo41_doc.getElementsByTagName("mat"); // 수학 점수 가져오기
		
		System.out.printf("*************************************************\n");
		for(int kopo41_i=0; kopo41_i<kopo41_tag_name.getLength(); kopo41_i++) {
			System.out.printf("이름 : %s\n",kopo41_tag_name.item(kopo41_i).getFirstChild().getNodeValue());
			//kopo41_tag_name의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
			System.out.printf("학번 : %s\n",kopo41_tag_studentid.item(kopo41_i).getFirstChild().getNodeValue());
			//kopo41_tag_studentid의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
			System.out.printf("국어 : %s\n",kopo41_tag_kor.item(kopo41_i).getFirstChild().getNodeValue());
			//kopo41_tag_kor의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
			System.out.printf("영어 : %s\n",kopo41_tag_eng.item(kopo41_i).getFirstChild().getNodeValue());
			//kopo41_tag_eng의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
			System.out.printf("수학 : %s\n",kopo41_tag_mat.item(kopo41_i).getFirstChild().getNodeValue());
			//kopo41_tag_mat의 kopo41_i번째 값의 첫번째 자식의 값을 가져온다.
			System.out.printf("*************************************************\n");
		}
		

	}

}
