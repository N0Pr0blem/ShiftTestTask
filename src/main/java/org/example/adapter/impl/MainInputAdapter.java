package org.example.adapter.impl;

import lombok.Getter;
import org.example.adapter.MainAdapter;
import org.example.input.Input;
import org.example.model.Employee;
import org.example.model.Manager;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MainInputAdapter implements MainAdapter {

    private List<Employee> employees;
    private List<Manager> managers;
    private List<String> wrongLines;

    public MainInputAdapter() {
        employees = new ArrayList<>();
        managers = new ArrayList<>();
        wrongLines = new ArrayList<>();
    }

    @Override
    public void adapt(Input input) {
        input.getData()
                .forEach(this::redirectPerson);
    }

    private void redirectPerson(String person) {

    }

}
