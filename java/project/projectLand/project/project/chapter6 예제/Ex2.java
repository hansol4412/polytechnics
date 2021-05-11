package chapter6;

public class Ex2 {
	// 변수와 메소드2 최한솔
	static int kop41_iStatic;

	public static void add(int kopo41_i){
		kop41_iStatic++;
		kopo41_i++;
		System.out.printf("add메소드에서->kop41_iStatic=[%d]\n",kop41_iStatic);
		System.out.printf("add메소드에서->kopo41_i=[%d]\n",kopo41_i);
	}
	
	public static int add2(int kopo41_i){
		kop41_iStatic++;
		kopo41_i++;
		System.out.printf("add2메소드에서->kop41_iStatic=[%d]\n",kop41_iStatic);
		System.out.printf("add2메소드에서->kopo41_i=[%d]\n",kopo41_i);
		return kopo41_i;
	}
	
	public static void main(String[] args) {
		int kopo41_iMain;
		kopo41_iMain=1;
		kop41_iStatic=1;
		
		System.out.printf("*****************************\n");
		System.out.printf("메소드호출전 메인에서 ->kop41_iStatic=[%d]\n",kop41_iStatic);
		System.out.printf("메소드호출전 메인에서->kopo41_iMain=[%d]\n",kopo41_iMain);
		System.out.printf("*****************************\n");
		
		add(kopo41_iMain);
		
		System.out.printf("*****************************\n");
		System.out.printf("메소드호출후 메인에서 ->kop41_iStatic=[%d]\n",kop41_iStatic);
		System.out.printf("메소드호출후 메인에서->kopo41_iMain=[%d]\n",kopo41_iMain);
		System.out.printf("*****************************\n");
		
		kopo41_iMain=add2(kopo41_iMain);
		
		System.out.printf("*****************************\n");
		System.out.printf("메소드 add2호출후 메인에서 ->kop41_iStatic=[%d]\n",kop41_iStatic);
		System.out.printf("메소드 add2호출후 메인에서->kopo41_iMain=[%d]\n",kopo41_iMain);
		System.out.printf("*****************************\n");
		
	}
}
		

