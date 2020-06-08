package symbol_table;

import java.util.HashMap;

public class SymbolTable {

  public HashMap<String, Integer> symbols = new HashMap<String, Integer>();

  public void put(String val, int location) {
    symbols.put(trim(val), location);
  }

  String trim(String input) {
    return input.replaceAll("[()@]", "");
  }

}