package ssafy_chap04_190722;

/**Person 정보클래스 */
class Person {
	/** 이름 */
	String name;		//이름	//멤버변수 name	//garbage collector 가 지우면 사라짐.
	/** 나이 */
	int age;			//나이
	/** 성별 */
	boolean gender;		//성별	//여 : true, 남 : false
	/** 주소 */
	String addr;		//주소
	/** Constructor */
	Person(){				//생성자를 직접 만들지 않아도
//		this("홍길동", 22);
//		this.addr			//기본으로 생성자가 생성된다.
//		this.age			//this는 여기서 Person이다.
//		this.name
//		this.gender
	}
	
	//Person()의 this()를 호출할 경우, 자기가 자기를 부르기 때문에, 에러..
	//핑퐁,, this()와 this("홍길동", 22) 를 같이 쓰면
	Person(String name, int age)
	{
//		this();						//이건 생성자를 의미한다..!!!
									//this를 이용한 생성자코드는 무조건 첫 라인에!!
									//객체가 만들어졌다라는 의미이기 때문에,,
		this.name = name;			//이름이 같을 때, this를 사용해서 이름충돌을 피한다.
		this.age = age;
	}
		
	/** Constructor (생성자) */
	Person(String name, int age, boolean gender, String addr){
		System.out.println("생성자");
		
		this.name = name;		//생성자가 끝나면 _name은 사라짐,
		this.age = age;
		this.gender = gender;
		this.addr = addr;
		
	}
	
	//정보 메소드
	String info()
	{
		String str = "name="+name+", age="+age+", gender="+gender+", addr="+addr;
		return str;
	}
	
	
}