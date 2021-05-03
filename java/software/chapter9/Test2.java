package chapter9;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Test2 {
	// JSON 만들기
	public static JSONObject kopo41_oneRec(String kopo41_name, int kopo41_studentid, int kopo41_kor, int kopo41_eng, int kopo41_mat) {
		//JSONObject클래스 객체에 json요소를 집어 넣는 함수
		
		JSONObject kopo41_dataObject = new JSONObject(); 
		//JSONObject 클래스의 kopo41_dataObject객체 생성
		kopo41_dataObject.put("name", kopo41_name);
		//kopo41_dataObject 객체에 이름 넣기
		kopo41_dataObject.put("studentid", kopo41_studentid);
		//kopo41_dataObject 객체에 학번 넣기
		
		//JSON 배열 생성
		JSONArray kopo41_score = new JSONArray();
		kopo41_score.add(kopo41_kor); //kopo41_score배열 안에 국어 점수 넣기
		kopo41_score.add(kopo41_eng); //kopo41_score배열 안에 영어 점수 넣기
		kopo41_score.add(kopo41_mat); //kopo41_score배열 안에 수학 점수 넣기
		kopo41_dataObject.put("score", kopo41_score); //kopo41_dataObject객체에 kopo41_score배열 넣기
		return kopo41_dataObject; //kopo41_dataObject객체 리턴하기
	}
	public static void main(String[] args) {
		
		JSONObject kopo41_jsonObject = new JSONObject(); 
		//JSONObject 클래스의 kopo41_dataObject객체 생성 (최종완성객체)
		JSONArray kopo41_datasArray = new JSONArray();
		//JSON 배열 생성 (한명의 성적의 정보를 담을 배열 선언)
		
		JSONObject kopo41_dataObject = new JSONObject(); 
		// 한명의 정보가 들어갈 kopo41_dataObject객체 선언
		kopo41_dataObject.put("name", "나연"); //kopo41_dataObject에 이름 넣기
		kopo41_dataObject.put("studentid", 209901); //kopo41_dataObject에 학번 넣기
		
		JSONArray kopo41_score = new JSONArray(); //JSON 배열 생성
		kopo41_score.add(90); //국어 점수 넣기
		kopo41_score.add(100); //영어 점수 넣기
		kopo41_score.add(95); //수학 점수 넣기
		
		kopo41_dataObject.put("score", kopo41_score); // kopo41_dataObject에 점수 배열 넣기
		kopo41_datasArray.add(kopo41_dataObject); // 전체 학생 객체 배열에 kopo41_dataObject넣기
		
		
		//전체 학생 객체 배열에 만들어논 kopo41_oneRec함수를 호출하여 요소를 집어 넣는다.
		kopo41_datasArray.add(kopo41_oneRec("정연",209902,100,85,75));
		kopo41_datasArray.add(kopo41_oneRec("모모",209903,90,75,85));
		kopo41_datasArray.add(kopo41_oneRec("사나",209904,90,85,75));
		kopo41_datasArray.add(kopo41_oneRec("지효",209905,80,75,85));
		kopo41_datasArray.add(kopo41_oneRec("미나",209906,80,85,65));
		kopo41_datasArray.add(kopo41_oneRec("다연",209907,70,75,75));
		kopo41_datasArray.add(kopo41_oneRec("채영",209908,70,85,85));
		kopo41_datasArray.add(kopo41_oneRec("쯔위",209909,60,65,75));
		
		try {
			FileWriter kopo41_file = new FileWriter("C:\\Users\\sol\\Desktop\\kopo41_test.json");
			// 파일 쓰기 위한 준비
			kopo41_file.write(kopo41_datasArray.toString());
			// 전체 학생의 데이터를 파일에 쓴다
			kopo41_file.flush(); //메모리에서 디스크로 데이터를 쓰기 위해
			kopo41_file.close(); // 파일쓰기 종료
		} catch(IOException e) { //오류 발생시 원인을 보여준다
			e.printStackTrace();
		}
		System.out.println("JSON만든거 : "+kopo41_datasArray); //JSON객체 출력
		

	}

}
