package org.example.output.format.impl;

import org.example.model.Employee;
import org.example.model.Manager;
import org.example.output.format.Formater;

import java.util.List;

public class BaseFormater implements Formater {
    @Override
    public String format(List<Employee> employees, List<Manager> managers, List<String> wrongLines) {
        return "";
    }
}
