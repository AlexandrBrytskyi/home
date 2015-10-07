package commandline.controller;

import java.io.*;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Alexandr
 * Date: 05.10.15
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public class FileHelper {
    //reciever
    //here is a logic of all the commands
    private File currentLocation = new File("D:/");

    public FileHelper() {

    }


//    +       - show all available commands        help
//    +       - changeCurrentLocation              cd
//    +       - find file(dir)                     find
//    +       - show directoryContent              dir
//    +       - show file (content)                type
//    +       - delete file or dir                 del , rd
//    +       - create dir                         mkdir
//    +       - create file                        ? )))
//            +       - show folder structure              tree
//    +       - copy file                          copy
//    +       - compare content of files           fc

    public void showHelp(String command) {
        String absPath = "src/commandline/controller/helpText";
        // if command == null show all commands help
        // if command != null then look if we have such command. if command exist show help else give message it doesn`t exist
        if (command == null) {
            showAllHelp(absPath);
        } else {
            showCommandHelp(command, absPath);
        }
    }


    private void showAllHelp(String absPath) {
        // show all commands help one after another
        String abPath = absPath;
        File textdirectory = new File(abPath);
        String[] commands = textdirectory.list();
        for (String command : commands) {
            try {
                Reader r = new FileReader(abPath + "/" + command);
                String res = "";
                int a = 0;
                while ((a = r.read()) != -1) {
                    res += (char) a;
                }
                System.out.println(res);
                System.out.println();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public File getCurrentLocation() {
        return currentLocation;
    }

    public void changeCurrLocation(String atribute) {
        if (atribute.equals("..")) {
            if (currentLocation.getAbsolutePath().length() > 3) {
                currentLocation = new File(currentLocation.getParent());
                return;
            }
        } else {
            if (atribute.charAt(1) == ':') {
                if (atribute.charAt(2) != '/') {
                    System.out.println("wrong path!");
                    return;
                }
                File newPath = new File(atribute);
                if (newPath.exists() && newPath.isDirectory()) {
                    currentLocation = newPath;
                    return;
                }
            } else {
                File newPath = new File(currentLocation + atribute);
                if (newPath.exists() && newPath.isDirectory()) {
                    currentLocation = newPath;
                    return;
                }
            }
        }
        System.out.println("wrong path");
        return;

    }

    private void showCommandHelp(String command, String absPath) {
        //look in the directory if it contains info about such command and show it, else say that wrong command
        String abPath = absPath;
        File textdirectory = new File(abPath);
        String[] commands = textdirectory.list();
        boolean contains = false;
        for (String com : commands) {
            if (com.contains(command)) {
                contains = true;
                break;
            }
        }
        if (contains) {
            try {
                Reader r = new FileReader(abPath + "/" + command + ".txt");
                String res = "";
                int a = 0;
                while ((a = r.read()) != -1) {
                    res += (char) a;
                }
                System.out.println(res);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Wrong command, try again");
        }
    }
}
