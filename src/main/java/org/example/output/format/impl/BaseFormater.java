package org.example.output.format.impl;

import org.example.adapter.InputAdapter;
import org.example.model.Employee;
import org.example.output.format.Formater;

import java.util.List;

public class BaseFormater implements Formater<InputAdapter> {
    @Override
    public String format(InputAdapter inputAdapter) {
        StringBuilder result = new StringBuilder();

        inputAdapter.getManagers().forEach(manager -> {
            int amount;
            double salary = 0;
            result.append(manager.getDepartmentName()).append("\n");
            result.append(manager).append("\n");
            salary += manager.getSalary();
            List<Employee> filterList = inputAdapter.getEmployees().stream()
                    .filter(employee -> employee.getManagerId() == manager.getId())
                    .toList();
            amount = filterList.size() + 1;
            for (Employee employee : filterList) {
                salary += employee.getSalary();
                result.append(employee).append("\n");
            }
            result.append(amount).append(", ").append(String.format("%.2f", salary / amount)).append("\n");
        });

        result.append("Некорректные данные:").append("\n");
        inputAdapter.getWrongLines().forEach(line -> {
            result.append(line).append("\n");
        });

        return result.toString();
    }
}
