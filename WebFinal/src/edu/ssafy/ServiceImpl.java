package edu.ssafy;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceImpl implements IService {

	@Override
	public ArrayList<edu.ssafy.Calc> calc(int a, int b) {
		// TODO Auto-generated method stub
		
		ArrayList<Calc> data = new ArrayList<>();
		
		data.add(new Calc(a, b, a+b));
		data.add(new Calc(a+1, b+1, a+b+2));
		data.add(new Calc(a+2, b+2, a+b+4));
		
		return data;
	}

}
