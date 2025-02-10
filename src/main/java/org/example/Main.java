package org.example;

import org.example.adapter.impl.CommandAdapter;
import org.example.input.impl.ConsoleInput;

public class Main {
    public static void main(String[] args) {
        CommandAdapter commandAdapter = new CommandAdapter();
        commandAdapter.adapt(new ConsoleInput());
    }
}