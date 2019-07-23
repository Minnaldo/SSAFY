package ssafy_chap04_190722;

public class Calculator {
	
	/** 오버로드 */
	/** 메소드 오버로드 */
	
	int add(int a, int b)
	{
		return a+b;
	}
	
	float add(float a, int b)
	{
		return a + b;
	}
	
	float add(int a, float b)
	{
		return a + b;
	}
	
	int minus(int a, int b)
	{
		return a-b;
	}
}
