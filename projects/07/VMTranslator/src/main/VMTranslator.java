import loadfile.*;
import java.io.File;

class VMAssembler {

	public static void main(String[] args) {

		try {

			LoadFile file = new LoadFile("SimpleAdd.vm");
			File sourceFile = file.getFile();

			FilePass.main(sourceFile);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR: Pass a .vm file as an argument to parse");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
