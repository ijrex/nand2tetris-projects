package instruction.utils;

public class Dest {

  static Boolean illegalDestCommand(String input) {
    if (input.length() == 0) {
      return true;
    }

    Boolean invalidCharacters = input.matches(".*[^ADM].*");
    if (invalidCharacters) {
      return true;
    }

    Boolean duplicateCharacters = input.matches(".*(.)\\1{1,}.*");
    if (duplicateCharacters) {
      return true;
    }

    return false;

  }

  public static String parse(String input) {

    if (input == null) {
      return "000";
    }

    Boolean isIllegal = illegalDestCommand(input);
    if (isIllegal) {
      throw new IllegalArgumentException("\"" + input + "\" is not a valid dest command");
    }

    char A, D, M;
    A = M = D = '0';

    char[] args = input.toCharArray();
    for (char arg : args) {
      switch (arg) {
        case 'A':
          A = '1';
          break;
        case 'D':
          D = '1';
          break;
        case 'M':
          M = '1';
          break;
        default:
          throw new IllegalArgumentException("\"" + arg + "\" is not a valid dest command");
      }
    }

    String dest = "" + A + D + M;

    return dest;
  }
}