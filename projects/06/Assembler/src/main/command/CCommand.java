package command;

import command.util.c.*;

public class CCommand implements Command {

  public String command;

  public CCommand(String input) {
    command = input;
  }

  public String[] decode() {
    String dest, comp, jump;
    dest = comp = jump = null;

    int equalPos = command.indexOf('=');
    int colonPos = command.indexOf(';');

    if (equalPos >= 0) {
      dest = command.substring(0, equalPos);
      comp = command.substring(equalPos + 1, command.length());
    }

    if (colonPos >= 0) {
      jump = command.substring(colonPos + 1, command.length());
      comp = command.substring(0, colonPos);
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