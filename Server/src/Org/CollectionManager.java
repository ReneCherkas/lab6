package Org;

import Mess.Mess;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayDeque;

public class CollectionManager implements Serializable {
    private static final long serialVersionUID = 1L;
    public static ArrayDeque<Person> pers = new ArrayDeque<Person>();
    private static CollectionPerson collectionPerson;
    private static String fileName;
    private static LocalDate time = LocalDate.now();

    public static void setFileName(String fileName){
        CollectionManager.fileName = fileName;
    }

    public static String getFileName(){
        return CollectionManager.fileName;
    }


    public static LocalDate getTime() {
        return time;
    }

    public static void setTime(LocalDate time) {
        CollectionManager.time = time;
    }


    public static void setCollection(ArrayDeque<Person> pers){
        CollectionManager.pers = pers;
    }
    public static ArrayDeque<Person> getCollection(){
        return pers;
    }

    public static int getSize(){
        return getPerson().size();
    }

    public static Class<? extends ArrayDeque> getType(){
        return pers.getClass();
    }

    public static void add(Person person) {
        pers.add(person);
    }


    public void removeFirst() {
        pers.removeFirst();
    }

    public void removeHead() {
        pers.removeFirst();
    }



    public CollectionManager() {
        pers = new ArrayDeque<>();
        collectionPerson = new CollectionPerson();
        Path file = Paths.get("Server\\src\\data\\data.csv");
        try{
            BasicFileAttributes attr =
                    Files.readAttributes(file, BasicFileAttributes.class);
            time = Instant.ofEpochMilli(attr.creationTime().toMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
        }
        catch (IOException e){
            time = LocalDate.now();
        }
    }

    public Person insert(Person person){
        long checkId = person.getId();
        for (Person ignored : getPerson())
            if (isElementInCollection(checkId)) checkId++;
        person.setId(checkId);
        pers.add(person);
        return person;
    }

    public static ArrayDeque<Person> getPerson() {
        return pers;
    }

    public boolean isElementInCollection(long id) {
        if (id < 1) {
            return false;
        }
        for (Person values : this.getPerson()) {
            if (values.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void clear() {
        pers.clear();
    }


    public Person getElementById(long id) {
        if (id < 1) {
            Mess.error("Введите корректный id!");
        }
        for (Person values : pers) {
            if (values.getId() == id) {
                return values;
            }
        }
        return null;
    }

}
