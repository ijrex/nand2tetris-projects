package instruction;

import instruction.utils.*;

public class CInstruction implements Instruction {

  public String instruction;

  public CInstruction(String input) {
    instruction = input;
  }

  public String[] decode() {
    String dest, comp, jump;
    dest = comp = jump = null;

    int equalPos = instruction.indexOf('=');
    int colonPos = instruction.indexOf(';');

    if (equalPos >= 0) {
      dest = instruction.substring(0, equalPos);
      comp = instruction.substring(equalPos + 1, instruction.length());
    }

    if (colonPos >= 0) {
      jump = instruction.substring(colonPos + 1, instruction.length());
      comp = instruction.substring(0, colonPos);
    }

    String[] command = { dest, comp, jump };
    return command;
  }

  public String toBinary() {
    String[] arg = this.decode();

    String dest = arg[0];
    String comp = arg[1];
    String jump = arg[2];

    String ddd = Dest.parse(dest);
    String ccccccc = Comp.parse(comp);
    String jjj = Jump.parse(jump);

    return "111" + ccccccc + ddd + jjj;

  }
}