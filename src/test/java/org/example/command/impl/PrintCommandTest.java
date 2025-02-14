package org.example.command.impl;

import org.example.adapter.InputAdapter;
import org.example.config.OutputConfig;
import org.example.output.format.Formater;
import org.example.output.format.impl.BaseFormater;
import org.example.output.printer.Printer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class PrintCommandTest {
    private InputAdapter inputAdapter;
    private Printer printer;
    private Formater<InputAdapter> formater;
    private PrintCommand printCommand;

    @BeforeEach
    void setup(){
        inputAdapter = mock(InputAdapter.class);
        printer = mock(Printer.class);
        formater = mock(BaseFormater.class);

        printCommand = new PrintCommand(inputAdapter,printer);
    }

    @Test
    void printTest(){
        OutputConfig outputConfig = mock(OutputConfig.class);
        when(outputConfig.getFormater()).thenReturn(formater);
        when(inputAdapter.getWrongLines()).thenReturn(List.of("test"));

        printCommand.execute();

        verify(printer).print("Некорректные данные:\ntest\n");

    }

}