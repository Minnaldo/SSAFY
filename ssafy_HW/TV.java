package ssafy_HW;

public class TV {
	/** product_num 멤버변수 */		//자바doc 쓰려고
	private String product_num;	
	private String product_name;
	private int	price;
	private int num;
	private int inch;
	private String display_type;
	
	/** 생성자 오버로드  (생성자 여러개)*/  //생성자 여러개
	TV() {}		//Constructor(생성자)		//생성자가 여러개라고 하더라고 실행되는 건 맞는 생성자 하나.
	
	/* this의 product_num 은   TV객체의 멤버변수 product_num 을 의미하고
	 * 멤버변수 this.product_num -> heap 영역,,
	 * 매개변수 product_num      -> stack 영역,,
	 * 	우측변에 있는 product_num 은 매개변수 product_num 을 뜻한다.
	 * 
	 */
	public TV(String product_num, String product_name, int price, int num, int inch, String display_type) {
		this();								//기본생성자 생성.
		this.product_num = product_num;		//기본생성자가 먼저 생성 되어야, 호출가능.
		this.product_name = product_name;	//따라서 기본생성자는 첫번째 줄에!!!
		this.price = price;
		this.num = num;
		this.inch = inch;
		this.display_type = display_type;
	}

	/** set get 사용 이유 */
	/*setter getter를 사용하는 이유
	*: 데이터 무결성 때문에, 객체의 멤버 변수를 private으로 다른 클래스에서 접근하지 못하게 해뒀기 때문에
	*  메소드로 만들면 -> 기능 구현,, 을 할 수 있기 때문에.  (데이터가 잘못 들어오지 않다.)
	*  [set get 쓰는 이유는 : Encasulation(캡슐화),, 속도가 늦더라도 데이터가 정확히 오는게 중요!!!
	*/ 
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
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getDisplay_type() {
		return display_type;
	}
	public void setDisplay_type(String display_type) {
		this.display_type = display_type;
	}
	
	/* 상위 클래스에서 오버라이드한 메소드,,(non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 상위 클래스에 정의되어 있는 toString을 오버라이드된 메소드임을 지정함으로써,
	 * 개발자가 메소드명이나 매개변수를 잘못 쓰고 찾지 못하는 것을 방지해준다.
	 */
	
	@Override
	public String toString() {
		return "TV [product_num=" + product_num + ", product_name=" + product_name + ", price=" + price + ", num=" + num
				+ ", inch=" + inch + ", display_type=" + display_type + "]";
	}
	
}
