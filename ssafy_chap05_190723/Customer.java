package ssafy_chap05_190723;

public class Customer {
	String num;
	String name;
	int age;
	
	public Customer(String num, String name, int age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}

	public Customer() {
		super();
	}

	
	//관습적으로 toString이 출력하는 구문이다.
	@Override
	public String toString() {
		return "Customer [num=" + num + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
