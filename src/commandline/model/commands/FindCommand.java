package commandline.model.commands;

import commandline.controller.FileHelper;

/**
 * User: huyti
 * Date: 08.10.15
 */
public class FindCommand implements Command {
    FileHelper helper;
    String atribute1;
    String atribute2;

    public FindCommand(FileHelper helper, String atribute1, String atribute2) {
        this.helper = helper;
        this.atribute1 = atribute1;
        this.atribute2 = atribute2;
    }

    @Override
    public void execute() {
        helper.find(atribute1, atribute2);
    }
}
