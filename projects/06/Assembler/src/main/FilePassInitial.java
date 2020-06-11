// *** FilePassInitial ***
//
// - Scans over .asm file, checking for psuedo commands i.e. `(LOOP)`
// - ROM address for psuedo commands gets saved to Symbol Table

import parser.*;
import symbol_table.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FilePassInitial {
  static void main(SymbolTable symbols, File readFile) {

    int lineNumber = 1;

    try {
      Scanner fileScanner = new Scanner(readFile);
      int counter = 0;

      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();

        Parser input = new Parser(line);
        String command = input.trimmed;

        Parser.CommandType type = input.commandType;

        switch (type) {
          case A_COMMAND:
          case C_COMMAND:
          case SYMBOL:
            counter++;
            break;
          case PSUEDO_COMMAND:
            symbols.put(command, counter);
            break;
          case INVALID_COMMAND:
            throw new IllegalArgumentException("Unable to parse command \"" + command + "\"");
          default:
            break;
        }
        lineNumber++;
      }

      fileScanner.close();
    } catch (IllegalArgumentException e) {
      System.out.println("ERROR ON LINE " + lineNumber);
      e.printStackTrace();
      System.exit(1);
    } catch (FileNotFoundException e) {
      System.out.println("An error occured.");
      e.printStackTrace();
    }
  }
}