package org.example.command.impl;

import org.example.command.Command;
import org.example.config.OutputConfig;
import org.example.output.printer.Printer;

public class OutputCommand implements Command {
    private Printer printer;

    public OutputCommand(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void execute() {
        OutputConfig.getInstance().setPrinter(printer);
    }
}
