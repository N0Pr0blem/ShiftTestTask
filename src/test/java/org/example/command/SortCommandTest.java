package org.example.command;

import org.example.adapter.InputAdapter;
import org.example.command.impl.SortCommand;
import org.example.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class SortCommandTest {

    @Mock
    private InputAdapter inputAdapter = new InputAdapter();

    private List<Employee> employees;
    SortCommand sortCommand;

    @BeforeEach
    void setup() {
        employees = new ArrayList<>(List.of(
                new Employee(1, "First", 2.1, 1),
                new Employee(2, "Second", 1.1, 1)
        ));

        when(inputAdapter.getEmployees()).thenReturn(employees);
    }

    @Test
    void sortCommandByValidNameWithAscendingTrue() {
        sortCommand = new SortCommand(inputAdapter, "name", true);

        sortCommand.execute();

        assertEquals("First", employees.getFirst().getName());
    }

    @Test
    void sortCommandByValidNameWithAscendingFalse() {
        sortCommand = new SortCommand(inputAdapter, "name", false);

        sortCommand.execute();

        assertEquals("Second", employees.getFirst().getName());
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

        assertEquals(1.1, employees.getFirst().getSalary());
    }

    @Test
    void sortCommandBySalaryWithAscendingFalse() {
        sortCommand = new SortCommand(inputAdapter, "salary", false);

        sortCommand.execute();

        assertEquals(2.1, employees.getFirst().getSalary());
    }

}