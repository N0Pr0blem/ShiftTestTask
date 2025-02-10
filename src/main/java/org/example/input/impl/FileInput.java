package org.example.input.impl;

import org.example.data.MyData;
import org.example.input.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileInput implements Input {

    private Path path;

    public FileInput(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public Stream<String> getData() {
        try{
            return Files.lines(path);
        }
        catch (IOException e){
            System.out.println("Wrong input file path");
        }
    }
}
