package commandline.controller;

import commandline.model.commands.Command;
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

    public void runHelpCommand(HelpCommand helpCommand) {
        this.helpCommand = helpCommand;
        helpCommand.execute();
    }

}
