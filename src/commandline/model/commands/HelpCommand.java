package commandline.model.commands;

import commandline.controller.FileHelper;

/**
 * User: Alexandr
 */
public class HelpCommand implements Command {
    FileHelper helper;
    String command;

    public HelpCommand(FileHelper helper, String command) {
        this.helper = helper;
        this.command = command;
    }

    @Override
    public void execute() {
        helper .showHelp(command);
    }
}
