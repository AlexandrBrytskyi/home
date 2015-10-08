package commandline.model.commands;

import commandline.controller.FileHelper;

import java.io.IOException;

/**
 * User: huyti
 * Date: 08.10.15
 */
public class CopyCommand implements Command {
    FileHelper helper;
    String atr1;
    String atr2;

    public CopyCommand(FileHelper helper, String atr1, String atr2) {
        this.helper = helper;
        this.atr1 = atr1;
        this.atr2 = atr2;
    }

    @Override
    public void execute() {
        helper.copyDirectory(atr1, atr2);
    }
}
