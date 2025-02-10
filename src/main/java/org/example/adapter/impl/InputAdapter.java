package org.example.adapter.impl;

import lombok.Getter;
import org.example.adapter.Adapter;
import org.example.input.Input;
import org.example.model.Employee;
import org.example.model.Manager;
import org.example.parser.impl.EmployeeParser;
import org.example.parser.impl.ManagerParser;

import java.util.ArrayList;
import java.util.List;

public class InputAdapter implements Adapter {

    @Getter
    private List<Employee> employees = new ArrayList<>();

    @Getter
    private List<Manager> managers = new ArrayList<>();

    @Getter
    private List<String> wrongLines = new ArrayList<>();

    private EmployeeParser employeeParser = new EmployeeParser();
    private ManagerParser managerParser = new ManagerParser();

    @Override
    public void adapt(Input input) {
        input.getData()
                .forEach(this::redirectPerson);
    }

    private void redirectPerson(String person) {
        try {
            if (person.trim().startsWith("E") || person.trim().startsWith("e")) {
                employees.add(employeeParser.parse(person));
            } else if (person.trim().startsWith("M") || person.trim().startsWith("m")) {
                managers.add(managerParser.parse(person));
            } else{
                throw new IllegalArgumentException("Wrong object type");
            }
        } catch (IllegalArgumentException e) {
            wrongLines.add(person);
        }
    }

}
