package org.example.command.impl;

import org.example.adapter.InputAdapter;
import org.example.command.Command;
import org.example.config.OutputConfig;
import org.example.output.printer.Printer;

public class PrintCommand implements Command {

    private final InputAdapter inputAdapter;
    private final Printer printer;

    public PrintCommand(InputAdapter inputAdapter, Printer printer) {
        this.inputAdapter = inputAdapter;
        this.printer = printer;
    }

    @Override
    public void execute() {
        String outputLine = OutputConfig.getInstance().getFormater().format(inputAdapter);
        printer.print(outputLine);
    }
}
