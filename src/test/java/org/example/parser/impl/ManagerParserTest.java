package org.example.parser.impl;

import org.example.model.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ManagerParserTest {

    private ManagerParser parser;

    @BeforeEach
    void setup(){
        parser = new ManagerParser();
    }

    @Test
    void parseTestWithValidateLineExpectedManagerObject() {
        String str = "Manager,101,John Doe,3000,HR";
        Manager manager = new Manager(101, "John Doe", 3000, "HR");

        assertEquals(manager, parser.parse(str));
    }

    @Test
    void parseTestWithValidateLineAndSpaceExpectedEmployeeObject() {
        String str = "    Manager    ,    101   ,    John Doe    ,    3000   ,   HR";
        Manager manager = new Manager(101, "John Doe", 3000, "HR");

        assertEquals(manager, parser.parse(str));
    }

    @Test
    void parseTestWithNotValidateLine6ArgumentsExpectedIllegalException() {
        String str = "Manager, 101, John Doe, 3000, HR, 2";

        assertThrows(IllegalArgumentException.class, () -> parser.parse(str));
    }

    @Test
    void parseTestNotValidateFieldLineExpectedIllegalException() {
        String str = "Manager, John Doe, 101, 3000, HR";

        assertThrows(IllegalArgumentException.class, () -> parser.parse(str));
    }
}