package edu.ssafy;

import java.util.ArrayList;

public class CalcServiceImpl implements IService{

	@Override
	public ArrayList<Calc> calc(int op1, int op2) {
		// TODO Auto-generated method stub
		
		
		//algorithm code here
		ArrayList<Calc> data = new ArrayList<>();
		data.add(new Calc(op1, op2, op1+op2));
		data.add(new Calc(op1+1, op2+1, op1+op2+2));
		data.add(new Calc(op1+2, op2+2, op1+op2+4));
		
		return data;
	}

}
