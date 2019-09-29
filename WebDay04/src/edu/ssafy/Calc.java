package edu.ssafy;

public class Calc {
	int op1;
	int op2;
	int sum;
	
	public Calc() { };
	public Calc(int op1, int op2, int sum) {
		this.op1 = op1;
		this.op2 = op2;
		this.sum = sum;
	}
	
	public void setOp1(int op1) {
		this.op1 = op1;
	}
	
	public int getOp1() {
		return op1;
	}
	
	public void setOp2(int op2) {
		this.op2 = op2;
	}
	
	public int getOp2() {
		return op2;
	}
	
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public int getSum() {
		return sum;
	}
	@Override
	public String toString() {
		return "Calc [op1=" + op1 + ", op2=" + op2 + ", sum=" + sum + "]";
	}
	
	
}
