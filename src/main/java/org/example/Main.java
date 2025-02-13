package org.example;

import org.example.adapter.InputAdapter;
import org.example.command.CommandContext;
import org.example.command.CommandExecutor;
import org.example.config.Config;
import org.example.config.OutputConfig;
import org.example.input.Input;
import org.example.input.impl.ConsoleInput;
import org.example.input.impl.FileInput;
import org.example.parser.impl.CommandParser;

public class Main {
    public static void main(String[] args) {
        InputAdapter inputAdapter = new InputAdapter();
        Input input = new ConsoleInput();

        inputAdapter.adapt(new FileInput(Config.INPUT_FILE_PATH));

        CommandExecutor executor = new CommandExecutor(inputAdapter);

        while (OutputConfig.getInstance().isCommandListenFlag()) {
            try {
                String commandLine = input.getData().findFirst().orElse("");
                CommandContext context = new CommandParser().parse(commandLine);
                executor.execute(context);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}