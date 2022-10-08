package Commands;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class PrintFiledAscendingNationality implements Command{
    @Override
    public String execute(Object o) throws ParserConfigurationException, IOException, TransformerException {
        return null;
    }

    @Override
    public String getName() {
        return "print_field_ascending_nationality";
    }

    @Override
    public String getDescription() {
        return "вывести значения поля nationality всех элементов в порядке возрастания";
    }
}
