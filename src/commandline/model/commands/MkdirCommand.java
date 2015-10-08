package commandline.model.commands;

import commandline.controller.FileHelper;

/**
 * User: huyti
 * Date: 08.10.15
 */
public class MkdirCommand implements Command  {
    FileHelper helper;
    String name;

    public MkdirCommand(FileHelper helper, String name) {
        this.helper = helper;
        this.name = name;
    }

    @Override
    public void execute() {
        helper .mkdir(name);
    }
}
