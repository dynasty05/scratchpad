import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash {
  public void hashInput(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    System.out.println("Original input string: " + input);
    MessageDigest digest = MessageDigest.getInstance("MD5");
    byte[] inputBytes = input.getBytes(StandardCharsets.ISO_8859_1.name());

    System.out.println("Byte array back to input string: " + new String(inputBytes, StandardCharsets.ISO_8859_1.name()));

    digest.update(inputBytes);


    byte[] hashedDigest = digest.digest();
    String hash = new String(hashedDigest, StandardCharsets.ISO_8859_1.name());
    System.out.println("Hash of " + input + " :" + hash);


  }

}
