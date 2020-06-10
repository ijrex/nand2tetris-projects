package parser;

import parser.util.*;

public class Parser {

	public String raw, trimmed;
	public CommandType commandType;

	public Parser(String line) {
		raw = line;
		trimmed = Util.trimData(raw);
		commandType = isType(trimmed);
	}

	public enum CommandType {
		A_COMMAND, C_COMMAND, SYMBOL, PSUEDO_COMMAND, IGNORE_COMMAND, INVALID_COMMAND
	}

	public Parser.CommandType isType(String str) {
		if (Util.isACommand(str)) {
			return Parser.CommandType.A_COMMAND;
		}
		if (Util.isPsuedoCommand(str)) {
			return Parser.CommandType.PSUEDO_COMMAND;
		}
		if (Util.isSymbol(str)) {
			return Parser.CommandType.SYMBOL;
		}
		if (Util.isIgnoreCommand(str)) {
			return Parser.CommandType.IGNORE_COMMAND;
		}
		if (Util.isCCommand(str)) {
			return Parser.CommandType.C_COMMAND;
		}

		return Parser.CommandType.INVALID_COMMAND;
	}
}
