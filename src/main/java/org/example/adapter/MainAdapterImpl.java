package org.example.adapter;

import org.example.dao.MainDao;
import org.example.model.Employee;
import org.example.model.Manager;

import java.util.List;

public class MainAdapterImpl implements MainAdapter{

    private MainDao mainDao;

    public MainAdapterImpl(MainDao mainDao) {
        this.mainDao = mainDao;
    }

    @Override
    public List<Employee> getEmployees() {
        return List.of();
    }

    @Override
    public List<Manager> getManagers() {
        return List.of();
    }
}
