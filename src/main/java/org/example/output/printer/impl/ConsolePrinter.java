package org.example.output.printer.impl;

import org.example.output.printer.Printer;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String str) {
        System.out.println(str);
    }
}
