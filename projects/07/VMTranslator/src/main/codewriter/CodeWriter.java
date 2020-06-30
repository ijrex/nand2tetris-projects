package codewriter;

import codewriter.util.*;
import codewriter.memorymap.*;
import codewriter.stack.*;

public class CodeWriter {

  Stack stack = new Stack(MemoryMap.STACK.value);

  public CodeWriter() {

  }

  public String writePushPop(String[] input) {
    switch (input[0]) {
      case "constant":
        stack.push(input[1]);
      default:
        break;
    }
    return "T0D0";
  }

  public String writeArtithmetic(String[] input) {
    // private CommandType type;
    // private String location, value;

    // type = commandType;
    // location = Util.parseVal(input, 0);
    // value = Util.parseVal(input, 1);
    return "T0D0";
  }
}