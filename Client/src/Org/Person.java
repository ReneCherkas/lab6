package Org;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class Person implements Comparable, Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private Double height;
    private ColorEye eyeColor;
    private ColorHair hairColor;
    private Country nationality;
    private Location location;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setEyeColor(ColorEye eyeColor) {
        this.eyeColor = eyeColor;
    }

    public ColorEye getEyeColor(){return eyeColor;}

    public void setHairColor(ColorHair hairColor) {
        this.hairColor = hairColor;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return String.format("Идентификатор: %d%n" +
                        "Имя: %s%n" +
                        "Координата X : %s%n" +
                        "Координата Y : %s%n" +
                        "Дата создания: %s%n" +
                        "Рост: %d%n" +
                        "Цвет глаз: %s%n" +
                        "Цвет волос: %s%n" +
                        "Национальность: %s%n" +
                        "Локация: %n" +
                        "X: %d%n"+
                        "y: %d%n"+
                        "z: %d",
                id, name, coordinates.getX(), coordinates.getY(), creationDate, height, eyeColor, hairColor, nationality, location.getX(),location.getY(),location.getZ());
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        return (int) this.id.compareTo(person.getId());
    }
}