package ssafy_chap05_190723;

public class DepartmentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer[] cArr = new Customer[3];
		
		cArr[0] = new Customer("111", "둘리", 8);
		cArr[1] = new Customer("222", "또치", 9);
		cArr[2] = new Customer("333", "도우너", 10);
		
		for(int i = 0; i < cArr.length; i++)
		{
			System.out.println(cArr[i].toString());
		}
		
		
		System.out.println("========================================================");
		
		VipCustomer[] vArr = new VipCustomer[3];
		
		vArr[0] = new VipCustomer("211", "고길동", 40, "둘리혼내기");
		vArr[1] = new VipCustomer("212", "박길동", 30, "발렛파킹");
		vArr[2] = new VipCustomer("213", "홍길동", 20, "호형호제");

		for(int i = 0; i < vArr.length; i++)
		{
			System.out.println(vArr[i].toString());
		}
	}	
}
