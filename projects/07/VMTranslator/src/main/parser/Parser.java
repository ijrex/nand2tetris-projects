package parser;

import parser.util.*;

public class Parser {

	public String raw, trimmed;
	public CommandType commandType;

	public Parser(String line) {
		raw = line;
		trimmed = Util.trimExcess(raw);
		commandType = isType(trimmed);
	}

	public enum CommandType {
		C_ARITHMETIC, C_PUSH, C_POP, C_LABEL, C_GOTO, C_IF, C_FUNCTION, C_RETURN, C_CALL, IGNORE_COMMAND, INVALID_COMMAND
	}

	public Parser.CommandType isType(String str) {
		// TODO: RETURN CORRECT COMMAND TYPE
		// TODO: RETURN COMMAND ARGS
		if (Util.isIgnoreCommand(str)) {
			return Parser.CommandType.IGNORE_COMMAND;
		}
		return Parser.CommandType.INVALID_COMMAND;
	}
}
