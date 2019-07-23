package ssafy_chap04_190722;

public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		System.out.println(c.add(4, 3));
		
		System.out.println(c.minus(6,  3));
//		System.out.print(c.add(4,  3));
		
		/** 오버로드 */
		/** 메소드 오버로드 */
		
		//실수형 default값은 double.
		//float을 해주고 싶으면, f를 붙여준다.
//		c.add(3.1f, b);
		
		//Calculator.java 클래스에서
		//같은 이름의 매개변수가 다른 함수를 만들어줘서 에러가 안 남.
		c.add(4,  3);
		c.add(3.f, 3);
		c.add(3,  3.f);
	}

}
