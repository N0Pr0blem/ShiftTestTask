package org.example.command.impl;

import org.example.adapter.InputAdapter;
import org.example.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SortCommandTest {
    private InputAdapter inputAdapter;
    private List<Employee> employees;
    private SortCommand sortCommand;

    @BeforeEach
    void setup() {
        employees = new ArrayList<>(List.of(
                new Employee(1, "First", 2.1, 1),
                new Employee(2, "Second", 1.1, 1)
        ));
        inputAdapter = mock(InputAdapter.class);
        when(inputAdapter.getEmployees()).thenReturn(employees);
    }

    @Test
    void sortCommandByValidNameWithAscendingTrue() {
        sortCommand = new SortCommand(inputAdapter, "name", true);

        sortCommand.execute();

        assertEquals("First", employees.get(0).getName());
    }

    @Test
    void sortCommandByValidNameWithAscendingFalse() {
        sortCommand = new SortCommand(inputAdapter, "name", false);

        sortCommand.execute();

        assertEquals("Second", employees.get(0).getName());
    }

    @Test
    void sortCommandByNotValidName() {
        sortCommand = new SortCommand(inputAdapter, "test", true);

        assertThrows(IllegalArgumentException.class, () -> sortCommand.execute());
    }

    @Test
    void sortCommandBySalaryWithAscendingTrue() {
        sortCommand = new SortCommand(inputAdapter, "salary", true);

        sortCommand.execute();

        assertEquals(1.1, employees.get(0).getSalary());
    }

    @Test
    void sortCommandBySalaryWithAscendingFalse() {
        sortCommand = new SortCommand(inputAdapter, "salary", false);

        sortCommand.execute();

        assertEquals(2.1, employees.get(0).getSalary());
    }

    @Test
    void sortCommandByNull() {
        sortCommand = new SortCommand(inputAdapter, null, false);

        sortCommand.execute();

        assertEquals(1, employees.get(0).getId());
    }

}