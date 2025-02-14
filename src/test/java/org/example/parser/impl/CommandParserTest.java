package org.example.parser.impl;

import org.example.command.CommandContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandParserTest {
    private CommandParser commandParser;
    private CommandContext commandContext;

    @BeforeEach
    void setup() {
        commandParser = new CommandParser();
    }

    @Test
    void validateLinesOfSortCommand() {
        List<String> validCommandLines = List.of(
                "--sort=name --order=ask",
                "--sort = name --order = desc",
                " -s=salary --order=ask",
                "-s =   salary      --order = desc",
                "-s",
                "--sort"
        );

        for (String line : validCommandLines) {
            commandContext = commandParser.parse(line);
            assertEquals("sort", commandContext.getCommand());
        }
    }

    @Test
    void invalidLinesOfSortCommand() {
        List<String> invalidCommandLines = List.of(
                "--sort=name --order=high",
                " -s=salary order=ask",
                " --order=ask",
                "-s =   salary     "
        );

        for (String line : invalidCommandLines) {
            assertThrows(IllegalArgumentException.class, () -> commandParser.parse(line));
        }
    }

    @Test
    void validateLinesOfOutputCommand() {
        List<String> validCommandLines = List.of(
                "--output=console",
                "--output = file --path = output",
                " -o=console   ",
                "-o =   file      --path = output"
        );

        for (String line : validCommandLines) {
            commandContext = commandParser.parse(line);
            assertEquals("output", commandContext.getCommand());
        }
    }

    @Test
    void invalidLinesOfOutputCommand() {
        List<String> invalidCommandLines = List.of(
                "--output=telegram",
                "-output = console --path = output",
                " -o   ",
                "-o =   file      --path"
        );

        for (String line : invalidCommandLines) {
            assertThrows(IllegalArgumentException.class, () -> commandParser.parse(line));
        }
    }

    @Test
    void validateLinesOfExitCommand() {
        List<String> validCommandLines = List.of(
                "--exit",
                "-e"
        );

        for (String line : validCommandLines) {
            commandContext = commandParser.parse(line);
            assertEquals("exit", commandContext.getCommand());
        }
    }

    @Test
    void invalidCommand() {
        List<String> invalidCommandLines = List.of(
                "--push",
                "-p"
        );

        for (String line : invalidCommandLines) {
            assertThrows(IllegalArgumentException.class, () ->
                    commandContext = commandParser.parse(line));
        }
    }
}