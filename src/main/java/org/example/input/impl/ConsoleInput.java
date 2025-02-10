package org.example.input.impl;

import org.example.input.Input;

import java.util.Scanner;
import java.util.stream.Stream;

public class ConsoleInput implements Input {

    private Scanner reader = new Scanner(System.in);

    @Override
    public Stream<String> getData() {
        return Stream.of(reader.next());
    }
}
