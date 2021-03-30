package project;

public class SortData{
	private String name;
	private int price;
	private int family;
	private int subway;

	public SortData(String name, int price, int family, int subway) {
		this.name = name;
		this.price = price;
		this.family = family;
		this.subway = subway;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		if(this.price==0) {
			return 9999999;
		}
		return price;
	}

	public int getFamily() {
		if(this.family==0) {
			return 99999;
		}
		return family;
	}

	public int getSubway() {
		if(this.family==0) {
			return 1000;
		}
		return subway;
	}
}
