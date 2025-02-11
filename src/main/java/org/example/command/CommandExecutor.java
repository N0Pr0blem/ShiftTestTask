package org.example.command;

import org.example.command.impl.OutputCommand;
import org.example.command.impl.SortCommand;
import org.example.config.Config;
import org.example.model.Employee;
import org.example.output.printer.Printer;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CommandExecutor {

    private final List<Employee> employees;
    private final Printer printer = new Config().getOutputSours();

    private final Map<String, Function<CommandContext, Command>> commandFactory = Map.of(
            "sort", this::createSortCommand,
            "output", this::createOutputCommand
    );

    public CommandExecutor(List<Employee> employees) {
        this.employees = employees;
    }

    private Command createSortCommand(CommandContext context) {
        String sortBy = context.getArg("field");
        boolean ascending = !context.getArg("order").equalsIgnoreCase("ask");

        return new SortCommand(employees, sortBy, ascending);
    }

    private Command createOutputCommand(CommandContext context) {
        String type = context.getArg("type");

        if (type.equalsIgnoreCase("console")) {
            return new OutputCommand();
        } else if (type.equalsIgnoreCase("file")) {
            String path = context.getArg("path");
            if (path == null) {
                throw new IllegalArgumentException("output=file must have path");
            } else {
                return new OutputCommand();
            }
        }
        else{
            throw new IllegalArgumentException("Wrong command style for output");
        }
    }

}
