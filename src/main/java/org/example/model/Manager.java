package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    private int id;
    private String name;
    private double salary;
    private String departmentName;

    @Override
    public String toString() {
        return "Manager, " + id +
                ", " + name +
                ", " + salary +
                ", " + departmentName;
    }
}
