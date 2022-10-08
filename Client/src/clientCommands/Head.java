package clientCommands;

import manager.CommandAndArg;

public class Head implements Command{
    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("head");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "head";
    }

    @Override
    public String getDescription() {
        return "Вывести первый элемент коллекции";
    }
}
