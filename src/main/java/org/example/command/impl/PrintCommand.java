package org.example.command.impl;

import org.example.adapter.InputAdapter;
import org.example.command.Command;
import org.example.config.OutputConfig;
import org.example.output.printer.Printer;

public class PrintCommand implements Command {

    private InputAdapter inputAdapter;
    private Printer printer;

    public PrintCommand(InputAdapter inputAdapter, Printer printer) {
        this.inputAdapter = inputAdapter;
    }

    @Override
    public void execute() {
        String outputLine = OutputConfig.getInstance().getFormater().format(inputAdapter);
        printer.print(outputLine);
    }
}
