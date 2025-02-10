package org.example.output.printer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Employee;
import org.example.model.Manager;
import org.example.output.format.Format;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public abstract class Printer {
    private List<Manager> managers;
    private List<Employee> employees;
    private Format outputFormat;

    public abstract void print(String str);
}
