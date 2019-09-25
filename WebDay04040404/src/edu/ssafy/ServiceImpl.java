package edu.ssafy;

import java.util.ArrayList;

public class ServiceImpl implements IService {

	@Override
	public ArrayList<Calc> calc(int a, int b) {
		ArrayList<Calc> list = new ArrayList<>();
		
		Calc sum = new Calc(a, b, a+b);
		Calc sum1 = new Calc(a+1, b+1, a+b+2);
		Calc sum2 = new Calc(a+2, b+2, a+b+4);
		
		list.add(sum);
		list.add(sum1);
		list.add(sum2);
			
		
		return list;
	}

}
