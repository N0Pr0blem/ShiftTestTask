package org.example.output.printer.impl;

import lombok.Getter;
import org.example.output.printer.Printer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FilePrinter implements Printer {

    @Getter
    private String path;

    public FilePrinter(String path) {
        this.path = path;
    }

    @Override
    public void print(String str) {
        try {
            Files.writeString(Path.of(path), str + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Wrong file path: " + path);
        }
    }
}
