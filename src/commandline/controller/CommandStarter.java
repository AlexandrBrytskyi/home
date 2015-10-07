package commandline.controller;

import commandline.model.commands.CDCommand;
import commandline.model.commands.Command;
import commandline.model.commands.FindCommand;
import commandline.model.commands.HelpCommand;

/**
 * User: Alexandr
 */
public class CommandStarter {
    // this class must be like invoker
    //invoker has all the methods are implemented by Command (model)
    //invoker must define is real command or not, then if all is ok it runs a command (run method execute)
    //

    Command helpCommand;
    Command cdCommand;
    Command findCommand;


    public void runHelpCommand(HelpCommand helpCommand) {
        this.helpCommand = helpCommand;
        helpCommand.execute();
    }

    public void runCDCommand(CDCommand cdCommand) {
        this.cdCommand = cdCommand;
        cdCommand.execute();
    }

    public void runFindCommand(FindCommand findCommand) {
        this.findCommand = findCommand;
        findCommand.execute();
    }

}
