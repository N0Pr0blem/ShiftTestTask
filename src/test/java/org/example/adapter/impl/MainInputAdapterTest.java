package org.example.adapter.impl;

import org.example.input.Input;
import org.example.input.impl.FileInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainInputAdapterTest {

    private MainInputAdapter mainAdapter = new MainInputAdapter();
    private final String FIRST_TEST_FILE_PATH = "src/test/java/org/example/test_files/test_1";
    private final String SECOND_TEST_FILE_PATH = "src/test/java/org/example/test_files/test_2";

    @Test
    void adaptTestParseToLists(){
        Input fileInput = new FileInput(FIRST_TEST_FILE_PATH);

        mainAdapter.adapt(fileInput);

        assertEquals(mainAdapter.getManagers().size(),2);
        assertEquals(mainAdapter.getEmployees().size(),2);
        assertEquals(mainAdapter.getWrongLines().size(),3);
    }

    @Test
    void adaptTestParseWrongFileText(){
        Input fileInput = new FileInput(SECOND_TEST_FILE_PATH);

        mainAdapter.adapt(fileInput);

        assertEquals(mainAdapter.getWrongLines().size(), 5);
    }

}