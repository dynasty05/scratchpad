import java.util.Optional;

public class Java8Optionals {

  public void playWithEmptyOptionals() {
    // The empty Optional represents an optional with nothing in it, effectively representing a null
    // but without actually having a null value
    Optional<String> emptyOptional = Optional.empty();
    System.out.println("Is value present in Optional? " + emptyOptional.isPresent());
  }

  public void playWithNonNullableOptionals() {
    // Use Optional.of to create optionals that should not have a null or an empty value
    Optional<String> nonEmptyOptional = Optional.of("Ribake");
    System.out.println("Non Empty Optional value: " + nonEmptyOptional.toString());
    // This throws a Null Pointer exception
//    System.out.println("Can I create an Optional.of with null? " + Optional.of(null));
  }

  public void playWithNullableOptionals() {
    Optional<String> nullableOptional = Optional.ofNullable(null);
    System.out.println("Nullable Optional with null value " + nullableOptional.toString());

    nullableOptional = Optional.ofNullable("'Ribake");
    System.out.println("Nullable Optional with a value " + nullableOptional.get());
  }

  public void checkIfOptionalHasAValue(){
    Optional<String> optional1 = Optional.ofNullable("Some value");
    Optional<String> optional2 = Optional.of("Some other value");
    Optional<String> optional3 = Optional.empty();

    System.out.println("Does optional1 hold a value? " + optional1.isPresent());
    System.out.println("Does optional2 hold a value? " + optional2.isPresent());
    System.out.println("Does optional3 hold a value? " + optional3.isPresent());
  }

  public void doSomethingIfValuePresentInOptional(){
    Optional<String> optional1 = Optional.empty();
    Optional<String> optional2 = Optional.ofNullable("Something");

    // The first statement will not be executed since the value is null
    optional1.ifPresent(optionalValue -> System.out.println("The value in this Optional is " + optionalValue));
    optional2.ifPresent(optionalValue -> System.out.println("The value in this Optional is " + optionalValue));
  }

  public void setDefaultValueForAnOptionalWithOrElse(){
    // If null is used directly in the ofNullable call, the line below returns a class cast exception
    // because the method expects a String type. Null can be assigned to any type. See below
//    String value = (String) Optional.ofNullable(null).orElse("Some Default Value");
    String creationValue = null;
    String returnedValue = Optional.ofNullable(creationValue).orElse("SomeDefaultValue");

    System.out.println("The value returned from this optional is " + returnedValue);
  }

}
