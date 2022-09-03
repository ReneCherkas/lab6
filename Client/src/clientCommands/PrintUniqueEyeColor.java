package clientCommands;

import manager.CommandAndArg;


public class PrintUniqueEyeColor implements Command {

    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("print_unique_eye_color");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "print_unique_eye_color";
    }

    @Override
    public String getDescription() {
        return "вывести уникальные значения поля eyeColor всех элементов в коллекции";
    }
}