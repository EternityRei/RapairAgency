package com.example.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private static Map<String, Command> commands;
    static {
        commands = new HashMap<>();
    }
    public static Command getCommand(String commandName){
        return commands.get(commandName);
    }
}
