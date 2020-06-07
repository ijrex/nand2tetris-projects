package instruction;

public class AInstruction implements Instruction {

  public String instruction;

  public AInstruction(String input) {
    instruction = input;
  }

  public int decode() {
    String data = instruction.substring(1);
    int dataInt = Integer.parseInt(data);
    if (dataInt < 0) {
      throw new IllegalArgumentException("A Register doesn't support negative numbers");
    }
    return dataInt;
  }

  public String toBinary() {
    int val = this.decode();
    String bin = Integer.toBinaryString(val);
    bin = String.format("%16s", bin).replace(" ", "0");
    return bin;
  }

}