package commandline.model.commands;

import commandline.controller.FileHelper;

/**
 * User: huyti
 * Date: 08.10.15
 */
public class DirCommand implements Command {
    FileHelper helper;

    public DirCommand(FileHelper helper) {
        this.helper = helper;
    }

    @Override
    public void execute() {
        helper.dir();
    }
}
