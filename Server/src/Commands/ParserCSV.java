package Commands;

import Mess.Mess;
import Org.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class ParserCSV {
    private static CollectionManager collectionManager;


    public  ParserCSV(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }


    public static void parser(String path) throws FileNotFoundException {
        ArrayDeque <Person> pers = new ArrayDeque<>();
        File fileCsv = new File(/*"Server\\src\\data\\" +*/ path);
        Scanner file = new Scanner(fileCsv);
        try {
            int lineNumber = 1;

            while (file.hasNextLine()) {
                String[] line = file.nextLine().trim().split("\\s*[,\"]+\\s*");

                if (line.length != 12) {
                    Mess.info("Коллекция не соответствует нормам " + line[0]);
                    continue;
                }
                for (int i = 0; i < line.length; i++) {
                    line[i] = line[i].replaceFirst(".+=", "");
                }
                Validation validation = new Validation();
                if (validation.validation(line, lineNumber)) {
                    Long id = Long.parseLong(line[0]);
                    String name = line[1];
                    Coordinates coordinates = new Coordinates(Float.parseFloat(line[2]), Integer.parseInt(line[3]));
                    LocalDateTime creationDate = LocalDateTime.parse(line[4]);
                    Double height = Double.parseDouble(line[5]);
                    ColorEye eyeColor = ColorEye.valueOf(line[6]);
                    ColorHair hairColor = ColorHair.valueOf(line[7]);
                    Country nationality = Country.valueOf(line[8]);
                    Location location = new Location(Long.parseLong(line[9]), Long.parseLong(line[10]), Integer.parseInt(line[11]));
                    Person person = new Person(id, name,coordinates,creationDate, height, eyeColor, hairColor, nationality, location);
                    pers.add(person);
                    CollectionManager.setCollection(pers);
                }
                lineNumber++;
            }
        Mess.info("Коллекция заполнена из файла");
    } catch (Exception e) {
        Mess.error("Ошибка парсинга, коллекция не была заполнена");
        System.exit(0);
        }
    }
}