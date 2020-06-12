package loadfile;

import java.io.File;

public class LoadFile {

  File sourceFile;
  String fileName;

  public LoadFile(String arg) {
    this.load(arg);
  }

  private void load(String arg) {
    try {
      sourceFile = new File(System.getProperty("user.dir"), arg);
      String extention = getFileExtension(sourceFile);

      if (!extention.matches("asm")) {
        throw new IllegalArgumentException();
      }

    } catch (IllegalArgumentException e) {
      System.out.println("ERROR: Pass an .asm file as an argument to parse");
      e.printStackTrace();
      System.exit(1);
    }
  }

  public File getFile() {
    return this.sourceFile;
  }

  private static String getFileExtension(File file) {
    String fileName = file.getName();
    if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
      return fileName.substring(fileName.lastIndexOf(".") + 1);
    else
      return "";
  }
}