package org.example.parser.impl;

import org.example.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeParserTest {

    private EmployeeParser parser;

    @BeforeEach
    void setup(){
        parser = new EmployeeParser();
    }

    @Test
    void parseTestWithValidateLineExpectedEmployeeObject() {
        String str = "Employee,101,John Doe,3000,1";
        Employee employee = new Employee(101, "John Doe", 3000, 1);

        assertEquals(employee, parser.parse(str));
    }

    @Test
    void parseTestWithValidateLineAndSpaceExpectedEmployeeObject() {
        String str = "    Employee    ,    101   ,    John Doe    ,    3000   ,   1";
        Employee employee = new Employee(101, "John Doe", 3000, 1);

        assertEquals(employee, parser.parse(str));
    }

    @Test
    void parseTestWithNotValidateLine6ArgumentsExpectedIllegalException() {
        String str = "Employee, 101, John Doe, 3000, 1, 2";

        assertThrows(IllegalArgumentException.class, () -> parser.parse(str));
    }

    @Test
    void parseTestNotValidateFieldLineExpectedIllegalException() {
        String str = "Employee, John Doe, 101, 3000, 1";

        assertThrows(IllegalArgumentException.class, () -> parser.parse(str));
    }

}