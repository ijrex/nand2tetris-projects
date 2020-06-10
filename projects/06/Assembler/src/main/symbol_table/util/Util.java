package symbol_table.util;

public class Util {
  public static String trim(String input) {
    return input.replaceAll("[()@]", "");
  }
}