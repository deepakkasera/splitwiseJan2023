package com.scaler.splitwisejan2023.commandsOld.registry;

import com.scaler.splitwisejan2023.commandsOld.Command;

public interface CommandRegistry {

    void registerCommand(Command command);

    Command getCommand(String commandLine);

    void removeCommand(Command command);

    boolean executeCommandLine(String commandLine);

//    // Upd
//    String suggestCommandBasedOnPrefix(String commandPrefix);
}
