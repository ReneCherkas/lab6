package Commands;

import Org.CollectionManager;
import Org.Person;
import manager.Message;

public class Add implements Command {

    @Override
    public String execute(Object arg) {
        Person person = (Person) arg;
        Message.setMessage("Был добавлен продукт");
        CollectionManager.add(person);
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
