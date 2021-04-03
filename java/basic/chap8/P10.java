package chapter8;

public class P10 {

	public static void main(String[] args) {
	// 에러처리
		int[] numbers = {5,10,12};
		try {
			System.out.println(numbers[3]);
			String temp=null;
			System.out.println(temp.length());
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("exception1");
			//e.printStackTrace();
		} catch(NullPointerException e){
			System.out.println("exception2");
		} catch(Exception e){
			System.out.println("exception3");
		}
		finally {
			System.out.println("finally");
		}
	}

}
