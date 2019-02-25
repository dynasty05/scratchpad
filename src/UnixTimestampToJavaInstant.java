import java.time.Instant;
import java.time.LocalDate;

public class UnixTimestampToJavaInstant {

  public void convertToInstant() {
    Instant now = Instant.now();
    System.out.println("Instant Now to Unix timestamp: " + Instant.now().toEpochMilli());

    long mandrillUnixTimestamp = 1549629372;
    Instant mandrillInstant = Instant.ofEpochMilli(1549901990000L);
    System.out.println("Unix timestamp to Instant: " + mandrillInstant);
    System.out.println("Above Instant is automatically displayed as a formatted date");
  }

}
