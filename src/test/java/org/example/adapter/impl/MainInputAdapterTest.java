package org.example.adapter.impl;

import org.example.adapter.InputAdapter;
import org.example.input.Input;
import org.example.input.impl.FileInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainInputAdapterTest {

    private final InputAdapter mainAdapter = new InputAdapter();

    @Test
    void adaptTestParseToLists(){
        String FIRST_TEST_FILE_PATH = "src/test/java/org/example/test_files/test_1";
        Input fileInput = new FileInput(FIRST_TEST_FILE_PATH);

        mainAdapter.adapt(fileInput);

        assertEquals(2, mainAdapter.getManagers().size());
        assertEquals(2, mainAdapter.getEmployees().size());
        assertEquals(3, mainAdapter.getWrongLines().size());
    }

    @Test
    void adaptTestParseWrongFileText(){
        String SECOND_TEST_FILE_PATH = "src/test/java/org/example/test_files/test_2";
        Input fileInput = new FileInput(SECOND_TEST_FILE_PATH);

        mainAdapter.adapt(fileInput);

        assertEquals(5, mainAdapter.getWrongLines().size());
    }

}