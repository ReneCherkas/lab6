package Commands;

import Mess.Mess;
import Org.CollectionManager;
import Org.ColorHair;
import Org.Person;
import manager.Message;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Locale;

public class CountLessThanLocation implements Command{
    private String arguments;


    @Override
    public String execute(Object arg) throws ParserConfigurationException, IOException, TransformerException {
        int count = 0;

        for (Person personIt : CollectionManager.getCollection()) {
            if (personIt.getLocation().getX() < Integer.parseInt(arg.toString())) {
                count += 1;
            }
        }

        Message.setMessage("количество элементов, значение поля location которых больше заданного: " + count);
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
