package clientCommands;

import manager.CommandAndArg;

public class Show implements Command{
    @Override
    public String execute(Object o) {
        CommandAndArg.setCommand("show");
        return null;
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "Показать коллекцию";
    }
}
