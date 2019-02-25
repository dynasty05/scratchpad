import java.net.MalformedURLException;
import java.net.URL;

public class MandrillURL {

  public boolean isValidUrl() throws MalformedURLException {
    String searchUrlString = "https://mandrillapp.com/api/1.0/messages/search";
    URL searchUrl = new URL(searchUrlString);
    return true;
  }

}
