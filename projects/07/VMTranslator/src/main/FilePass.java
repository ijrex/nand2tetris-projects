// *** FilePassWrite ***
//
// - Re-scans over .asm file, Parses A and C commands then translates to binary
// - Fetches previously stored symbols and returns value to be parsed as binary
// - Assigns available memory address for symbols to the Symbol Table 

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import util.*;

import parser.*;
import codewriter.*;
import commandtype.CommandType;

class FilePass {

  static void main(File readFile) {

    int lineNumber = 1;

    try {
      Scanner fileScanner = new Scanner(readFile);

      String outputFile = Util.outputFilePath(readFile);
      FileWriter fileWriter = new FileWriter(outputFile, false);

      CodeWriter codeWriter = new CodeWriter();

      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();

        Parser command = new Parser(line);

        CommandType type = command.getType();

        switch (type) {
          case C_PUSH:
            codeWriter.writePushPop(command.getArgs());
            break;
          case C_ARITHMETIC:
            codeWriter.writeArtithmetic(command.getArgs());
            break;

          default:
            break;

        }

        lineNumber++;
      }

      fileScanner.close();
      fileWriter.close();

      System.out.println(outputFile);

    } catch (IllegalArgumentException e) {
      System.out.println("ERROR ON LINE " + lineNumber);
      e.printStackTrace();
      System.exit(1);
    } catch (IOException e) {
      System.out.println("An error occured.");
      System.exit(1);
      e.printStackTrace();
    }
  }
}