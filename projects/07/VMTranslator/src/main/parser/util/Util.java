package parser.util;

public class Util {

  public static Boolean isIgnoreCommand(String str) {
    if (str.length() == 0) {
      return true;
    }
    return false;
  }

  public static String trimExcess(String str) {
    if (str.length() > 0) {
      int comment = str.indexOf("//");
      if (comment >= 0) {
        str = str.substring(0, comment);
      }
    }
    str = str.trim();
    return str;
  }
}