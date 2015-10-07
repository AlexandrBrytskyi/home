package commandline.model.commands;

import commandline.controller.FileHelper;

/**
 * User: huyti
 * Date: 07.10.15
 */
public class CDCommand implements Command {
    FileHelper helper;
    String atribute;

    public CDCommand(FileHelper helper, String command) {
        this.helper = helper;
        this.atribute = command;
    }

    @Override
    public void execute() {
         helper.changeCurrLocation(atribute);
    }
}
