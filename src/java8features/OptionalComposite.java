package java8features;

import java.util.Optional;

public class OptionalComposite {
  private String name;
  private int age;
  private String password;

  public OptionalComposite(String name, int age, String password) {
    this.name = name;
    this.age = age;
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public Optional<Integer> getAge() {
    return Optional.of(age);
  }

  public Optional<String> getName() {
    return Optional.of(name);
  }
}
