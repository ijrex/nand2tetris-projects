package util;

import java.io.File;

public class Util {
  public static String getPrunedName(File file) {
    String fileName = file.getName();
    return fileName.substring(0, fileName.lastIndexOf("."));
  }
}