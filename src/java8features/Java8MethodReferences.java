package java8features;

import java.util.Arrays;

// Illustrates the use of method references in Java 8
// Method references are concise alternatives to lambda expressions in which there is ONLY ONE call
// to an already existing method.
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
    String [] names = {"Ayomide", "Olamide", "Monisola"};
    // A constructor is a special method, so it can be referenced by a method reference.
    // This construct can be used for both a no argument and a parameterised constructor,
    // depending the context that applies on the lambda.
    // E.g. Map each name string to a User object using a mapping function

    Arrays.stream(names)
          .map(name -> new User());

    /* Instead of
    Arrays.stream(names)
          .map(name -> new User(name));*/

    // This method reference works for the parameterised constructor, not the no argument one.
    Arrays.stream(names)
          .map(User::new);
  }

  public void useMethodReferenceInPlaceOfStaticMethodCallInLambdaFunction() {
    // Suppose there is a static method isRealUser(String) in UserValidation
    String [] names = {"Ayomide", "Olamide", "Monisola"};
    /* Instead of
    Arrays.stream(names)
          .anyMatch(name -> UserValidation.isRealUser(name));
    */

    Arrays.stream(names)
          .anyMatch(UserValidation::isRealUser);
  }

  public void useMethodReferenceInPlaceOfAnObjectsInstanceMethodInLambdaFunction() {
    // E.g on the stream of Strings, call java8features.UserValidation's boolean method to check for the ones
    // that are admins
    String [] names = {"Ayomide", "Olamide", "Monisola"};
    UserValidation userValidation = new UserValidation();

    /* Instead of
    Arrays.stream(names)
          .anyMatch(name -> userValidation.isAdmin(name));
   */

    Arrays.stream(names)
          .anyMatch(userValidation::isAdmin);
  }

}
