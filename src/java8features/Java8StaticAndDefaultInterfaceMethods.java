package java8features;

public class Java8StaticAndDefaultInterfaceMethods {

  public void aboutInterfaceStaticMethods() {
    StringBuilder message = new StringBuilder();
    message.append("Interface static methods are added to interfaces to propagate behaviour that "
                   + "implementing classes should not be able to override.");
    System.out.println(message);
  }

  public void aboutInterfaceDefaultMethods() {
    StringBuilder message = new StringBuilder();
    message.append("Interface default methods are added to interfaces to propagate behaviour that "
                  + "implementing classes can override.");
  }

}
