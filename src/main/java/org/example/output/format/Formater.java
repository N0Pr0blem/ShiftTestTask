package org.example.output.format;

import org.example.model.Employee;
import org.example.model.Manager;

import java.util.List;

public interface Formater {
    String format(List<Employee> employees, List<Manager> managers, List<String> wrongLines);
}
