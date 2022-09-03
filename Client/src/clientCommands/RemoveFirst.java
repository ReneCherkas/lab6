package clientCommands;

import manager.CommandAndArg;

public class RemoveFirst implements Command {

    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("remove_first");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "remove_first";
    }

    @Override
    public String getDescription() {
        return "Удалить первый элемент из коллекции";
    }
}
