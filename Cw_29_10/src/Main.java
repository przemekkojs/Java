
public class Main 
{
	public static void main(String[] args) 
	{		
		Data date1 = new Data(4, 3, 2003);
		Data date2 = new Data(13, 4, 2003);
		
		System.out.println(Data.CompareDate(date1, date2));
		System.out.println(Data.DayOfYear(4, 3, 2003));
		System.out.println(Data.HowManyDaysInMonth(2, 2020));
		System.out.println(Data.IsDateCorrect(40, 2, 201));
		System.out.println(Data.IsYearLeap(2020));
	}
}