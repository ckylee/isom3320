import java.util.*;

public class CalendarEx {
  public static void main(String[] args) {
    GregorianCalendar cal = new GregorianCalendar();
    int year = cal.get(GregorianCalendar.YEAR);
    int month = cal.get(GregorianCalendar.MONTH);
    int day = cal.get(GregorianCalendar.DAY_OF_MONTH);
    System.out.println("Current: " + year + " " + month + " " + day);
    
    cal.setTimeInMillis(1234567898765L);
    year = cal.get(GregorianCalendar.YEAR);
    month = cal.get(GregorianCalendar.MONTH);
    day = cal.get(GregorianCalendar.DAY_OF_MONTH);
    System.out.println("setTimeInMillis: " + year + " " + month + " " + day);
  }
}