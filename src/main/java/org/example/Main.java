package org.example;

import org.example.data.MyData;
import org.example.input.Input;
import org.example.input.impl.FileInput;

public class Main {
    public static void main(String[] args) {
        Input input = new FileInput(MyData.INPUT_FILE_PATH);
        input.getData();
    }
}