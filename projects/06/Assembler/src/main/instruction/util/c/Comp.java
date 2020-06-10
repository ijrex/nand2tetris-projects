package instruction.util.c;

public class Comp {

  public static String parse(String input) {

    String comp = "000000";
    char M = '0';

    if (input.contains("M")) {
      input = input.replace("M", "A");
      M = '1';
    }

    String sortInput = input;

    String compAD = "D[+|&]A";
    String compAplusD = "1[+|&][AD]";

    if (input.matches(compAD) || input.matches(compAplusD)) {
      char[] vals = input.toCharArray();
      sortInput = "" + vals[2] + vals[1] + vals[0];
    }

    switch (sortInput) {
      case "0":
        comp = "101010";
        break;
      case "1":
        comp = "111111";
        break;
      case "-1":
        comp = "111010";
        break;
      case "D":
        comp = "001100";
        break;
      case "A":
        comp = "110000";
        break;
      case "!D":
        comp = "001101";
        break;
      case "!A":
        comp = "110001";
        break;
      case "-D":
        comp = "001111";
        break;
      case "-A":
        comp = "110011";
        break;
      case "D+1":
        comp = "011111";
        break;
      case "A+1":
        comp = "110111";
        break;
      case "D-1":
        comp = "001110";
        break;
      case "A-1":
        comp = "110010";
        break;
      case "A+D":
        comp = "000010";
        break;
      case "D-A":
        comp = "010011";
        break;
      case "A-D":
        comp = "000111";
        break;
      case "A&D":
        comp = "000000";
        break;
      case "A|D":
        comp = "010101";
        break;
      default:
        throw new IllegalArgumentException("\"" + input + "\" is not a valid comp command");
    }

    return M + comp;
  }
}