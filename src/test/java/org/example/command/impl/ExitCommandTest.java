package org.example.command.impl;

import org.example.command.Command;
import org.example.config.OutputConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExitCommandTest {

    private Command exitCommand;

    @BeforeEach
    void setup(){
        exitCommand = new ExitCommand();
    }

    @Test
    void testExit(){
        assertTrue(OutputConfig.getInstance().isCommandListenFlag());

        exitCommand.execute();

        assertFalse(OutputConfig.getInstance().isCommandListenFlag());
    }

}