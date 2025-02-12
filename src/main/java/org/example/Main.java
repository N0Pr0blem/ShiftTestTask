package org.example;

import org.example.adapter.impl.InputAdapter;
import org.example.command.CommandContext;
import org.example.command.CommandExecutor;
import org.example.config.Config;
import org.example.config.OutputConfig;
import org.example.input.Input;
import org.example.input.impl.ConsoleInput;
import org.example.input.impl.FileInput;
import org.example.model.Employee;
import org.example.model.Manager;
import org.example.output.format.Formater;
import org.example.output.format.impl.BaseFormater;
import org.example.output.printer.impl.FilePrinter;
import org.example.parser.impl.CommandParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputAdapter inputAdapter = new InputAdapter();
        Input input = new ConsoleInput();
        Formater formater = new BaseFormater();

        inputAdapter.adapt(new FileInput(Config.INPUT_FILE_PATH));

        List<Employee> employees = inputAdapter.getEmployees();
        List<Manager> managers = inputAdapter.getManagers();
        List<String> wrongLines = inputAdapter.getWrongLines();
        CommandExecutor executor = new CommandExecutor(employees);
        boolean flag = true;

        while (flag) {
            try {
                String commandLine = input.getData().findFirst().orElse("");
                CommandContext context = new CommandParser().parse(commandLine);
                executor.execute(context);

                String output = formater.format(employees, managers, wrongLines);

                OutputConfig.getInstance().getPrinter().print(output);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}