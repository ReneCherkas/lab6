package clientCommands;

import manager.CommandAndArg;

public class RemoveHead implements Command{
    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("remove_head");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "remove_head";
    }

    @Override
    public String getDescription() {
        return "Вывести первый элемент коллекции и удалить его";
    }
}
