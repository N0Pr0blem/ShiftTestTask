package org.example.parser.impl;

import org.example.command.CommandContext;
import org.example.parser.Parser;

import java.util.regex.Matcher;

import static org.example.config.Config.OUTPUT_COMMAND_PATTERN;
import static org.example.config.Config.SORT_COMMAND_PATTERN;

public class CommandParser implements Parser<CommandContext> {
    private CommandContext context;

    @Override
    public CommandContext parse(String commandLine) {
        commandLine = commandLine.trim();

        Matcher sortCommandMatcher = SORT_COMMAND_PATTERN.matcher(commandLine);
        Matcher outputCommandMatcher = OUTPUT_COMMAND_PATTERN.matcher(commandLine);

        if (commandLine.isEmpty()) {
            throw new IllegalArgumentException("Wrong command");
        }

        if (sortCommandMatcher.matches()) {
            context = new CommandContext("sort");
            context.addArg("field", sortCommandMatcher.group(2));
            context.addArg("order", sortCommandMatcher.group(4));

            return context;
        }

        if (outputCommandMatcher.matches()) {
            context = new CommandContext("output");
            context.addArg("type", outputCommandMatcher.group(2));
            if (outputCommandMatcher.groupCount() >= 3 && outputCommandMatcher.group(3) != null) {
                context.addArg("path", outputCommandMatcher.group(3));
            }

            return context;
        }

        throw new IllegalArgumentException("Wrong command style");
    }
}
