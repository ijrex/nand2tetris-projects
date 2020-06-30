package parser;

import java.util.Arrays;
import commandtype.*;

import parser.util.*;

public class Parser {

	private String[] args;

	public Parser(String input) {
		args = Util.splitArgs(input);
	}

	public String[] getArgs() {
		if (args != null) {
			return Arrays.copyOfRange(args, 1, args.length);
		}
		return null;
	}

	public CommandType getType() {
		if (args == null) {
			return CommandType.IGNORE_COMMAND;
		}

		switch (args[0]) {
			case "push":
				return CommandType.C_PUSH;
			case "add":
				return CommandType.C_ARITHMETIC;
		}

		return CommandType.INVALID_COMMAND;
	}
}
