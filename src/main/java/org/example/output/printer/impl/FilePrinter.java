package org.example.output.printer.impl;

import lombok.Getter;
import org.example.output.printer.Printer;

public class FilePrinter implements Printer {

    @Getter
    private String path;

    public FilePrinter(String path) {
        this.path = path;
    }

    @Override
    public void print(String str) {

    }
}
