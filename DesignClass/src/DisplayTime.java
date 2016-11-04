import java.util.*;


public class DisplayTime {
	public static void main(String[] args){
		Time time1 = new Time();
		Time time2 = new Time(555550000);
		System.out.println("time now:");
		System.out.println("The hour is "+time1.getHour());
		System.out.println("The minute is "+time1.getMinute());
		System.out.println("The second is "+time1.getSecond());
		System.out.print("\n555550000s after midnight:\n");
		System.out.println("The hour is "+time2.getHour());
		System.out.println("The minute is "+time2.getMinute());
		System.out.println("The second is "+time2.getSecond());
	}
}

class Time{
	int hour;
	int minute;
	int second;
	
	Time(){
		Calendar calendar =new GregorianCalendar();
		this.hour=calendar.get(Calendar.HOUR_OF_DAY);
		this.minute=calendar.get(Calendar.MINUTE);
		this.second=calendar.get(Calendar.SECOND);
	}
	
	Time(int s){
		s=s/1000;
		this.hour=s/3600%24;
		this.minute=s%3600/60;
		this.second=s%60;
	}
	
	int getHour(){
		return this.hour;
	}
	
	int getMinute(){
		return this.minute;
	}
	
	int getSecond(){
		return this.second;
	}
	
	
}