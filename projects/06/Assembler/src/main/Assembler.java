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

		SymbolTable symbols = new SymbolTable();

		try {
			File readFile = new File("example.asm");
			Scanner fileScanner = new Scanner(readFile);
			int counter = 0;

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();

				Parser input = new Parser(line);

				Parser.CommandType type = input.commandType;

				switch (type) {
					case A_COMMAND:
						counter = counter + 1;
						break;
					case C_COMMAND:
						counter = counter + 1;
						break;
					case SYMBOL:
						counter = counter + 1;
						break;
					case PSUEDO_COMMAND:
						symbols.put(input.trimmed, counter);
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
						AInstruction a = new AInstruction(input.trimmed);
						fileWriter.write(a.toBinary() + "\n");
						break;
					case C_COMMAND:
						CInstruction c = new CInstruction(input.trimmed);
						fileWriter.write(c.toBinary() + "\n");
						break;
					case SYMBOL:
						int symbolVal = symbols.handleVar(input.trimmed);
						AInstruction val = new AInstruction(symbolVal);
						fileWriter.write(val.toBinary() + "\n");
						break;
					case INVALID_COMMAND:
						throw new IllegalArgumentException("\"" + input + "\" is not a valid command");
					default:
						break;
				}

			}
			fileScanner.close();
			fileWriter.close();
		} catch (

		FileNotFoundException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
}
