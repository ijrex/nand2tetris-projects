package parser.utils;

public class Utils {

  public static String trimData(String str) {
    if (str.length() > 0) {
      int comment = str.indexOf("//");
      if (comment >= 0) {
        str = str.substring(0, comment);
      }
    }
    str = str.trim();
    return str;
  }

  public static Boolean isACommand(String str) {
    if (str.length() > 0) {
      char prefix = str.charAt(0);
      if (prefix == '@') {
        return true;
      }
    }
    return false;
  }

  public static Boolean isCCommand(String str) {
    if (str.length() > 0) {
      int equals = str.indexOf('=');
      int colon = str.indexOf(';');

      if (equals >= 0 ^ colon >= 0) {
        return true;
      }
    }
    return false;
  }

  public static Boolean isIgnoreCommand(String str) {
    if (str.length() == 0) {
      return true;
    }
    return false;
  }
}