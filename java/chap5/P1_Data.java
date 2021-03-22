package chapter5;

public class P1_Data {	
	int apple;
	int strawberry;
	int grape;
	int watermelon;
	
	public P1_Data(int apple, int strawberry, int grape, int watermelon) {
		this.apple = apple;
		this.strawberry = strawberry;
		this.grape = grape;
		this.watermelon = watermelon;
	}
	
	public int applePrice() {
		return this.apple;
	}
	
	public int strawberryPrice() {
		return this.strawberry;
	}
	
	public int grapePrice() {
		return this.grape;
	}
	
	public int watermelonPrice() {
		return this.watermelon;
	}
	

}
