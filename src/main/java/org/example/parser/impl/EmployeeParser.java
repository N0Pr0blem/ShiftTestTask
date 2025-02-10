package org.example.parser.impl;

import org.apache.commons.lang3.math.NumberUtils;
import org.example.model.Employee;
import org.example.parser.Parser;

public class EmployeeParser implements Parser<Employee> {

    private final int EMPLOYEE_FIELD_COUNT = 4;
    private int id, managerId;
    private String name;
    private double salary;

    @Override
    public Employee parse(String line) {
        String[] fields = line.trim().split(",");

        if (!fields[0].trim().equalsIgnoreCase("Employee") || fields.length != EMPLOYEE_FIELD_COUNT + 1) {
            throw new IllegalArgumentException("Wrong format for Employee: " + line);
        }

        if(validFields(fields)){
            return new Employee(id,name,salary,managerId);
        }
        else {
            throw new IllegalArgumentException("Wrong data for Employee: " + line);
        }
    }

    private boolean validFields(String[] fields) {
        if(NumberUtils.isCreatable(fields[1].trim())
                && NumberUtils.isDigits(fields[3].trim())
                && NumberUtils.isCreatable(fields[4].trim())
        ) {
            id = Integer.parseInt(fields[1].trim());
            name = fields[2].trim();
            salary = Double.parseDouble(fields[3].trim());
            managerId = Integer.parseInt(fields[4].trim());

            return true;
        }
        else {
            return false;
        }
    }
}
