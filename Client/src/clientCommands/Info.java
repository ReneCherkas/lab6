package clientCommands;

import manager.CommandAndArg;

public class Info implements Command{
    @Override
    public String execute(Object o) {
        CommandAndArg.setCommand("info");
        return null;
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "Вывести информацию о коллекции";
    }
}

