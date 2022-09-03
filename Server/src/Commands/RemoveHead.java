package Commands;

import Mess.Mess;
import Org.CollectionManager;
import manager.Message;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Objects;

public class RemoveHead implements Command{
    private CollectionManager collectionManager;

    @Override
    public String execute(Object o) throws ParserConfigurationException, IOException, TransformerException {
        try {
            if (CollectionManager.getSize() == 0) {
                Message.setMessage("Коллекция пустая.");
            }
            else {
                Long id = Long.parseLong(String.valueOf(1));
                CollectionManager.getCollection().removeIf(person -> Objects.equals(person.getId(), id));
                Message.setMessage("Был удален первый элемент");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getName() {
        return "remove_head";
    }

    @Override
    public String getDescription() {
        return "Удалить первый элемент из коллекции";
    }
}
