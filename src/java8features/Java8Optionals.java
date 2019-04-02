package java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
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

  public void checkIfOptionalHasAValue() {
    Optional<String> optional1 = Optional.ofNullable("Some value");
    Optional<String> optional2 = Optional.of("Some other value");
    Optional<String> optional3 = Optional.empty();

    System.out.println("Does optional1 hold a value? " + optional1.isPresent());
    System.out.println("Does optional2 hold a value? " + optional2.isPresent());
    System.out.println("Does optional3 hold a value? " + optional3.isPresent());
  }

  public void doSomethingIfValuePresentInOptional() {
    Optional<String> optional1 = Optional.empty();
    Optional<String> optional2 = Optional.ofNullable("Something");

    // The first statement will not be executed since the value is null
    optional1.ifPresent(
        optionalValue -> System.out.println("The value in this Optional is " + optionalValue));
    optional2.ifPresent(
        optionalValue -> System.out.println("The value in this Optional is " + optionalValue));
  }

  public void setDefaultValueForAnOptionalWithOrElse() {
    // Note: Unlike, orelseget(), whether the optional has a value or not, the object specified in orelse() is always created.
    // Note: If null literal is used directly in the ofNullable call, the line below returns a class cast exception
    // because the method expects a String type. Null can be assigned to any type. See below
    // String value = (String) Optional.ofNullable(null).orElse("Some Default Value");
    String creationValue = null;
    String returnedValue = Optional.ofNullable(creationValue).orElse("SomeDefaultValue");

    System.out.println("The value returned from this optional is " + returnedValue);
  }

  public void setDefaultValueForAnOptionalWithOrElseGet() {
    // Note: The object in orelseget() is not created if the optional is empty
    // OrElseGet uses a Supplier to return the default value
    String creationValue = null;
    String returnedValue = Optional.ofNullable(creationValue).orElseGet(() -> "Some Default Value from a Supplier");
    System.out.println("The value returned for this optional is from the Supplier " + returnedValue);
  }

  public void playWithOrElseThrow() {
    // Note: This throws an exception if the optional is empty, instead of returning a default value
    String someValue = "Something";
    String returnedValue = Optional.ofNullable(someValue).orElseThrow(IllegalArgumentException::new);
    System.out.println("Value returned from orElseThrow: " + returnedValue);

    String nullValue = null;
//    returnedValue = Optional.ofNullable(nullValue).orElseThrow(() -> new IllegalArgumentException());
  }

  public void playWithGet() {
    // Get returns the wrapped value and a NoSuchElementException if empty. Using this goes against
    // the purpose of having optionals, which is to avoid getting exceptions when using values. With
    // optionals, we want to anticipate the border cases and provide for them, or explicitly throw
    // our own exceptions using orElseThrow.
    // Optionals help us to better program defensively.
    String value = Optional.of("Ribake").get();
    System.out.println("Value of non empty optional using get() " + value);

    try {
      String value2 = (String)Optional.ofNullable(null).get();
      System.out.println("Value of empty optional using get() " + value2);
    } catch (NoSuchElementException nse) {
      nse.printStackTrace();
      System.out.println("NoSuchElementException thrown as expected");
    }

  }

  public void chooseDesiredValuesUsingOptionalFilter() {
    // filter() is used to check if a data value matches a predicate, and return an Optional wrapping
    // that value if it matches. If not, an empty Optional is returned.
    // Example below filters number objects between 10 and 15
    Integer[] numbers = {Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(15), Integer.valueOf(13),
                         Integer.valueOf(10), null, Integer.valueOf(6), null, Integer.valueOf(8)};

    List<Integer> numbersWithinRange = new ArrayList<>();

    //POINT: Use a Collection when access to data and management of data is the goal, and use Stream
    //       when computation on the contents of a data source is the goal.
    Arrays.stream(numbers).forEach(n -> {
      Optional<Integer> filteredOptional = Optional.ofNullable(n).filter(i -> i >= 10 && i <= 15);
      if(filteredOptional.isPresent()){
        numbersWithinRange.add(filteredOptional.get());
      }
    });

//    for (Integer i : numbers) {
//      Optional<Integer> filteredOptional = Optional.ofNullable(i).filter(n -> n >= 10 && n <= 15);
//      if(filteredOptional.isPresent()) {
//        numbersWithinRange.add(filteredOptional.get());
//      }
//    }

    System.out.println("The amount of numbers between 10 and 15: " + numbersWithinRange.size());
  }

  public void transformOptionalValueWithMap() {
    // Mapping generally means performing a computation on a value to return another value.
    // In the context of an optional, it is performing a computation on the value wrapped inside
    // that optional, to produce another optional wrapping the result of the computation.
    // In the context of a stream, map() performs the computation on every element in the stream,
    // producing another stream of the computed results.
    // A mapping is generally done using a mapping function, one that conforms to the
    // `Function` functional interface.

    // EXERCISE: A password is valid if it is at least 8 characters in length.
    // Use Optional map() and other Optional api's to check if a given password is valid.

    String longPassword = "somePasswordLongerThanEightCharacters";
    String shortPassword = "shrtPwd";

    Optional<String> passwordOptional = Optional.of(longPassword);
    // Below mapping function returns an integer, so returned optional is an optional of Integer
    Optional<Integer> passwordLengthOptional = passwordOptional.map((pwd) -> pwd.length());
    // passwordOptional.map(String::length); Alternative to above

    // The Optional returned from the mapping can further be harnessed using Optional api's to more
    // elegantly obtain desired result.

    // Using Optional get()
    if(passwordLengthOptional.get() >= 8){
      System.out.println("Password is valid.");
    }
    // Using Optional filter() to achieve the same thing
    //    if(passwordLengthOptional.filter(l -> l>=8).isPresent()){
    //      System.out.println("Password is valid");
    //    }

    // Now, validate the above two passwords, combining the above techniques.
    String[] passwords = {longPassword, shortPassword};
    Arrays.stream(passwords)
          .forEach(password -> {
            if(Optional.of(password).map(String::length).filter(l -> l>=8).isPresent()){
              System.out.println(String.format("Password %s is valid", password));
            } else{
              System.out.println(String.format("Password %s is not valid", password));
            }
          });
  }

  public void transformNestedOptionalValuesWithFlatMap() {
    // Similar to map(), flatMap() performs a computation on an Optional, but flatMap() does not
    // wrap the result of the computation in an Optional. The mapping function MUST be one that returns
    // an Optional.

    Optional<OptionalComposite> nestedOptional = Optional.of(new OptionalComposite("Ribake",
        30, "powerfulpasswprd"));
    // whereas map nestedOptional.map(java8features.OptionalComposite::getName); would give an Optional<Optional<String>>
    Optional<String> nameOptional = nestedOptional.flatMap(OptionalComposite::getName);
    //Note:nestedOptional.flatMap(java8features.OptionalComposite::getPassword) will not work as the function does not return an Optional
    Optional<Integer> ageOptional = nestedOptional.flatMap(OptionalComposite::getAge);

    System.out.println("Flat mapped name: " + nameOptional.orElse("???"));
    System.out.println("Flat mapped age: " + ageOptional.orElse(0));

  }
}
