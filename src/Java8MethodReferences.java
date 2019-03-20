import java.util.Arrays;

// Illustrates the use of method references in Java 8
public class Java8MethodReferences {

  public void useMethodReferenceInPlaceOfATypesInstanceMethodInLambdaFunction() {
    // Concise way of calling instance method of an object with a known type
    // E.g get length of a String object being made as the only call in a lambda method
    String [] names = {"Ayomide", "Olamide", "Monisola"};

    /* Instead of
    Arrays.stream(names)
        .forEach(name -> name.length()); */

    Arrays.stream(names)
          .forEach(String::length); // More concisely

  }

  public void useMethodReferenceInPlaceOfConstructorCreationInLamdbaFunction() {

  }

  public void useMethodReferenceInPlaceOfStaticMethodCallInLambdaFunction() {

  }

  public void useMethodReferenceInPlaceOfAnObjectsInstanceMethodInLambdaFunction() {

  }

}
