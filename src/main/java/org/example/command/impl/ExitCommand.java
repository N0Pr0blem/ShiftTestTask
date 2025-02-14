package org.example.command.impl;

import org.example.command.Command;
import org.example.config.OutputConfig;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        OutputConfig.getInstance().setCommandListenFlag(false);
    }
}
