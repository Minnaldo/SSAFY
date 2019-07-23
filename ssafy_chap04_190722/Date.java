package ssafy_chap04_190722;

public class Date {
	private int year;
	private int month;
	private int day;
	private String s;
	
	/* 데이터에는 private - 마음대로 open XX ,
	 * 기능(메소드)에는 public 
	 */
	
	public void setYear(int year)
	{
		if(year >= 2100 || year < 1900)
		{
			System.out.println("입력하신 년도는 범위를 벗어납니다.");
		}
		else
		{
			this.year = year;
		}
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setMonth(int month)
	{
		if(month > 0 && month <= 12)
			this.month = month;
		else
			System.out.println("입력하신 월은 범위를 벗어납니다.");
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public void setDay(int day)
	{
		
		this.day = day;
	}
	
	public int getDay()
	{
		return day;
	}
	
	
	public Date() {}
	
	public Date(int year, int month, int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String info()
	{
		return this.year+","+month+","+day;
	}
}
