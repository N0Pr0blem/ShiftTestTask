package org.example.command.impl;

import org.example.adapter.InputAdapter;
import org.example.command.Command;
import org.example.config.OutputConfig;
import org.example.model.Employee;
import org.example.model.Manager;

import java.util.Comparator;
import java.util.Map;

public class SortCommand implements Command {

    private final InputAdapter inputAdapter;
    private final String sortBy;
    private final boolean ascending;

    private static final Map<String, Comparator<Employee>> COMPARATORS = Map.of(
            "name", Comparator.comparing(Employee::getName),
            "salary", Comparator.comparingDouble(Employee::getSalary)
    );


    public SortCommand(InputAdapter inputAdapter, String sortBy, boolean ascending) {
        this.inputAdapter = inputAdapter;
        this.sortBy = sortBy;
        this.ascending = ascending;
    }

    @Override
    public void execute() {
        inputAdapter.getManagers().sort(Comparator.comparing(Manager::getDepartmentName));

        if (sortBy!=null) {
            Comparator<Employee> comparator = COMPARATORS.getOrDefault(sortBy.toLowerCase(), null);

            if (comparator == null) {
                throw new IllegalArgumentException("Wrong field name");
            }
            if (!ascending) {
                comparator = comparator.reversed();
            }

            inputAdapter.getEmployees().sort(comparator);
        }

        new PrintCommand(inputAdapter, OutputConfig.getInstance().getPrinter()).execute();

    }
}
