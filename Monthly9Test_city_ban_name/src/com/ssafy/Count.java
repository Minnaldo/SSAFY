package com.ssafy;


import java.util.Arrays;
import java.util.StringTokenizer;

public class Count {

	public static String execute(String book) {
		String word = "";
		
// 구현하세요.
						
		//String 값을 받아와서
		StringTokenizer st = new StringTokenizer(book);
		int len = st.countTokens();
		String[] str = new String[len];
		
		//단어마다 자르고.
		for(int i = 0; i < str.length; i++) {
			str[i] = st.nextToken();
//			System.out.println(str[i]);
		}
		
		
		
		//단어끼리 비교를 해서, 가장 많이 있는 단어를 뽑는다.
		int[] cnt = new int[str.length];
		for(int i = 0; i < str.length; i++) {
			for(int j = 0; j < str.length; j++) {
				if(str[i].equals(str[j]))
				{
					cnt[i]++;
				}
			}
		}
		
		int max_cnt=0;
		for(int i = 0; i < str.length; i++) {
			max_cnt = Math.max(cnt[i], max_cnt);
		}
		
		//가장 많이 카운트 된 단어를 word에 붙여준다.
		for(int i = 0; i < str.length; i++) {
			if(max_cnt == cnt[i])
			{
				word += str[i].toLowerCase();
				break;
			}
		}
		
//		String min = "MIN";
//		word+=min.toLowerCase();
//		System.out.println(word);
		
		return word;
	}
	
	
	public static void main(String[] args) {
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";
		Count c = new Count();
		System.out.println(c.execute(book1));
		System.out.println(c.execute(book2));
		System.out.println(c.execute(book3));

	}

}


