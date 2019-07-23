package ssafy_HW;

public class Refrigerator {
	private String product_num;	
	private String product_name;
	private int	price;
	private int num;
	private int capacity;
	
	Refrigerator() {}

	public Refrigerator(String product_num, String product_name, int price, int num, int capacity) {
		this.product_num = product_num;
		this.product_name = product_name;
		this.price = price;
		this.num = num;
		this.capacity = capacity;
	}

	public String getProduct_num() {
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}



	@Override
	public String toString() {
		return "Refrigerator [product_num=" + product_num + ", product_name=" + product_name + ", price=" + price
				+ ", num=" + num + ", capacity=" + capacity + "]";
	}
	
	
	
	
}
