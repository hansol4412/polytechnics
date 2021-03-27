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
		return price;
	}

	public int getFamily() {
		return family;
	}

	public int getSubway() {
		return subway;
	}
}
