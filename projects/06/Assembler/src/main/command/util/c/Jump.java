package command.util.c;

public class Jump {

  public static String parse(String input) {
    String jump = "000";

    if (input == null)
      input = "null";

    switch (input) {
      case "JGT":
        jump = "001";
        break;
      case "JEQ":
        jump = "010";
        break;
      case "JGE":
        jump = "011";
        break;
      case "JLT":
        jump = "100";
        break;
      case "JNE":
        jump = "101";
        break;
      case "JLE":
        jump = "110";
        break;
      case "JMP":
        jump = "111";
        break;
      case "null":
        jump = "000";
        break;
      default:
        throw new IllegalArgumentException("\"" + input + "\" is not a valid jump command");
    }

    return jump;
  }
}