package org.example.config;

import java.util.regex.Pattern;

public class Config {
    public static final String INPUT_FILE_PATH = "input";

    public static final Pattern SORT_COMMAND_PATTERN = Pattern.compile("(--sort|-s)(?:\\s*=)?(?:\\s*(\\w+)\\s+(--order)\\s*=\\s*(ask|desc))?");

    public static final Pattern OUTPUT_COMMAND_PATTERN = Pattern.compile("(--outpu|-o)\\s*=\\s*(console|file)(?:\\s+(--path)\\s*=\\s*\\w)?");
}
