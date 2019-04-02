import java.text.ParseException;
import java8features.Java8MethodReferences;
import java8features.Java8StaticAndDefaultInterfaceMethods;

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

        /*MaximumFromList maximumFromList = new MaximumFromList();
        System.out.println(maximumFromList.getMaxFromOneItemList());*/


        /*java8features.Java8Optionals j8opt = new java8features.Java8Optionals();
        j8opt.playWithEmptyOptionals();
        j8opt.playWithNonNullableOptionals();
        j8opt.playWithNullableOptionals();
        j8opt.checkIfOptionalHasAValue();
        j8opt.doSomethingIfValuePresentInOptional();
        marker();
        j8opt.setDefaultValueForAnOptionalWithOrElse();
        marker();
        j8opt.setDefaultValueForAnOptionalWithOrElseGet();
        marker();
        j8opt.playWithOrElseThrow();
        marker();
        j8opt.playWithGet();
        marker();
        j8opt.chooseDesiredValuesUsingOptionalFilter();
        marker();
        j8opt.transformOptionalValueWithMap();
        marker();
        j8opt.transformNestedOptionalValuesWithFlatMap();*/

        Java8StaticAndDefaultInterfaceMethods j8InterfaceMethods = new Java8StaticAndDefaultInterfaceMethods();
        j8InterfaceMethods.aboutInterfaceDefaultMethods();
        j8InterfaceMethods.aboutInterfaceStaticMethods();

        Java8MethodReferences java8MethodReferences = new Java8MethodReferences();
        java8MethodReferences.useMethodReferenceInPlaceOfATypesInstanceMethodInLambdaFunction();
        marker();
    }

    public static void marker(){
        System.out.println("***************************************************");
    }
}
