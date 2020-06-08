import parser.*;
import instruction.*;
import symbol_table.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Assembler {

	public static void main(String[] args) {

		try {
			File readFile = new File("example.asm");
			Scanner fileScanner = new Scanner(readFile);
			SymbolTable symbols = new SymbolTable();
			int counter = 0;

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();

				Parser input = new Parser(line);

				Parser.CommandType type = input.commandType;

				switch (type) {
					case A_COMMAND:
						counter++;
						break;
					case C_COMMAND:
						counter++;
						break;
					case PSUEDO_COMMAND:
						symbols.put(input.trimmed, counter + 1);
						break;
					case INVALID_COMMAND:
						throw new IllegalArgumentException("\"" + input + "\" is not a valid command");
					default:
						break;
				}

			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}

		try {
			File readFile = new File("example.asm");
			FileWriter fileWriter = new FileWriter("example.hack", false);
			Scanner fileScanner = new Scanner(readFile);
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();

				Parser input = new Parser(line);

				Parser.CommandType type = input.commandType;

				switch (type) {
					case A_COMMAND:
						AInstruction A = new AInstruction(input.trimmed);
						fileWriter.write(A.toBinary() + "\n");
						break;
					case C_COMMAND:
						CInstruction C = new CInstruction(input.trimmed);
						fileWriter.write(C.toBinary() + "\n");
						break;
					case SYMBOL:
						// TODO:
						// -> CHECK IF SYMBOL EXISTS
						// -> IF IT DOES, GET MEMORY LOCATION FROM SYMBOLS TABLE
						// -> IF IT DOESN'T, CREATE SYMBOLE
						// CREATE A_COMMAND FROM VALUE AND PARSE BINARY
						System.out.println("L_COMMAND: " + input.trimmed);
						break;
					case INVALID_COMMAND:
						throw new IllegalArgumentException("\"" + input + "\" is not a valid command");
					default:
						break;
				}
			}
			fileScanner.close();
			fileWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
}
