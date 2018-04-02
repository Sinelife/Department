package main;

public class Test {

	public static void main(String[] args)
	{
		String s = getCurrentDate();
		System.out.println(s);
	}

	
	
	public static String getCurrentDate()
	{
		java.util.Date date = new java.util.Date();
		String result = "";
		String day = String.valueOf(date.getDate());
		String year = String.valueOf(date.getYear() + 1900);
		String month = "";
		String s = String.valueOf(date.getMonth() + 1);
		if((Integer.valueOf(s)) < 10)
		{
			String s1 = "0";
			month = s1.concat(s);
		}
		else
		{
			month = s;
		} 
		result = year.concat("-").concat(month).concat("-").concat(day);
		return result;
	}
}
