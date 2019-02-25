import java.net.MalformedURLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        /*String inputDayString = "29()/01/2019";
        DateAndTimePad dateAndTimePad = new DateAndTimePad();
        String month = dateAndTimePad.getMonthInWords(inputDayString);
        System.out.println(month);
        String day = dateAndTimePad.getCalendarDay(inputDayString);
        System.out.println(day); */

        /*ExtractOTP extractor = new ExtractOTP();
        System.out.println("OTP: " + extractor.extract());*/

        /*UnixTimestampToJavaInstant converter = new UnixTimestampToJavaInstant();
        converter.convertToInstant();*/

        /*MandrillURL url = new MandrillURL();
        try {
            url.isValidUrl();
            System.out.println("Valid URL");
        } catch (MalformedURLException m){
            System.out.println("Bad URL");
            m.printStackTrace();
        }*/

        Java8Optionals j8opt = new Java8Optionals();
        j8opt.playWithEmptyOptionals();
        j8opt.playWithNonNullableOptionals();
        j8opt.playWithNullableOptionals();
        j8opt.checkIfOptionalHasAValue();
        j8opt.doSomethingIfValuePresentInOptional();
        j8opt.setDefaultValueForAnOptionalWithOrElse();

    }
}
