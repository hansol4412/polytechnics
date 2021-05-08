package chapter2;

public class Test2 {
	//숫자 변수 교환 (최한솔)
	public static void main(String[] args) {
		int kopo41_x = 10; //x 10으로 초기값 지정
		int kpop41_y = 20; // y 20으로 초기값 지정
		int kopo41_tmp = 0; //tmp 0으로 초기값 지정
		
		System.out.println("x:"+kopo41_x+" y:"+kpop41_y); // x,y값 출력해서 확인
		
		kopo41_tmp = kopo41_x; //tmp값에 x값을 넣는다
		kopo41_x = kpop41_y; // x값에 y값을 넣는다
		kpop41_y = kopo41_tmp; // y값에 tmp에 저장한 x값을 저장한다.
		
		System.out.println("x:"+kopo41_x+" y:"+kpop41_y); // x,y값 출력해서 바뀐것 확인
	}
}
