package commandline.model.commands;

/**
 * Created with IntelliJ IDEA.
 * User: Alexandr
 * Date: 05.10.15
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 */
public interface Command {
           //concrette command will implement this interface
           //command has a reciever where placed all logic, this is FileHelper class
    //in method execute() we use reciever.dosome()


    void execute();
}
