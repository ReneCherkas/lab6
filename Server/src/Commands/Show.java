package Commands;

import manager.Message;

import static Org.CollectionManager.getCollection;

public class Show implements Command{
    @Override
    public String execute(Object o) {
        Message.setMessage(getCollection().toString());
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
