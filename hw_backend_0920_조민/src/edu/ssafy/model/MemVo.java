package edu.ssafy.model;

public class MemVo {
	private String id;
	private String name;
	private String quantity;
	private int price;
	
	public MemVo() {
		super();
	}

	public MemVo(String id, String name, String quantity, int price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MemVo [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
		
	
}
