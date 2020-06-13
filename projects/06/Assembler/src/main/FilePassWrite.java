// *** FilePassWrite ***
//
// - Re-scans over .asm file, Parses A and C commands then translates to binary
// - Fetches previously stored symbols and returns value to be parsed as binary
// - Assigns available memory address for symbols to the Symbol Table 

import parser.*;
import command.*;
import symbol_table.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import util.*;

class FilePassWrite {

  static void main(SymbolTable symbols, File readFile) {

    int lineNumber = 1;
    try {
      Scanner fileScanner = new Scanner(readFile);

      String outputFile = Util.outputFilePath(readFile);
      FileWriter fileWriter = new FileWriter(outputFile, false);

      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();

        Parser input = new Parser(line);
        String command = input.trimmed;

        Parser.CommandType type = input.commandType;

        switch (type) {
          case A_COMMAND:
            ACommand a = new ACommand(command);
            fileWriter.write(a.toBinary() + "\n");
            break;
          case C_COMMAND:
            CCommand c = new CCommand(command);
            fileWriter.write(c.toBinary() + "\n");
            break;
          case SYMBOL:
            int symbolVal = symbols.handleVar(command);
            ACommand val = new ACommand(symbolVal);
            fileWriter.write(val.toBinary() + "\n");
            break;
          default:
            break;
        }
        lineNumber++;
      }
      fileScanner.close();
      fileWriter.close();

      System.out.println("SUCCESS: Hack file written to: ");
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