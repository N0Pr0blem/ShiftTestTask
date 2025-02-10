package org.example.output.printer.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Employee;
import org.example.model.Manager;
import org.example.output.format.Format;
import org.example.output.printer.Printer;

import java.util.List;

public class FilePrinter extends Printer {

    @Getter
    @Setter
    private Format outputFormat;

    @Getter
    private String path;

    public FilePrinter(List<Manager> managers, List<Employee> employees, Format outputFormat, String path) {
        super(managers, employees, outputFormat);
        this.path = path;
    }

    @Override
    public void print(String str) {

    }
}
