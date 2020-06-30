package codewriter.memorymap;

public enum MemoryMap {
  STACK(256);

  public final int value;

  private MemoryMap(int value) {
    this.value = value;
  }
}