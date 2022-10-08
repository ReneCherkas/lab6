package clientCommands;

import Org.Person;
import manager.CommandAndArg;

public class Add implements Command {

    @Override
    public String execute(Object arg) {
        ProductCreator productCreator = new ProductCreator();
        Person person = productCreator.create((String) arg);
        if (person != null){
            CommandAndArg.setCommand("add");
            CommandAndArg.setArg(person);
            return  null;
        }
        CommandAndArg.setCommand("");
        return null;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "добавление объекта";
    }
}
