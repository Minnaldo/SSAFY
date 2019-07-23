package com.ssafy;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("21424", "Java Pro", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
		Book b2 = new Book("35355", "분석설계        ", "소나무", "Jaen.kr", 30000, "SW 모델링");
		Magazine m1 = new Magazine("35535", "Java World", "편집부", "java.com", 7000, "첫걸음", 2018, 2);
		Magazine m2 = new Magazine("77177", "Java Getit", "도서부", "java.com", 9000, "세걸음", 2019, 7);
		
				
		System.out.println("======================== 도서 목록 =========================");
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		
		
		Book[] bArr = new Book[2];
		Magazine[] mArr = new Magazine[2];
		
//		bArr[0] = new Book();	//객체 생성을 먼저 해야 한다.
		bArr[0] = b1;
		bArr[1] = b2;
		
		mArr[0] = m1;
		mArr[1] = m2;
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < bArr.length; i++)
		{
			System.out.println(bArr[i].toString());
		}
		
		for (int i = 0; i < mArr.length; i++)
		{
			System.out.println(mArr[i].toString());
		}
	}
}
