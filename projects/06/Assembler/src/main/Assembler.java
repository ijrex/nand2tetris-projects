import symbol_table.*;
import loadfile.*;
import java.io.File;

class Assembler {

	public static void main(String[] args) {

		try {

			LoadFile file = new LoadFile(args[0]);
			File sourceFile = file.getFile();

			SymbolTable symbols = new SymbolTable();

			FilePassInitial.main(symbols, sourceFile);
			FilePassWrite.main(symbols, sourceFile);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR: Pass an .asm file as an argument to parse");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
