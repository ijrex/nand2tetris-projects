import symbol_table.*;

import java.io.File;

class Assembler {

	public static void main(String[] args) {

		File readFile = new File("example.asm");

		SymbolTable symbols = new SymbolTable();

		FilePassInitial.main(symbols, readFile);
		FilePassWrite.main(symbols, readFile);
	}
}
