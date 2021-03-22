package chapter5;

public class P13_Data {
	public int input;
	public int output;
	public double number;
	
	public P13_Data(int input, int output, double number) {
		this.input = input;
		this.output = output;
		this.number = number;
	}
	
	public double convertM(int code, double num) {
		if(code ==1) {
			return num/100;
		} else if (code==2) {
			return num;
		} else if (code==3) {
			return num/1000;
		} else if (code==4) {
			return num*1000;
		} else if (code==5) {
			return num*1609.344;
		} else {
			return 0;
		}
	}
	
	public double convertO(int code, double num) {
		if(code ==1) {
			return num*100;
		} else if (code==2) {
			return num;
		} else if (code==3) {
			return num*1000;
		} else if (code==4) {
			return num/1000;
		} else if (code==5) {
			return num/1609.344;
		} else {
			return 0;
		}
	}
	
	
}

