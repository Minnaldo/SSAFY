package ssafy_chap05_190723;

/** 상속 extends */	//Customer를 상속받은 VipCustomer 클래스
public class VipCustomer extends Customer {
//		String num;
//		String name;
//		int age;
		String service;
		
		public VipCustomer(String num, String name, int age, String service) {
			this.num = num;
			this.name = name;
			this.age = age;
			this.service = service;
		}

		public VipCustomer() {
			super();
		}

		@Override
		public String toString() {
			return "VipCustomer [num=" + num + ", name=" + name + ", age=" + age + ", service=" + service + "]";
		}
		
		
		
	

}
