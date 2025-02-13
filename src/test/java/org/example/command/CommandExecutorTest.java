package org.example.command;

import org.example.adapter.InputAdapter;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CommandExecutorTest {

    private CommandExecutor commandExecutor;
    private InputAdapter inputAdapter;

    @BeforeEach
    void setup(){
        inputAdapter = mock(InputAdapter.class);

        commandExecutor = new CommandExecutor(inputAdapter);
        //when()
    }

}