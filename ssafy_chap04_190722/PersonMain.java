package ssafy_chap04_190722;

public class PersonMain {

	//JAVA Virtual Machine 이 main함수를 호출해줌.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("홍길동", 21, false, "장덕동");
		System.out.println(p.info());
//		p.name = "둘리";
//		p.age = 8;
//		p.gender = false;
//		p.addr = "쌍문동";
		
//		System.out.println(p.name);			//둘리
//		System.out.println(p.age);			//8
//		System.out.println(p.gender);		//false
//		System.out.println(p.addr);			//쌍문동

		
		//Person.java에서 메소드 리턴!!! 
//		System.out.println(p.info());
		
		Person p2 = new Person("둘리", 8, false, "쌍문동");
		System.out.println(p2.info());
//		p2.name = "고길동";
//		p2.age = 40;
//		p2.gender = false;
//		p2.addr = "쌍문동";
		
		Person p3 = new Person();
	}

}


