package chapter9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test3 {
	//JSON 파싱
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{
		JSONParser kopo41_parser = new JSONParser(); // 자바에서 json을 파싱하기 위한 클래스
		
		Object kopo41_obj  = kopo41_parser.parse(new FileReader("C:\\Users\\sol\\Desktop\\kopo41_test.json")); 
		//json 경로 지정해서 Object 파일에 넣기
		
		JSONArray kopo41_array = (JSONArray)kopo41_obj; // 파싱해온 데이터를 JSONArray형식으로 변환해서 JSONArray 객체에 넣기
		
		System.out.println("*******************************************");
		for(int kopo41_i=0; kopo41_i<kopo41_array.size(); kopo41_i++) { //kopo41_array의 크기만큼 반복문 돌리기
			JSONObject kopo41_result = (JSONObject) kopo41_array.get(kopo41_i); 
			//kopo41_result에 kopo41_array의 요소들을 하나씩 집어 넣기, 즉 한 사람의 정보를 kopo41_result에 집어 넣기
			System.out.println("이름 : "+ kopo41_result.get("name")); //kopo41_result에서 이름 정보 출력
			System.out.println("학번 : "+ kopo41_result.get("studentid")); //kopo41_result에서 학번 정보 출력
			
			JSONArray kopo41_score = (JSONArray)kopo41_result.get("score"); //kopo41_result에서 성적 정보 가져오기
			long kopo41_kor = (long)kopo41_score.get(0); // kopo41_score배열에서 국어 점수 가져오기
			long kopo41_eng = (long)kopo41_score.get(1); // kopo41_score배열에서 영어 점수 가져오기
			long kopo41_mat = (long)kopo41_score.get(2); // kopo41_score배열에서 수학 점수 가져오기
			System.out.println("국어 : "+ kopo41_kor); // 국어 점수 출력
			System.out.println("영어 : "+ kopo41_eng); // 영어 점수 출력
			System.out.println("수학 : "+ kopo41_mat); // 수학 점수 출력
			System.out.println("총점 : "+ (kopo41_kor+kopo41_eng+kopo41_mat)); // 총합 점수 출력
			System.out.println("평균 : "+ ((kopo41_kor+kopo41_eng+kopo41_mat)/3.0)); // 평균 점수 출력
			System.out.println("*******************************************"); 
		}
	}

}
