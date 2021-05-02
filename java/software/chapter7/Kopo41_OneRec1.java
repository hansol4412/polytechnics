package chapter7;

public class Kopo41_OneRec1 {
	private int kopo41_student_id;
	private String kopo41_name; //이름
	private int kopo41_kor; //국어점수
	private int kopo41_eng; //영어점수
	private int kopo41_mat; //수학점수
	
	//생성자 만들어서 객체를 만들 때 변수가 저장될 수 있도록 한다.
	public Kopo41_OneRec1(int kopo41_student_id, String kopo41_name, int kopo41_kor, int kopo41_eng, int kopo41_mat) {
		super();
		this.kopo41_student_id = kopo41_student_id;
		this.kopo41_name = kopo41_name;
		this.kopo41_kor = kopo41_kor;
		this.kopo41_eng = kopo41_eng;
		this.kopo41_mat = kopo41_mat;
	}
	
	// 변수가 private로 선언되어 외부 클래스에서 변수를 호출하지 못한다.
	// 변수를 호출하기 위해 메소드를 사용하여 변수를 호출하도록 한다.
	public int kopo41_student_id() { //번호 호출
		return this.kopo41_student_id;
	}
	public String kopo41_name() { //이름 호출
		return this.kopo41_name;
	}
	public int kopo41_kor() { //국어 점수 호출
		return this.kopo41_kor;
	}
	
	public int kopo41_eng() { //영어 점수 호출
		return this.kopo41_eng;
	}
	
	public int kopo41_mat() { //수학 점수 호출
		return this.kopo41_mat;
	}
	
	public int kopo41_sum() { //총합 점수 호출
		return this.kopo41_kor+this.kopo41_eng+this.kopo41_mat;
	}
	
	public double kopo41_avg() { //평균 점수 호출
		return (this.kopo41_kor+this.kopo41_eng+this.kopo41_mat)/3.0;
	}
}
