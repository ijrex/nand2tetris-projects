package instruction;

public class AInstruction implements Instruction {

  public int val;

  public AInstruction(String input) {
    val = decode(input);
  }

  public AInstruction(int input) {
    val = input;
  }

  static int decode(String input) {
    String data = input.replace("@", "");
    int dataInt = Integer.parseInt(data);
    if (dataInt < 0) {
      throw new IllegalArgumentException("A Register doesn't support negative numbers");
    }
    return dataInt;
  }

  public String toBinary() {
    String bin = Integer.toBinaryString(val);
    bin = String.format("%16s", bin).replace(" ", "0");
    return bin;
  }

}