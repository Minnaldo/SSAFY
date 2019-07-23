package ssafy_chap04_190722;

public class DateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	07, 08  -> 앞에 이렇게 붙으면 08부터는 8진수라 에러.
		// 따라서, 7, 8 이렇게 써야함.
		Date d= new Date(2019,7,22);
		System.out.println(d.info());
		
		//Calculator 클래스에서 private 으로 해놓아서 접근이 불가.
//		d.day = 32;
//		System.out.println(d.info());
		
		
		d.setYear(2020);
		d.setMonth(12);
		
		
		System.out.println(d.info());
		/*절자지향과 객체지향의 또 다른 차이점.
		 * 
		 */
	}

}
