package org.example;

import org.example.adapter.impl.MainInputAdapter;
import org.example.data.MyData;
import org.example.input.Input;
import org.example.input.impl.FileInput;

public class Main {
    public static void main(String[] args) {
        Input fileInput = new FileInput(MyData.INPUT_FILE_PATH);
        MainInputAdapter mainAdapter = new MainInputAdapter();
        mainAdapter.adapt(fileInput);

        System.out.println("Managers");
        mainAdapter.getManagers().forEach(System.out::println);
        System.out.println("Employees");
        mainAdapter.getEmployees().forEach(System.out::println);
        System.out.println("Wrong lines");
        mainAdapter.getWrongLines().forEach(System.out::println);
    }
}