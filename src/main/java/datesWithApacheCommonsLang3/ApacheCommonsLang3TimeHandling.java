package datesWithApacheCommonsLang3;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;

public class ApacheCommonsLang3TimeHandling {
	public static void main(String[] args) {
		showDateUtils();
	}

	private static void showDateUtils() {
		System.out.println("showDateUtils methods");
		ceiling();
		isSameDay();
		isSameInstant();
		round();
		truncate();
		truncatedCompareTo();
		truncatedEquals();
	}

	
	private static void ceiling() {
		System.out.println("ceiling");
		Calendar cal = new GregorianCalendar(2000, 0, 3);
		showCalendar(cal);//2000 - 0 - 3
		System.out.println("ceiled to the Month field");
		Calendar ceiledCalendar = DateUtils.ceiling(cal, Calendar.MONTH);
		showCalendar(ceiledCalendar);//2000 - 1 - 1
	}

	private static void isSameDay() {
		System.out.println("isSameDay");
		Calendar cal1 = new GregorianCalendar(2000, Calendar.FEBRUARY, 1);
		Calendar cal2 = new GregorianCalendar(2000, Calendar.FEBRUARY, 2);
		System.out.println(DateUtils.isSameDay(cal1, cal2));//not same
		Calendar cal3 = new GregorianCalendar(2000, Calendar.FEBRUARY, 1, 23, 59, 59);
		System.out.println(DateUtils.isSameDay(cal1, cal3));//same
	}
	
	private static void isSameInstant() {
		System.out.println("isSameInstant");
		Calendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
		cal1.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
		Calendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
		cal2.set(2000, Calendar.JANUARY, 1, 1, 0, 0);
		System.out.println(DateUtils.isSameInstant(cal1, cal2));//different instant because different times in same timezone.
		
		cal2 = new GregorianCalendar(TimeZone.getTimeZone("Europe/Berlin"));
		cal2.set(2000, Calendar.JANUARY, 1, 1, 0, 0);
		System.out.println(DateUtils.isSameInstant(cal1, cal2));//same instant because 1 hour away from timezones that are 1 hour away.
	}
	
	private static void round() {
		System.out.println("round");
		Calendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
		cal1.set(2000, Calendar.JANUARY, 1, 23, 0, 0);
		Calendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
		cal2.set(2000, Calendar.JANUARY, 1, 1, 0, 0);
		Calendar dayRoundedCal1 = DateUtils.round(cal1, Calendar.DAY_OF_MONTH);
		Calendar dayRoundedCal2 = DateUtils.round(cal2, Calendar.DAY_OF_MONTH);
		showCalendar(dayRoundedCal1);//2000 - 0 - 2
		showCalendar(dayRoundedCal2);//2000 - 0 - 1
	}
	
	private static void truncate() {
		System.out.println("truncate");
		Calendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
		cal1.set(2000, Calendar.JANUARY, 1, 23, 0, 0);
		Calendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
		cal2.set(2000, Calendar.JANUARY, 1, 1, 0, 0);
		Calendar dayRoundedCal1 = DateUtils.truncate(cal1, Calendar.DAY_OF_MONTH);
		Calendar dayRoundedCal2 = DateUtils.truncate(cal2, Calendar.DAY_OF_MONTH);
		showCalendar(dayRoundedCal1);//2000 - 0 - 1
		showCalendar(dayRoundedCal2);//2000 - 0 - 1
	}

	private static void truncatedCompareTo() {
		System.out.println("truncatedCompareTo");
		Calendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
		cal1.set(2000, Calendar.JANUARY, 1, 23, 0, 0);
		Calendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
		cal2.set(2000, Calendar.JANUARY, 1, 1, 0, 0);
		System.out.println(DateUtils.truncatedCompareTo(cal1, cal2, Calendar.DAY_OF_MONTH));//0 (equal)
		System.out.println(DateUtils.truncatedCompareTo(cal1, cal2, Calendar.HOUR));//1 (cal1 > cal2)
	}

	private static void truncatedEquals() {
		System.out.println("truncatedEquals");
		Calendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
		cal1.set(2000, Calendar.JANUARY, 1, 23, 0, 0);
		Calendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
		cal2.set(2000, Calendar.JANUARY, 1, 1, 0, 0);
		System.out.println(DateUtils.truncatedEquals(cal1, cal2, Calendar.DAY_OF_MONTH));//true (equal)
		System.out.println(DateUtils.truncatedEquals(cal1, cal2, Calendar.HOUR));//false (cal1 != cal2)
	}
	
	private static void showCalendar(Calendar cal) {
		System.out.println(cal.get(Calendar.YEAR) +" - "+cal.get(Calendar.MONTH) +" - "+cal.get(Calendar.DAY_OF_MONTH));
	}
	
}
