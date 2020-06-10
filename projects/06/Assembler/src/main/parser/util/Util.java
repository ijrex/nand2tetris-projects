package parser.util;

public class Util {

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
      String regex = "@\\d+$";
      if (str.matches(regex)) {
        return true;
      }
    }
    return false;
  }

  public static Boolean isSymbol(String str) {
    if (str.length() > 0) {
      String regex = "@[^\\d][\\w_.$:]+";
      if (str.matches(regex)) {
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

  public static Boolean isPsuedoCommand(String str) {
    if (str.length() > 0) {
      boolean brackets = str.matches("\\([^\\d][\\w_.$:]+\\)");
      if (brackets) {
        return true;
      }
      ;
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