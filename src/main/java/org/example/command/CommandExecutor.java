package org.example.command;

import org.example.adapter.InputAdapter;
import org.example.command.impl.ExitCommand;
import org.example.command.impl.OutputCommand;
import org.example.command.impl.SortCommand;
import org.example.output.printer.impl.ConsolePrinter;
import org.example.output.printer.impl.FilePrinter;

import java.util.Map;
import java.util.function.Function;

public class CommandExecutor {

    private final InputAdapter inputAdapter;

    private final Map<String, Function<CommandContext, Command>> commandFactory = Map.of(
            "sort", this::createSortCommand,
            "output", this::createOutputCommand,
            "exit", this::createExitCommand
    );

    public CommandExecutor(InputAdapter inputAdapter) {
        this.inputAdapter = inputAdapter;
    }

    public void execute(CommandContext context){
        Command command = commandFactory.getOrDefault(context.getCommand(),c->{
            throw  new IllegalArgumentException("No such command");
        }).apply(context);

        command.execute();
    }

    private Command createSortCommand(CommandContext context) {
        String sortBy = context.getArg("field");
        boolean ascending = false;

        if(context.getArg("order")!=null) {
            ascending = context.getArg("order").equalsIgnoreCase("ask");
        }
        return new SortCommand(inputAdapter, sortBy, ascending);
    }

    private Command createOutputCommand(CommandContext context) {
        String type = context.getArg("type");

        if (type.equalsIgnoreCase("console")) {
            return new OutputCommand(new ConsolePrinter());
        } else if (type.equalsIgnoreCase("file")) {
            String path = context.getArg("path");
            if (path == null) {
                throw new IllegalArgumentException("output=file must have path");
            } else {
                return new OutputCommand(new FilePrinter(path));
            }
        } else {
            throw new IllegalArgumentException("Wrong command style for output");
        }
    }

    private Command createExitCommand(CommandContext context) {
        return new ExitCommand();
    }

}
