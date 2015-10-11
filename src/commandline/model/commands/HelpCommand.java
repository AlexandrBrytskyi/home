package commandline.model.commands;

import commandline.controller.FileHelper;

/**
 * User: Alexandr
 */
public class HelpCommand implements Command {
    FileHelper helper;
    String atribute;

    public HelpCommand(FileHelper helper, String atribute) {
        this.helper = helper;
        this.atribute  = atribute;
    }

    @Override
    public void execute() {
        helper .showHelp(atribute);
    }
}
