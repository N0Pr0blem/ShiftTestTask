package org.example.command.impl;

import org.example.config.OutputConfig;
import org.example.output.printer.Printer;
import org.example.output.printer.impl.ConsolePrinter;
import org.example.output.printer.impl.FilePrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.mock;

class OutputCommandTest {

    private OutputConfig outputConfig;

    @BeforeEach
    void setup() {
        outputConfig = OutputConfig.getInstance();
    }

    @Test
    void outputTestCommandExpectedConsolePrinter(){
        Printer consolePrinter = new ConsolePrinter();

        OutputCommand outputCommand = new OutputCommand(consolePrinter);
        outputCommand.execute();

        assertInstanceOf(ConsolePrinter.class, outputConfig.getPrinter());
    }

    @Test
    void outputTestCommandExpectedFilePrinter(){
        Printer filePrinter = mock(FilePrinter.class);

        OutputCommand outputCommand = new OutputCommand(filePrinter);
        outputCommand.execute();

        assertInstanceOf(FilePrinter.class, outputConfig.getPrinter());
    }

}