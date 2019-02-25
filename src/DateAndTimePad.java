import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimePad {

  public String getMonthInWords(String dateString) throws ParseException {
    SimpleDateFormat expectedInputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date inputDate = expectedInputDateFormat.parse(dateString);
    SimpleDateFormat longMonthFormat = new SimpleDateFormat("dd MMMM yyyy");
    return longMonthFormat.format(inputDate).split(" ")[1];
  }

  public String getCalendarDay(String inputDayString) throws ParseException {
    SimpleDateFormat expectedInputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date inputDate = expectedInputDateFormat.parse(inputDayString);
    SimpleDateFormat longMonthFormat = new SimpleDateFormat("d MMMM yyyy");
    return longMonthFormat.format(inputDate).split(" ")[0];
  }
}
