package Commands;

import manager.Message;

import static Org.CollectionManager.getCollection;

public class Show implements Command{
    @Override
    public String execute(Object o) {
        Message.setMessage(getCollection().toString());
        //Mess.info(CollectionManager.getCollection().toString());
        //Mess.info(CollectionManager.);
        //Message.setMessage(CollectionManager.setCollection(););
        /*if (CollectionManager.getPerson().size() == 0) {
            Message.setMessage("Коллекция пуста!");
        } else {
            for (Person values : CollectionManager.getPerson()) {
                Message.setMessage(values.toString());
            }
        }*/
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
