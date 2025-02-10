package org.example.adapter.impl;

import org.example.adapter.Adapter;
import org.example.input.Input;

public class CommandAdapter implements Adapter {

    @Override
    public void adapt(Input input) {
        String commandLine = input.getData()
                .findFirst()
                .toString()
                .trim();

        System.out.println(commandLine);
    }
}
