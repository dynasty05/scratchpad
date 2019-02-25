import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractOTP {

  public String extract(){
//    Please enter the following code to sign your prescription:\n+([0-9]+\-[0-9]+\-[0-9]+)\n+
//    .*sign your prescription:[^*]*\*([^*]*)\*.*
    String regexForSingleLineMatches = "[0-9]+-[0-9]+-[0-9]+";
    Pattern patternForSingleLineMatches = Pattern.compile(regexForSingleLineMatches);
    String otp = "";

    String messageContent = "Hi BC-GP ClinicalServices, \n"
        + "\n"
        + "Please enter the following code to sign your prescription:\n"
        + "\n"
        + "1287-5603-6346\n"
        + "\n"
        + "\n"
        + "Wishing you the best of health,\n"
        + "The Babylon team";

    String[] tokens = messageContent.split("\\n");
    for (String line:tokens) {
      Matcher matcher = patternForSingleLineMatches.matcher(line);
      if (matcher.matches()){
        otp = matcher.group();
        System.out.println("Matched entire line using matches(): " + otp);
      }
    }

    String regexForSubsequenceMatching = ".*Please enter the following code to sign your prescription:\\s*([\\d]+-[\\d]+-[\\d]+)\\s*.*";
    Pattern patternForSubsequenceMatching = Pattern.compile(regexForSubsequenceMatching);
    Matcher matcherForSubsequenceMatching = patternForSubsequenceMatching.matcher(messageContent);
    if (matcherForSubsequenceMatching.find()){
      otp = matcherForSubsequenceMatching.group(1);
      System.out.println("Matched some subsequence of entire string using find(): " + otp);
    }

    String regexForSubsequencePrefixMatching = ".*Please enter the following code to sign your prescription:\\s*([\\d]+-[\\d]+-[\\d]+)\\s*.*";
    Pattern patternForSubsequencePrefixMatching = Pattern.compile(regexForSubsequencePrefixMatching);
    Matcher matcherForSubsequencePrefixMatching = patternForSubsequencePrefixMatching.matcher(messageContent);
    if (matcherForSubsequenceMatching.lookingAt()){
      otp = matcherForSubsequencePrefixMatching.group(1);
      System.out.println("Matched a prefix of the entire string using lookingAt()" + otp);
    }

      return otp;
  }

}
