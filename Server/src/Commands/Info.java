package Commands;

import Org.CollectionManager;
import manager.Message;

public class Info implements Command{
    @Override
    public String execute(Object o) {
        Message.setMessage("Тип коллекции: " + CollectionManager.getType() + " дата инициализации: " + CollectionManager.getTime() + " количество элементов: " + CollectionManager.getSize());
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

