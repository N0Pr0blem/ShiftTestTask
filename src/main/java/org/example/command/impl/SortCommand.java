package org.example.command.impl;

import org.example.command.Command;
import org.example.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SortCommand implements Command {

    private List<Employee> employees;
    private final String sortBy;
    private final boolean ascending;

    private static final Map<String, Comparator<Employee>> COMPARATORS = Map.of(
            "name", Comparator.comparing(Employee::getName),
            "salary", Comparator.comparingDouble(Employee::getSalary)
    );


    public SortCommand(List<Employee> employees, String sortBy, boolean ascending) {
        this.employees = employees;
        this.sortBy = sortBy;
        this.ascending = ascending;
    }

    @Override
    public void execute() {
        Comparator<Employee> comparator = COMPARATORS.getOrDefault(sortBy.toLowerCase(), null);

        if (comparator == null) {
            throw new IllegalArgumentException("Wrong field name");
        }
        if (!ascending) {
            comparator = comparator.reversed();
        }

        employees.sort(comparator);
    }
}
