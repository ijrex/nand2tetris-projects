package parser.util;

public class Util {

  public static Boolean isPushCommand(String str) {
    return str.matches("push");
  }

  public static Boolean isIgnoreCommand(String str) {
    return str.length() == 0;
  }

  public static String[] splitArgs(String str) {
    str = trimExcess(str);
    if (str.length() > 0)
      return str.split(" ");

    return null;
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