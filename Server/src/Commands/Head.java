package Commands;

import Org.CollectionManager;
import manager.Message;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Head implements Command{

    @Override
    public String execute(Object o) throws ParserConfigurationException, IOException, TransformerException {
        try {
            Message.setMessage(String.valueOf(CollectionManager.getPerson().peekFirst()));
        } catch (Exception e) {
            Message.setMessage("Коллекция пуста");
        }
        return null;
    }

    @Override
    public String getName() {
        return "head";
    }

    @Override
    public String getDescription() {
        return "Вывести первый элемент коллекции";
    }
}
