public class Data 
{
	public static int Day;
	public static int Month;
	public static int Year;
	
	public Data(int day, int month, int year)
	{
		Day = day;
		Month = month;
		Year = year;
	}
	
	public static int GetDay() 
	{
		return Day;
	}
	
	public static int GetMonth() 
	{
		return Month;
	}
	
	public static int GetYear() 
	{
		return Year;
	}
	
	public static void SetDay(int newDay)
	{
		Day = newDay;
	}
	
	public static void SetMonth(int newMonth)
	{
		Month = newMonth;
	}
	
	public static void SetYear(int newYear)
	{
		Year = newYear;
	}
	
	public static void Display()
	{
		System.out.printf("%d.%d.%d", Day, Month, Year);
	}
	
	public static void SetDate(int newDay, int newMonth, int newYear)
	{
		Day = newDay;
		Month = newMonth;
		Year = newYear;
	}
	
	public static boolean IsYearLeap (int year)
	{
		if(year%4 == 0)
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean IsDateCorrect (int day, int month, int year)
	{
		switch(month)
		{
		case 1:
			if(day > 31)
			{
				return false;
			}
			return true;			
		case 2:
			if(year%4 == 0)
			{
				if(day > 29)
				{
					return false;
				}
			}
			else if(day > 28)
			{
				return false;
			}
			return true;			
		case 3:
			if(day > 31)
			{
				return false;
			}
			return true;	
		case 4:
			if(day > 30)
			{
				return false;
			}
			return true;	
		case 5:
			if(day > 31)
			{
				return false;
			}
			return true;	
		case 6:
			if(day > 30)
			{
				return false;
			}
			return true;	
		case 7:
			if(day > 31)
			{
				return false;
			}
			return true;	
		case 8:
			if(day > 31)
			{
				return false;
			}
			return true;	
		case 9:
			if(day > 30)
			{
				return false;
			}
			return true;	
		case 10:
			if(day > 31)
			{
				return false;
			}
			return true;	
		case 11:
			if(day > 30)
			{
				return false;
			}
			return true;	
		case 12:
			if(day > 31)
			{
				return false;
			}
			return true;	
		default:
			return false;
		}		
	}
	
	public static int HowManyDaysInMonth(int month, int year)
	{		
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
		{
			return 31;
		}
		else if(month == 2)
		{
			if(year%4 == 0)
			{
				return 29;
			}
			
			return 28;
		}
		else
		{
			return 30;
		}
	}
	
	public static int DayOfYear(int day, int month, int year)
	{
		int res = 0;
	
		if(month > 1)
		{
			for(int i = 1; i <= month; i++)
			{
				res += HowManyDaysInMonth(month, year);				
			}
			
			res += day;
		}
		else
		{
			return day;
		}
		
		return res;
	}
	
	public static int CompareDate(Data date1, Data date2)
	{
		if(date1.Year < date2.Year)
		{
			return -1;
		}
		else if(date1.Year > date2.Year)
		{
			return 1;
		}
		else
		{
			if(date1.Month < date2.Month)
			{
				return -1;
			}
			else if(date1.Month > date2.Month)
			{
				return 1;
			}
			else
			{
				if(date1.Day < date2.Day)
				{
					return -1;
				}
				else if(date1.Day > date2.Day)
				{
					return 1;
				}
				
				return 0;
			}
		}		
	}
}