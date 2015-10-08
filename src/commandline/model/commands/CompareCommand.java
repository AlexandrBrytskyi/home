package commandline.model.commands;

import commandline.controller.FileHelper;

/**
 * User: huyti
 * Date: 08.10.15
 */
public class CompareCommand implements Command {
    FileHelper helper;
    String atr1;
    String atr2;

    public CompareCommand(FileHelper helper, String atr1, String atr2) {
        this.helper = helper;
        this.atr1 = atr1;
        this.atr2 = atr2;
    }

    @Override
    public void execute() {
        helper.compare(atr1, atr2);
    }
}
