package parser;

import parser.utils.*;

public class Parser {

	public String raw, trimmed;
	public CommandType commandType;

	public Parser(String line) {
		raw = line;
		trimmed = Utils.trimData(raw);
		commandType = isType(trimmed);
	}

	public enum CommandType {
		A_COMMAND, C_COMMAND, IGNORE_COMMAND, INVALID_COMMAND
	}

	public Parser.CommandType isType(String str) {
		if (Utils.isACommand(str)) {
			return Parser.CommandType.A_COMMAND;
		}
		if (Utils.isIgnoreCommand(str)) {
			return Parser.CommandType.IGNORE_COMMAND;
		}
		if (Utils.isCCommand(str)) {
			return Parser.CommandType.C_COMMAND;
		}

		return Parser.CommandType.INVALID_COMMAND;
	}
}
