package org.example.config;

import lombok.Getter;
import lombok.Setter;
import org.example.output.format.Formater;
import org.example.output.format.impl.BaseFormater;
import org.example.output.printer.Printer;
import org.example.output.printer.impl.ConsolePrinter;

@Setter
@Getter
public class OutputConfig {
    private static final OutputConfig INSTANCE = new OutputConfig();

    private Printer printer = new ConsolePrinter();
    private Formater formater = new BaseFormater();
    private boolean commandListenFlag = true;

    private OutputConfig() {
    }

    public static OutputConfig getInstance() {
        return INSTANCE;
    }

}
