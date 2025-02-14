package org.example.command;

import org.example.adapter.InputAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CommandExecutorTest {

    private CommandExecutor commandExecutor;
    private CommandContext commandContext;
    private InputAdapter inputAdapter;

    @BeforeEach
    void setup(){
        inputAdapter = mock(InputAdapter.class);

        commandExecutor = new CommandExecutor(inputAdapter);
    }

    @Test
    void testExecuteSortCommand(){
        commandContext = mock(CommandContext.class);
        when(commandContext.getCommand()).thenReturn("sort");
        when(commandContext.getArg("field")).thenReturn("name");
        when(commandContext.getArg("order")).thenReturn("asc");

        commandExecutor.execute(commandContext);

        verify(inputAdapter).getEmployees();
    }

    @Test
    void testExecuteOutputCommandConsole(){
        commandContext = mock(CommandContext.class);
        when(commandContext.getCommand()).thenReturn("output");
        when(commandContext.getArg("type")).thenReturn("console");

        commandExecutor.execute(commandContext);

        verify(commandContext).getArg("type");
    }

    @Test
    void testExecuteOutputCommandFile(){
        commandContext = mock(CommandContext.class);
        when(commandContext.getCommand()).thenReturn("output");
        when(commandContext.getArg("type")).thenReturn("file");
        when(commandContext.getArg("path")).thenReturn("output");

        commandExecutor.execute(commandContext);

        verify(commandContext).getArg("path");
    }

    @Test
    void testExecuteExitCommand() {
        commandContext = mock(CommandContext.class);
        when(commandContext.getCommand()).thenReturn("exit");

        commandExecutor.execute(commandContext);

        verify(commandContext).getCommand();
    }

    @Test
    void testExecuteInvalidCommand() {
        commandContext = mock(CommandContext.class);
        when(commandContext.getCommand()).thenReturn("invalid");

        assertThrows(IllegalArgumentException.class,()->commandExecutor.execute(commandContext));
    }
    @Test
    void testExecuteOutputWithoutPath() {
        commandContext = mock(CommandContext.class);
        when(commandContext.getCommand()).thenReturn("output");
        when(commandContext.getArg("type")).thenReturn("file");
        when(commandContext.getArg("path")).thenReturn(null);

        assertThrows(IllegalArgumentException.class,()->commandExecutor.execute(commandContext));
    }
}