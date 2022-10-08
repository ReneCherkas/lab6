package clientCommands;

import Org.*;
import manager.CommandAndArg;
import manager.Message;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductCreator {
    private final Scanner scanner = new Scanner(System.in);


    public Person create(String id) {
        Person person = new Person();

        try {
            if (id.equals("free")) {
                person.setId(CollectionManager.getFreeId());
            } else {
                person.setId(Long.parseLong(id));
            }
        } catch (Exception e){
            Message.error("Неверный формат команды, аргумент должен быть = 'free' или быть типа long");
            CommandAndArg.setCommand("");
            return null;
        }
        

        this.setName(person);
        Coordinates coordinates = new Coordinates();
        this.setCoordinateX(coordinates);
        this.setCoordinateY(coordinates);
        person.setCoordinates(coordinates);
        person.setCreationDate(LocalDateTime.now());
        this.setHeight(person);
        this.setEyeColor(person);
        this.setHairColor(person);
        this.setNationality(person);
        Location location = new Location();
        this.setLocationX(location);
        this.setLocationY(location);
        this.setLocationZ(location);
        person.setLocation(location);
        return person;
    }

    private void setLocationX(Location location) {
        try {
            Message.info("Введите локацию x: (long)");
            String x = scanner.nextLine();
            if (x.equals("") || x.equals(null)) this.setLocationX(location);
            else {
                long xn = Long.parseLong(x);
                location.setX(xn);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            Message.error("Значение должно быть типа:\"long\".");
            this.setLocationX(location);
        }
    }

    private void setLocationY(Location location) {
        try {
            Message.info("Введите локацию y: (long)");
            String y = scanner.nextLine();
            if (y.equals("") || y.equals(null)) this.setLocationY(location);
            else {
                long yn = Long.parseLong(y);
                location.setY(yn);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            Message.error("Значение должно быть типа:\"long\".");
            this.setLocationY(location);
        }

    }

    private void setLocationZ(Location location) {
        try {
            Message.info("Введите локацию z: (int)");
            String z = scanner.nextLine();
            if (z.equals("") || z.equals(null)) this.setLocationZ(location);
            else {
                int zn = Integer.parseInt(z);
                location.setZ(zn);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            Message.error("Значение должно быть типа:\"int\".");
            this.setLocationZ(location);
        }
    }

    private void setNationality(Person person) {
        Message.info("Введите национальность: \n" +
                "   (RUSSIA, \n" +
                "    SPAIN,\n" +
                "    INDIA,\n" +
                "    VATICAN,\n" +
                "    SOUTH_KOREA;)");
        String unit = scanner.nextLine().toUpperCase();
        try {
            person.setNationality(Country.valueOf(unit));
        } catch (Exception e) {
            Message.error("Значение должно соответствовать перечисленным типам. Введите значение:");
            this.setNationality(person);
        }
    }

    private void setHairColor(Person person) {
        Message.info("Введите цвет волос: \n " +
                "   (RED, \n" +
                "    BLACK,\n" +
                "    YELLOW,\n" +
                "    BROWN;)");
        String unit = scanner.nextLine().toUpperCase();
        try {
            person.setHairColor(ColorHair.valueOf(unit));
        } catch (Exception e) {
            Message.error("Значение должно соответствовать перечисленным типам. Введите значение:");
            this.setHairColor(person);
        }
    }

    private void setEyeColor(Person person) {
        Message.info("Введите цвет глаз: \n" +
                "   (GREEN, \n" +
                "    BLACK,\n" +
                "    ORANGE;)\n");
        String unit = scanner.nextLine().toUpperCase();
        try {
            person.setEyeColor(ColorEye.valueOf(unit));
        } catch (Exception e) {
            Message.error("Значение должно соответствовать перечисленным типам. Введите значение:");
            this.setEyeColor(person);
        }
    }

    private void setHeight(Person person) {
        try {
            Message.info("Введите рост: (Double)");
            Double Height = Double.parseDouble(scanner.nextLine());
            person.setHeight(Height);
        } catch (InputMismatchException | NumberFormatException e) {
            Message.error("Значение должно быть типа:\"Double\".");
            this.setHeight(person);
        }
    }


    public void setName(Person person) {
        Message.info("Введите имя: (String)");
        String name = scanner.nextLine();
        if (name.equals("") || name.equals("null")) {
            Message.error("Имя не может быть пустым");
            this.setName(person);
        } else {
            person.setName(name);
        }
    }

    public void setCoordinateX(Coordinates coords) {
        try {
            Message.info("Введите координату x: (float)");
            String x = scanner.nextLine();
            if (x.equals("")) this.setCoordinateX(coords);
            else {
                float xn = Float.parseFloat(x);
                coords.setX(xn);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            Message.error("Значение должно быть типа:\"float\".");
            this.setCoordinateX(coords);
        }
    }

    public void setCoordinateY(Coordinates coords) {
        try {
            Message.info("Введите координату y: (Double)");
            String y = scanner.nextLine();
            if (y.equals("")) {
                Message.error("y не может быть null");
                this.setCoordinateY(coords);
            } else {
                int yn = Integer.parseInt(y);
                coords.setY(yn);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            Message.error("Значение должно быть типа:\"Double\".");
            this.setCoordinateY(coords);
        }
    }

}