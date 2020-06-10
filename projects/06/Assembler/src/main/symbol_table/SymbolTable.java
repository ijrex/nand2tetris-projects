package symbol_table;

import java.util.HashMap;

import symbol_table.util.*;

public class SymbolTable {

  static int currentUserVarMax;

  public static HashMap<String, Integer> table = new HashMap<String, Integer>();

  final static int USER_VARIABLE_START_ADDRESS = 0x0010;

  public SymbolTable() {
    this.loadConstants();
    currentUserVarMax = USER_VARIABLE_START_ADDRESS;
  }

  int incrementUserVarAddress() {
    return currentUserVarMax++;
  }

  public void put(String val, int location) {
    table.put(Util.trim(val), location);
  }

  public int handleVar(String val) {
    String trimmedVal = Util.trim(val);

    if (table.containsKey(trimmedVal)) {
      return table.get(trimmedVal);
    }
    int memoryAddress = incrementUserVarAddress();
    table.put(trimmedVal, memoryAddress);
    return memoryAddress;
  }

  void loadConstants() {
    HashMap<String, Integer> predefined = new HashMap<String, Integer>();

    predefined.put("SP", 0x0000);
    predefined.put("LCL", 0x0001);
    predefined.put("ARG", 0x0002);
    predefined.put("THIS", 0x0003);
    predefined.put("THAT", 0x0004);
    predefined.put("SCREEN", 0x4000);
    predefined.put("KBD", 0x6000);
    predefined.put("R0", 0x0000);
    predefined.put("R1", 0x0001);
    predefined.put("R2", 0x0002);
    predefined.put("R3", 0x0003);
    predefined.put("R4", 0x0004);
    predefined.put("R5", 0x0005);
    predefined.put("R6", 0x0006);
    predefined.put("R7", 0x0007);
    predefined.put("R8", 0x0008);
    predefined.put("R9", 0x0009);
    predefined.put("R10", 0x000A);
    predefined.put("R11", 0x000B);
    predefined.put("R12", 0x000C);
    predefined.put("R13", 0x000D);
    predefined.put("R14", 0x000E);
    predefined.put("R15", 0x000F);

    table.putAll(predefined);
  }

}