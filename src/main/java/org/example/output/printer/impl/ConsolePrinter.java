package org.example.output.printer.impl;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Employee;
import org.example.model.Manager;
import org.example.output.format.Format;
import org.example.output.printer.Printer;

import java.util.List;

@Getter
@Setter
public class ConsolePrinter extends Printer {

    public ConsolePrinter(List<Manager> managers, List<Employee> employees, Format outputFormat) {
        super(managers, employees, outputFormat);
    }

    @Override
    public void print(String str) {
        System.out.println(getOutputFormat().format(getEmployees(),getManagers()));
    }
}
