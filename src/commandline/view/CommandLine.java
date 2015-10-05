package commandline.view;

import commandline.controller.CommandFinder;

import java.util.Scanner;

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

    CommandFinder finder = new CommandFinder();

    public CommandLine() {
        init();
    }

    private void init() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter command");
        System.out.print(finder.currLocation());
        finder.definCommand(s.nextLine());
        init();
    }


}
