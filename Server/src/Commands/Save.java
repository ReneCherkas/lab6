package Commands;

import Org.CollectionManager;
import Org.Coordinates;
import Org.Location;
import Org.Person;
import manager.Message;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Locale;

public class Save implements  Command {
    @Override
    public String execute(Object o) throws ParserConfigurationException, IOException, TransformerException {
        File file = new File("Server\\src\\data\\data.csv");
        try (FileOutputStream outputStream = new FileOutputStream(file)){
            for (Person value : CollectionManager.getPerson()) {
                Long id = value.getId();
                String name = value.getName();
                Coordinates coordinates = value.getCoordinates();
                LocalDateTime creationDate = value.getCreationDate();
                Double height = value.getHeight();
                String eyeColor = value.getColor().toString().toUpperCase(Locale.ROOT);
                String hairColor = value.getColorHair().toString().toUpperCase(Locale.ROOT);
                String nationality = value.getCountry().toString().toUpperCase(Locale.ROOT);
                Location location = value.getLocation();
                String message = ( id + ", " + name + ", " + coordinates.getX() + ", " + coordinates.getY() + ", " + creationDate + ", " + height + ", " + eyeColor + ", " + hairColor + ", " + nationality + ", " + location.getX() + ", " + location.getY() + ", " + location.getZ() + ", ");
                outputStream.write(message.getBytes(StandardCharsets.UTF_8));
                outputStream.write("\n".getBytes(StandardCharsets.UTF_8));
            }
        } catch (FileNotFoundException e) {
            Message.setMessage("Ошибка. Отсутствует доступ к файлу." + e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            Message.setMessage("Ошибка");
        }
        return null;
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "Сохранить коллекцию в файл";
    }
}
