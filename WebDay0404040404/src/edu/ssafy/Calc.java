package edu.ssafy;

public class Calc {
	int aaa;
	int bbb;
	int sum;
	
	public Calc() {
		
	}
	
	public Calc(int aaa, int bbb, int sum) {
		super();
		this.aaa = aaa;
		this.bbb = bbb;
		this.sum = sum;
	}
	public int getAaa() {
		return aaa;
	}
	public void setAaa(int aaa) {
		this.aaa = aaa;
	}
	public int getBbb() {
		return bbb;
	}
	public void setBbb(int bbb) {
		this.bbb = bbb;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "Calc [aaa=" + aaa + ", bbb=" + bbb + ", sum=" + sum + "]";
	}
	
	
}
