package codewriter.util;

public class Util {
  public static String parseVal(String[] str, int num) {
    if (str != null) {
      if (str.length > num) {
        return str[num];
      }
    }
    return null;
  }
}