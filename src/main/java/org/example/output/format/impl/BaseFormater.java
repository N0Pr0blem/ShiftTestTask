package org.example.output.format.impl;

import org.example.model.Employee;
import org.example.model.Manager;
import org.example.output.format.Formater;

import java.util.Comparator;
import java.util.List;

public class BaseFormater implements Formater {
    @Override
    public String format(List<Employee> employees, List<Manager> managers, List<String> wrongLines) {
        StringBuilder result = new StringBuilder();

        managers.sort(Comparator.comparing(Manager::getDepartmentName));

        managers.forEach(manager -> {
            int amount;
            double salary = 0;
            result.append(manager.getDepartmentName()).append("\n");
            List<Employee> filterList = employees.stream()
                    .filter(employee -> employee.getManagerId() == manager.getId())
                    .toList();
            amount = filterList.size();
            for(Employee employee : filterList){
                salary+= employee.getSalary();
                result.append(employee).append("\n");
            }
            result.append(amount).append(", ").append(String.format("%.2f",amount/salary)).append("\n");
        });

        return result.toString();
    }
}
