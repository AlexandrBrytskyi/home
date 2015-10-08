package commandline.model.commands;

import commandline.controller.FileHelper;

/**
 * User: huyti
 * Date: 08.10.15
 */
public class TypeCommand implements Command {
    FileHelper helper;
    String file;

    public TypeCommand(FileHelper helper, String file) {
        this.helper = helper;
        this.file = file;
    }

    @Override
    public void execute() {
        helper.type(file);
    }
}
