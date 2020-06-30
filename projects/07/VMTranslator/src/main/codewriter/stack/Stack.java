package codewriter.stack;

import java.util.LinkedHashMap;

public class Stack extends LinkedHashMap<Integer, String> {
  int stackPointer;

  public Stack(int base) {
    stackPointer = base;
  }

  public void push(String val) {
    this.put(stackPointer, val);
    stackPointer++;
  }
}