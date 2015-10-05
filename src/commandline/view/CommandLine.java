package commandline.view;

import commandline.controller.CommandFinder;

/**
 * Created with IntelliJ IDEA.
 * User: Alexandr
 * Date: 05.10.15
 * Time: 21:00
 * To change this template use File | Settings | File Templates.
 */
public class CommandLine {
    //here is our command line;
    //here must me a method where we say our command and give it to the commandFinder,

    CommandFinder finder;

    public CommandLine() {
        this.finder  = new CommandFinder();
    }


}
