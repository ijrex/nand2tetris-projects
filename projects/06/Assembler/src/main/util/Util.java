package util;

import java.io.File;

public class Util {
  private static String getPrunedPath(File file) {
    String fileName = file.getAbsolutePath();
    return fileName.substring(0, fileName.lastIndexOf("."));
  }

  public static String outputFilePath(File file) {
    String filePath = getPrunedPath(file);

    return filePath + ".hack";
  }
}