package org.example.command;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CommandContext {
    private String command;
    private Map<String, String> args = new HashMap<>();

    public CommandContext(String command) {
        this.command = command;
    }

    public void addArg(String key, String value) {
        args.put(key, value);
    }

    public String getArg(String key) {
        return args.get(key);
    }
}
