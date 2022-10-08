package Org;

import Mess.Mess;

import java.util.Scanner;

public class PersonFieldReade {
    private Scanner in = new Scanner(System.in);

    public String readName() {
        String str;
        while (true) {
            Mess.info("Введите имя:");
            str = in.nextLine();
            if (str.trim().equals("")) {
                Mess.error("Имя не может быть пустой строкой");
                continue;
            }
            if (str.trim().equals("null")) {
                Mess.error("Имя не может быть null");
                continue;
            }
            return str;
        }
    }


    public Coordinates readCoordinates() {
        return new Coordinates(readCoordinateX(), readCoordinateY());
    }

    public float readCoordinateX() {
        float x;
        while (true) {
            try {
                Mess.info("Введите координату Х: ");
                String str = in.nextLine();
                x = Float.parseFloat(str.trim());
                return x;
            } catch (NumberFormatException e) {
                Mess.error("Координата Х должна быть числом");
            }
        }
    }

    public int readCoordinateY() {
        int y;
        while (true) {
            try {
                Mess.info("Введите координату Y: ");
                String str = in.nextLine();
                y = Integer.parseInt(str.trim());
                return y;
            } catch (NumberFormatException e) {
                Mess.error("Координата Y должна быть числом");
            }
        }
    }

    public ColorEye readColorEye() {
        ColorEye eyeColor;
        while (true) {
            try {
                Mess.info("Выберите цвет глаз: ");
                for (ColorEye val : ColorEye.values()) {
                    Mess.info(val.name());
                }
                String val = in.nextLine();
                if (val.trim().equals("")) {
                    Mess.error("Цвет глаз не может быть пустой строкой");
                    continue;
                }
                if (val.trim().equals("null")) {
                    Mess.error("Цвет глаз не может быть null");
                    continue;
                }
                eyeColor = ColorEye.valueOf(val.trim().toUpperCase());
                return eyeColor;
            } catch (IllegalArgumentException e) {
                Mess.error("Выберите значение из списка");
            }
        }
    }

    public ColorHair readColorHair() {
        ColorHair hairColor;
        while (true) {
            try {
                Mess.info("Выберите цвет волос:");
                for (ColorHair val : ColorHair.values()) {
                    Mess.info(val.name());
                }
                String val = in.nextLine();
                if (val.trim().equals("")) {
                    Mess.error("Цвет волос не может быть пустой строкой");
                    continue;
                }
                if (val.trim().equals("null")) {
                    Mess.error("Цвет волос не может быть null");
                    continue;
                }
                hairColor = ColorHair.valueOf(val.trim().toUpperCase());
                return hairColor;
            } catch (IllegalArgumentException e) {
                Mess.error("Выберите значение из списка");
            }
        }
    }

    public Country readCountry() {
        Country nationality;
        while (true) {
            try {
                Mess.info("Выберите национальность: ");
                for (Country val : Country.values()) {
                    Mess.info(val.name());
                }
                String val = in.nextLine();
                if (val.trim().equals("")) {
                    Mess.error("национальность не может быть пустой строкой");
                    continue;
                }
                if (val.trim().equals("null")) {
                    Mess.error("национальность не может быть null");
                    continue;
                }
                nationality = Country.valueOf(val.trim().toUpperCase());
                return nationality;
            } catch (IllegalArgumentException e) {
                Mess.error("Выберите значение из списка");
            }
        }
    }

    public Location readLocation() {
        return new Location(readLocationX(), readLocationY(),readLocationZ());
    }

    public long readLocationX() {
        long x;
        while (true) {
            try {
                Mess.info("Введите координату Х: ");
                String str = in.nextLine();
                x = Long.parseLong(str.trim());
                return x;
            } catch (NumberFormatException e) {
                Mess.error("Координата Х должна быть числом");
            }
        }
    }

    public long readLocationY() {
        long y;
        while (true) {
            try {
                Mess.info("Введите координату Y: ");
                String str = in.nextLine();
                y = Long.parseLong(str.trim());
                return y;
            } catch (NumberFormatException e) {
                Mess.error("Координата Y должна быть числом");
            }
        }
    }

    public int readLocationZ() {
        int z;
        while (true) {
            try {
                Mess.info("Введите координату Z: ");
                String str = in.nextLine();
                z = Integer.parseInt(str.trim());
                return z;
            } catch (NumberFormatException e) {
                Mess.error("Координата Z должна быть числом");
            }
        }
    }

    public Double readHeight() {
        Double height;
        while (true) {
            try {
                Mess.info("Введите Рост: ");
                String str = in.nextLine();
                height = Double.parseDouble(str.trim());
                return height;
            } catch (NumberFormatException e) {
                Mess.error("Рост должен быть числом");
            }
        }
    }
}
