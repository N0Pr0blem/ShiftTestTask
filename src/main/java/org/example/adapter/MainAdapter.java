package org.example.adapter;

import org.example.model.Employee;
import org.example.model.Manager;

import java.util.List;

public interface MainAdapter {
    List<Employee> getEmployees();
    List<Manager> getManagers();
}
