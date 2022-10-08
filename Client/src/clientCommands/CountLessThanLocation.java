package clientCommands;

import manager.CommandAndArg;

public class CountLessThanLocation implements Command{
    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("count_less_than_location");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "count_less_than_locationX";
    }

    @Override
    public String getDescription() {
        return "вывести количество элементов, значение поля location которых меньше заданного";
    }
}
