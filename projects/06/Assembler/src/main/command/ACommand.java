package command;

public class ACommand implements Command {

  public int val;

  public ACommand(String input) {
    val = decode(input);
  }

  public ACommand(int input) {
    val = input;
  }

  static int decode(String input) {
    String raw = input.replace("@", "");
    int parsed = Integer.parseInt(raw);
    return parsed;
  }

  public String toBinary() {
    String bin = Integer.toBinaryString(val);
    bin = String.format("%16s", bin).replace(" ", "0");
    return bin;
  }

}